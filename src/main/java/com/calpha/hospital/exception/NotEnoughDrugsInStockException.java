package com.calpha.hospital.exception;

import com.calpha.hospital.model.PharmacyDrugs;

public class NotEnoughDrugsInStockException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Not enough drugs in stock";


	public NotEnoughDrugsInStockException() {
		// TODO Auto-generated constructor stub
		 super(DEFAULT_MESSAGE);
	}
	
    

    public NotEnoughDrugsInStockException(PharmacyDrugs drugs) {
        super(String.format("Not enough %s drugs in stock. Only %d left", drugs.getDrugName(), drugs.getStockLevel()));
    }

}
