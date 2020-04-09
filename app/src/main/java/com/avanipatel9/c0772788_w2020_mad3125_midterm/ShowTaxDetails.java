package com.avanipatel9.c0772788_w2020_mad3125_midterm;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.avanipatel9.c0772788_w2020_mad3125_midterm.models.CRACustomer;

import java.text.NumberFormat;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShowTaxDetails extends AppCompatActivity {

    @InjectView(R.id.val_sin_display)
    TextView valSinDisplay;
    @InjectView(R.id.val_full_name_display)
    TextView valFullNameDisplay;
    @InjectView(R.id.val_birth_date_display)
    TextView valBirthDateDisplay;
    @InjectView(R.id.val_gender_display)
    TextView valGenderDisplay;
    @InjectView(R.id.val_age_display)
    TextView valAgeDisplay;
    @InjectView(R.id.val_tax_filling_date_display)
    TextView valTaxFillingDateDisplay;
    @InjectView(R.id.val_gross_income_display)
    TextView valGrossIncomeDisplay;
    @InjectView(R.id.val_cpp_display)
    TextView valCppDisplay;
    @InjectView(R.id.val_ei_display)
    TextView valEiDisplay;
    @InjectView(R.id.val_rrsp_contributed_display)
    TextView valRrspContributedDisplay;
    @InjectView(R.id.val_carry_forward_rrsp_display)
    TextView valCarryForwardRrspDisplay;
    @InjectView(R.id.val_taxable_income_display)
    TextView valTaxableIncomeDisplay;
    @InjectView(R.id.val_federal_tax_display)
    TextView valFederalTaxDisplay;
    @InjectView(R.id.val_provincial_tax_display)
    TextView valProvincialTaxDisplay;
    @InjectView(R.id.val_total_tax_display)
    TextView valTotalTaxDisplay;

    CRACustomer craCustomer;
    NumberFormat format = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tax_details);
        ButterKnife.inject(this);
        getSupportActionBar().setTitle("Tax Details");

        if (getIntent().getExtras() != null) {
            craCustomer = (CRACustomer) getIntent().getExtras().getParcelable("craCustomer");
            valSinDisplay.setText(craCustomer.getSinNumber());
            valFullNameDisplay.setText(craCustomer.getFullName());
            //valBirthDateDisplay.setText(craCustomer.getBirthDate());
            valGenderDisplay.setText(craCustomer.getGender());
            //valAgeDisplay.setText(craCustomer.getAge());
            valTaxFillingDateDisplay.setText(craCustomer.getTaxFillingDate());
            valGrossIncomeDisplay.setText(format.format(craCustomer.getGrossIncome()));
            valCppDisplay.setText(format.format(craCustomer.getCpp()));
            valEiDisplay.setText(format.format(craCustomer.getEi()));
            valRrspContributedDisplay.setText(format.format(craCustomer.getRrspContributed()));

            if(craCustomer.getCarryForwardRRSP() < 0)
            {
                valCarryForwardRrspDisplay.setTextColor(Color.RED);
                valCarryForwardRrspDisplay.setText(format.format(craCustomer.getCarryForwardRRSP()));
            }
            else
            {
                valCarryForwardRrspDisplay.setText(format.format(craCustomer.getCarryForwardRRSP()));
            }

            valTaxableIncomeDisplay.setText(format.format(craCustomer.getTotalTaxableIncome()));
            valFederalTaxDisplay.setText(String.format("%2f", craCustomer.getFederalTax()));
            valProvincialTaxDisplay.setText(String.format("%2f", craCustomer.getProvincialTax()));
            valTotalTaxDisplay.setText(format.format(craCustomer.getTotalTaxPayed()));

        }


    }

}
