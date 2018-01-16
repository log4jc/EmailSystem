package com.jwebcoder.emailsystem.utility;

import com.jwebcoder.emailsystem.enums.DateType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jason on 14/10/2017.
 */
public class DateUtility {
    private static Map<DateType, ThreadLocal<SimpleDateFormat>> simpleDataFormatThreadLocal = new HashMap<>();

    private static SimpleDateFormat getSimpleDateFormat(DateType dateType) {
        ThreadLocal<SimpleDateFormat> threadLocal = simpleDataFormatThreadLocal.get(dateType);

        if (threadLocal == null) {
            synchronized (simpleDataFormatThreadLocal) {
                threadLocal = simpleDataFormatThreadLocal.get(dateType);
                if (threadLocal == null) {
                    threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat(dateType.getType()));
                    simpleDataFormatThreadLocal.put(dateType, threadLocal);
                }
            }
        }

        return threadLocal.get();
    }

    public static Date getFormattedDateByString(DateType dateType, String date) throws ParseException {
        return getSimpleDateFormat(dateType).parse(date);
    }

    public static String getFormattedDateByDate(DateType dateType, Date date) {
        return getSimpleDateFormat(dateType).format(date);
    }

    public static String getCurrentDate() {
        return getFormattedDateByDate(DateType.YMDHMS_, new Date());
    }
}
