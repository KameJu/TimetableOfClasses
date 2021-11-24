package TZ.TimetableOfClasses.controllers;

import TZ.TimetableOfClasses.models.Group;
import TZ.TimetableOfClasses.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public List<Group> getGroups() {
        return groupService.findAll();
    }

    @GetMapping("/{groupNumber}")
    public Group findOne(@PathVariable int groupNumber) {
       return groupService.findOne(groupNumber);
    }

    @PutMapping()
    public Group create(@RequestBody Group group) {
        return groupService.create(group);
    }

    @DeleteMapping("/{groupNumber}")
    public void delete(@PathVariable int groupNumber) {
        groupService.delete(groupNumber);
    }

    @PutMapping("/{groupNumber}")
    public Group update(
            @PathVariable("groupNumber") int groupNumber,
            @RequestBody Group group
    ){
        return groupService.update(groupNumber, group);
    }
}
