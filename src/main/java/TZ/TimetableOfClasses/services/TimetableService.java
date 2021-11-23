package TZ.TimetableOfClasses.services;

import TZ.TimetableOfClasses.models.Timetable;
import TZ.TimetableOfClasses.repositories.TimetableRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimetableService {

    private final TimetableRepository timetableRepository;

    private final ObjectMapper mapper = new ObjectMapper();
    private final ObjectWriter writer = mapper.setConfig(mapper.getDeserializationConfig()).writerWithView(List.class);
    private final ObjectReader reader = mapper.setConfig(mapper.getDeserializationConfig()).readerWithView(List.class);



    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    public Timetable create(Timetable timetable){
        return timetableRepository.save(timetable);
    }

    public void delete(Timetable timetable) {
        timetableRepository.delete(timetable);
    }

    public Timetable update(Timetable fromDb, Timetable timetable) {
        fillUpdate(fromDb, timetable);
        return fromDb;
    }

    private void fillUpdate(Timetable fromDb, Timetable timetable) {
        fromDb.setLessons(timetable.getLessons());
        fromDb.setGroup(timetable.getGroup());
        fromDb.setDate(timetable.getDate());
    }






    private void addLesson(Timetable timetable, String lesson) throws JsonProcessingException {
        String lessons = timetable.getLessons();
        List<String> currentLessons = reader.readValue(lessons);
        currentLessons.add(lesson);
        timetable.setLessons(writer.writeValueAsString(currentLessons));
    }

    public void setLessons(Timetable timetable, List<String> lessons) throws JsonProcessingException {
        timetable.setLessons(writer.writeValueAsString(lessons));
    }

    public String getJsonLessons(List<String> lessons) throws JsonProcessingException {
        return writer.writeValueAsString(lessons);
    }
}
