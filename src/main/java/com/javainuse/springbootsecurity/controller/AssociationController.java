package com.javainuse.springbootsecurity.controller;

import com.javainuse.springbootsecurity.Services.AssociationService;
import com.javainuse.springbootsecurity.Services.VolunteerService;
import com.javainuse.springbootsecurity.model.Association;
import com.javainuse.springbootsecurity.model.Volunteer;
import com.javainuse.springbootsecurity.model.Volunteer_Association;
import lombok.Data;
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

    @RequestMapping(value = "/addToAss",method = RequestMethod.POST)
    public ResponseEntity<Association> addToAss(@RequestBody addtoass addtoass) throws Exception
    {

        Association association1=associationService.addVolToAssociation(addtoass.assId,addtoass.volId);
        return ResponseEntity.ok().body(association1);
    }

    @RequestMapping(value = "/changeAddToAss/{vaID}",method = RequestMethod.POST)
    public ResponseEntity<Volunteer_Association> changeAddToAss(@PathVariable Long vaID,@RequestBody Volunteer_Association volunteer_association) throws Exception
    {

        System.out.println(volunteer_association.getStatus());
        Volunteer_Association association1=associationService.changeStatus(vaID,volunteer_association);
        return ResponseEntity.ok().body(association1);
    }

    //Api to add new Emp


}
@Data
class addtoass
{
    Long volId;
    Long assId;
}

