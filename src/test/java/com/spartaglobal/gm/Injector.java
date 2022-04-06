package com.spartaglobal.gm;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.MalformedURLException;
import java.net.URL;

public class Injector {
    public static PeopleDTO injectDTO(String url){
        PeopleDTO peopleDTO = new PeopleDTO();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            peopleDTO = objectMapper.readValue(new URL(url), PeopleDTO.class)
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return peopleDTO;
    }
}
