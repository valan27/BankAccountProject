package com.bankaccountservice;

import com.bankaccountdao.BankDao;
import com.bankaccountdao.BankDaoImpl;
import com.bankaccountdto.BankAccount;

import java.util.List;

public class BankServiceImpl implements BankService {

    private BankDao bankDao = new BankDaoImpl();


    @Override
    public void create(BankAccount bankAccount) {
    bankDao.create(bankAccount);
    }

    @Override
    public void remove(BankAccount bankAccount) {
        bankDao.remove(bankAccount);
    }

    @Override
    public void update(BankAccount bankAccount) {
        bankDao.update(bankAccount);
    }

    @Override
    public List<BankAccount> read() {
       return bankDao.read();

    }

    @Override
    public List<BankAccount> byId(int a) {
        return bankDao.byId(a);
    }

    @Override
    public List<BankAccount> byCustName(String a) {
        return bankDao.byName(a);
    }

    @Override
    public List<BankAccount> byBid(int a) {
        return bankDao.byBid(a);
    }

    @Override
    public List<Object[]> getAllBankAccGroupByCity() {
        return bankDao.getAllBankAccGroupByCity();
    }


}
