package com.example.profileactivity;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavFragment extends Fragment {


    public NavFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav, container, false);

        Button personal = view.findViewById(R.id.button);
        personal.setOnClickListener(mOnClickListener);
        Button agent = view.findViewById(R.id.button2);
        agent.setOnClickListener(mOnClickListener);
        Button business = view.findViewById(R.id.button3);
        business.setOnClickListener(mOnClickListener);


        return view;
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    Navigation.findNavController(v).navigate(R.id.action_navFragment_to_personalProfileFragment);
                    break;
                case R.id.button2:
                    Navigation.findNavController(v).navigate(R.id.action_navFragment_to_agentProfileFragment);
                    break;
                case R.id.button3:
                    Navigation.findNavController(v).navigate(R.id.action_navFragment_to_businessProfileFragment);
                    break;
            }
        }
    };

}
