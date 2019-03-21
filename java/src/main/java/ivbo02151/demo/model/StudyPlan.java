package ivbo02151.demo.model;

public class StudyPlan {

    private int id;
    private Subject subject;
    private ExamType examType;

    public int getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public ExamType getExamType() {
        return examType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setExamType(ExamType examType) {
        this.examType = examType;
    }
}
