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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Arrays;
import java.util.List;

public class CurrencyPickerFragment extends Fragment implements AdapterView.OnItemSelectedListener {


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
    public void onResume() {
        super.onResume();
        View view = getView();
        List<String> currenciesAvailable = Arrays.asList(getResources().getStringArray(R.array.currencies_array));
        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.dropdown_currency_item, currenciesAvailable);
        AutoCompleteTextView autoComplete = view.findViewById(R.id.AutoCompTxtView);
        autoComplete.setAdapter(adapter);
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
        TextInputLayout mtextInputLayout= view.findViewById(R.id.currencyTIL);

        autoComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtextInputLayout.setErrorEnabled(false);
            }
        });


        autoComplete.setOnItemSelectedListener(this);

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curr=autoComplete.getText().toString();
                if (isValidCurrency(curr)){
                    String currency_selected=mtextInputLayout.getEditText().getText().toString();
                    CurrencyPickerFragmentDirections.ActionCurrencyPickerFragmentToEnterBalanceFragment action=CurrencyPickerFragmentDirections.actionCurrencyPickerFragmentToEnterBalanceFragment(currency_selected);
                    action.setCurrency(currency_selected);
                    //                    ConfirmationAction action = SpecifyAmountFragmentDirections.confirmationAction();
                    Navigation.findNavController(view).navigate(action);
                }
                else{
//                    Toast.makeText(getContext(),"Pick a valid currency", Toast.LENGTH_LONG).show();
                    mtextInputLayout.setError("Pick a valid currency");
                }
            }
        });
        // Inflate the layout for this fragment
        return view;



    }

    private boolean isValidCurrency(String currstr){
        if(currstr.indexOf('(')!=-1){
            return true;
        }

        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d("HIDEO", "HO");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}