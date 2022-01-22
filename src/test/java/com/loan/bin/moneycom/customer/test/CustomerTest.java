package com.loan.bin.moneycom.customer.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.loan.bin.money.customer.BusinessCustomer;
import com.loan.bin.money.customer.Customer;
import com.loan.bin.money.customer.PrivateCustomer;

public class CustomerTest {

	Customer privateCustomer;
	Customer businessCustomer;

	@BeforeEach
	public void privateCustomer() {
		privateCustomer = new PrivateCustomer("Sachin Tendulkar");
		businessCustomer = new BusinessCustomer("Shinzo Abe");
	}

	@Test
	@DisplayName("Creating a private customer, the property isPrivate should be true")
	public void testIsPrivateCustomer() {
		assertEquals(true, privateCustomer.isPrivate(),
				"Creatintg a private customer, the property isPrivate should be true");
	}

	@Test
	@DisplayName("Creating a private customer, the property isPrivate should be true")
	public void testIsBusinessCustomer() {
		assertEquals(false, businessCustomer.isPrivate(),
				"Creatintg a private customer, the property isPrivate should be true");
	}

}
