package edu.miu.contacts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Contact;
import model.EmailAddress;
import model.PhoneNumber;

import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        Contact[] contacts = buildSampleContacts();
        Arrays.sort(contacts, Comparator.comparing(Contact::getLastName, String.CASE_INSENSITIVE_ORDER));

        System.out.println(toPrettyJson(contacts));
    }

    static Contact[] buildSampleContacts() {
        Contact david = new Contact("David", "Sanger", "Argos LLC", "Sales Manager");
        david.addPhoneNumber(new PhoneNumber("240-133-0011", "Home"));
        david.addPhoneNumber(new PhoneNumber("240-112-0123", "Mobile"));
        david.addEmailAddress(new EmailAddress("dave.sang@gmail.com", "Home"));
        david.addEmailAddress(new EmailAddress("dsanger@argos.com", "Work"));

        Contact carlos = new Contact("Carlos", "Jimenez", "Zappos", "Director");

        Contact ali = new Contact("Ali", "Gafar", "BMI Services", "HR Manager");
        ali.addPhoneNumber(new PhoneNumber("412-116-9988", "Work"));
        ali.addEmailAddress(new EmailAddress("ali@bmi.com", "Work"));

        return new Contact[]{david, carlos, ali};
    }

    static String toPrettyJson(Contact[] contacts) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writeValueAsString(contacts);
    }
}
