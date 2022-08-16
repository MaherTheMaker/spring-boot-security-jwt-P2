package com.javainuse.springbootsecurity.controller;

import com.javainuse.springbootsecurity.Services.AssociationService;
import com.javainuse.springbootsecurity.model.*;
import com.javainuse.springbootsecurity.repository.SkillRepository;
import com.javainuse.springbootsecurity.repository.VolunteerAreaRepository;
import com.javainuse.springbootsecurity.repository.VolunteerDayRepository;
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

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    VolunteerAreaRepository volunteerAreaRepository;

    @Autowired
    VolunteerDayRepository volunteerDayRepository;



    @RequestMapping(value = "/GetAllSkill",method = RequestMethod.GET)
    public ResponseEntity<List<Skill>> GetAllSkill() throws Exception
    {
        return ResponseEntity.ok().body( skillRepository.findAll());

    }




    @RequestMapping(value = "/GetAllVolunteeringArea",method = RequestMethod.GET)
    public ResponseEntity<List<VolunteeringArea>> GetAllVolunteeringArea() throws Exception
    {
        return ResponseEntity.ok().body( volunteerAreaRepository.findAll());

    }


    @RequestMapping(value = "/GetAllVolunteerDay",method = RequestMethod.GET)
    public ResponseEntity<List<VolunteerDay>> GetAllVolunteerDay() throws Exception
    {
        return ResponseEntity.ok().body( volunteerDayRepository.findAll());

    }


    @RequestMapping(value = "/GetAllAss",method = RequestMethod.GET)
    public ResponseEntity<List<Association>> GetAllAss() throws Exception
    {
        return ResponseEntity.ok().body( associationService.GetAllAss());

    }
}
