package com.avanipatel9.c0772788_w2020_mad3125_midterm;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.avanipatel9.c0772788_w2020_mad3125_midterm.models.CRACustomer;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

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
    @InjectView(R.id.rrsp_contribution)
    TextInputLayout rrspContribution;
    @InjectView(R.id.card_calculate)
    CardView cardCalculate;
    @InjectView(R.id.rrsp_contributed_edit_text)
    TextInputEditText rrspContributedEditText;
    @InjectView(R.id.birth_date_edit_text)
    TextInputEditText birthDateEditText;
    @InjectView(R.id.birth_date)
    TextInputLayout birthDate;
    @InjectView(R.id.male)
    RadioButton male;
    @InjectView(R.id.female)
    RadioButton female;
    @InjectView(R.id.other)
    RadioButton other;
    private RadioButton rbSelectedGender;

    private DatePickerDialog picker;
    final Calendar calendar = Calendar.getInstance();
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final int month = calendar.get(Calendar.MONTH);
    final int year = calendar.get(Calendar.YEAR);

    String genderS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        int selectedId = gender.getCheckedRadioButtonId();
        rbSelectedGender = (RadioButton) findViewById(selectedId);

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.male)
                {
                    genderS = male.getText().toString();
                }
                else if(checkedId == R.id.female)
                {
                    genderS = female.getText().toString();
                }
                else
                {
                    genderS = other.getText().toString();
                }
            }
        });

        birthDateEditText.setInputType(InputType.TYPE_NULL);
        birthDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {


                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                birthDateEditText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, year, month, day);
                picker.show();
            }
        });


        cardCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateText(sinNumberEditText, sinNumber) && validateText(firstNameEditText, firstName) && validateText(lastNameEditText, lastName) && validateText(birthDateEditText, birthDate) && validateText(grossIncomeEditText, grossIncome) && validateText(rrspContributedEditText, rrspContribution)) {

                    CRACustomer craCustomer = new CRACustomer(sinNumberEditText.getText().toString(), firstNameEditText.getText().toString(), lastNameEditText.getText().toString(), genderS, Double.parseDouble(grossIncomeEditText.getText().toString()), Double.parseDouble(rrspContributedEditText.getText().toString()));


                    Intent mIntent = new Intent(MainActivity.this, ShowTaxDetails.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("craCustomer", craCustomer);
                    mIntent.putExtras(bundle);
                    startActivity(mIntent);
                }
            }
        });
    }

    public boolean validateText(EditText editText, TextInputLayout til) {
        if (editText.getText().toString().equals("")) {
            til.setError("You need to enter a value");
            return false;
        } else {
            til.setError("");
            return true;
        }
    }

    int selectedGender = 0;

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        selectedGender = checkedId;
    }
}
