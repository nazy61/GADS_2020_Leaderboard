package com.nazycodes.gads2020leaderboard.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nazycodes.gads2020leaderboard.fragments.LearnersLeadersFragment;
import com.nazycodes.gads2020leaderboard.fragments.SkillIQLeaders;

public class TabAdapter extends FragmentStatePagerAdapter {

    private static int TAB_COUNT = 2;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return LearnersLeadersFragment.newInstance();
            case 1:
                return SkillIQLeaders.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return LearnersLeadersFragment.TITLE;

            case 1:
                return SkillIQLeaders.TITLE;

        }
        return super.getPageTitle(position);
    }

}
