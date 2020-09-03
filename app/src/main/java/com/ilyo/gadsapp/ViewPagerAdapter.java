package com.ilyo.gadsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ilyo.gadsapp.ui.LeaderBoardFragment;

/**
 * Created by iLyas Dev on 02/09/2020
 */
public class ViewPagerAdapter extends FragmentStateAdapter {

    private static final int ITEM_SIZE = 2;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new LeaderBoardFragment(position);
    }

    @Override
    public int getItemCount() {
        return ITEM_SIZE;
    }
}