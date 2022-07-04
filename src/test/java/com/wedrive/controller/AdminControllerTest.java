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
    public void adminsGetList() throws Exception{
        String uri="/api/v1/admin/";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }

    @Test
    public void adminSave() throws  Exception{
        String uri="/api/v1/admin/save";
        User user=new User(1L, "Jack","Johnes", "a@a.com", "+998998884684", LocalDateTime.of(2022, 1,1,12,30),"1234",null, null );
        Admin admin= new Admin(1L,"123123123", user);
        String inputJson = super.mapToJson(admin);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }

}

//@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
//@WebMvcTest(AdminController.class)
//class AdminControllerTest extends AbstractTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    ObjectMapper objectMapper = new ObjectMapper();
//    ObjectWriter objectWriter = objectMapper.writer();
//
//    @MockBean
//    private AdminService adminService;
//    @MockBean
//    private RentalService rentalService;
//    @MockBean
//    private CarService carService;
//    @MockBean
//    private UserService userService;
//
//
//    @InjectMocks
//    private AdminController adminController;
//
//    User user1 = new User( 1L,
//            "Ralph","Deus","Ralph.Deus@miu.edu","6418192484", null
//            ,"test_pass", null, null
//    );
//    User user2 = new User( 2L,
//            "Diaby","Simon","Diaby.Simon@miu.edu","6418192484", null
//            ,"test_pass", null, null
//    );
//
//    Admin admin1 = new Admin(1L, "785485874", user1);
//    Admin admin2 = new Admin(2L, "867543554", user2);
//
//    @Before
//    public void setUp()
//    {
////        MockitoAnnotations.initMocks(this);
////        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
//        System.out.println();
//    }
//
//    @Test
//    public void findAllAdmin_success() throws Exception
//    {
////        given(adminService.findAllAdmin()).willReturn(Arrays.asList(admin1, admin2));
////        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/admin/")
////                .contentType(MediaType.APPLICATION_JSON);
////        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
////        MockHttpServletResponse response = result.getResponse();
////        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
//        String uri = "/api/v1/admin/";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//    }
//    @Test
//    public void saveAdmin_success() throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(admin1);
//        given(adminService.saveAdmin(admin1)).willReturn("Saved");
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/admin/save/")
//                .accept(MediaType.APPLICATION_JSON).content(jsonString).contentType(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//
//        String outputInJson = response.getContentAsString();
//        User returnedUser = mapper.readValue(outputInJson,User.class);
//
//        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
//    }
//}