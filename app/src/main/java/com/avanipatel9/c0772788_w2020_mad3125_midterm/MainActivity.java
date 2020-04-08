package com.avanipatel9.c0772788_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.sin_number_edit_text)
    TextInputEditText sinNumberEditText;
    @InjectView(R.id.sin_number)
    TextInputLayout sinNumber;
    @InjectView(R.id.first_name_edit_text)
    TextInputEditText firstNameEditText;
    @InjectView(R.id.first_name)
    TextInputLayout firstName;
    @InjectView(R.id.last_name_edit_text)
    TextInputEditText lastNameEditText;
    @InjectView(R.id.last_name)
    TextInputLayout lastName;
    @InjectView(R.id.gender)
    RadioGroup gender;
    @InjectView(R.id.gross_income_edit_text)
    TextInputEditText grossIncomeEditText;
    @InjectView(R.id.gross_income)
    TextInputLayout grossIncome;
    @InjectView(R.id.postal_code_edit_text)
    TextInputEditText postalCodeEditText;
    @InjectView(R.id.rrsp_contribution)
    TextInputLayout rrspContribution;
    @InjectView(R.id.card_calculate)
    CardView cardCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        cardCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, ShowTaxDetails.class);
               startActivity(mIntent);
            }
        });
    }
}
