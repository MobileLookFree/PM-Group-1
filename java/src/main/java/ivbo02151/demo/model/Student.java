package ivbo02151.demo.model;

public class Student {

    private int id;
    private String surname;
    private String name;
    private String second_name;
    private int studyGroup;

    public Student(int id, String surname, String name, String second_name, int studyGroup) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.second_name = second_name;
        this.studyGroup = studyGroup;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public int getStudyGroup() {
        return studyGroup;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public void setStudyGroup(int studyGroup) {
        this.studyGroup = studyGroup;
    }
}
