package com.javainuse.springbootsecurity.controller;

import com.javainuse.springbootsecurity.Services.VolunteerService;
import com.javainuse.springbootsecurity.model.User;
import com.javainuse.springbootsecurity.model.Volunteer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vol")
public class VolunteerController {

    @Autowired
    VolunteerService volunteerService;

    @RequestMapping(value = "/add/{userid}",method = RequestMethod.POST)
    public ResponseEntity<Volunteer> AddVol(@RequestBody Volunteer volunteer,@PathVariable int userid) throws Exception
    {
        //Todo get list of skills and days and areas

       Volunteer volunteer2= volunteerService.RegisterVolunteer(volunteer,userid);
        return ResponseEntity.ok().body(volunteer2);
    }




}

@Data
class  NewVol
{
    Volunteer volunteer;
    List<Long> skillsList;
    List<Long> daysList;
    List<Long> areaList;
}
