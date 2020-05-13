package com.example.endtermandroid.ui.utilities.timezone;

import android.graphics.Canvas;

import java.util.Calendar;

public interface DialOverlay {
    public abstract void onDraw(Canvas canvas, int cX, int cY, int w, int h, Calendar calendar,
                                boolean sizeChanged);
}
