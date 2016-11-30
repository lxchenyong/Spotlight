package bz.sunlight.store.myspotlight;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * fdds
 * Created by Administrator on 2016/11/28.
 */
public class ActvActivity  extends Fragment {
    private AutoCompleteTextView actv;
    private InputMethodManager m;
    private List<String> lists = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.actv_search,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showListView(view);
        showActv(view);
//        actv = (AutoCompleteTextView) view.findViewById(R.id.search_edit);
//        ActvSearchClearUtil.showActv(actv,getActivity());
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.actv_search);
//        showListView();
//        showActv();
//    }


    private void showListView(View view){
        lists.add("11111111111111111");
        lists.add("22222222222222222");
        lists.add("33333333333333333");
        lists.add("444444444444444444");
        lists.add("5555555555555555");
        lists.add("666666666666666666666");
        lists.add("777777777777777777777");
        lists.add("888888888888888888888");
        lists.add("999999999999999999999");
        lists.add("qqqqqqqqqqqqqqqqqqqqqqq");
        lists.add("wwwwwwwwwwwwwwwwwwwwww");
        lists.add("eeeeeeeeeeeeeeeeeeeeeee");
        lists.add("rrrrrrrrrrrrrrrrrrrrr");
        lists.add("tttttttttttttttttt");
        lists.add("yyyyyyyyyyyyyyyyyyyyyy");
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,lists);
        listView.setAdapter(adapter);
    }

    private void showActv(View view){
        actv = (AutoCompleteTextView) view.findViewById(R.id.search_edit);

        actv.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if (s.length() == 0) {
                    actv.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_search_black_18dp), null, null, null);
                    //注意刚开始使用的是setCompoundDrawables方法就没有用，不知道为什么
                } else {
                    actv.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_search_black_18dp), null,
                            getResources().getDrawable(R.drawable.ic_clear_black_18dp), null);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });
        actv.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
// TODO Auto-generated method stub
                m=(InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if(actv.isFocused()){
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
