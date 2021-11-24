package TZ.TimetableOfClasses.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "study_group")
@NoArgsConstructor
@ToString
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

    public Set<Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(Set<Timetable> timetables) {
        this.timetables = timetables;
    }
}
