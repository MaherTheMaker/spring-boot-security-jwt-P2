package com.javainuse.springbootsecurity.controller;

import com.javainuse.springbootsecurity.Services.AssociationService;
import com.javainuse.springbootsecurity.Services.UsersService;
import com.javainuse.springbootsecurity.model.Association;
import com.javainuse.springbootsecurity.model.Employee;
import com.javainuse.springbootsecurity.model.User;
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

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/add/{userid}",method = RequestMethod.POST)
    public ResponseEntity<Association> addAss(@RequestBody Association association, @PathVariable int userid) throws Exception
    {

       Association association1=associationService.RegisterAssociation(association,userid);
        return ResponseEntity.ok().body(association);
    }

    @RequestMapping(value = "/addToAss",method = RequestMethod.POST)
    public ResponseEntity<Association> addToAss(@RequestBody AddVolToAss AddVolToAss) throws Exception
    {

        Association association1=associationService.addVolToAssociation(AddVolToAss.assId, AddVolToAss.volId);
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

    @RequestMapping(value = "/AddNewEmp",method = RequestMethod.POST)
    public ResponseEntity<Association> AddNewEmp(@RequestBody AddEmpToAss addEmpToAss) throws Exception
    {

        Association association1=associationService.AddNewEmp(addEmpToAss.assId,addEmpToAss.newUser.user,addEmpToAss.newUser.profile,addEmpToAss.price);
        return ResponseEntity.ok().body(association1);

    }

}
@Data
class AddVolToAss
{
    Long volId;
    Long assId;
}

@Data
class AddEmpToAss
{
    Long assId;
    newUser newUser;
    int price;
}