package com.haotsang.neteasecloudmusic.utils;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;

/**
 * Log工具，类似android.util.Log。 tag自动产生，格式:
 * customTagPrefix:className.methodName(Line:lineNumber),
 * customTagPrefix为空时只输出：className.methodName(Line:lineNumber)。
 * http://blog.csdn.net/finddreams
 */
public class LogUtils {

    public static String customTagPrefix = "";

    public LogUtils() {
    }

    // 容许打印日志的类型，默认是true，设置为false则不打印
    public static boolean allowD = true;
    public static boolean allowE = true;
    public static boolean allowI = false;//
    public static boolean allowV = true;
    public static boolean allowW = true;
    public static boolean allowWtf = true;

    private static String generateTag(StackTraceElement caller) {
        String tag = "%s.%s(Line:%d)"; // 占位符
        String callerClazzName = caller.getClassName(); // 获取到类名
        callerClazzName = callerClazzName.substring(callerClazzName
                .lastIndexOf(".") + 1);
        tag = String.format(tag, callerClazzName, caller.getMethodName(),
                caller.getLineNumber()); // 替换
        tag = TextUtils.isEmpty(customTagPrefix) ? tag : customTagPrefix + ":"
                + tag;
        return tag;
    }

    /**
     * 自定义的logger
     */
    public static CustomLogger customLogger = new CustomLogger() {
        @Override
        public void d(String tag, String content) {
            Log.d(customTagPrefix + tag, content);
        }

        @Override
        public void d(String tag, String content, Throwable tr) {
            Log.d(customTagPrefix + tag, content, tr);
        }

        @Override
        public void e(String tag, String content) {
            Log.e(customTagPrefix + tag, content);
        }

        @Override
        public void e(String tag, String content, Throwable tr) {
            Log.e(customTagPrefix + tag, content, tr);
        }

        @Override
        public void i(String tag, String content) {
            Log.i(customTagPrefix + tag, content);
        }

        @Override
        public void i(String tag, String content, Throwable tr) {
            Log.i(customTagPrefix + tag, content, tr);
        }

        @Override
        public void v(String tag, String content) {
            Log.v(customTagPrefix + tag, content);
        }

        @Override
        public void v(String tag, String content, Throwable tr) {
            Log.v(customTagPrefix + tag, content, tr);
        }

        @Override
        public void w(String tag, String content) {
            Log.w(customTagPrefix + tag, content);
        }

        @Override
        public void w(String tag, String content, Throwable tr) {
            Log.w(customTagPrefix + tag, content, tr);
        }

        @Override
        public void w(String tag, Throwable tr) {
            Log.w(customTagPrefix + tag, tr);
        }

        @Override
        public void wtf(String tag, String content) {
            Log.wtf(customTagPrefix + tag, content);
        }

        @Override
        public void wtf(String tag, String content, Throwable tr) {
            Log.wtf(customTagPrefix + tag, content, tr);
        }

        @Override
        public void wtf(String tag, Throwable tr) {
            Log.wtf(customTagPrefix + tag, tr);
        }
    };

    public interface CustomLogger {
        void d(String tag, String content);

        void d(String tag, String content, Throwable tr);

        void e(String tag, String content);

        void e(String tag, String content, Throwable tr);

        void i(String tag, String content);

        void i(String tag, String content, Throwable tr);

        void v(String tag, String content);

        void v(String tag, String content, Throwable tr);

        void w(String tag, String content);

        void w(String tag, String content, Throwable tr);

        void w(String tag, Throwable tr);

        void wtf(String tag, String content);

        void wtf(String tag, String content, Throwable tr);

        void wtf(String tag, Throwable tr);
    }

    public static void d(String content) {
        if (!allowD) {
            return;
        }
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        if (customLogger != null) {
            customLogger.d(tag, content);
        } else {
            Log.d(tag, content);
        }

    }

    public static void d(String tag, String content) {
        if (!allowD) {
            return;
        }

        if (customLogger != null) {
            customLogger.d(tag, content);
        } else {
            Log.d(tag, content);
        }

    }


    public static void d(String content, Throwable tr) {
        if (!allowD) {
            return;
        }
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        if (customLogger != null) {
            customLogger.d(tag, content, tr);
        } else {
            Log.d(tag, content, tr);
        }

    }

    public static void e(String content) {
        if (!allowE) {
            return;
        }
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        if (customLogger != null) {
            customLogger.e(tag, content);
        } else {
            Log.e(tag, content);
        }

    }

