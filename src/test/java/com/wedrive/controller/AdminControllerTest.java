package com.wedrive.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jayway.jsonpath.JsonPath;
import com.wedrive.model.Admin;
import com.wedrive.model.User;
import com.wedrive.repository.AdminRepository;
import com.wedrive.service.AdminService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
class AdminControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    AdminService adminService;


    @InjectMocks
    private AdminController adminController;

    User user1 = new User( 1L,
            "Ralph","Deus","Ralph.Deus@miu.edu","6418192484", LocalDateTime.now()
            ,"test_pass", null, null
    );
    User user2 = new User( 2L,
            "Diaby","Simon","Diaby.Simon@miu.edu","6418192484", LocalDateTime.now()
            ,"test_pass", null, null
    );

    Admin admin1 = new Admin(1L, "785485874", user1);
    Admin admin2 = new Admin(2L, "867543554", user2);

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void findAllAdmin_success() throws Exception
    {
//        given(adminService.findAllAdmin()).willReturn(Arrays.asList(admin1, admin2));
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/admin")
//                .contentType(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());

    }
}