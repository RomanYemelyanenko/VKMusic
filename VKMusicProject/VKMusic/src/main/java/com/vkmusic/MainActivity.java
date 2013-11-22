package com.vkmusic;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.util.Property;
import android.view.Gravity;
import android.view.View;
import android.view.ViewPropertyAnimator;


public class MainActivity extends FragmentActivity {
    private DrawerLayout _drawer;
    private View _contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_main);
        _contentView = findViewById(R.id.player_fragment);
        _drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        _drawer.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View view, float v) {

            }

            @Override
            public void onDrawerOpened(View view) {
                if(_contentView != null)
                {
                    _contentView.animate()
                            .scaleX(0.8f)
                            .scaleY(0.8f)
                            .alpha(0.5f)
                            .withLayer()
                            .setDuration(500)
                            .start();
                }
            }

            @Override
            public void onDrawerClosed(View view) {
                if(_contentView != null)
                {
                    _contentView.animate()
                            .scaleX(1f)
                            .scaleY(1f)
                            .alpha(1f)
                            .withLayer()
                            .setDuration(500)
                            .start();
                }
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
        //_drawer.setScrimColor( getResources().getColor(R.color.dark_green));
        //_drawer.openDrawer(Gravity.END);
    }
}
