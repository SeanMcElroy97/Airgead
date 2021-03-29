package com.example.airgead;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EnterBalanceFragment extends Fragment {

    public EnterBalanceFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static EnterBalanceFragment newInstance(String param1, String param2) {
        EnterBalanceFragment fragment = new EnterBalanceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enter_balance, container, false);
    }
}