package com.example.n_son.roombookingsupport.CustomView;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.example.n_son.roombookingsupport.R;

/**
 * Created by N-SON on 24/07/2017.
 */

@SuppressLint("AppCompatCustomView")
public class PasswordEditext extends EditText {

    Drawable eye,eyeStrike;
    Boolean visible = false;
    Boolean useStrike = false;
    Drawable drawable;
    final int ALPHA= (int)(255 * .55f);

    public PasswordEditext(Context context) {
        super(context);
        khoitao(null);
    }

    public PasswordEditext(Context context, AttributeSet attrs) {
        super(context, attrs);
        khoitao(attrs);
    }

    public PasswordEditext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        khoitao(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PasswordEditext(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        khoitao(attrs);
    }

    private void khoitao(AttributeSet attrs){
        if(attrs != null){
            TypedArray array = getContext().getTheme().obtainStyledAttributes(attrs,R.styleable.PasswordEditext,0,0);
            this.useStrike = array.getBoolean(R.styleable.PasswordEditext_useEyeStrike,false);
        }
        eye = ContextCompat.getDrawable(getContext(), R.drawable.ic_visibility_black_24dp).mutate();
        eyeStrike = ContextCompat.getDrawable(getContext(), R.drawable.ic_visibility_off_black_24dp).mutate();
        caidat();
    }

    private void caidat(){
        setInputType(InputType.TYPE_CLASS_TEXT | (visible? InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD : InputType.TYPE_TEXT_VARIATION_PASSWORD));
        Drawable[] drawables = getCompoundDrawables();
        drawable = useStrike && !visible? eyeStrike : eye;
        drawable.setAlpha(ALPHA);
        setCompoundDrawablesWithIntrinsicBounds(drawables[0],drawables[1],drawable,drawables[3]);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == event.ACTION_UP && event.getX() >= (912)){
            visible= !visible;
            caidat();
            invalidate();
        }
        return super.onTouchEvent(event);
    }
}