package com.example.airgead;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

public class CurrencyPickerFragment extends Fragment {


    public CurrencyPickerFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CurrencyPickerFragment newInstance(String param1, String param2) {
        CurrencyPickerFragment fragment = new CurrencyPickerFragment();
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
        View view = inflater.inflate(R.layout.fragment_currency_picker, container, false);
        List<String> currenciesAvailable = Arrays.asList(getResources().getStringArray(R.array.currencies_array));
        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.dropdown_currency_item, currenciesAvailable);
        AutoCompleteTextView autoComplete = view.findViewById(R.id.AutoCompTxtView);
        autoComplete.setAdapter(adapter);




        Button nextBTN = view.findViewById(R.id.currencyNextButton);

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("HEY", "HO");
                Navigation.findNavController(view).navigate(R.id.action_currencyPickerFragment_to_enterBalanceFragment);
            }
        });
        // Inflate the layout for this fragment
        return view;



    }
}