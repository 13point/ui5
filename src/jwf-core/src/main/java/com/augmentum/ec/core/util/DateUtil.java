/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.core.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.augmentum.ec.core.constant.CommonConstant;

/**
 * The Class DateUtil.
 */
public final class DateUtil {

    /** The Constant DEFAULT_LOCALE. */
    private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;

    /**
     * Instantiates a new date util.
     */
    private DateUtil() {
        // empty
    }

    /**
     * Check if after today.
     *
     * @param date the date
     * @return true, if successful
     */
    public static boolean checkIfAfterToday(final Date date) {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);
        calendarDate.set(Calendar.HOUR_OF_DAY, 0);
        calendarDate.set(Calendar.MINUTE, 0);
        calendarDate.set(Calendar.SECOND, 0);
        calendarDate.set(Calendar.MILLISECOND, 0);

        Calendar calendarNow = Calendar.getInstance();
        calendarNow.set(Calendar.HOUR_OF_DAY, 0);
        calendarNow.set(Calendar.MINUTE, 0);
        calendarNow.set(Calendar.SECOND, 0);
        calendarNow.set(Calendar.MILLISECOND, 0);

        return calendarDate.after(calendarNow);
    }

    /**
     * Format date.
     *
     * @param date the date
     * @param dateFormat the date format
     * @return the string
     */
    public static String formatDate(final Date date, final String dateFormat) {
        return formatDate(date, dateFormat, DEFAULT_LOCALE);
    }

    /**
     * Format date.
     *
     * @param date the date
     * @param dateFormat the date format
     * @param locale the locale
     * @return the string
     */
    public static String formatDate(final Date date, final String dateFormat, final Locale locale) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf =
                new SimpleDateFormat(StringUtils.isEmpty(dateFormat) ? CommonConstant.DATE_FORMAT_LONG : dateFormat,
                        (null == locale) ? locale : DEFAULT_LOCALE);
        return sdf.format(date);
    }

    /**
     * Format date String to Timestamp.
     *
     * @param dateStr the date String
     * @param dateFormat the date format
     * @return Timestamp the timestamp
     */
    public static Timestamp formatDateString(final String dateStr, final String dateFormat) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }

        SimpleDateFormat sdf =
                new SimpleDateFormat(StringUtils.isEmpty(dateFormat) ? CommonConstant.DATE_FORMAT_LONG : dateFormat);
        Timestamp ts = null;
        try {
            ts = new Timestamp(sdf.parse(dateStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ts;
    }
}
