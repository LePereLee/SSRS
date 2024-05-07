package com.huawei.ibooking.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huawei.ibooking.BookingApplication;
import com.huawei.ibooking.model.StudentDO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookingApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@WebAppConfiguration
public class StudentControllerTest {
    private final String url = "/student";
    private final String queryStuByNumUrl = "/student/{stuNum}";

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shoule_be_success_when_query_all_students() throws Exception {
        final MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        final List<StudentDO> students = new ObjectMapper().readValue(
                result.getResponse().getContentAsString(), new TypeReference<List<StudentDO>>() {
                });

        Assert.assertEquals(students.size(), 5);
    }

    @Test
    public void should_be_success_when_add_a_new_student() throws Exception {
        final StudentDO stuDo = addNewStudent();
        final StudentDO queryDo = queryStudent(stuDo);

        Assert.assertEquals(stuDo.getStuNum(), queryDo.getStuNum());
        Assert.assertEquals(stuDo.getName(), queryDo.getName());
        Assert.assertEquals(stuDo.getPassword(), queryDo.getPassword());
    }

    @Test
    public void should_be_fail_when_adding_the_same_student() {
        // to be continue
    }

    @Test
    public void should_be_success_when_modifying_existing_student() throws Exception {
        final StudentDO stuDo = addNewStudent();
        stuDo.setPassword("modify123");

        mockMvc.perform(MockMvcRequestBuilders.put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(stuDo))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        final StudentDO queryDo = queryStudent(stuDo);

        Assert.assertEquals(stuDo.getStuNum(), queryDo.getStuNum());
        Assert.assertEquals(stuDo.getName(), queryDo.getName());
        Assert.assertEquals(stuDo.getPassword(), queryDo.getPassword());
    }

    @Test
    public void should_be_fail_when_modifying_non_existing_student() {
        // to be continue
    }

    @Test
    public void should_be_success_when_delete_existing_student() throws Exception {
        final StudentDO stuDo = addNewStudent();

        mockMvc.perform(MockMvcRequestBuilders.delete(url + "//" + stuDo.getStuNum())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders
                        .get(queryStuByNumUrl, stuDo.getStuNum())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void should_be_success_when_delete_non_existing_student() {
        // to be continue
    }

    private StudentDO addNewStudent() throws Exception {
        final StudentDO stuDo = new StudentDO();
        stuDo.setStuNum("test99");
        stuDo.setName("test");
        stuDo.setPassword("test123");
        final String json = new ObjectMapper().writeValueAsString(stuDo);

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        return stuDo;
    }

    private StudentDO queryStudent(StudentDO stuDo) throws Exception {
        final MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get(queryStuByNumUrl, stuDo.getStuNum())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        return new ObjectMapper().readValue(
                result.getResponse().getContentAsString(), new TypeReference<StudentDO>() {
                });
    }
}