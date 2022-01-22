package com.loan.bin.money.customer;

/**
 * Created by Devershi Srivastava on 1/16/2022.
 *
 * com.loan.bin.money.customer.Private Customer
 *
 */
public class PrivateCustomer extends Customer {
	
	public PrivateCustomer(final String name){
		this.setName(name);
		this.isPrivate(true);
	}
	
	public static void main(String[] args) {
		
        Customer c = new PrivateCustomer("John");

        System.out.println("Customer name : "+ c.getName());
        System.out.println("Customer is private : "+ c.isPrivate());
    }

}
