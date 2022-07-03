package com.wedrive.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wedrive.model.Admin;
import com.wedrive.model.User;
import com.wedrive.service.AdminService;
import com.wedrive.service.CarService;
import com.wedrive.service.RentalService;
import com.wedrive.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.mockito.BDDMockito.given;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@WebMvcTest(AdminController.class)
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;


    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @MockBean
    private AdminService adminService;
    @MockBean
    private RentalService rentalService;
    @MockBean
    private CarService carService;
    @MockBean
    private UserService userService;


    @InjectMocks
    private AdminController adminController;

    User user1 = new User( 1L,
            "Ralph","Deus","Ralph.Deus@miu.edu","6418192484", null
            ,"test_pass", null, null
    );
    User user2 = new User( 2L,
            "Diaby","Simon","Diaby.Simon@miu.edu","6418192484", null
            ,"test_pass", null, null
    );

    Admin admin1 = new Admin(1L, "785485874", user1);
    Admin admin2 = new Admin(2L, "867543554", user2);

    @Before
    public void setUp()
    {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
        System.out.println();
    }

    @Test
    public void findAllAdmin_success() throws Exception
    {
        given(adminService.findAllAdmin()).willReturn(Arrays.asList(admin1, admin2));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/admin/")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());

    }
    @Test
    public void saveAdmin_success() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(admin1);
        given(adminService.saveAdmin(admin1)).willReturn("Saved");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/admin/save/")
                .accept(MediaType.APPLICATION_JSON).content(jsonString).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();
        User returnedUser = mapper.readValue(outputInJson,User.class);

        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}