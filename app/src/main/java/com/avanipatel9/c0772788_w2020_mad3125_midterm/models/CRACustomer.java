package com.avanipatel9.c0772788_w2020_mad3125_midterm.models;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.Period;

public class CRACustomer implements Parcelable {

    private String sinNumber;
    private String firstName;
    private String lastName;
    private String fullName;
    private LocalDate birthDate;
    private String gender;
    private int age;
    private LocalDate taxFillingDate;
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

    public CRACustomer(String sinNumber, String firstName, String lastName, LocalDate birthDate, String gender, Double grossIncome, Double rrspContributed) {
        this.sinNumber = sinNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.grossIncome = grossIncome;
        this.rrspContributed = rrspContributed;
    }

    public String getSinNumber() {
        return sinNumber;
    }

    public Double getMaxRRSPAllowed() {
        return maxRRSPAllowed;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    public String getFullName() {
        return firstName +" "+ lastName;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getAge() {
        int age;
        age = Period.between(birthDate, LocalDate.now()).getYears();
        return age;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public LocalDate getTaxFillingDate() {
        return LocalDate.now();
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

    protected CRACustomer(Parcel in) {
    }

    public static final Creator<CRACustomer> CREATOR = new Creator<CRACustomer>() {
        @Override
        public CRACustomer createFromParcel(Parcel in) {
            return new CRACustomer(in);
        }

        @Override
        public CRACustomer[] newArray(int size) {
            return new CRACustomer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
