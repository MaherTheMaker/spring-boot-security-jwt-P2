package com.javainuse.springbootsecurity.Services;


import com.javainuse.springbootsecurity.model.*;
import com.javainuse.springbootsecurity.model.Exception.NotFoundException;
import com.javainuse.springbootsecurity.repository.*;
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
    private EmployeeRepo employeeRepo;

    @Autowired
    UsersService usersService;

    @Autowired
    private Volunteer_AssociationRepo volunteer_associationRepo;

    public Association RegisterAssociation (Association association,int userId)
    {

        associationRepo.save(association);


        return association;
    }

    public Association AddNewEmp (Long AssId,User user,Profile profile,int price)
    {

       Association association  = associationRepo.findById(AssId);

       if(association==null)
           throw  new NotFoundException("no such Association");

       User userEmp=usersService.RegisterUser(user,profile);


        Employee emp=new Employee();
        emp.setUser(userEmp);
        emp.setPrice(price);
        emp.setAssociation(association);
        emp.getUser().setType(Type.AssociationEmp);
        emp.getUser().getProfile().setRole("ROLE_EMP");
        Employee employee= employeeRepo.save(emp);

        association.getEmployees().add(employee);

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