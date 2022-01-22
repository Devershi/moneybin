package com.loan.bin.moneycom.exception.test;

import org.junit.Test;
import java.util.ArrayList;

public class ExceptionsTest {

	@Test(expected = ArithmeticException.class)
	public void testDivisionWithException() {
		int i = 1 / 0;
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testEmptyList() {
		new ArrayList<>().get(0);
	}

}