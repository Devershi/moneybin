package com.loan.bin.money.customer;

public class BusinessCustomer extends Customer {

	public BusinessCustomer(final String name){
		this.setName(name);
		this.isPrivate(false);
	}
}
