package com.math.bin.money;

import java.util.Objects;

public class MoneyBinBigDecimal {
	
	private long intValue;
	private long decimalValue;
	private static final int PRECISION = 8;
	
	private static final String DELIMETER = "\\.";
	
	public long getIntValue() {
		return intValue;
	}

	public void setIntValue(long intValue) {
		this.intValue = intValue;
	}

	public long getDecimalValue() {
		return decimalValue;
	}

	public void setDecimalValue(long decimalValue) {
		this.decimalValue = decimalValue;
	}

	public static int getPrecision() {
		return PRECISION;
	}

	public MoneyBinBigDecimal(String value){
		System.out.println("Constructor value : " + value);
		String[] values = value.split(DELIMETER);
		System.out.println("values : " + values);
		if(!values[0].isEmpty()) {
			this.intValue = Long.parseLong(values[0]);
		}
			
		if(values[1].length()<8) {
			this.decimalValue = Long.parseLong(values[1]);
		}else {
			this.decimalValue = Long.parseLong(values[1].substring(0, PRECISION));
		}
			
	}
	
	public static void main(String ar[]) {
		MoneyBinBigDecimal mdc = new MoneyBinBigDecimal("25000.678921");
		System.out.println(mdc.toString());
		
		System.out.println(MoneyBinBigDecimal.multiply(new MoneyBinBigDecimal("3.25"), new MoneyBinBigDecimal("1.75")));
		System.out.println(MoneyBinBigDecimal.multiply(new MoneyBinBigDecimal(".25"), new MoneyBinBigDecimal(".75")));
		
	}
	
	public MoneyBinBigDecimal(int value){
		// unimplemented
	}

	public MoneyBinBigDecimal(long value){
		// unimplemented
	}
	
	public static MoneyBinBigDecimal add(MoneyBinBigDecimal a, MoneyBinBigDecimal b) {
		long actualSum = Long.parseLong((a.intValue + "").concat((a.decimalValue + ""))) + Long.parseLong((b.intValue+ "").concat((b.decimalValue + "")));
		System.out.println("@@@@@calculatedSumValue : " + actualSum);
		String[] sumStr = (actualSum+"").split(DELIMETER);
		String integerValue = sumStr[0];
		String decimalValue = "";
		Long firstPart = 0l;
		Long secondPart = 0l;
		if(sumStr.length > 1)
			decimalValue = sumStr[1];
		if(integerValue != null && !integerValue.isBlank())
			firstPart = Long.parseLong(integerValue);
		if(decimalValue != null && !decimalValue.isBlank())
			secondPart = Long.parseLong(decimalValue);
		return new MoneyBinBigDecimal( firstPart + "." + secondPart);
	}
	
	public static MoneyBinBigDecimal subtract(MoneyBinBigDecimal a, MoneyBinBigDecimal b) {
		long actualSum = Long.parseLong((a.intValue + "").concat((a.decimalValue + ""))) - Long.parseLong((b.intValue+ "").concat((b.decimalValue + "")));
		System.out.println("@@@@@calculatedSumValue : " + actualSum);
		String integerValue = (actualSum+"").split(DELIMETER)[0];
		String decimalValue = (actualSum+"").split(DELIMETER)[1];
		return new MoneyBinBigDecimal(Long.parseLong(integerValue) + "." + Long.parseLong(decimalValue));
	}
	
	public static MoneyBinBigDecimal multiply(MoneyBinBigDecimal a, MoneyBinBigDecimal b) {
		long actualProduct = Long.parseLong((a.intValue + "").concat((a.decimalValue + ""))) * Long.parseLong((b.intValue+ "").concat((b.decimalValue + "")));
		System.out.println("actualProduct : " + actualProduct);
		int decimalValueLengthSum = (a.decimalValue + "").length() + (b.decimalValue + "").length();
		System.out.println("decimalValueLengthSum : " + decimalValueLengthSum);
		String actualProductStr = actualProduct + "";
		String integerValue = "";
		String decimalValue = "";
		System.out.println("actualProductStr : " + actualProductStr);
		if(actualProductStr.length()>decimalValueLengthSum) {
			integerValue = actualProductStr.substring(0, actualProductStr.length() - decimalValueLengthSum);
			decimalValue =  actualProductStr.substring(actualProductStr.length() - decimalValueLengthSum, actualProductStr.length() - 1 );
		}else {
			integerValue = "0";
			decimalValue = actualProductStr;
		}
		String calculatedValue = integerValue + DELIMETER + decimalValue;
		System.out.println("@@@@@calculatedValue : " + calculatedValue);
		return new MoneyBinBigDecimal(Long.parseLong(integerValue) + "." + Long.parseLong(decimalValue));
	}
	
	public static MoneyBinBigDecimal divide(MoneyBinBigDecimal a, MoneyBinBigDecimal b) {
		long actualProduct = Long.parseLong((a.intValue + "").concat((a.decimalValue + ""))) / Long.parseLong((b.intValue+ "").concat((b.decimalValue + "")));
		System.out.println("actualProduct : " + actualProduct);
		int decimalValueLengthSum = (a.decimalValue + "").length() + (b.decimalValue + "").length();
		System.out.println("decimalValueLengthSum : " + decimalValueLengthSum);
		String actualProductStr = actualProduct + "";
		String integerValue = "";
		String decimalValue = "";
		System.out.println("actualProductStr : " + actualProductStr);
		if(actualProductStr.length()>decimalValueLengthSum) {
			integerValue = actualProductStr.substring(0, actualProductStr.length() - decimalValueLengthSum);
			decimalValue =  actualProductStr.substring(actualProductStr.length() - decimalValueLengthSum, actualProductStr.length() - 1 );
		}else {
			integerValue = "0";
			decimalValue = actualProductStr;
		}
		String calculatedValue = integerValue + DELIMETER + decimalValue;
		System.out.println("@@@@@calculatedValue : " + calculatedValue);
		return new MoneyBinBigDecimal(Long.parseLong(integerValue) + "." + Long.parseLong(decimalValue));
	}


	@Override
	public String toString() {
		return intValue + "." + decimalValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(decimalValue, intValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoneyBinBigDecimal other = (MoneyBinBigDecimal) obj;
		return decimalValue == other.decimalValue && intValue == other.intValue;
	}

}