    public static void e(String tag, String content) {
        if (!allowE) {
            return;
        }

        if (customLogger != null) {
            customLogger.e(tag, content);
        } else {
            Log.e(tag, content);
        }

    }

    public static void e(String content, Throwable tr) {
        if (!allowE) {
            return;
        }
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        if (customLogger != null) {
            customLogger.e(tag, content, tr);
        } else {
            Log.e(tag, content, tr);
        }

    }

    public static void i(String content) {
        if (!allowI) {
            return;
        }
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        if (customLogger != null) {
            customLogger.i(tag, content);
        } else {
            Log.i(tag, content);
        }

    }

    public static void i(String tag, String content) {
        if (!allowI) {
            return;
        }

        if (customLogger != null) {
            customLogger.i(tag, content);
        } else {
            Log.i(tag, content);
        }

    }

    public static void i(String content, Throwable tr) {
        if (!allowI) {
            return;
        }
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        if (customLogger != null) {
            customLogger.i(tag, content, tr);
        } else {
            Log.i(tag, content, tr);
        }

    }

    public static void v(String content) {
        if (!allowV) {
            return;
        }
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        if (customLogger != null) {
            customLogger.v(tag, content);
        } else {
            Log.v(tag, content);
        }
    }

    public static void v(String tag, String content) {
        if (!allowV) {
            return;
        }

        if (customLogger != null) {
            customLogger.v(tag, content);
        } else {
            Log.v(tag, content);
        }
    }

    public static void v(String content, Throwable tr) {
        if (!allowV) {
            return;
        }
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        if (customLogger != null) {
            customLogger.v(tag, content, tr);
        } else {
            Log.v(tag, content, tr);
        }
    }

    public static void w(String content) {
        if (!allowW) {
            return;
        }
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        if (customLogger != null) {
            customLogger.w(tag, content);
        } else {
            Log.w(tag, content);
        }
    }

    public static void w(String tag, String content) {
        if (!allowW) {
            return;
        }

        if (!TextUtils.isEmpty(content)) {
            if (customLogger != null) {
                customLogger.w(tag, content);
            } else {
                Log.w(tag, content);
            }
        }
    }


    public static void w(String content, Throwable tr) {
        if (!allowW) {
            return;
        }
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        if (customLogger != null) {
            customLogger.w(tag, content, tr);
        } else {
            Log.w(tag, content, tr);
        }
    }

    public static void w(Throwable tr) {
        if (!allowW) {
            return;
        }
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        if (customLogger != null) {
            customLogger.w(tag, tr);
        } else {
            Log.w(tag, tr);
        }
    }

    public static void wtf(String content) {
        if (!allowWtf) {
            return;
        }
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        if (customLogger != null) {
            customLogger.wtf(tag, content);
        } else {
            Log.wtf(tag, content);
        }
    }

    public static void wtf(String content, Throwable tr) {
        if (!allowWtf) {
            return;
        }
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        if (customLogger != null) {
            customLogger.wtf(tag, content, tr);
        } else {
            Log.wtf(tag, content, tr);
        }
    }

    public static void wtf(Throwable tr) {
        if (!allowWtf) {
            return;
        }
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        if (customLogger != null) {
            customLogger.wtf(tag, tr);
        } else {
            Log.wtf(tag, tr);
        }
    }

    private static StackTraceElement getCallerStackTraceElement() {
        return Thread.currentThread().getStackTrace()[4];
    }

    /**
     * 根据文件路径 递归创建文件
     *
     * @param file
     */
    public static void createDipPath(String file) {
        String parentFile = file.substring(0, file.lastIndexOf("/"));
        File file1 = new File(file);
        File parent = new File(parentFile);
        if (!file1.exists()) {
            parent.mkdirs();
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * A little trick to reuse a formatter in the same thread
     */
    private static class ReusableFormatter {

        private Formatter formatter;
        private StringBuilder builder;

        public ReusableFormatter() {
            builder = new StringBuilder();
            formatter = new Formatter(builder);
        }

        public String format(String msg, Object... args) {
            formatter.format(msg, args);
            String s = builder.toString();
            builder.setLength(0);
            return s;
        }
    }


    private static final ThreadLocal<ReusableFormatter> thread_local_formatter = new ThreadLocal<ReusableFormatter>() {
        @Override
        protected ReusableFormatter initialValue() {
            return new ReusableFormatter();
        }
    };

    public static String format(String msg, Object... args) {
        ReusableFormatter formatter = thread_local_formatter.get();
        return formatter.format(msg, args);
    }


}