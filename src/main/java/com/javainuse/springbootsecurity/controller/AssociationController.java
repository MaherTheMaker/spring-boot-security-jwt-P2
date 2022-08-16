package com.javainuse.springbootsecurity.controller;

import com.javainuse.springbootsecurity.Services.AssociationService;
import com.javainuse.springbootsecurity.Services.UsersService;
import com.javainuse.springbootsecurity.model.*;
import com.javainuse.springbootsecurity.repository.SkillRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping(value = "/ass")
public class AssociationController {

    // testing quasi
    @Autowired
    AssociationService associationService;

    @Autowired
    UsersService usersService;

    @Autowired
    SkillRepository skillRepository;



//    @RequestMapping(value = "/add/{userid}",method = RequestMethod.POST)
//    public ResponseEntity<Association> addAss(@RequestBody Association association, @PathVariable int userid) throws Exception
//    {
//
//       Association association1=associationService.RegisterAssociation(association,userid);
//        return ResponseEntity.ok().body(association);
//    }

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
    @RequestMapping(value = "/AddNewEvent",method = RequestMethod.POST)
    public ResponseEntity<Association> AddNewEvent(@RequestBody AddEventToAss addEventToAss) throws Exception
    {

        Association association1=associationService.AddEvent(addEventToAss.assId,addEventToAss.event,addEventToAss.benIds);
        return ResponseEntity.ok().body(association1);

    }

    @RequestMapping(value = "/GetEvents/{assId}",method = RequestMethod.GET)
    public ResponseEntity<List<Event>> GetEvents(@PathVariable Long assId) throws Exception
    {
        return ResponseEntity.ok().body( associationService.GetEventByAss(assId));

    }

    @RequestMapping(value = "/AddTaskToEven",method = RequestMethod.POST)
    public ResponseEntity<Event> AddTaskToEven(@RequestBody AddTaskToEvent addTaskToEvent) throws Exception
    {

       Event event= associationService.AddTaskToEvent(addTaskToEvent.eveId,addTaskToEvent.event_task,addTaskToEvent.volIds);
        return ResponseEntity.ok().body(event);

    }

    @RequestMapping(value = "/AddBenToEven",method = RequestMethod.POST)
    public ResponseEntity<Event> AddBenToEven(@RequestBody AddBenToEvent addBenToEvent) throws Exception
    {

        Event event= associationService.AddBenToEvent(addBenToEvent.eveId,addBenToEvent.benId);
        return ResponseEntity.ok().body(event);

    }
    @RequestMapping(value = "/AddVolToEveTask",method = RequestMethod.POST)
    public ResponseEntity<Event_Task> AddVolToEveTask(@RequestBody AddVolToEveTask addVolToEveTask) throws Exception
    {

        Event_Task event_task= associationService.AddVolToEveTask(addVolToEveTask.eveTaskId,addVolToEveTask.volId);
        return ResponseEntity.ok().body(event_task);

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
@Data
class AddEventToAss
{
    Long assId;
    Event event;
    List<Long> benIds;

}

@Data
class AddTaskToEvent
{
    Long eveId;
    Event_Task event_task;
    List<Long> volIds;

}

@Data
class AddBenToEvent
{
    Long benId;
    Long eveId;
}

@Data
class AddVolToEveTask
{
    Long volId;
    Long eveTaskId;
}


