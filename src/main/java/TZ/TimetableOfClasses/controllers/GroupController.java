package TZ.TimetableOfClasses.controllers;

import TZ.TimetableOfClasses.models.Group;
import TZ.TimetableOfClasses.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public List<Group> getGroups() {
        return groupRepository.findAll();
    }
}
