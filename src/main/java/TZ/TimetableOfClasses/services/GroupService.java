package TZ.TimetableOfClasses.services;

import TZ.TimetableOfClasses.models.Group;
import TZ.TimetableOfClasses.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group create(Group group) {
        return groupRepository.save(group);
    }

    public void delete(int groupNumber) {
        groupRepository.delete(groupRepository.findGroupByNumber(groupNumber));
    }

    public Group update(int groupNumber, Group group) {
        Group groupFromDB = fillUpdates(groupRepository.findGroupByNumber(groupNumber), group);
        return groupRepository.save(groupFromDB);
    }

    private Group fillUpdates(Group groupFromDB, Group group) {
        if (group.getTimetables() != null) {
            groupFromDB.setStudents(group.getStudents());
        }
        if (group.getStudents() != null) {
            groupFromDB.setTimetables(group.getTimetables());
        }
        return groupFromDB;
    }
}
