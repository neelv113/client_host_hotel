package com.example.ashish.client_host.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {

    private final String TAG = BaseFragment.class.getSimpleName();

    private Activity activityRef;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        activityRef = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getParentFragment() == null) {
            setRetainInstance(true);
        }
    }

    public Activity getActivityRef() {
        return activityRef;
    }

}
