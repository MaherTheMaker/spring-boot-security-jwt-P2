package com.javainuse.springbootsecurity.controller;

import com.javainuse.springbootsecurity.Services.BeneficiaryService;
import com.javainuse.springbootsecurity.Services.VolunteerService;
import com.javainuse.springbootsecurity.model.Beneficiary;
import com.javainuse.springbootsecurity.model.Event_Task;
import com.javainuse.springbootsecurity.model.Need;
import com.javainuse.springbootsecurity.model.Volunteer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ben")
public class BeneficiaryController {

    @Autowired
    BeneficiaryService beneficiaryService;

    @RequestMapping(value = "/add/{userid}",method = RequestMethod.POST)
    public ResponseEntity<Beneficiary> AddBen(@RequestBody Beneficiary beneficiary, @PathVariable int userid) throws Exception
    {

       Beneficiary beneficiary1=beneficiaryService.RegisterBeneficiary(beneficiary,userid);
        return ResponseEntity.ok().body(beneficiary);
    }
    @RequestMapping(value = "/addNeed",method = RequestMethod.POST)
    public ResponseEntity<Beneficiary> addNeed(@RequestBody AddNeed addNeed) throws Exception
    {

        Beneficiary beneficiary1=beneficiaryService.AddNeeds(addNeed.benId,addNeed.need,addNeed.assId);
        return ResponseEntity.ok().body(beneficiary1);
    }




}
@Data
class AddNeed
{
    Long benId;
    Need need ;
    Long assId;

}

