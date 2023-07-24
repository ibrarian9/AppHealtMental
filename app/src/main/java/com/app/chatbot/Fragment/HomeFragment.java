package com.app.chatbot.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.chatbot.ChatBotActivity;
import com.app.chatbot.DiaryActivity;
import com.app.chatbot.R;
import com.app.chatbot.UrApotekActivity;
import com.app.chatbot.UrShineActivity;
import com.app.chatbot.VideoMoodActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    Intent intent1, intent2, intent3, intent4, intent5;
    Button btn1, btn2, btn3, btn4, btn5;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Ur Shine Activity
        intent1 = new Intent(getActivity(), UrShineActivity.class);
        btn1 = rootView.findViewById(R.id.btnUrShine);
        btn1.setOnClickListener(view -> startActivity(intent1));
        // Ur Movie Activity
        intent2 = new Intent(getActivity(), VideoMoodActivity.class);
        btn2 = rootView.findViewById(R.id.btnUrMovie);
        btn2.setOnClickListener(view -> startActivity(intent2));
        // Ur Diary Activity
        intent3 = new Intent(getActivity(), DiaryActivity.class);
        btn3 = rootView.findViewById(R.id.btnDiary);
        btn3.setOnClickListener(view -> startActivity(intent3));
        // Ur Partner Activity
        intent4 = new Intent(getActivity(), ChatBotActivity.class);
        btn4 = rootView.findViewById(R.id.btnUrPartner);
        btn4.setOnClickListener(view -> startActivity(intent4));
        // Ur Apotek Activity
        intent5 = new Intent(getActivity(), UrApotekActivity.class);
        btn5 = rootView.findViewById(R.id.btnApotek);
        btn5.setOnClickListener(view -> startActivity(intent5));

        return rootView;
    }
}