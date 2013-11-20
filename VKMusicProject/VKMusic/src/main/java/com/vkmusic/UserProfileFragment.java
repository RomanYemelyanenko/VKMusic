package com.vkmusic;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UserProfileFragment extends Fragment {

    private boolean isLogined()
    { return false; }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if(isLogined())
            return inflater.inflate(R.layout.layout_user_profile,null);
        else
        {
            View view = inflater.inflate(R.layout.layout_login, null);
            View selectedView = view.findViewById(R.id.login_button);
            selectedView.setSelected(true);
            return  view;
        }

    }

}