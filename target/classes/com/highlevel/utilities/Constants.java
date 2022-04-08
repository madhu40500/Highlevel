package com.highlevel.utilities;

import com.github.javafaker.Faker;


public class Constants {

	static Faker faker = new Faker();
	public static String priorityDoctor = "Madhu QA";
	public static String name = faker.name().fullName();
	public static String firstName = faker.name().firstName();
	public static String lastName = faker.name().lastName();
	public static String email = firstName + lastName + "@gmail.com";
	public static String sucessMessage = "Your Meeting has been Scheduled";
}
