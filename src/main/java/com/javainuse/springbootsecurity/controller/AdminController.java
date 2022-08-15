package com.javainuse.springbootsecurity.controller;


import com.javainuse.springbootsecurity.Services.BeneficiaryService;
import com.javainuse.springbootsecurity.Services.VolunteerService;
import com.javainuse.springbootsecurity.model.Beneficiary;
import com.javainuse.springbootsecurity.model.Skill;
import com.javainuse.springbootsecurity.repository.SkillRepository;
import com.javainuse.springbootsecurity.repository.VolunteerAreaRepository;
import com.javainuse.springbootsecurity.repository.VolunteerDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //todo api to add skills

    @RequestMapping(value = "/addSkill",method = RequestMethod.POST)
    public ResponseEntity<Skill> AddSkill(Skill skill) throws Exception
    {
    return ResponseEntity.ok().body(skillRepository.save(skill));
    }

    //todo api to add Volunteering Area

    //todo api to add Volunteering Days

    //todo api to Create Association and AssociationAdmin

    //todo api to get Vol List

    //todo api to get Ben List






}
