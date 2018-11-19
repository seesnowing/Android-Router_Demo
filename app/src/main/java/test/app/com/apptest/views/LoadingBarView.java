package test.app.com.apptest.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/**
 * loadingBarView 是一个会执行加载中的圆圈效果图。
 * （1）可以设置圆圈的颜色
 * （2）大小
 * （3）设置阴影
 * （4）旋转角度。
 * （5）通过loading dialog 让他浮在app 上显示。
 */
public class LoadingBarView extends View {

    private Paint mPaintOfArc;
    // 圆弧的颜色
    int mColorOfArc = Color.WHITE;
    int mWidthOfArcLine = 8;
    //圆弧所在区域
    int mWidthOfArc = 150;
    int mHeightOfArc = 150;
    RectF mRectOfArc;
    //初始角度
    int mInitArcAngle = 110;
    //旋转角度
    int mSweepLengthOfArc = 150;
    Context mContext;

    //旋转状态
    boolean isRunning = false;

    public LoadingBarView(Context context) {
        super(context);
        init(context, null);
    }

    public LoadingBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public LoadingBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawArc(canvas);
    }

    protected void init(Context mCtx, AttributeSet attrs) {
        mRectOfArc = new RectF(mWidthOfArcLine,
                mWidthOfArcLine,
                mWidthOfArc - mWidthOfArcLine,
                mHeightOfArc - mWidthOfArcLine);
        mPaintOfArc = new Paint();
        mPaintOfArc.setStrokeWidth(mWidthOfArcLine);
        mPaintOfArc.setAntiAlias(true);
        mPaintOfArc.setStyle(Paint.Style.STROKE);
        mPaintOfArc.setColor(mColorOfArc);
        this.mContext=mCtx;
    }

    // 绘制圆弧
    void drawArc(Canvas canvas) {
        canvas.drawArc(mRectOfArc, -mInitArcAngle, mSweepLengthOfArc, false, mPaintOfArc);
        canvas.drawArc(mRectOfArc, 180 - mInitArcAngle, mSweepLengthOfArc, false, mPaintOfArc);
    }

    public void setLineColor(int color) {
        if (color < -1) {
            return;
        }
        this.mColorOfArc = color;
    }

    public void setLineWidth(int width) {
        this.mWidthOfArcLine = width;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidthOfArc = w;
        mHeightOfArc = h;
        mRectOfArc = new RectF(mWidthOfArcLine,
                mWidthOfArcLine,
                mWidthOfArc - mWidthOfArcLine,
                mHeightOfArc - mWidthOfArcLine);
    }

    public void startRunning() {

        if(isRunning){
            return;
        }
        isRunning=true;
        //缩放，
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(this, "scaleX", 0, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(this, "scaleY", 0, 1f);
        scaleX.setDuration(500);
        scaleY.setDuration(500);
        scaleX.setInterpolator(new DecelerateInterpolator());
        scaleY.setInterpolator(new DecelerateInterpolator());
        //旋转
        ObjectAnimator rotate = ObjectAnimator.ofFloat(this, "rotation", 0, 360);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setRepeatMode(ValueAnimator.RESTART);
        rotate.setRepeatCount(ValueAnimator.INFINITE);
        rotate.setDuration(700);
        //透明度
        ObjectAnimator alpha = ObjectAnimator.ofFloat(this, "alpha", 0f, 1f);
        alpha.setDuration(800);
        AnimatorSet mAnimatorSet = new AnimatorSet();
        mAnimatorSet.playTogether(scaleX, scaleY, rotate, alpha);
        mAnimatorSet.start();
    }

    public void stopRunning() {
        isRunning=false;
        //缩放，
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(this, "scaleX", 1f, 0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(this, "scaleY", 1, 0f);
        scaleX.setDuration(500);
        scaleY.setDuration(500);
        scaleX.setInterpolator(new DecelerateInterpolator());
        scaleY.setInterpolator(new DecelerateInterpolator());
        //旋转
        ObjectAnimator rotate = ObjectAnimator.ofFloat(this, "rotation", 0, 360);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setRepeatMode(ValueAnimator.RESTART);
        rotate.setDuration(700);
        //透明度
        ObjectAnimator alpha = ObjectAnimator.ofFloat(this, "alpha", 1f, 0);
        alpha.setDuration(900);
        AnimatorSet mAnimatorSet = new AnimatorSet();
        mAnimatorSet.playTogether(scaleX, scaleY, rotate, alpha);
        mAnimatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {


            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(statues!=null)
                    statues.loadEnd();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        mAnimatorSet.start();
    }

    public void setArcSize(int i) {
        this.mWidthOfArc=this.mHeightOfArc=i;
    }

    LoadStatues statues;
    public void setLoadStatusListener(LoadStatues statues){
        this.statues=statues;
    }

    public interface LoadStatues{
        void loadEnd();
    }
}
