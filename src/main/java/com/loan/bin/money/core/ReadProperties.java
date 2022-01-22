package com.loan.bin.money.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.loan.bin.money.exception.FileHandlingException;

public class ReadProperties {

	public static void main(String[] ar) throws FileHandlingException {// loadProperties() throws FileHandlingException
																		// {
		try (InputStream input = new FileInputStream("config.properties")) {
			Properties prop = new Properties();
			prop.load(input);
		} catch (IOException ex) {
			throw new FileHandlingException("Properties file not found.", "ERRFIL004");
		}
	}
}
