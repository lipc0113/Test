/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.lpc.test.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.lpc.test.R;

/**
 * 搜索：渐变关键性代码
 *
 */
public class CircleProgressBar extends View {

    private final int[] goldenColors = new int[]{Color.parseColor("#8B4A26"), Color.parseColor("#AB6B46"),
            Color.parseColor("#C88863"), Color.parseColor("#E5A680"),
            Color.parseColor("#55FFC09A")};

    private float progress = 0;
    private float strokeWidth = 2;
    private float backgroundStrokeWidth = 2;
    private int color = Color.BLACK;
    private int backgroundColor = Color.GRAY;

    private int startAngle = -90;
    private RectF rectF;
    private Paint backgroundPaint;
    private Paint foregroundPaint;
    private int mXCenter;
    private int mYCenter;

    public CircleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        rectF = new RectF();
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircleProgressBar, 0, 0);
        try {
            progress = typedArray.getFloat(R.styleable.CircleProgressBar_progress_value, progress);
            strokeWidth = typedArray.getDimension(R.styleable.CircleProgressBar_progress_width, strokeWidth);
            backgroundStrokeWidth =
                    typedArray.getDimension(R.styleable.CircleProgressBar_background_width, backgroundStrokeWidth);
            color = typedArray.getInt(R.styleable.CircleProgressBar_progress_color, color);
            backgroundColor = typedArray.getInt(R.styleable.CircleProgressBar_background_color, backgroundColor);
        } finally {
            typedArray.recycle();
        }

        backgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        backgroundPaint.setColor(backgroundColor);
        backgroundPaint.setStyle(Paint.Style.STROKE);
        backgroundPaint.setStrokeWidth(backgroundStrokeWidth);

        foregroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        foregroundPaint.setColor(color);
        foregroundPaint.setStyle(Paint.Style.STROKE);
        foregroundPaint.setStrokeWidth(strokeWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mXCenter = getMeasuredWidth();
        mYCenter = getMeasuredHeight();
        canvas.drawOval(rectF, backgroundPaint);
        float angle = 360 * progress / 100;

        // 渐变关键性代码
        float[] arcPostion = new float[]{0f * progress / 100, 0.1f * progress / 100,
                0.2f * progress / 100, 0.6f * progress / 100,
                1f * progress / 100};
        LinearGradient gradient = new LinearGradient(mXCenter / 2, 0, mXCenter / 2, mYCenter,
                goldenColors, arcPostion, Shader.TileMode.MIRROR);
        foregroundPaint.setShader(gradient);
        foregroundPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(rectF, startAngle, angle, false, foregroundPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        final int width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        final int min = Math.min(width, height);
        setMeasuredDimension(min, min);
        float highStroke = (strokeWidth > backgroundStrokeWidth) ? strokeWidth : backgroundStrokeWidth;
        rectF.set(0 + highStroke / 2, 0 + highStroke / 2, min - highStroke / 2, min - highStroke / 2);
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = (progress <= 100) ? progress : 100;
        invalidate();
    }

    public float getProgressBarWidth() {
        return strokeWidth;
    }

    public void setProgressBarWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
        foregroundPaint.setStrokeWidth(strokeWidth);
        requestLayout();
        invalidate();
    }

    public float getBackgroundProgressBarWidth() {
        return backgroundStrokeWidth;
    }

    public void setBackgroundProgressBarWidth(float backgroundStrokeWidth) {
        this.backgroundStrokeWidth = backgroundStrokeWidth;
        backgroundPaint.setStrokeWidth(backgroundStrokeWidth);
        requestLayout();
        invalidate();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        foregroundPaint.setColor(color);
        invalidate();
        requestLayout();
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        backgroundPaint.setColor(backgroundColor);
        invalidate();
        requestLayout();
    }

    /**
     * Set the progress with an animation.
     * Note that the {@link ObjectAnimator} Class automatically set the progress
     * so don't call the {@link CircleProgressBar#setProgress(float)} directly within this method.
     *
     * @param progress The progress it should animate to it.
     */
    public void setProgressWithAnimation(float progress) {
        setProgressWithAnimation(progress, 1500);
    }

    /**
     * Set the progress with an animation.
     * Note that the {@link ObjectAnimator} Class automatically set the progress
     * so don't call the {@link CircleProgressBar#setProgress(float)} directly within this method.
     *
     * @param progress The progress it should animate to it.
     * @param duration The length of the animation, in milliseconds.
     */
    public void setProgressWithAnimation(float progress, int duration) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "progress", progress);
        objectAnimator.setDuration(duration);
        objectAnimator.setInterpolator(new DecelerateInterpolator());
        objectAnimator.start();
    }
}
