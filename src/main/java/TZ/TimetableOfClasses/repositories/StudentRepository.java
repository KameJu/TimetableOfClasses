package TZ.TimetableOfClasses.repositories;

import TZ.TimetableOfClasses.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student getStudentById(Long studentId);
}
