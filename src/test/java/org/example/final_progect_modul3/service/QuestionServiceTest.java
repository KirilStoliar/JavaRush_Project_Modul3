package org.example.final_progect_modul3.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.example.final_progect_modul3.model.Data;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceTest {

    @Test
    @SneakyThrows
    void readFromFile() {
        assertThrows(NullPointerException.class,
                () -> new BufferedReader(new InputStreamReader(
                        QuestionService.class.getClassLoader().getResourceAsStream(null))));
    }

    @Test
        void readFromFile2() {
            ObjectMapper mapper = new ObjectMapper();
            assertThrows(JsonParseException.class,
                    () -> mapper.readValue("C:next", Data.class));
        }
}