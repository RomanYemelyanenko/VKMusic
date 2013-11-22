package com.vkmusic;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import adapters.RightSideBarTabs;
import views.ITabBuilder;
import views.TabView;

public class AudioSourcesDrawerFragment extends Fragment {

    public Context _context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        _context = this.getActivity();
        View view = inflater.inflate(R.layout.layout_audio_sources, null);
        FragmentActivity activity = this.getActivity();
        ITabBuilder tabBuilder = new RightSideBarTabs(activity, activity.getSupportFragmentManager() );
        TabView tabView = (TabView)view.findViewById(R.id.audio_source_tabs);
        tabView.setTabBuilder(tabBuilder);

        View login = view.findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(_context, R.anim.come_set);
//                view.clearAnimation();
//                view.startAnimation(animation);
                //transitiondrawable xml
            }
        });
        return  view;
    }


}