package com.javainuse.springbootsecurity.Services;


import com.javainuse.springbootsecurity.model.Association;
import com.javainuse.springbootsecurity.model.Exception.NotFoundException;
import com.javainuse.springbootsecurity.model.User;
import com.javainuse.springbootsecurity.model.Volunteer;
import com.javainuse.springbootsecurity.repository.AssociationRepo;
import com.javainuse.springbootsecurity.repository.UserRepo;
import com.javainuse.springbootsecurity.repository.VolunteerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociationService {


    @Autowired
    private VolunteerRepo volunteerRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AssociationRepo associationRepo;

    public Association RegisterAssociation (Association association,int userId)
    {

        associationRepo.save(association);


        return association;
    }

//    public  Association addVolToAssociation(int assId, int volId)
//    {
//        Volunteer volunteer =volunteerRepo.findById(volId);
//        if (volunteer==null)
//        {
//            throw new NotFoundException("no such volunteer");
//        }
//
//        Association association =associationRepo.findById(volId);
//        if (association==null)
//        {
//            throw new NotFoundException("no such association");
//        }
//        volunteer.getAssociations().add(association);
//        association.getVolunteers().add(volunteer);
//
//
//
//    }




}