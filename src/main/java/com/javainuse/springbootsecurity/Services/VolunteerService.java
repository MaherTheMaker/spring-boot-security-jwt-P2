package com.javainuse.springbootsecurity.Services;



import com.javainuse.springbootsecurity.model.Exception.NotFoundException;
import com.javainuse.springbootsecurity.model.User;
import com.javainuse.springbootsecurity.model.Volunteer;
import com.javainuse.springbootsecurity.model.VolunteerDay;
import com.javainuse.springbootsecurity.repository.UserRepo;
import com.javainuse.springbootsecurity.repository.VolunteerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VolunteerService  {


    @Autowired
    private VolunteerRepo volunteerRepo;

    @Autowired
    private UserRepo userRepo;


    public Volunteer RegisterVolunteer (Volunteer volunteer,int userid)
    {
      User  user= userRepo.findById(userid);
      if (user==null)
          throw new NotFoundException("no such user id");

        volunteer.setUser(user);

        volunteer=volunteerRepo.save(volunteer);

        return volunteer;
    }




}