package com.example.testsw1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class mockMvcRegister45 {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testRegistration() throws Exception {
        // мокмвс по юрл слэш регистер отправляет значение логина и пароля и возвращает статус
        mockMvc.perform(post("/register")
                        .param("login", "testuser2")
                        .param("pass", "testpassword"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnAccessGranted() throws Exception {
        this.mockMvc.perform(post("/").param("login", "123").param("pass", "123")).
                andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Добро пожаловать, 123")));
        this.mockMvc.perform(get("/logout")).
                andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Пользователь вышел")));
    }

    @Test
    public void shouldReturnAccessDenied() throws Exception {
        this.mockMvc.perform(post("/").param("login", "123").param("pass", "234")).
                andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Неправильный пароль, 123")));

    }
}
