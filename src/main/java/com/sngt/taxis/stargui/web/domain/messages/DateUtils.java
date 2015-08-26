package com.sngt.taxis.stargui.web.domain.messages;

import java.text.*;
import java.util.*;
import java.math.*;
import org.slf4j.*;

public class DateUtils
{
    public static final Logger logger;
    public static final String FULL_NO_YEAR_FORMAT = "cccc dd MMMM";
    public static final String TIMESTAMP_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String HOUR_FORMAT = "HH:mm";
    public static final String HOUR_FORMAT_JOB_CPLT = "HH'h'mm";
    public static final String TIMESTAMP_KML_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String TIMESTAMP_OFFER_FORMAT = "dd-MM-yy'A'HH'H'mm";
    public static final String TIMESTAMP_RELEVE_FORMAT = "dd-MM-yy' A 'HH'H'mm";
    public static final String DAY_FORMAT = "dd-MM-yy";
    public static final String CPAM_BIRTH_FORMAT = "yyyyMMdd";
    public static final String STAT_DIST_DATE_FORMAT = "yyyy/MM/dd";
    public static final String STAT_DIST_HOUR_FORMAT = "HH:mm:ss";
    public static final SimpleDateFormat FULL_NO_YEAR_F;
    
    public static String formatDate(final Date date) {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
    }
    
    public static String formatDateFullNoYear(final Date date) {
        return DateUtils.FULL_NO_YEAR_F.format(date);
    }
    
    public static String formatTime(final Date date) {
        if (date != null) {
            return new SimpleDateFormat("HH:mm").format(date);
        }
        return "";
    }
    
    public static String formatDateStatDistDateFormat(final Date date) {
        return new SimpleDateFormat("yyyy/MM/dd").format(date);
    }
    
    public static String formatDateStatDistHourFormat(final Date date) {
        return new SimpleDateFormat("HH:mm:ss").format(date);
    }
    
    public static String formatDateOfferFormat(final Date date) {
        return new SimpleDateFormat("dd-MM-yy'A'HH'H'mm").format(date);
    }
    
    public static String formatDateReleveFormat(final Date date) {
        return new SimpleDateFormat("dd-MM-yy' A 'HH'H'mm").format(date);
    }
    
    public static String formatDateInDay(final Date date) {
        return new SimpleDateFormat("dd-MM-yy").format(date);
    }
    
    public static Date parseTimeFormat(final String date) {
        try {
            return new SimpleDateFormat("HH:mm").parse(date);
        }
        catch (ParseException e) {
            DateUtils.logger.error("parseTimeFormat :", (Object)e.getMessage());
            return null;
        }
    }
    
    public static Date parseDate(final String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(date);
        }
        catch (ParseException e) {
            DateUtils.logger.error("parseDate :", (Object)e.getMessage());
            return null;
        }
    }
    
    public static String formatDateForKml(final Date date) {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(date);
    }
    
    public static String formatDateByPattern(final String pattern) {
        try {
            return new SimpleDateFormat(pattern).format(new Date());
        }
        catch (Exception e) {
            DateUtils.logger.error("formatDateByPattern :", (Object)e.getMessage());
            return null;
        }
    }
    
    public static String reformatDate(final String pattern, final Date date) {
        try {
            return new SimpleDateFormat(pattern).format(date);
        }
        catch (Exception e) {
            DateUtils.logger.error("formatDateByPattern :", (Object)e.getMessage());
            return null;
        }
    }
    
    public static Date parseDateForKml(final String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(date);
        }
        catch (ParseException e) {
            DateUtils.logger.error("parseDateForKml :", (Object)e.getMessage());
            return null;
        }
    }
    
    public static String getHourForOffer(final String dateStr) {
        Date date = null;
        try {
            date = new SimpleDateFormat("dd-MM-yy'A'HH'H'mm").parse(dateStr);
        }
        catch (Exception e) {
            DateUtils.logger.error("getHourForOffer :", (Object)e.getMessage());
        }
        if (date != null) {
            return new SimpleDateFormat("HH'h'mm").format(date);
        }
        return "";
    }
    
    public static Integer getSecondSinceMidnight() {
        final Calendar calendar = Calendar.getInstance();
        final int second = calendar.get(13);
        final int minute = calendar.get(12);
        final int hour = calendar.get(11);
        return second + minute * 60 + hour * 3600;
    }
    
    public static long getTimestampUnix() {
        return System.currentTimeMillis();
    }
    
    public static int convertToSecondsSinceMidnight(final long timestamp) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        final int second = calendar.get(13);
        final int minute = calendar.get(12);
        final int hour = calendar.get(11);
        return second + minute * 60 + hour * 3600;
    }
    
    public static int compareDays(final Calendar c1, final Calendar c2) {
        if (c1.get(1) != c2.get(1)) {
            return c1.get(1) - c2.get(1);
        }
        if (c1.get(2) != c2.get(2)) {
            return c1.get(2) - c2.get(2);
        }
        return c1.get(5) - c2.get(5);
    }
    
    public static long getSecondBetweenDates(final Date recentDate, final Date oldDate) {
        return (recentDate.getTime() - oldDate.getTime()) / 1000L;
    }
    
    public static Date tryParse(final String strDate, final String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(strDate);
        }
        catch (ParseException e) {
            return null;
        }
    }
    
    public static int getDelayFromDA(final String daTime) {
        final Calendar calendar = Calendar.getInstance();
        final Calendar now = Calendar.getInstance();
        try {
            final Date date = new SimpleDateFormat("dd-MM-yy'A'HH'H'mm").parse(daTime);
            calendar.setTime(date);
        }
        catch (Exception e) {
            DateUtils.logger.error("Impossible de parser la date : " + daTime, (Object)e.getMessage());
            return -1;
        }
        if (now.before(calendar)) {
            return (int)((calendar.getTimeInMillis() - now.getTimeInMillis()) / 60000L);
        }
        return -1;
    }
    
    public static int getDelayFromMH(final String daTime) {
        final Calendar calendar = Calendar.getInstance();
        final Calendar now = Calendar.getInstance();
        try {
            final Date date = new SimpleDateFormat("HH:mm").parse(daTime);
            calendar.setTime(date);
            calendar.set(now.get(1), now.get(2), now.get(5));
        }
        catch (Exception e) {
            DateUtils.logger.error("Impossible de parser la date : " + daTime, (Object)e.getMessage());
            return -1;
        }
        if (now.before(calendar)) {
            return (int)((calendar.getTimeInMillis() - now.getTimeInMillis()) / 60000L);
        }
        return -1;
    }
    
    public static int[] splitSecondsToComponentTimes(final BigDecimal biggy) {
        final long longVal = biggy.longValue();
        final int hours = (int)longVal / 3600;
        int remainder = (int)longVal - hours * 3600;
        final int mins = remainder / 60;
        final int secs;
        remainder = (secs = remainder - mins * 60);
        final int[] ints = { hours, mins, secs };
        return ints;
    }
    
    public static String getStringFromTimeComponent(final int[] hours) {
        String time = "";
        if (hours[0] > 0) {
            time = time + hours[0] + " h";
        }
        if (hours[1] > 0) {
            time = time + hours[1] + " mn";
        }
        if (hours[2] > 0 && time.equals("")) {
            time = time + hours[2] + " s";
        }
        return time;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)DateUtils.class);
        FULL_NO_YEAR_F = new SimpleDateFormat("cccc dd MMMM");
    }
}
