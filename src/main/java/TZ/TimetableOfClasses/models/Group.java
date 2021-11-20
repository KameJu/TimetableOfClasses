package TZ.TimetableOfClasses.models;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Group {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int number;

    @OneToMany(mappedBy = "group")
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Timetable> timetable = new ArrayList<>();

    public Group(int number, List<Student> students, List<Timetable> timetable) {
        this.number = number;
        this.students = students;
        this.timetable = timetable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Timetable> getTimetable() {
        return timetable;
    }

    public void setTimetable(List<Timetable> timetable) {
        this.timetable = timetable;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
