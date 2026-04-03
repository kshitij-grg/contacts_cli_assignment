package edu.miu.contacts;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Contact;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void buildSampleContacts_sortedByLastName_isAscending() {
        Contact[] contacts = App.buildSampleContacts();
        Arrays.sort(contacts, Comparator.comparing(Contact::getLastName, String.CASE_INSENSITIVE_ORDER));

        assertEquals("Gafar", contacts[0].getLastName());
        assertEquals("Jimenez", contacts[1].getLastName());
        assertEquals("Sanger", contacts[2].getLastName());
    }

    @Test
    public void toPrettyJson_containsExpectedContactData() throws Exception {
        Contact[] contacts = App.buildSampleContacts();
        Arrays.sort(contacts, Comparator.comparing(Contact::getLastName, String.CASE_INSENSITIVE_ORDER));

        String json = App.toPrettyJson(contacts);
        JsonNode root = new ObjectMapper().readTree(json);

        assertEquals(3, root.size());
        assertEquals("Ali", root.get(0).get("firstName").asText());
        assertEquals("Jimenez", root.get(1).get("lastName").asText());
        assertEquals("dsanger@argos.com", root.get(2).get("emailAddresses").get(1).get("address").asText());
    }
}
