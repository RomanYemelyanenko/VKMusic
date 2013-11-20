package com.vkmusic;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

public class AudioSourcesDrawerFragment extends Fragment {

    private ExpandableListAdapter _sourceListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_audio_sources, null);
    }

    private ExpandableListView getSourceList()
    {
        return (ExpandableListView)getView().findViewById(R.id.audio_source_list);
    }
}