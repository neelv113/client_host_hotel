package com.example.ashish.client_host.util;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.Fragment;

import com.example.ashish.client_host.fragment.BaseFragment;

public class FragmentUtil {
    public static String getTag(Fragment fragment) {
        return fragment.getClass().getSimpleName();
    }

    public static String getTag(Class<? extends Fragment> fragmentClass) {
        return fragmentClass.getSimpleName();
    }

    public static Activity getActivity(Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }

        if (fragment instanceof BaseFragment) {
            return ((BaseFragment) fragment).getActivityRef();

        } else {
            return fragment.getActivity();
        }
    }

/*    public static App getApplication(Fragment fragment) {
        return (App) getActivity(fragment).getApplication();
    }*/

    public static Resources getResources(Fragment fragment) {
        return getActivity(fragment).getResources();
    }

    public static String getString(Fragment fragment, int res) {
        return getResources(fragment).getString(res);
    }
}
