package com.vkmusic;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by Roman on 17.11.13.
 */
public class DrawerProvider {
    private  Activity _activity;

    public DrawerProvider(Activity activity)
    {
        _activity = activity;
        ViewGroup content = getContentView();
        ViewGroup parent= getContentViewParent();
        parent.removeView(content);

        ViewGroup drawer = (ViewGroup)LayoutInflater.from(_activity).inflate(R.layout.drawer_main, null);
        FrameLayout container = (FrameLayout)drawer.findViewById(R.id.container);
        container.addView(content);
        parent.addView(drawer);
    }

    public void openLeftSideBar()
    {
        getDrawer().openDrawer(Gravity.START);
    }

    public void openRightSideBar()
    {
        getDrawer().openDrawer(Gravity.END);
    }

    public DrawerLayout  getDrawer()
    {
        return (DrawerLayout)_activity.findViewById(R.id.drawer_layout);
    }

    private ViewGroup getContentView()
    {
        return (ViewGroup)_activity.findViewById(android.R.id.content).getParent();
    }

    private  ViewGroup getContentViewParent()
    {
        return  (ViewGroup)getContentView().getParent();
    }
}
