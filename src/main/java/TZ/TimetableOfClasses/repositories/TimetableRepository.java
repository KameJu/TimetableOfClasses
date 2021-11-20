package TZ.TimetableOfClasses.repositories;

import TZ.TimetableOfClasses.models.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
}
