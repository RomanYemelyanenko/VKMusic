package com.vkmusic;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import adapters.RightSideBarTabs;
import views.ITabBuilder;
import views.TabView;

public class AudioSourcesDrawerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_audio_sources, null);
        Activity activity = this.getActivity();
        ITabBuilder tabBuilder = new RightSideBarTabs(activity,activity.getFragmentManager());
        TabView tabView = (TabView)view.findViewById(R.id.audio_source_tabs);
        tabView.setTabBuilder(tabBuilder);
        return  view;
    }


}