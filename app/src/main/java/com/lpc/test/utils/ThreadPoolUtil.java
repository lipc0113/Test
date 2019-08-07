package com.lpc.test.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUtil {

	private ExecutorService threadPool;
	
	private ThreadPoolUtil() {
		super();
		int countProcessors = Runtime.getRuntime().availableProcessors() * 2;
		threadPool = Executors.newFixedThreadPool(countProcessors);
	}

	private static class ThreadPoolUtilSingleTon{

		private static final ThreadPoolUtil threadPoolUtil = new ThreadPoolUtil();
	}
	
	public static ThreadPoolUtil getInstance(){

		return ThreadPoolUtilSingleTon.threadPoolUtil;
	}
	
	public void addTask(Runnable task){
		threadPool.submit(task);
	}

	public void shutdown(){
		threadPool.shutdown();
	}
}
