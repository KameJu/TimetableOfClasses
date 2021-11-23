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
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final TimetableRepository timetableRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student assignStudentToGroup(Long student_id, int group_number) {
        Student student = studentRepository.getById(student_id);

        Group group = groupRepository.findGroupByNumber(group_number);

        student.setGroup(group);

        return studentRepository.save(student);
    }

    public List<Timetable> getAllTimetables(Student student) {
        return timetableRepository.getTimetablesByGroup(student.getGroup());
    }

    public Timetable getTimetable(Student student, LocalDate date) {
        return timetableRepository.getTimetableByDateAndGroup(date, student.getGroup());

    }

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public void delete(Student student) {
            studentRepository.delete(student);
    }

    public Student update(Student studentFromDb, Student student) {
        fillUpdates(studentFromDb, student);
        return studentRepository.save(studentFromDb);
    }

    private void fillUpdates(Student studentFromDb, Student student) {
        studentFromDb.setFirstName(student.getFirstName());
        studentFromDb.setLastName(student.getLastName());
        studentFromDb.setGroup(student.getGroup());
    }
}
