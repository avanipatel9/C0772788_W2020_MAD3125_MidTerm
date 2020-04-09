package com.avanipatel9.c0772788_w2020_mad3125_midterm.models;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class CRACustomer implements Parcelable {

    private String sinNumber;
    private String firstName;
    private String lastName;
    private String fullName;
    private Date birthDate;
    private String gender;
    private int age;
    private String taxFillingDate;
    private Double grossIncome;
    private Double federalTax;
    private Double provincialTax;
    private Double cpp;
    private Double ei;
    private Double rrspContributed;
    private Double maxRRSPAllowed;
    private Double carryForwardRRSP;
    private Double totalTaxableIncome;
    private Double totalTaxPayed;

    public CRACustomer(String sinNumber, String firstName, String lastName, String gender, Double grossIncome, Double rrspContributed) {
        this.sinNumber = sinNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.grossIncome = grossIncome;
        this.rrspContributed = rrspContributed;
        calculateCpp();
        calculateEi();
        calculateMaxRRSPAllowed();
        calculateCarryForwardRRSP();
        calculateTotalTaxableIncome();
        calculateProvincialTax(this.totalTaxableIncome);
        calculateFederalTax(this.totalTaxableIncome);
        calculateTotalTaxPayed();
    }

    public String getSinNumber() {
        return sinNumber;
    }

    public void setSinNumber(String sinNumber) {
        this.sinNumber = sinNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFullName() {
        return lastName.toUpperCase() +", "+ firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge(int year, int month, int day)  {
        int age;
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(Double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public Double getRrspContributed() {
        return rrspContributed;
    }

    public void setRrspContributed(Double rrspContributed) {
        this.rrspContributed = rrspContributed;
    }

    public Double getMaxRRSPAllowed() {
        return maxRRSPAllowed;
    }

    public String getTaxFillingDate() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }

    public Double getFederalTax() {
        return federalTax;
    }

    public Double getProvincialTax() {
        return provincialTax;
    }

    public Double getCpp() {
        return cpp;
    }

    public Double getEi() {
        return ei;
    }

    public Double getCarryForwardRRSP() {
        return carryForwardRRSP;
    }

    public Double getTotalTaxableIncome() {
        return totalTaxableIncome;
    }

    public Double getTotalTaxPayed() {
        return totalTaxPayed;
    }

    private void calculateCpp(){
        if (this.grossIncome > 57400){
            this.cpp = 2927.4;
        }
        else {
            this.cpp = this.grossIncome*5.10/100;
        }
    }

    private void calculateEi(){
        if (this.grossIncome > 53100){
            this.ei = 860.22;
        }
        else {
            this.ei = this.grossIncome * 0.0162;
        }
    }

    private void calculateMaxRRSPAllowed()
    {
        this.maxRRSPAllowed = this.grossIncome * 18 / 100;
    }

    private void calculateCarryForwardRRSP()
    {
        this.carryForwardRRSP = this.maxRRSPAllowed - this.rrspContributed;
    }

    private void calculateTotalTaxableIncome()
    {
        if(rrspContributed<maxRRSPAllowed) {
            this.totalTaxableIncome = this.grossIncome - (this.cpp + this.ei + this.rrspContributed);
        }
        else
        {
            this.totalTaxableIncome = this.grossIncome - (this.cpp + this.ei + this.maxRRSPAllowed);
        }
    }

    private void calculateFederalTax(double totalTaxableIncome)
    {
        if(totalTaxableIncome <= 12069){
            this.federalTax = totalTaxableIncome * 0 / 100;
        }else  if(totalTaxableIncome >= 12069.01 && totalTaxableIncome <= 47630){
            this.federalTax = totalTaxableIncome * 15 / 100;
        } else if(totalTaxableIncome >= 47630.01 && totalTaxableIncome <= 95259){
            this.federalTax = totalTaxableIncome * 20.50 / 100;
        } else if(totalTaxableIncome >= 95259.01 && totalTaxableIncome <= 147667){
            this.federalTax = totalTaxableIncome * 26 / 100;
        } else if(totalTaxableIncome >= 147667.01 && totalTaxableIncome <= 210371){
            this.federalTax = totalTaxableIncome * 29 / 100;
        } else if(totalTaxableIncome >= 210371.01){
            this.federalTax = totalTaxableIncome * 33 / 100;
        }
    }

    private void calculateProvincialTax(double totalTaxableIncome)
    {
        if(totalTaxableIncome <= 10582){
            this.provincialTax = totalTaxableIncome * 0 / 100;
        }else  if(totalTaxableIncome >= 10582.01 && totalTaxableIncome <= 43906){
            this.provincialTax = totalTaxableIncome * 5.05 / 100;
        } else if(totalTaxableIncome >= 43906.01 && totalTaxableIncome <= 87813){
            this.provincialTax = totalTaxableIncome * 9.15 / 100;
        } else if(totalTaxableIncome >= 87813.01 && totalTaxableIncome <= 150000){
            this.provincialTax = totalTaxableIncome * 11.16 / 100;
        } else if(totalTaxableIncome >= 150000.01 && totalTaxableIncome <= 220000){
            this.provincialTax = totalTaxableIncome * 12.16 / 100;
        } else if(totalTaxableIncome >= 220000.01){
            this.provincialTax = totalTaxableIncome * 13.16 / 100;
        }
    }

    private void calculateTotalTaxPayed()
    {
        this.totalTaxPayed = this.federalTax + this.provincialTax;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sinNumber);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.fullName);
        dest.writeString(this.gender);
        dest.writeInt(this.age);
        dest.writeSerializable(this.taxFillingDate);
        dest.writeValue(this.grossIncome);
        dest.writeValue(this.federalTax);
        dest.writeValue(this.provincialTax);
        dest.writeValue(this.cpp);
        dest.writeValue(this.ei);
        dest.writeValue(this.rrspContributed);
        dest.writeValue(this.maxRRSPAllowed);
        dest.writeValue(this.carryForwardRRSP);
        dest.writeValue(this.totalTaxableIncome);
        dest.writeValue(this.totalTaxPayed);
    }

    protected CRACustomer(Parcel in) {
        this.sinNumber = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.fullName = in.readString();
        this.gender = in.readString();
        this.age = in.readInt();
        this.taxFillingDate = in.readString();
        this.grossIncome = (Double) in.readValue(Double.class.getClassLoader());
        this.federalTax = (Double) in.readValue(Double.class.getClassLoader());
        this.provincialTax = (Double) in.readValue(Double.class.getClassLoader());
        this.cpp = (Double) in.readValue(Double.class.getClassLoader());
        this.ei = (Double) in.readValue(Double.class.getClassLoader());
        this.rrspContributed = (Double) in.readValue(Double.class.getClassLoader());
        this.maxRRSPAllowed = (Double) in.readValue(Double.class.getClassLoader());
        this.carryForwardRRSP = (Double) in.readValue(Double.class.getClassLoader());
        this.totalTaxableIncome = (Double) in.readValue(Double.class.getClassLoader());
        this.totalTaxPayed = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Creator<CRACustomer> CREATOR = new Creator<CRACustomer>() {
        @Override
        public CRACustomer createFromParcel(Parcel source) {
            return new CRACustomer(source);
        }

        @Override
        public CRACustomer[] newArray(int size) {
            return new CRACustomer[size];
        }
    };
}
