package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerConfig {
	Faker faker = new Faker(new Locale("en-US"));

	public static FakerConfig getFaker() {
		return new FakerConfig();
	}

	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String emailAddress() {
		return faker.internet().emailAddress();
	}

	public String password() {
		return faker.internet().password();
	}
}
