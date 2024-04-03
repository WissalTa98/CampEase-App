package org.event.Services;

import lombok.RequiredArgsConstructor;
import org.event.Entity.Event;
import org.event.Entity.EventCategory;
import org.event.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceEventImp {


    @Autowired
    private final EventRepository eventRepository;


    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }


    public Event updateEvent( Integer idEvent , Event eventdetails) {

        Event event = eventRepository.findById(idEvent).get();

        event.setName(eventdetails.getName());
        event.setDescription(event.getDescription());
        event.setStartDate(eventdetails.getStartDate());
        event.setEndDate(eventdetails.getEndDate());
        event.setNbParticipant(eventdetails.getNbParticipant());
        event.setImage(eventdetails.getImage());
        event.setPrice(eventdetails.getPrice());
        event.setVideoUrl(eventdetails.getVideoUrl());
        event.setCategory(eventdetails.getCategory());

        return  eventRepository.save(event);

    }


    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }




    public Event getEventById(int id) {
        return eventRepository.findById(id).orElse(null);
    }





    public List<EventCategory> getCategories() {
        List<EventCategory> categories = Arrays.asList(EventCategory.values());
        return categories;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }


/*
    public List<Event> getRelevantEvent(EventCategory category) {
        return eventRepository.findTop4ByCategory(category);
    }


    public List<Event> getEventsByCampPlace(Integer campPlaceId){
        return eventRepository.findTop10ByCampPlaceIdCampPlace(campPlaceId);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findTop10ByOrderByStartDateDesc();
    }

    public Page<Event> getFilteredEvents(
            List<EventCategory> categories,
            Double minPrice,
            Double maxPrice,
            Date startDate,
            Date endDate,
            String search,
            Pageable pageable) {
        return eventRepository.findByCategoryInAndPriceBetweenAndStartDateBetweenWithSearch(
                categories,
                minPrice,
                maxPrice,
                startDate,
                endDate,
                search,
                pageable);
    }
    public long eventCount(){
        return  this.eventRepository.count();
    }
*/
}