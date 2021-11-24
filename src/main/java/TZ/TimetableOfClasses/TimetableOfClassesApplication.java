package TZ.TimetableOfClasses;


import TZ.TimetableOfClasses.models.Group;
import TZ.TimetableOfClasses.models.Student;
import TZ.TimetableOfClasses.models.Timetable;
import TZ.TimetableOfClasses.repositories.GroupRepository;
import TZ.TimetableOfClasses.repositories.StudentRepository;
import TZ.TimetableOfClasses.repositories.TimetableRepository;
import TZ.TimetableOfClasses.services.TimetableService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class TimetableOfClassesApplication implements CommandLineRunner {

	private final GroupRepository groupRepository;
	private final StudentRepository studentRepository;
	private final TimetableRepository timetableRepository;

	private final TimetableService timetableService;

	private final ObjectMapper mapper;


	public static void main(String[] args) {
		SpringApplication.run(TimetableOfClassesApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		ObjectWriter writer = mapper.setConfig(mapper.getDeserializationConfig()).writerWithView(List.class);

		groupRepository.save(new Group(291));
		groupRepository.save(new Group(292));
		groupRepository.save(new Group(293));

		studentRepository.save(new Student("Ivan", "Shaptalov", groupRepository.findGroupByNumber(291)));

		List<String> lessons = new ArrayList<>();
		lessons.add("Chemistry");
		lessons.add("Math");
		lessons.add("Physics");



		timetableRepository.save(new Timetable(groupRepository.findGroupByNumber(291), LocalDate.now(), timetableService.getJsonLessons(lessons)));
		timetableRepository.save(new Timetable(groupRepository.findGroupByNumber(292), LocalDate.now(), timetableService.getJsonLessons(lessons)));
		timetableRepository.save(new Timetable(groupRepository.findGroupByNumber(293), LocalDate.now(), timetableService.getJsonLessons(lessons)));
		timetableRepository.save(new Timetable(groupRepository.findGroupByNumber(293), LocalDate.of(2021, 11, 23), writer.writeValueAsString(lessons)));

	}
}
