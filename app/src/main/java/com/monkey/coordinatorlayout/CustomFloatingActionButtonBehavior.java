package com.monkey.coordinatorlayout;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Description:自定义FloatingActionButtonBehavior
 * Author: lanjing
 * Time: 2017/5/19 13:57
 */

public class CustomFloatingActionButtonBehavior extends FloatingActionButton.Behavior {

    public CustomFloatingActionButtonBehavior() {
        super();
    }

    public CustomFloatingActionButtonBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        boolean result =  nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
                || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
        Log.e("TAG", "onStartNestedScroll: result"+result);
        return result;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        /*
        在sdk是25以上有bug:floatingactionbutton消失了就不再显示了
            Calling child.hide() on the floating action button sets the view’s visibility to View.GONE,
            which means now (as of 25.1.0), the onNestedScroll method call will be skipped for the floating
            action button in the future (because it skips all views whose visibility is GONE).
         */

        if(dyConsumed>0&&child.getVisibility()==View.VISIBLE){
            //child.hide();
            child.setVisibility(View.INVISIBLE);//不设置为gone，否则消失了就不再显示了
        }else if(dyConsumed<0&&child.getVisibility()!=View.VISIBLE){
            //child.show();
            child.setVisibility(View.VISIBLE);
        }
        Log.e("TAG", "dxConsumed: "+dxConsumed+
                "   dyConsumed:"+dyConsumed+
                "   dxUnconsumed:"+dxUnconsumed+
                "   dyUnconsumed:"+dyUnconsumed
        );
    }
}
