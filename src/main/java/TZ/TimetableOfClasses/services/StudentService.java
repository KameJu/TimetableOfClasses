package TZ.TimetableOfClasses.services;

import TZ.TimetableOfClasses.models.Group;
import TZ.TimetableOfClasses.models.Student;
import TZ.TimetableOfClasses.models.Timetable;
import TZ.TimetableOfClasses.repositories.GroupRepository;
import TZ.TimetableOfClasses.repositories.StudentRepository;
import TZ.TimetableOfClasses.repositories.TimetableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final TimetableRepository timetableRepository;

    public Student assignStudentToGroup(Long student_id, int group_number) {
        Student student = studentRepository.getById(student_id);

        Group group = groupRepository.findGroupByNumber(group_number);

        student.setGroup(group);

        return studentRepository.save(student);
    }

    public List<Timetable> getAllTimetables(Long studentId) {
        return timetableRepository.getTimetablesByGroup(getGroup(studentId));
    }

    public Timetable getTimetable(Long studentId, String date) {
        LocalDate parseDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        return timetableRepository.getTimetableByDateAndGroup(parseDate, getGroup(studentId));

    }

    private Group getGroup(Long studentId) {
        return studentRepository.findById(studentId).get().getGroup();
    }
}
