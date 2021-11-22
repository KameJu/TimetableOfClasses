package TZ.TimetableOfClasses.repositories;

import TZ.TimetableOfClasses.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    public Group findGroupByNumber(int number);
}
