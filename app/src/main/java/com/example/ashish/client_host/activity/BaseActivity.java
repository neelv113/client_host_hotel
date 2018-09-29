package com.example.ashish.client_host.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.ashish.client_host.fragment.BaseFragment;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //oncreate called
        super.onCreate(savedInstanceState);
    }

    public void addFragment(int containerViewId, BaseFragment baseFragment, String tag, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, baseFragment, tag);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void replaceFragment(int containerViewId, BaseFragment baseFragment, String tag, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, baseFragment, tag);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void removeFragment(BaseFragment baseFragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(baseFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    protected BaseFragment getFragmentByTag(String fragmentTag) {
        return (BaseFragment) getSupportFragmentManager().findFragmentByTag(fragmentTag);
    }

   /* @Override
    protected void onStart() {
        super.onStart();
        if (!(this instanceof HomeActivity)) {
            if (((App) getApplication()).setCurrentActivityListener(this)) {
                removeNoInternetSnackbar();
            }
        } else {
            ((App) getApplication()).setCurrentActivityListener(this);
        }
    }

    @Override
    public void onConnectionFailure() {
        SnackbarUtil.getInstance().showSnackBar(findViewById(android.R.id.content));
    }

    @Override
    public void onDBUpgradeCompleted() {

    }

    @Override
    public void onConnectionResumed() {

    }

    @Override
    public void showNoInternetSnackbar(View view, int length) {

    }

    @Override
    public void removeNoInternetSnackbar() {

    }*/
}
