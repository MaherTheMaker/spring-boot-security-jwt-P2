package com.javainuse.springbootsecurity.controller;


import com.javainuse.springbootsecurity.Services.AssociationService;
import com.javainuse.springbootsecurity.Services.BeneficiaryService;
import com.javainuse.springbootsecurity.Services.VolunteerService;
import com.javainuse.springbootsecurity.model.*;
import com.javainuse.springbootsecurity.repository.SkillRepository;
import com.javainuse.springbootsecurity.repository.VolunteerAreaRepository;
import com.javainuse.springbootsecurity.repository.VolunteerDayRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    SkillRepository skillRepository;

    @Autowired
    VolunteerAreaRepository volunteerAreaRepository;

    @Autowired
    VolunteerDayRepository volunteerDayRepository;

    @Autowired
    VolunteerService volunteerService;

    @Autowired
    BeneficiaryService beneficiaryService;

    @Autowired
    AssociationService associationService;

    @RequestMapping(value = "/addAss",method = RequestMethod.POST)
    public ResponseEntity<Association> addAss(@RequestBody AddAss addAss ) throws Exception
    {

        Association association1=associationService.RegisterAssociation(addAss.association,addAss.user,addAss.profile);
        return ResponseEntity.ok().body(association1);
    }



    @RequestMapping(value = "/addSkill",method = RequestMethod.POST)
    public ResponseEntity<Skill> AddSkill(@RequestBody Skill skill) throws Exception
    {
        System.out.println(skill.getName());
        return ResponseEntity.ok().body(skillRepository.save(skill));
    }


    @RequestMapping(value = "/addVolunteeringArea",method = RequestMethod.POST)
    public ResponseEntity<VolunteeringArea> AddVolunteeringArea(@RequestBody VolunteeringArea volunteeringArea) throws Exception
    {
        return ResponseEntity.ok().body(volunteerAreaRepository.save(volunteeringArea));
    }


    @RequestMapping(value = "/addVolunteerDay",method = RequestMethod.POST)
    public ResponseEntity<VolunteerDay> AddVolunteerDay(@RequestBody VolunteerDay volunteerDay) throws Exception
    {
        return ResponseEntity.ok().body(volunteerDayRepository.save(volunteerDay));
    }


    //todo api to Create Association and AssociationAdmin


    @RequestMapping(value = "/GetAllVol",method = RequestMethod.GET)
    public ResponseEntity<List<Volunteer>> GetAllVol() throws Exception
    {
        return ResponseEntity.ok().body( volunteerService.GetAllVol());

    }

    @RequestMapping(value = "/GetAllBen",method = RequestMethod.GET)
    public ResponseEntity<List<Beneficiary>> GetAllBen() throws Exception
    {
        return ResponseEntity.ok().body( beneficiaryService.GetAllBen());

    }





}
@Data
class AddAss
{
    Association association;
    Profile profile;
    User user;
}