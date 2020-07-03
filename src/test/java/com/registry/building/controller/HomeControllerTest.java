package com.registry.building.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private HomeController homeController;

//    @Before
//    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.standaloneSetup(homeController)
//                .build();
//    }

    @Test
    public void getAllBuildings() throws Exception {
//         mockMvc.perform( MockMvcRequestBuilders
//                 .get("/")
//                 .accept(MediaType.APPLICATION_JSON))
//                 .andDo(print())
//                 .andExpect(status().isOk())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$./").exists())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.").isNotEmpty());
    }

    @Test
    public void getBuildingById() throws Exception  {
        mockMvc.perform( MockMvcRequestBuilders
//                 .get("/api/buildings/{id}", 1)
//                 .accept(MediaType.APPLICATION_JSON))
//                 .andDo(print())
//                 .andExpect(status().isOk())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    public void createBuilding() {
    }

    @Test
    public void updateBuildingID() {
    }

    @Test
    public void deleteBuildingID() {
    }

    @Test
    public void deleteAllBuildings() {
    }

}
