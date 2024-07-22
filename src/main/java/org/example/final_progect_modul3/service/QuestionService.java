package org.example.final_progect_modul3.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.final_progect_modul3.model.Data;
import java.io.*;

import static org.example.consts.Variables.pathFileJson;

public class QuestionService {

    public Data readFromFile() throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(
                QuestionService.class.getClassLoader().getResourceAsStream(pathFileJson), "UTF-8"));
        String line = "";
        while (buffer.ready()) {
            line = line + "\n" + buffer.readLine();
        }
        buffer.close();

        ObjectMapper mapper = new ObjectMapper();
        Data root = mapper.readValue(line, Data.class);
        return root;
    }
}
