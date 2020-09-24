package com.lpc.test.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.view.View;

import androidx.annotation.Nullable;

import com.lpc.test.base.BaseTextRecyclerViewActivity;
import com.lpc.test.utils.LogUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 11:03 2020/9/23
 * @ Description：
 */
public class ConcurrentActivity extends BaseTextRecyclerViewActivity {

    private Object lock = new Object();
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition;
    private int i = 0;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        condition = reentrantLock.newCondition();
    }

    @Override
    protected void initRecyclerViewData() {

        /**
         * 线程安全计数 j并不准确，integer、k准确
         * */
        addBeanToMList("AtomicInteger与CountDownLatch", new View.OnClickListener() {

            private CountDownLatch countDownLatch = null;
            private AtomicInteger integer = null;
            private int j = 0;
            private int k = 0;

            @Override
            public void onClick(View v) {

                countDownLatch = new CountDownLatch(100);
                integer = new AtomicInteger(0);
                j = 0;
                k = 0;

                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        for (i = 0; i < 100; i++) {
                            Thread A = new Thread(new Runnable() {

                                @Override
                                public void run() {
                                    SystemClock.sleep(100);
                                    integer.getAndIncrement();
//                                    j++;
//                                    synchronized (countDownLatch) {
//                                        k++;
//                                    }
                                    countDownLatch.countDown();
                                }
                            });
                            A.start();
                        }
                        try {
                            countDownLatch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        LogUtil.d("integer = " + integer.get() + ";j = " + j + ";k = " + k);
                    }
                }.start();
            }
        });

        /**
         * 自测总结：
         * 1.多个读锁可以同时使用；
         * 2.读锁使用时，写锁无法进入；
         *
         *  一、线程进入读锁的前提条件：
         *  1.没有其他线程的写锁，
         *  2.没有写请求或者有写请求，但调用线程和持有锁的线程是同一个。
         *  二、线程进入写锁的前提条件：
         *  1.没有其他线程的读锁
         *  2.没有其他线程的写锁
         *  */
        addBeanToMList("ReentrantReadWriteLock", new View.OnClickListener() {

            private ReentrantReadWriteLock rLock = new ReentrantReadWriteLock();
            private ReentrantReadWriteLock.ReadLock readLock = rLock.readLock();
            private ReentrantReadWriteLock.WriteLock writeLock = rLock.writeLock();
            private int i = 0;

            @Override
            public void onClick(View v) {
                i = 0;

                final Thread A = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            readLock.lock();
                            LogUtil.d("线程A执行---start");
                            while (i == 0) {
                                SystemClock.sleep(100);
                                LogUtil.d("线程A执行---readLock:" + i);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                LogUtil.d("线程A执行---end");
                                readLock.unlock();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, "A");

                final Thread C = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            readLock.lock();
                            LogUtil.d("线程C执行---start");
                            while (i == 0) {
                                SystemClock.sleep(100);
                                LogUtil.d("线程C执行---readLock:" + i);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                LogUtil.d("线程C执行---end");
                                readLock.unlock();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, "C");

                final Thread B = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            writeLock.lock();
                            LogUtil.d("线程B执行---start");
                            i++;
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            LogUtil.d("线程B执行---end");
                            writeLock.unlock();
                        }
                    }
                }, "B");

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        A.start();
                        C.start();
                    }
                }, 500);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        B.start();
                    }
                }, 800);
            }
        });

        addBeanToMList("ReentrantLock限时等待", new View.OnClickListener() {

            private ReentrantLock rLock = new ReentrantLock();

            @Override
            public void onClick(View v) {
                final Thread A = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LogUtil.d("线程A执行---start");
                        try {
//                            while(!rLock.tryLock()){
                            while (!rLock.tryLock(500, TimeUnit.MILLISECONDS)) {
                                LogUtil.d("线程A执行---tryLock:" + false);
                            }
                            LogUtil.d("线程A执行---tryLock:" + true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                rLock.unlock();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            LogUtil.d("线程A执行---end");
                        }
                    }
                }, "A");
                final Thread B = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LogUtil.d("线程B执行---start");
                        try {
                            rLock.lock();
                            LogUtil.d("线程B执行---wait");
                            SystemClock.sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            rLock.unlock();
                            LogUtil.d("线程B执行---end");
                        }
                    }
                }, "B");

                B.start();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        A.start();
                    }
                }, 500);
            }
        });

        addBeanToMList("ReentrantLock响应中断", new View.OnClickListener() {

            private ReentrantLock rLock = new ReentrantLock();
            private ReentrantLock rLock2 = new ReentrantLock();

            @Override
            public void onClick(View v) {
                final Thread A = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LogUtil.d("线程A执行---start");
                        try {
                            rLock.lockInterruptibly();
                            SystemClock.sleep(100);
                            LogUtil.d("线程A执行---wait");
                            rLock2.lockInterruptibly();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                rLock.unlock();
                                rLock2.unlock();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            LogUtil.d("线程A执行---end");
                        }
                    }
                }, "A");
                final Thread B = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LogUtil.d("线程B执行---start");
                        try {
                            rLock2.lockInterruptibly();
                            SystemClock.sleep(100);
                            LogUtil.d("线程B执行---wait");
                            rLock.lockInterruptibly();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            rLock2.unlock();
                            rLock.unlock();
                            LogUtil.d("线程B执行---end");
                        }
                    }
                }, "B");

                A.start();
                B.start();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        A.interrupt();
                    }
                }, 2000);
            }
        });

        /**
         * 这个demo，并没有出现理论现象
         */
        addBeanToMList("ReentrantLock非公平锁", new View.OnClickListener() {

            ReentrantLock rLock = new ReentrantLock(false);

            @Override
            public void onClick(View v) {

                for (i = 0; i < 10; i++) {
                    Thread A = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try {
                                LogUtil.d("线程" + Thread.currentThread().getName() + "执行---start");
                                rLock.lock();
                                LogUtil.d("线程" + Thread.currentThread().getName() + "执行ing");
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                rLock.unlock();
                            }
                        }
                    }, "A" + i);
                    A.start();
                }
            }
        });

        /**
         * 这个demo，并没有出现理论现象
         */
        addBeanToMList("ReentrantLock公平锁", new View.OnClickListener() {

            ReentrantLock rLock = new ReentrantLock(true);

            @Override
            public void onClick(View v) {

                for (i = 0; i < 10; i++) {
                    Thread A = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try {
                                LogUtil.d("线程" + Thread.currentThread().getName() + "执行---start");
                                rLock.lock();
                                LogUtil.d("线程" + Thread.currentThread().getName() + "执行ing");
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                rLock.unlock();
                            }
                        }
                    }, "A" + i);
                    A.start();
                }
            }
        });

        addBeanToMList("ReentrantLock调用await/notify", new View.OnClickListener() {

            private boolean isNeedWait = true;

            @Override
            public void onClick(View v) {
                Thread A = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LogUtil.d("线程A执行---start");
                        try {
                            reentrantLock.lock();
                            isNeedWait = true;
                            if (isNeedWait) {
                                try {
                                    LogUtil.d("线程A执行---wait锁");
                                    condition.await();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            reentrantLock.unlock();
                            LogUtil.d("线程A执行---end");
                        }
                    }
                }, "A");
                Thread B = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LogUtil.d("线程B执行---start");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            reentrantLock.lock();
                            isNeedWait = false;
                            LogUtil.d("线程B执行---notify锁");
                            condition.signal();
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            reentrantLock.unlock();
                            LogUtil.d("线程B执行---end");
                        }
                    }
                }, "B");

                A.start();
                B.start();
            }
        });

        addBeanToMList("synchronized调用wait(1000)/notify", new View.OnClickListener() {

            private boolean isNeedWait = true;

            @Override
            public void onClick(View v) {
                Thread A = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LogUtil.d("线程A执行---start");
                        synchronized (lock) {
                            isNeedWait = true;
                            if (isNeedWait) {
                                try {
                                    LogUtil.d("线程A执行---wait锁");
                                    lock.wait(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        LogUtil.d("线程A执行---end");
                    }
                }, "A");
                Thread B = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LogUtil.d("线程B执行---start");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        isNeedWait = false;
                        LogUtil.d("线程B执行---notify锁");
                        synchronized (lock) {
                            lock.notify();
                        }
                        LogUtil.d("线程B执行---end");
                    }
                }, "B");

                A.start();
                B.start();
            }
        });

        addBeanToMList("synchronized调用wait/notify", new View.OnClickListener() {

            private boolean isNeedWait = true;

            @Override
            public void onClick(View v) {
                Thread A = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LogUtil.d("线程A执行---start");
                        synchronized (lock) {
                            isNeedWait = true;
                            if (isNeedWait) {
                                try {
                                    LogUtil.d("线程A执行---wait锁");
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        LogUtil.d("线程A执行---end");
                    }
                }, "A");
                Thread B = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LogUtil.d("线程B执行---start");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        isNeedWait = false;
                        LogUtil.d("线程B执行---notify锁");
                        synchronized (lock) {
                            lock.notify();
                        }
                        LogUtil.d("线程B执行---end");
                    }
                }, "B");

                A.start();
                B.start();
            }
        });

        addBeanToMList("synchronized锁", new View.OnClickListener() {

            private boolean isNeedWait = true;

            @Override
            public void onClick(View v) {
                Thread A = new Thread(new Runnable() {

                    private int i = 0;

                    @Override
                    public void run() {
                        LogUtil.d("线程A执行---start");
                        synchronized (lock) {
                            while (true) {
                                try {
                                    Thread.sleep(500);
                                    LogUtil.d("线程A执行---" + (i++));
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        }

                    }
                }, "A");
                Thread B = new Thread(new Runnable() {

                    private int i = 0;

                    @Override
                    public void run() {
                        LogUtil.d("线程B执行---start");
                        synchronized (lock) {
                            while (true) {
                                try {
                                    Thread.sleep(500);
                                    LogUtil.d("线程B执行---" + (i++));
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    }
                }, "B");

                A.start();
                B.start();
            }
        });

        addBeanToMList("线程优先级", new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Thread A = new Thread(new Runnable() {

                    private int i = 0;

                    @Override
                    public void run() {
                        Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_AUDIO);
                        while (true) {
                            LogUtil.d("线程A执行---start" + i++);
                        }
                    }
                }, "A");
                Thread B = new Thread(new Runnable() {

                    private int i = 0;

                    @Override
                    public void run() {
                        while (true) {
                            Process.setThreadPriority(Process.THREAD_PRIORITY_DEFAULT);
                            LogUtil.d("线程B执行---start" + i++);
                        }
                    }
                }, "B");

                A.start();
                B.start();
            }
        });
    }
}
