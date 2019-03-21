package ivbo02151.demo.controller;


        import ivbo02151.demo.dao.MarkJdbc;
        import ivbo02151.demo.model.mark;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkController {
    private final MarkJdbc markJdbc;

    public MarkController(MarkJdbc markJdbc) {
        this.markJdbc = markJdbc;
    }

    @GetMapping("/mark/{id}")
    public mark getMark (@PathVariable int id){
        mark mark = markJdbc.get(id);
        return mark;
    }
    @GetMapping("/search/{name}")
    public mark search (@PathVariable String name){
        mark mark = markJdbc.search(name);
        return mark;
    }
}