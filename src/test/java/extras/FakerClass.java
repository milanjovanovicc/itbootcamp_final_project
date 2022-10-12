package extras;

import com.github.javafaker.Faker;

public class FakerClass {

    static Faker faker = new Faker();

    public static String getFakeEmail(){
        return faker.internet().emailAddress();
    }

    public static String getFakePassword(){
        return faker.internet().password();
    }

    public static String getFakeName() {
        return faker.name().fullName();
    }

    public static String getFakePhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String getFakeCity() {
        return faker.address().city();
    }

    public static String getFakeCountry() {
        return faker.address().country();
    }

    public static String getFakeTwitter() {
        return "http://" + faker.internet().domainName() + faker.internet().domainSuffix();
    }

    public static String getFakeGitHub() {
        return "https://" + faker.internet().domainName() + faker.internet().domainSuffix();
    }
}
