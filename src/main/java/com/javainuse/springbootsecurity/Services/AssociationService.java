package com.javainuse.springbootsecurity.Services;


import com.javainuse.springbootsecurity.model.*;
import com.javainuse.springbootsecurity.model.Exception.NotFoundException;
import com.javainuse.springbootsecurity.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    private EventRepo eventRepo;

    @Autowired
    private Event_TaskRepo event_taskRepo;

    @Autowired
    private BeneficiaryRepo beneficiaryRepo;

    @Autowired
    private Ben_EventRepo ben_eventRepo;

    @Autowired
    private Volunteer_AssociationRepo volunteer_associationRepo;

    @Autowired
    private Event_Task_VolunteerRepo event_task_volunteerRepo;

    @Autowired
    UsersService usersService;


    public AssociationService() {
    }

    public Association RegisterAssociation (Association association,User user,Profile profile)
    {



       association= associationRepo.save(association);
        //todo Create SuperEmp user
        User userEmp=usersService.RegisterUser(user,profile);


        Employee emp=new Employee();
        emp.setUser(userEmp);
        emp.setPrice(10000);
        emp.setAssociation(association);
        emp.getUser().setType(Type.AssociationAdmin);
        emp.getUser().getProfile().setRole("ROLE_SUPEREMP");
        Employee employee= employeeRepo.save(emp);

        association.setEmployees(new ArrayList<>());
        association.setEvents(new ArrayList<>());
        association.setNeeds(new ArrayList<>());
        association.setVolunteer_associations(new ArrayList<>());
        association.getEmployees().add(employee);



        return associationRepo.save(association);
    }

    public List<Association> GetAllAss ()
    {

        return associationRepo.findAll();
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


    public  Association addVolToAssociation(Long assId, long volId)
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


    public  Association AddEvent(Long AssId,Event event,List<Long> benIds)
    {
        Association association  = associationRepo.findById(AssId);

        if(association==null)
            throw  new NotFoundException("no such Association");

        event.setAssociation(association);




        Event event1=eventRepo.save(event);
        association.getEvents().add(event);
        associationRepo.save(association);
        return association;
    }

    public List<Event> GetEventByAss(Long AssId)
    {
        Association association  = associationRepo.findById(AssId);

        if(association==null)
            throw  new NotFoundException("no such Association");

        return eventRepo.findAllByAssociation(association);

    }

    public Event AddTaskToEvent(Long EveId,Event_Task event_task,List<Long> volIds)
    {
        Event event=eventRepo.findById(EveId);

        if(event==null)
            throw  new NotFoundException("no such Event");

        event_task.setEvent(event);
        Event_Task event_task1=event_taskRepo.save(event_task);

        event.getEvent_tasks().add(event_task1);





        return  eventRepo.save(event);

    }

    public Event AddBenToEvent(Long EveId,long BenId)
    {
        Event event=eventRepo.findById(EveId);

        if(event==null)
            throw  new NotFoundException("no such Event");

        Beneficiary beneficiary=beneficiaryRepo.findById(BenId);

        if(beneficiary==null)
            throw  new NotFoundException("no such Beneficiary");

        Beneficiary_Event beneficiary_event=new Beneficiary_Event();
        beneficiary_event.setBeneficiary(beneficiary);
        beneficiary_event.setEvent(event);

        Beneficiary_Event beneficiary_event1= ben_eventRepo.save(beneficiary_event);


        event.getBeneficiary_events().add(beneficiary_event1);


        return  eventRepo.save(event);

    }


    public Event_Task AddVolToEveTask(  Long eveTaskId,  long volId) {
        Event_Task event_task=event_taskRepo.findById(eveTaskId);

        if(event_task==null)
            throw  new NotFoundException("no such Event_Task");

        Volunteer volunteer=volunteerRepo.findById(volId);

        if(volunteer==null)
            throw  new NotFoundException("no such Volunteer");

        Event_Task_Volunteer event_task_volunteer=new Event_Task_Volunteer();

        event_task_volunteer.setEventTask(event_task);
        event_task_volunteer.setVolunteer(volunteer);

         Event_Task_Volunteer event_task_volunteer1= event_task_volunteerRepo.save(event_task_volunteer);

         event_task.getEventTaskVolunteers().add(event_task_volunteer1);


        return event_taskRepo.save(event_task);
    }
}