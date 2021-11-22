package TZ.TimetableOfClasses.repositories;

import TZ.TimetableOfClasses.models.Group;
import TZ.TimetableOfClasses.models.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    public List<Timetable> getTimetablesByDate(LocalDate date);
    public Timetable getTimetableByDateAndGroup(LocalDate date, Group group);

    public List<Timetable> getTimetablesByGroup(Group group);
}
