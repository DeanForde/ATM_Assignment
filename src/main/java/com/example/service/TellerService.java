package com.example.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Teller;
import com.example.repository.TellerRepository;

@Service
public class TellerService {
	@Autowired
	TellerRepository tellerRepository;
	
	public Teller getTeller(Integer id){
		return tellerRepository.getById(id);
	}
	
    public void updateTeller(Teller teller) {
        tellerRepository.save(teller);
    }
    
	public double getTotalFunds(Teller teller) {
		return teller.getTotal();

	}
	
	public String dispenseCash(Teller teller, double amount) {
		String notes = "";
    	ArrayList<INoteBucket> NoteBuckets = new ArrayList<INoteBucket>();
        NoteBuckets.add(new NoteBucket(50,teller.getFifty()));
        NoteBuckets.add(new NoteBucket(20,teller.getTwenty()));
        NoteBuckets.add(new NoteBucket(10,teller.getTen()));
        NoteBuckets.add(new NoteBucket(5,teller.getFive()));
    
    	for(INoteBucket noteBucket : NoteBuckets){
    		//Optimize - Replace while loop with modulo.
    		int counter = 0;
            while(amount >= noteBucket.GetDenom() && noteBucket.CheckTakeNote()){
                amount = amount - noteBucket.GetDenom();
                noteBucket.TakeNotes(1);
                counter += 1;
                if(amount == 0)
                    break;
            }
            notes += "Returned: " + counter + " x " + noteBucket.GetDenom() + ", ";
            updateNotes(noteBucket.GetDenom(), counter, teller);
            if(amount == 0)
                    break;
          }
              
        return notes;
	}
	
    public void updateNotes(int note, int count, Teller teller) {
  		if(note == 50) {
			teller.setFifty(teller.getFifty() - count);
			updateTeller(teller);
		}
  		if(note == 20) {
			teller.setTwenty(teller.getTwenty() - count);
			updateTeller(teller);
		}
  		if(note == 10) {
			teller.setTen(teller.getTen() - count);
			updateTeller(teller);
		}
  		if(note == 5) {
			teller.setFive(teller.getFive() - count);
			updateTeller(teller);
		}
    }
    
    public void updateTotal(Teller teller) {
    	double total = 50 * teller.getFifty() + (20 * teller.getTwenty()) + (10 * teller.getTen()) + (5 * teller.getFive());
    	teller.setTotal(total);
    	updateTeller(teller);
    }
    
}

interface INoteBucket
{
    public int GetDenom();
    public int GetAmountOfNotes();
    public boolean TakeNotes(int qtyofnotes);
    public boolean CheckTakeNote();
}

class NoteBucket implements INoteBucket
{
    private int Denominator;
    private int AmountOfNotes;
   
    public NoteBucket(int denom, int notes){
        this.Denominator = denom;
        this.AmountOfNotes = notes;
    }
    
    public boolean CheckTakeNote(){
        if(this.AmountOfNotes > 0)
            return true;  
        return false;
        
    }
    
    public int GetDenom(){
        return this.Denominator;
    }
    
    public int GetAmountOfNotes(){
        return this.AmountOfNotes;
    }
    
    public boolean TakeNotes(int qtyofnotes){
        if (this.AmountOfNotes >= qtyofnotes)
        {
            this.AmountOfNotes -= qtyofnotes;
            return true;
        }
        return false;
    }
    
}
