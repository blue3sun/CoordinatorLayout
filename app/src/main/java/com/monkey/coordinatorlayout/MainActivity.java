package com.monkey.coordinatorlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton mFloatingActinonBar;
    private CoordinatorLayout mCoordinatorLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //setActionBar();
    }

    private void setActionBar() {
        setSupportActionBar(mToolBar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
        }
    }

    private void initView() {
        mCoordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator_layout);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.rgb(255,0,0));//收缩至最小是title的颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.rgb(0,0,255));//完全显示时title的颜色
        mToolBar = (Toolbar)findViewById(R.id.toolbar);
        mFloatingActinonBar = (FloatingActionButton)findViewById(R.id.floating_action_button);
        mFloatingActinonBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mCoordinatorLayout,"SnackBar......",Snackbar.LENGTH_LONG)
                        .setAction("cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "点击了按钮", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }
}
