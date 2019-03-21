package ivbo02151.demo.controller;

    import ivbo02151.demo.dao.StudentJdbc;
    import ivbo02151.demo.model.Student;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RestController;

@RestController

public class StudentController {
    private final StudentJdbc studentJdbc;

    public StudentController(StudentJdbc studentJdbc) {
        this.studentJdbc = studentJdbc;
    }

    @GetMapping("/student/{id}")
    public Student getStudent (@PathVariable int id){
        Student student = studentJdbc.get(id);
        return student;
    }
}
