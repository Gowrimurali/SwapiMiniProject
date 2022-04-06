package com.spartaglobal.gm;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class Injector {
    public static PeopleDTO injectDTO(String url){
        PeopleDTO peopleDTO = new PeopleDTO();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            peopleDTO = objectMapper.readValue(ConnectionManager.getConnectionResponse(1).body(), PeopleDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return peopleDTO;
    }
}
