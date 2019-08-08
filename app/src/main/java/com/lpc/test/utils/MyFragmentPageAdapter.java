package com.lpc.test.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public MyFragmentPageAdapter(FragmentManager fm, List<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int arg0) {
        return mFragments.get(arg0);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

//	@Override
//	public void destroyItem(ViewGroup container, int position, Object object) {
//		super.destroyItem(container, position, object);
//	}

}
