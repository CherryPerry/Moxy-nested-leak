package ru.cherryperry.moxyleak;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.MvpDelegate;

public class CustomFragment extends Fragment {
    private MvpDelegate<? extends MvpAppCompatFragment> mMvpDelegate;

    public CustomFragment() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    public void onStart() {
        super.onStart();
        getMvpDelegate().onAttach();
    }

    public void onDestroyView() {
        super.onDestroyView();
        getMvpDelegate().onDetach();
    }

    public void onDestroy() {
        super.onDestroy();

        if (BuildConfig.FLAVOR.equals("original")) {
            if (isRemoving() || getActivity().isFinishing()) {
                getMvpDelegate().onDestroy();
            }
        } else {
            boolean anyParentIsRemoving = false;
            Fragment parent = getParentFragment();
            while (!anyParentIsRemoving && parent != null) {
                anyParentIsRemoving = parent.isRemoving();
                parent = parent.getParentFragment();
            }
            if (isRemoving() || anyParentIsRemoving || getActivity().isFinishing()) {
                getMvpDelegate().onDestroy();
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpDelegate().onSaveInstanceState(outState);
    }

    public MvpDelegate getMvpDelegate() {
        if (mMvpDelegate == null) {
            mMvpDelegate = new MvpDelegate(this);
        }

        return mMvpDelegate;
    }
}
