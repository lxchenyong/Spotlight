package bz.sunlight.store.myspotlight;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.wooplr.spotlight.prefs.PreferencesManager;
import com.wooplr.spotlight.utils.SpotlightSequence;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zhy.com.highlight.HighLight;
import zhy.com.highlight.position.OnBottomPosCallback;
import zhy.com.highlight.position.OnLeftPosCallback;
import zhy.com.highlight.position.OnRightPosCallback;
import zhy.com.highlight.shape.CircleLightShape;
import zhy.com.highlight.shape.RectLightShape;

/**
 *
 * Created by Administrator on 2016/11/16.
 */
public class TestActivity extends Activity implements View.OnClickListener {

    private HighLight mHightLight;
    @BindView(R.id.bt_1)
    Button bt1;
    @BindView(R.id.bt_2)
    Button bt2;
    @BindView(R.id.bt_3)
    Button bt3;
    private Bean bean1;
    private Bean bean2;
    private List<Bean> beans1 = new ArrayList<>();
    private List<Bean> beans2 = new ArrayList<>();
    private boolean isflag ;

    private void initDataList(){
        List<String> strs = new ArrayList<>();
        strs.add("1234");
//        strs.add(new Pero("0","1234"));
//        strs.add(new Pero("1","2345"));
//        strs.add(new Pero("2","3456"));
        beans1.add(new Bean("1232","rewr",true,strs));
//        beans1.add(new Bean("3454f","rewr",true,strs));
//        beans1.add(new Bean("432fr","rewr",true,strs));

        List<String> strs2 = new ArrayList<>();
        strs.add("1234");
//        strs2.add(new Pero("0","1234"));
//        strs2.add(new Pero("1","2345"));
//        strs2.add(new Pero("2","3456"));
        beans2.add(new Bean("1232r","rewr",true,strs2));
//        beans2.add(new Bean("3454f","rewr",true,strs2));
//        beans2.add(new Bean("432fr","rewr",true,strs2));gfgfdgfg
    }
//    private void initData(){
//        List<Pero> strs3 = new ArrayList<>();
//        strs3.add(new Pero("0","1234"));
//        strs3.add(new Pero("1","2345"));
//        strs3.add(new Pero("2","3456"));
//
////        bean1 = new Bean("1232r","rewr",true,strs);
//
//        List<Pero> strs2 = new ArrayList<>();
//        strs2.add(new Pero("0","1234"));
//        strs2.add(new Pero("1","2345"));
////        strs2.add(new Pero("2","3456"));
//
////        bean2 = new Bean("1232r","rewr",true,strs2);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_ac);

        ButterKnife.bind(this);
//        initData();
        initDataList();
        //提示语暗示
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mHightLight = new HighLight(TestActivity.this)//
                        .anchor(findViewById(R.id.id_container))//如果是Activity上增加引导层，不需要设置anchor
                        .addHighLight(R.id.bt_1,R.layout.info_gravity_left_down,new OnRightPosCallback(10),new CircleLightShape())
                        .addHighLight(R.id.bt_2,R.layout.info_gravity_left_down,new OnBottomPosCallback(5),new CircleLightShape())
                        .addHighLight(R.id.bt_3,R.layout.info_gravity_left_down,new OnLeftPosCallback(45),new RectLightShape())
//                .addHighLight(view,R.layout.info_gravity_left_down,new OnRightPosCallback(10),new CircleLightShape())
                        .autoRemove(false)
                        .enableNext()
                        .setClickCallback(new HighLight.OnClickCallback() {
                            @Override
                            public void onClick() {
                                Toast.makeText(TestActivity.this, "clicked and show next tip view by yourself", Toast.LENGTH_SHORT).show();
                                mHightLight.next();
                            }
                        });
                mHightLight.show();
            }
        },400);

    }
 public void showNextTipView(View view){
//    Log.d("EqualsBuilder","EqualsBuilder===>"+EqualsBuilder.reflectionEquals(bean1,bean2)+
//    "======>"+EqualsBuilder.reflectionEquals(beans1,beans2));
     Log.d("EqualsBuilder", "======>"+beans1.equals(beans2));
     isflag = true;
     for (int i = 0; i <beans1.size() ; i++) {
//         for (int j = 0; j <beans2.size() ; j++) {
//             if (beans1.get(i).getId().equals(beans2.get(j).getId())){
                 Log.d("EqualsBuilder", "====22==>"+beans1.get(i).getStrs().equals(beans2.get(i).getStrs()));
                 if (EqualsBuilder.reflectionEquals(beans1.get(i),beans2.get(i))){
                     Log.d("EqualsBuilder", "======>他们是不相等的！！！弹出对话框");
                     isflag= false;
                     break;
//                 }
//             }

         }

     }
     if (isflag){
         Log.d("EqualsBuilder", "======>他们是相等的！");
     }
//     Log.d("EqualsBuilder","total32423423 times "+compare(beans1,beans2));
 }

    @OnClick
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_1:
                break;
            case R.id.bt_2:
                break;
            case R.id.bt_3:
                break;
        }
    }
    public void showNextTipView2(View view){
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list1.add("test"+i);
        }
        for (int i = 0; i < 10; i++) {
            list2.add("test"+i);
        }
//        compare(list1,list2);
        Log.d("EqualsBuilder","total times "+compare(list1,list2));
    }
    public static <T extends Comparable<T>> boolean compare(List<T> a, List<T> b) {
        if(a.size() != b.size())
            return false;
        Collections.sort(a);
        Collections.sort(b);
        for(int i=0;i<a.size();i++){
            if(!a.get(i).equals(b.get(i)))
                return false;
        }
        return true;
    }

    public void showNextTipView3(View view){
        startActivity(new Intent(this,ActvActivity.class));
    }
}
