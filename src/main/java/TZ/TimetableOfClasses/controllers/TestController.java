package TZ.TimetableOfClasses.controllers;

import TZ.TimetableOfClasses.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/student")
    public Student getStudent() {
        return new Student();
    }
}
