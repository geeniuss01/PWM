package me.samen.pwm.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.samen.pwm.R;


public class IntroFragment extends Fragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_DESC = "desc";
    private static final String ARG_IMAGE = "iamge";
    private static final String ARG_BG = "bg";

    private String mTitle;
    private String mDescription;
    private int mIntroImage;
    private int mBackground;


    public IntroFragment() {
        // Required empty public constructor
    }

    public static IntroFragment newInstance(String title, String description, int image, int background) {
        IntroFragment fragment = new IntroFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_DESC, description);
        args.putInt(ARG_IMAGE, image);
        args.putInt(ARG_BG, background);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_TITLE);
            mDescription = getArguments().getString(ARG_DESC);
            mIntroImage = getArguments().getInt(ARG_IMAGE);
            mBackground = getArguments().getInt(ARG_BG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
