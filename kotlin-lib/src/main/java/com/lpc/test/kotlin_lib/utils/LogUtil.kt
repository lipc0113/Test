package com.lpc.test.kotlin_lib.utils

import android.util.Log

/**
 * 功能:
 *
 *
 * 描述: 正式Tag为class名称，lipc0113临时测试log
 *
 *
 * Created by lipc0113 on 2017/12/21.
 */
class LogUtil private constructor() {
    companion object {
        private const val TAG = "lipc0113"

        /**
         * show error note
         *
         * @param error
         */
        fun e(error: String) {
            Log.e(TAG, "---> $error")
        }

        fun e(tag: String?, error: String) {
            Log.e(tag, "---> $error")
        }

        fun e(throwable: Throwable?) {
            if (throwable != null) {
                val stackTrace = throwable.stackTrace
                val message = throwable.message
                val sb = StringBuffer()
                sb.append("fatal :")
                sb.append(message)
                sb.append("\n")
                for (i in stackTrace.indices) {
                    sb.append(stackTrace[i])
                }
                Log.e(TAG, "---> $sb")
            }
        }

        fun e(tag: String?, ex: Throwable?) {
            if (ex != null) {
                val stackTrace = ex.stackTrace
                val message = ex.message
                val sb = StringBuffer()
                sb.append("fatal :")
                sb.append(message)
                sb.append("\n")
                for (i in stackTrace.indices) {
                    sb.append(stackTrace[i])
                }
                Log.e(tag, "---> $sb")
            }
        }

        /**
         * show debug note
         *
         * @param infor
         */
        fun d(infor: String) {
            Log.d(TAG, "---> $infor")
        }

        fun d(tag: String?, infor: String) {
            Log.d(tag, "---> $infor")
        }

        fun i(infor: String) {
            Log.i(TAG, "---> $infor")
        }

        fun i(tag: String?, infor: String) {
            Log.i(tag, "---> $infor")
        }
    }

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }
}