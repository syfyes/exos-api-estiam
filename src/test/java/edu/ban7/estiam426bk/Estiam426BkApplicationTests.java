package edu.ban7.estiam426bk;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
@RequiredArgsConstructor
class Estiam426BkApplicationTests {

    private final WebApplicationContext context;
    private MockMvc mvc;

    @BeforeEach
    void setup() {

        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                //.apply(springSecurity())
                .build();
    }

    @Test
    void getAllUser_shouldReturn200ok() throws Exception {

        mvc.perform(get("/user/all"))
                .andExpect(status().isOk());
    }

    @Test
    void getAnyUser_passwordShouldBeNull() throws Exception {

        mvc.perform(get("/user/1"))
                .andExpect(jsonPath("$.password").doesNotExist());
    }

}
