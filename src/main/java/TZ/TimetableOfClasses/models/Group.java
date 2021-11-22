package TZ.TimetableOfClasses.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "study_group")
@NoArgsConstructor
public class Group {

    @Id
    @NotNull
    private int number;

    @JsonIgnore
    @OneToMany(mappedBy = "group", orphanRemoval = true)
    private Set<Student> students = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "group", orphanRemoval = true)
    private Set<Timetable> timetables = new HashSet<>();



















    public Group(int number) {
        this.number = number;
    }


    public void addStudent(Student student) {
        students.add(student);
        student.setGroup(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setGroup(null);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
