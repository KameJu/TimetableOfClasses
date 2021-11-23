package TZ.TimetableOfClasses.controllers;

import TZ.TimetableOfClasses.models.Student;
import TZ.TimetableOfClasses.models.Timetable;
import TZ.TimetableOfClasses.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping("/{studentId}")
    public Student getOne(@PathVariable("studentId") Student student) {
        return student;
    }

    @PutMapping("{/studentId}")
    public Student update(
            @PathVariable("studentId") Student studentFromDb,
            @RequestBody Student student) {
        System.out.println("something");
        return studentService.update(studentFromDb, student);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable("studentId") Student student) {
        studentService.delete(student);
    }

    @GetMapping("/{studentId}/timetables")
    public List<Timetable> getAllTimetables(@PathVariable("studentId") Student student) {
        return studentService.getAllTimetables(student);
    }

    @GetMapping("/{studentId}/timetables/{date}")
    public Timetable getTimetable(
            @PathVariable("studentId") Student student,
            @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    ) {
        return studentService.getTimetable(student, date);
    }


    @PutMapping("/{student_id}/group/{group_number}")
    public Student assignStudentToGroup(
            @PathVariable Long student_id,
            @PathVariable int group_number
    ) {
        return studentService.assignStudentToGroup(student_id, group_number);
    }
}
