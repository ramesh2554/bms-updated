package com.cts.utility;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cts.model.RegistrationDetails;

public class Utility {

	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	static Random random = new Random();
	RegistrationDetails details;

	public static int getAge(Date dob) {

		formatter.format(dob);
		Instant instant = dob.toInstant();
		ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
		LocalDate givenDate = zone.toLocalDate();
		Period period = Period.between(givenDate, LocalDate.now());
		return period.getYears();
	}

	public static String generateAccountNum() {

		int nextInt = random.nextInt(10000);
		int nextInt2 = random.nextInt(10000);
		int nextInt3 = random.nextInt(10000);
		int nextInt4 = random.nextInt(10000);
		return String.valueOf(nextInt) + String.valueOf(nextInt2) + String.valueOf(nextInt3) + String.valueOf(nextInt4);

	}

//	@SuppressWarnings("static-access")
//	public static String generateAccountNum1() {
//		long x = (long) (random.nextDouble() * 100000000000000L);
//		String s = String.valueOf(x) + String.format("%014d", x);
//		
//		return  s.format("%014d");
//	}
	public static boolean passwordRegex(String password) {

		String regex = "(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		return m.matches();

	}

}
