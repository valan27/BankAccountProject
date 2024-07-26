package com.bankaccountdto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class BankAccount implements Comparable{
    @Id
    private int ActNumber;
    private String CustomerName;
    private double ActBalance;
    private String City;
    private int BranchCode;

    public BankAccount(int actNumber, String customerName, double actBalance, String city, int branchCode) {
        ActNumber = actNumber;
        CustomerName = customerName;
        ActBalance = actBalance;
        City = city;
        BranchCode = branchCode;
    }
    public BankAccount(){

    }

    public BankAccount(int actNumber) {
        ActNumber = actNumber;
    }

    public int getActNumber() {
        return ActNumber;
    }

    public void setActNumber(int actNumber) {
        ActNumber = actNumber;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public double getActBalance() {
        return ActBalance;
    }

    public void setActBalance(double actBalance) {
        ActBalance = actBalance;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getBranchCode() {
        return BranchCode;
    }

    public void setBranchCode(int branchCode) {
        BranchCode = branchCode;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "ActNumber=" + ActNumber +
                ", CustomerName='" + CustomerName + '\'' +
                ", ActBalance=" + ActBalance +
                ", City='" + City + '\'' +
                ", BranchCode=" + BranchCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return ActNumber == that.ActNumber && Double.compare(ActBalance, that.ActBalance) == 0 && BranchCode == that.BranchCode && Objects.equals(CustomerName, that.CustomerName) && Objects.equals(City, that.City);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ActNumber, CustomerName, ActBalance, City, BranchCode);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
