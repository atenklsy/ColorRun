package com.mengshitech.colorrun.fragment.lerun;

import java.util.Calendar;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Color;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by kanghuicong on 2016/7/15.
 */

public class TimeCount extends DigitalClock {

    Calendar mCalendar;
    private final static String m12 = "h:mm aa";
    private final static String m24 = "k:mm";
    private FormatChangeObserver mFormatChangeObserver;
    private Runnable mTicker;
    private Handler mHandler;
    private long endTime;
    LinearLayout layout;
    TextView tv;
    public static long distanceTime;
    private ClockListener mClockListener;
    private static boolean isFirst;
    private boolean mTickerStopped;
    @SuppressWarnings("unused")
    private String mFormat;

    public TimeCount(Context context) {
        super(context);
        initClock(context);
    }
    public TimeCount(Context context, AttributeSet attrs) {
        super(context, attrs);
        initClock(context);
    }
    private void initClock(Context context) {
        if (mCalendar == null) {
            mCalendar = Calendar.getInstance();
        }
        mFormatChangeObserver = new FormatChangeObserver();
        getContext().getContentResolver().registerContentObserver(
                Settings.System.CONTENT_URI, true, mFormatChangeObserver);
        setFormat();
    }
    @Override
    protected void onAttachedToWindow() {
        mTickerStopped = false;
        super.onAttachedToWindow();
        mHandler = new Handler();
        /**
         * requests a tick on the next hard-second boundary
         */
        mTicker = new Runnable() {
            public void run() {
                if (mTickerStopped)
                    return;
                long currentTime = System.currentTimeMillis();
                if (currentTime / 1000 == endTime / 1000 - 5 * 60) {
                    mClockListener.remainFiveMinutes();
                }
                distanceTime = endTime - currentTime;
                distanceTime /= 1000;
                if (distanceTime == 0) {
                    setText("00:00:00");
                    layout.setBackgroundColor(Color.parseColor("#cccccc"));
                    tv.setText("报名结束啦");
                    layout.setEnabled(false);
                    onDetachedFromWindow();
                } else if (distanceTime < 0) {
                    setText("00:00:00");
                    layout.setBackgroundColor(Color.parseColor("#cccccc"));
                    tv.setText("报名结束啦");
                    layout.setEnabled(false);
                    onDetachedFromWindow();
                } else {
                    setText(dealTime(distanceTime));
                }
                invalidate();
                long now = SystemClock.uptimeMillis();
                long next = now + (1000 - now % 1000);
                mHandler.postAtTime(mTicker, next);
            }
        };
        mTicker.run();
    }
    /**
     * deal time string
     *
     * @param time
     * @return
     */
    public static Spanned dealTime(long time) {
        Spanned str;
        StringBuffer returnString = new StringBuffer();
        long day = time / (24 * 60 * 60);
        long hours = (time % (24 * 60 * 60)) / (60 * 60);
        long minutes = ((time % (24 * 60 * 60)) % (60 * 60)) / 60;
        long second = ((time % (24 * 60 * 60)) % (60 * 60)) % 60;
        String dayStr = String.valueOf(day);
        String hoursStr = timeStrFormat(String.valueOf(hours));
        String minutesStr = timeStrFormat(String.valueOf(minutes));
        String secondStr = timeStrFormat(String.valueOf(second));
        returnString.append(dayStr).append("天").append(hoursStr).append("小时")
                .append(minutesStr).append("分钟").append(secondStr).append("秒");
        str = Html.fromHtml(returnString.toString());
        if (day >= 10) {
            ((Spannable) str).setSpan(new AbsoluteSizeSpan(16), 2, 3,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ((Spannable) str).setSpan(new AbsoluteSizeSpan(16), 5, 7,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ((Spannable) str).setSpan(new AbsoluteSizeSpan(16), 9, 11,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ((Spannable) str).setSpan(new AbsoluteSizeSpan(16), 13, 14,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            ((Spannable) str).setSpan(new AbsoluteSizeSpan(16), 1, 2,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ((Spannable) str).setSpan(new AbsoluteSizeSpan(16), 4, 6,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ((Spannable) str).setSpan(new AbsoluteSizeSpan(16), 8, 10,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ((Spannable) str).setSpan(new AbsoluteSizeSpan(16), 12, 13,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        // return returnString.toString();
        return str;
    }
    /**
     * format time
     *
     * @param timeStr
     * @return
     */
    private static String timeStrFormat(String timeStr) {
        switch (timeStr.length()) {
            case 1:
                timeStr = "0" + timeStr;
                break;
        }
        return timeStr;
    }
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mTickerStopped = true;
    }
    /**
     * Clock end time from now on.
     *
     * @param endTime
     */
    public void setEndTime(long endTime, LinearLayout layout, TextView tv) {
        this.endTime = endTime;
        this.layout = layout;
        this.tv = tv;

    }
    /**
     * Pulls 12/24 mode from system settings
     */
    private boolean get24HourMode() {
        return android.text.format.DateFormat.is24HourFormat(getContext());
    }
    private void setFormat() {
        if (get24HourMode()) {
            mFormat = m24;
        } else {
            mFormat = m12;
        }
    }
    private class FormatChangeObserver extends ContentObserver {
        public FormatChangeObserver() {
            super(new Handler());
        }
        @Override
        public void onChange(boolean selfChange) {
            setFormat();
        }
    }
    public void setClockListener(ClockListener clockListener) {
        this.mClockListener = clockListener;
    }
    public interface ClockListener {
        void timeEnd();
        void remainFiveMinutes();
    }
}
