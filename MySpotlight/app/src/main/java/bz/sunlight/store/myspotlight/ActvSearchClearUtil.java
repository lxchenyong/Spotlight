package bz.sunlight.store.myspotlight;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;


/**
 * AutoCompleteTextView增加删除按钮
 * Created by chenyong on 2016/11/28.
 */
public class ActvSearchClearUtil {

    public static void showActv(final AutoCompleteTextView actv, final Context mContext) {
        actv.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if (s.length() == 0) {
                    actv.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.drawable.ic_search_white_24dp), null, null, null);
                    //注意刚开始使用的是setCompoundDrawables方法就没有用，不知道为什么
                } else {
                    actv.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.drawable.ic_search_white_24dp), null,
                            mContext.getResources().getDrawable(R.drawable.ic_search_white_24dp), null);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        actv.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager m = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (!actv.isFocused()) {
                    m.showSoftInput(actv, InputMethodManager.SHOW_FORCED);
                }
                final int DRAWABLE_RIGHT = 2;
                //可以获得上下左右四个drawable，右侧排第二。图标没有设置则为空。
                Drawable rightIcon = actv.getCompoundDrawables()[DRAWABLE_RIGHT];
                if (rightIcon != null && event.getAction() == MotionEvent.ACTION_UP) {
                    //检查点击的位置是否是右侧的删除图标
                    //注意，使用getRwwX()是获取相对屏幕的位置，getX()可能获取相对父组件的位置
                    int leftEdgeOfRightDrawable = actv.getRight() - actv.getPaddingRight()
                            - rightIcon.getBounds().width();
                    if (event.getRawX() >= leftEdgeOfRightDrawable) {
                        actv.setText("");
                    }
                }
                return true;
            }
        });
    }
}
