package lab.task_03_StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private Map<String, Student> studentsByName;

    public StudentRepository() {
        this.studentsByName = new HashMap<>();
    }

    public void add(Student student) {
        this.studentsByName.put(student.getName(), student);
    }

    public Student get(String name) {
        return this.studentsByName.get(name);
    }

    public boolean isContains(String name) {
        for (String s : studentsByName.keySet()) {
            if (s.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
