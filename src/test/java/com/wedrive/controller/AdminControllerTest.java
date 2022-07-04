package com.wedrive.controller;


import com.wedrive.model.Admin;
import com.wedrive.model.Customer;
import com.wedrive.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class AdminControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void adminsGetList() throws Exception {
        String uri = "/api/v1/admin/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }

    @Test
    public void adminCreate() throws Exception {
        String uri = "/api/v1/admin/save";
        User user = new User(1L, "Jack", "Johnes", "a@a.com", "+998998884684", LocalDateTime.of(2022, 1, 1, 12, 30), "1234", null, null);
        Admin admin = new Admin(1L, "123123123", user);
        String inputJson = super.mapToJson(admin);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }

    @Test
    public void adminApproveDenyRental() throws Exception {
        String uri = "/api/v1/admin/approve_denied/1/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Rental Approved");

    }
}

