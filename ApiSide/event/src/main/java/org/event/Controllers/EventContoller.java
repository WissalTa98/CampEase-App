package org.event.Controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.event.Entity.Event;
import org.event.Services.ServiceEventImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("event")
@AllArgsConstructor

public class EventContoller {

    private final  ServiceEventImp serviceEventImp;

    @GetMapping("/allevent")
    public List<Event> getAll() {
        List<Event> events =  serviceEventImp.getAllEvents();
        return events;
    }


    @PostMapping("/addEevent")
    public Event addEvent(@RequestBody Event event)
    {
        return serviceEventImp.addEvent(event);
    }

    @PutMapping("/updateEvent/{id}")
    public Event updateEvent(@PathVariable  Integer id ,
                             @RequestBody  Event event)
    {
        return serviceEventImp.updateEvent(id,event);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public  void deleteEvent ( @PathVariable Integer id)
    {
        serviceEventImp.deleteEvent(id);
    }






}
