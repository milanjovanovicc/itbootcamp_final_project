package Extras;

import com.github.javafaker.Faker;

public class FakerClass {

    Faker faker = new Faker();

    public String getFakeEmail(){
        return faker.internet().emailAddress();
    }

    public String getFakePassword(){
        return faker.internet().password();
    }

    public String getFakeName() {
        return faker.name().fullName();
    }

    public String getFakePhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getFakeCity() {
        return faker.address().city();
    }

    public String getFakeCountry() {
        return faker.address().country();
    }

    public String getFakeTwitter() {
        return "http://" + faker.internet().domainName() + faker.internet().domainSuffix();
    }

    public String getFakeGitHub() {
        return "https://" + faker.internet().domainName() + faker.internet().domainSuffix();
    }
}
