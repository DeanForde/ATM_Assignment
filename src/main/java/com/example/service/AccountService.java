package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Accounts;
import com.example.repository.AccountsRepository;

@Service
public class AccountService {

	@Autowired
	private AccountsRepository accountsRepository;
	
	public Accounts getAccount(Integer account_no) {
		return accountsRepository.getById(account_no);
	}
	
    public void saveAccount(Accounts acc) {
        accountsRepository.save(acc);
    }
    
	public String getBalance(Accounts acc) {
		return "Opening Balance: " + Double.toString(acc.getOpening_balance()) +
				"\n" + "Overdraft: " + Double.toString(acc.getOverdraft()) + "\n" ;
	}
	
	public boolean checkPin(Accounts acc, int pin) {
		if(acc.getPin() == pin)
			return true;
		return false;
	}
	
	public double availableFunds(Accounts acc) {
		return (acc.getOpening_balance() + acc.getOverdraft());
	}
	
    public void updateBalance(Accounts acc, double amount) {
    	if(amount < acc.getOpening_balance())
    		acc.setOpening_balance(acc.getOpening_balance() - amount);
    	else {
    		double availablefunds = acc.getOpening_balance() + acc.getOverdraft();
    		acc.setOpening_balance(0);
    		acc.setOverdraft(availablefunds - amount);
    	}
        accountsRepository.save(acc);
    }
	
}
