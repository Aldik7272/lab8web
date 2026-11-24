package kz.iitu.clinic.service;

import kz.iitu.clinic.model.Event;
import kz.iitu.clinic.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAll(String title) {
        if (title != null && !title.isBlank()) {
            return eventRepository.findByTitleContainingIgnoreCase(title.trim());
        }
        return eventRepository.findAll();
    }

    public Optional<Event> getById(Long id) {
        return eventRepository.findById(id);
    }

    public Event create(Event event) {
        if (event == null || isBlank(event.getTitle()) || isBlank(event.getLocation())) {
            return null;
        }
        Event toSave = new Event(event.getTitle().trim(), event.getLocation().trim());
        return eventRepository.save(toSave);
    }

    public Optional<Event> update(Long id, Event updated) {
        if (updated == null || isBlank(updated.getTitle()) || isBlank(updated.getLocation())) {
            throw new IllegalArgumentException("Invalid input");
        }
        return eventRepository.findById(id).map(existing -> {
            existing.setTitle(updated.getTitle().trim());
            existing.setLocation(updated.getLocation().trim());
            return eventRepository.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (!eventRepository.existsById(id)) {
            return false;
        }
        eventRepository.deleteById(id);
        return true;
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}