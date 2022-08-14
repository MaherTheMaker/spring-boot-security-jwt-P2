package com.javainuse.springbootsecurity.controller;

import com.javainuse.springbootsecurity.Services.AssociationService;
import com.javainuse.springbootsecurity.Services.VolunteerService;
import com.javainuse.springbootsecurity.model.Association;
import com.javainuse.springbootsecurity.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ass")
public class AssociationController {

    // testing quasi
    @Autowired
    AssociationService associationService;

    @RequestMapping(value = "/add/{userid}",method = RequestMethod.POST)
    public ResponseEntity<Association> addAss(@RequestBody Association association, @PathVariable int userid) throws Exception
    {

       Association association1=associationService.RegisterAssociation(association,userid);
        return ResponseEntity.ok().body(association);
    }
}

