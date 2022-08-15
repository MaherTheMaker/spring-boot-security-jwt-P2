package com.javainuse.springbootsecurity.Services;


import com.javainuse.springbootsecurity.model.*;
import com.javainuse.springbootsecurity.model.Exception.NotFoundException;
import com.javainuse.springbootsecurity.repository.AssociationRepo;
import com.javainuse.springbootsecurity.repository.UserRepo;
import com.javainuse.springbootsecurity.repository.VolunteerRepo;
import com.javainuse.springbootsecurity.repository.Volunteer_AssociationRepo;
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

    @Autowired
    private Volunteer_AssociationRepo volunteer_associationRepo;

    public Association RegisterAssociation (Association association,int userId)
    {

        associationRepo.save(association);


        return association;
    }

    public  Volunteer_Association changeStatus(Long vaID,Volunteer_Association va )
    {
       Volunteer_Association volunteer_association= volunteer_associationRepo.findById(vaID);
       volunteer_association.setStatus(va.getStatus());

                volunteer_associationRepo.save(volunteer_association);
        return volunteer_association;



    }
    public  Association addVolToAssociation(Long assId, Long volId)
    {
        Volunteer volunteer =volunteerRepo.findById(volId);
        if (volunteer==null)
        {
            throw new NotFoundException("no such volunteer");
        }

        Association association =associationRepo.findById(assId);
        if (association==null)
        {
            throw new NotFoundException("no such association");
        }


        Volunteer_Association volunteer_association=new Volunteer_Association();
        volunteer_association.setAssociation(association);
        volunteer_association.setVolunteer(volunteer);
        volunteer_association.setStatus(Status.pending);

        volunteer_association= volunteer_associationRepo.save(volunteer_association);
        volunteer.getVolunteer_associations().add(volunteer_association);
        association.getVolunteer_associations().add(volunteer_association);

        volunteerRepo.save(volunteer);
        associationRepo.save(association);

    return association;

    }




}