package ivbo02151.demo.controller;

    import ivbo02151.demo.model.StudyGroup;
    import ivbo02151.demo.dao.StudyGroupJdbc;
    import org.springframework.web.bind.annotation.CrossOrigin;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RestController;
    import java.util.List;

@CrossOrigin("http://localhost:3000")

@RestController
public class StudyGroupController {

    private final StudyGroupJdbc studyGroupJdbc;

    public StudyGroupController(StudyGroupJdbc markJdbc) {
        this.studyGroupJdbc = markJdbc;
    }

    @GetMapping("/group/id={id}")
    public StudyGroup getStudyGroup(@PathVariable int id) {
        return studyGroupJdbc.get(id);
    }

    @GetMapping("/group/name={name}")
    public StudyGroup searchStudyGroup(@PathVariable String name) {
        return studyGroupJdbc.search(name);
    }

    @GetMapping("/groups")
    public List<StudyGroup> getStudyGroups() {
        return studyGroupJdbc.getAll();
    }

    @GetMapping("/group/add/id={id}&name={name}")
    public int addStudyGroup(@PathVariable int id, @PathVariable String name) {
        return studyGroupJdbc.add(id, name);
    }

    @GetMapping("/group/delete/id={id}")
    public int deleteStudyGroup(@PathVariable int id) {
        return studyGroupJdbc.delete(id);
    }

    @GetMapping("/group/set/id={id}&name={name}")
    public int updateName(@PathVariable int id, @PathVariable String name) {
        return studyGroupJdbc.setName(id, name);
    }
}
