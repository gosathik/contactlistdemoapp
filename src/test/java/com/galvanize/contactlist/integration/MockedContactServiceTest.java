package com.galvanize.contactlist.integration;

import com.galvanize.contactlist.domain.Contacts;
import com.galvanize.contactlist.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MockedContactServiceTest
{
    @Autowired
    private MockMvc mvc;


    @MockBean
    ContactRepository repo;
    @Test
    void getAllContacts() throws Exception {
        List<Contacts> contactsList = new ArrayList<Contacts>();
        contactsList.add(new Contacts("Addisalam", "Wordofa","9199071234"));
        contactsList.add(new Contacts("Sathik", "Mohamed","9199073456"));

        when(repo.findAll()).thenReturn(contactsList);
        RequestBuilder request = MockMvcRequestBuilders.get("/contacts");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(2))
                .andExpect(jsonPath("[0]").value(contactsList.get(0)))
                .andExpect(jsonPath("[1]").value(contactsList.get(1)));
    }

}
