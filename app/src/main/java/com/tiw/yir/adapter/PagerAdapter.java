package com.tiw.yir.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.tiw.yir.fragment.ElectedStudentsFragment;
import com.tiw.yir.fragment.MonthlyScholarshipFragment;
import com.tiw.yir.fragment.ScholarshipAward;
import com.tiw.yir.fragment.TotalApplicationFragment;


public class PagerAdapter extends FragmentStateAdapter {

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);

    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ElectedStudentsFragment();
            case 1:
                return new ScholarshipAward();
            case 2:
                return new MonthlyScholarshipFragment();
            default:
                return new TotalApplicationFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
