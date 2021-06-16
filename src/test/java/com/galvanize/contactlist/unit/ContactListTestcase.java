package com.galvanize.contactlist.unit;
import com.galvanize.contactlist.repository.ContactRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContactListTestcase
{
    @Autowired
    MockMvc mvc;

    @Autowired
    ContactRepository repository;

    @Test
    void testEmptyContact() throws Exception
    {
        RequestBuilder request = MockMvcRequestBuilders.get("/contacts")
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    void testAddContact() throws Exception
    {
        RequestBuilder request = MockMvcRequestBuilders.post("/contact")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"givenName\":\"Sagubar\",\n" +
                        "    \"surname\":\"Sathik\",\n" +
                        "    \"phoneNumber\":\"9199075338\"\n" +
                        "}");
        this.mvc.perform(request)
                .andExpect(status().isOk());
    }
}
