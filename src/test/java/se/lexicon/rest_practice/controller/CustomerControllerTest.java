package se.lexicon.rest_practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import se.lexicon.rest_practice.entity.Customer;
import se.lexicon.rest_practice.entity.Gender;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;//u need to import it

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private Customer customer;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        customer = new Customer();
        customer.setFirstName("Aman");
        customer.setLastName("A");
        customer.setAge(25);
        customer.setEmail("95pinkpanda@gmail.com");
        customer.setGender(Gender.Female);
    }

    @Test
    public void save_customer_CREATED() throws Exception {
      /*  String jsonMessage = "{\n" +
                "    \"id\" :1,\n" +
                "    \"firstName\" : \"A2\",\n" +
                "    \"lastName\" : \"Adam22\",\n" +
                "    \"email\" : \"test22\",\n" +
                "    \"phoneNumber\" : \"089798227\",\n" +
                "    \"age\" : 24,\n" +
                "    \"gender\" : 1,\n" +
                "    \"address\" : {\n" +
                "        \"city\" :\"Nybro2\",\n" +
                "        \"country\" : \"Sweden2\",\n" +
                "        \"street\" : \"klock1\",\n" +
                "        \"zipCode\": \"37645\"\n" +
                "    }\n" +
                "}";

       */
        String customerJsonMassage = objectMapper.writeValueAsString(customer);
        System.out.println("customerJsonMassage = " + customerJsonMassage);
        MvcResult mvcResult = mockMvc.perform(post("/api/customer/").content(customerJsonMassage)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(201, status);
    }

}
