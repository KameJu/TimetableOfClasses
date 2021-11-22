package TZ.TimetableOfClasses.controllers;

import TZ.TimetableOfClasses.models.Group;
import TZ.TimetableOfClasses.models.Timetable;
import TZ.TimetableOfClasses.repositories.GroupRepository;
import TZ.TimetableOfClasses.repositories.TimetableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/timetables")
public class TimetableController {

    private final TimetableRepository timetableRepository;
    private final GroupRepository groupRepository;

    @GetMapping
    public List<Timetable> getTimetables() {
        return timetableRepository.findAll();
    }

    @GetMapping("/{date}")
    public List<Timetable> getTimetablesByDate(@PathVariable String date) {
        LocalDate newDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        return timetableRepository.getTimetablesByDate(newDate);
    }

    @GetMapping("/{date}/{group_number}")
    public Timetable getTimetableByDateForGroup(@PathVariable String date, @PathVariable int group_number) {
        LocalDate newDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        Group group = groupRepository.findGroupByNumber(group_number);
        return timetableRepository.getTimetableByDateAndGroup(newDate, group);
    }


}
