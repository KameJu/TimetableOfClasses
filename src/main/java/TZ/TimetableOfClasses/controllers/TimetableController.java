package TZ.TimetableOfClasses.controllers;

import TZ.TimetableOfClasses.models.Timetable;
import TZ.TimetableOfClasses.services.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/timetables")
public class TimetableController {

    private final TimetableService timetableService;

    @GetMapping
    public List<Timetable> getTimetables() {
        return timetableService.findAll();
    }

    @GetMapping("/{timetableId}")
    public Timetable getOne(@PathVariable("timetableId") Timetable timetable) {
        return timetable;
    }

    @PutMapping
    public Timetable create(@RequestBody Timetable timetable) {
        return timetableService.create(timetable);
    }

    @DeleteMapping("/{timetableId}")
    public void delete(@PathVariable("timetableId") Timetable timetable) {
        timetableService.delete(timetable);
    }

    @PutMapping("/{timetableId}")
    public Timetable update(
            @PathVariable("timetableId") Timetable fromDb,
            @RequestBody Timetable timetable
    ) {
        return timetableService.update(fromDb, timetable);
    }
}
