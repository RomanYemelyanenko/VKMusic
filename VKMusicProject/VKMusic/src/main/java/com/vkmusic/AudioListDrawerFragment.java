package com.vkmusic;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;

import DAL.AudioDescriptor;
import adapters.AudioListAdapter;

/**
 * Fragment used for managing interactions for and presentation of a navigation drawer.
 * See the <a href="https://developer.android.com/design/patterns/navigation-drawer.html#Interaction">
 * design guidelines</a> for a complete explanation of the behaviors implemented here.
 */
public class AudioListDrawerFragment extends Fragment {

    private ArrayAdapter<String> _audioListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<AudioDescriptor> dataList = new ArrayList<AudioDescriptor>();
        for(int i = 0; i < 100; i++)
        {
            AudioDescriptor descriptor = new AudioDescriptor("Audio: "+i);
            dataList.add(descriptor);
        }
        
        View view =inflater.inflate(R.layout.layout_audio_list, container, false);
        ListView list = (ListView)view.findViewById(R.id.audio_list);
        AudioListAdapter adapter = new AudioListAdapter(getActivity(),dataList);

        list.setAdapter(adapter);
        return  view;
    }

}
