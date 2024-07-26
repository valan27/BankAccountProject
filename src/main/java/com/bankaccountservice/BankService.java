package com.bankaccountservice;

import com.bankaccountdto.BankAccount;

import java.util.List;

public interface BankService {
    public void create(BankAccount bankAccount);
    public void remove(BankAccount bankAccount);
    public void update(BankAccount bankAccount);
    public List<BankAccount> read();
    public List<BankAccount> byId(int a);
    public List<BankAccount> byCustName(String a);
    public List<BankAccount> byBid(int a);
    public List<Object[]> getAllBankAccGroupByCity();







}
