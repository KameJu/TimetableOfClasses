package TZ.TimetableOfClasses.controllers;

import TZ.TimetableOfClasses.models.Student;
import TZ.TimetableOfClasses.models.Timetable;
import TZ.TimetableOfClasses.repositories.GroupRepository;
import TZ.TimetableOfClasses.repositories.StudentRepository;
import TZ.TimetableOfClasses.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    private final StudentRepository studentRepository;

    private final GroupRepository groupRepository;


    @GetMapping
    public List<Student> getAllStudents() {
        System.out.println("All students");
        return studentRepository.findAll();
    }

    @GetMapping("/{student_id}")
    public Student getStudentById(@PathVariable Long student_id) {

        return studentRepository.findById(student_id).orElse(null);
    }

    @GetMapping("/{student_id}/timetables/")
    public List<Timetable> getTimetables(@PathVariable Long student_id) {
        return studentService.getAllTimetables(student_id);
    }

    @GetMapping("/{studentId}/timetables/{date}")
    public Timetable getTimetable(@PathVariable Long studentId, @PathVariable String date) {
        return studentService.getTimetable(studentId, date);
    }

    @PutMapping
    public Student addNewStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }


    @DeleteMapping("/{student_id}")
    public void deleteStudent(@PathVariable Long student_id) {
        studentRepository.delete(studentRepository.getById(student_id));
    }


    @PutMapping("/{student_id}/group/{group_number}")
    public Student assignStudentToGroup(
            @PathVariable Long student_id,
            @PathVariable int group_number
    ){
        return studentService.assignStudentToGroup(student_id, group_number);
    }
}
