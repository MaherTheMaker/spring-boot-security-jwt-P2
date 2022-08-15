package com.javainuse.springbootsecurity.controller;

import com.javainuse.springbootsecurity.Services.AssociationService;
import com.javainuse.springbootsecurity.model.Association;
import com.javainuse.springbootsecurity.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/public")
public class PublicInfoController {

    @Autowired
    AssociationService associationService;

    //todo api to Get skills

    //todo api to Get Volunteering Area

    //todo api to Get Volunteering Days

    //todo api to get all ass
    @RequestMapping(value = "/GetAllAss",method = RequestMethod.GET)
    public ResponseEntity<List<Association>> GetAllAss() throws Exception
    {
        return ResponseEntity.ok().body( associationService.GetAllAss());

    }
}
