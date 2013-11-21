package com.vkmusic;

import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;

public class MainActivity extends FragmentActivity {
    private DrawerLayout _drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_main);
        _drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        //_drawer.setScrimColor( getResources().getColor(R.color.dark_green));
        //_drawer.openDrawer(Gravity.END);
    }
}
