package ivbo02151.demo.controller;

    import ivbo02151.demo.dao.JournalJdbc;
    import ivbo02151.demo.model.Journal;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RestController;
    import java.util.List;

@RestController
public class JournalController {

    private final JournalJdbc journalJdbc;

    public JournalController(JournalJdbc markJdbc) {
        this.journalJdbc = markJdbc;
    }

    @GetMapping("/journalAll")
    public List<Journal> getRecords() {
        return journalJdbc.getAll();
    }

    @GetMapping("/journal/studentId={studentId}")
    public List<Journal> getRecordsByStudentId(@PathVariable int studentId) {
        return journalJdbc.getAllByStudentId(studentId);
    }

    @GetMapping("/journal/group={group}")
    public List<Journal> getRecordsByStudentId(@PathVariable String group) {
        return journalJdbc.getAllByGroup(group);
    }

    @GetMapping("/journal/add/id={id}&studentId={studentId}&studyPlanId={studyPlanId}&inTime={inTime}&count={count}&markId={markId}")
    public int addRecord(@PathVariable int id, @PathVariable int studentId, @PathVariable int studyPlanId, @PathVariable boolean inTime, @PathVariable int count, @PathVariable int markId) {
        return journalJdbc.add(id, studentId, studyPlanId, inTime, count, markId);
    }

    @GetMapping("journal/delete/id={id}")
    public int deleteRecord(@PathVariable int id) {
        return journalJdbc.delete(id);
    }

    @GetMapping("journal/set/id={id}&student_id={studentId}")
    public int updateStudentId(@PathVariable int id, @PathVariable int studentId) {
        return journalJdbc.setStudentId(id, studentId);
    }

    @GetMapping("journal/set/id={id}&study_plan_id={study_plan_id}")
    public int updateStudyPlanId(@PathVariable int id, @PathVariable int study_plan_id) {
        return journalJdbc.setStudyPlanId(id, study_plan_id);
    }

    @GetMapping("journal/set/id={id}&in_ime={inTime}")
    public int updateInTime(@PathVariable int id, @PathVariable boolean inTime) {
        return journalJdbc.setInTime(id, inTime);
    }

    @GetMapping("journal/set/id={id}&count={count}")
    public int updateCount(@PathVariable int id, @PathVariable int count) {
        return journalJdbc.setCount(id, count);
    }

    @GetMapping("journal/set/id={id}&mark_id={markId}")
    public int updateMarkId(@PathVariable int id, @PathVariable int markId) {
        return journalJdbc.setMarkId(id, markId);
    }
}
