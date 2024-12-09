package utility;

import com.github.javafaker.Faker;

public class RandomUtility {
	public String createaRandomName() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}

	public String createARandomPassword() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}
	public String createARandomAddress() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}

	public String createARandomEmail() {
		Faker faker = new Faker();
	return faker.name().firstName();
		
	}
	public String createARandomPhoneNumber() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}
	public String createaRandomName3() {
		Faker faker = new Faker();
		return faker.name().name();
	}

	public String createaRandomNameWithMiddleName() {
		Faker faker = new Faker();
		return faker.name().nameWithMiddle();
	}

	public String createaRandomNamePrefix() {
		Faker faker = new Faker();
		return faker.name().prefix();
	}
	

}
