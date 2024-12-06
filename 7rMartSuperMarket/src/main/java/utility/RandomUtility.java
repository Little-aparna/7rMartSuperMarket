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

	public String createaRandomName2() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}

	public String createaRandomName3() {
		Faker faker = new Faker();
		return faker.name().name();
	}

	public String createaRandomName4() {
		Faker faker = new Faker();
		return faker.name().nameWithMiddle();
	}

	public String createaRandomName5() {
		Faker faker = new Faker();
		return faker.name().prefix();
	}
	

}
