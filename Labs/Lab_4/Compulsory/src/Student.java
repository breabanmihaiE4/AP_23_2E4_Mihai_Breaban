import java.util.List;

public class Student implements Comparable{
    private String name;
    private List<Project> projects;

    public Student(String name, List<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student){
            if (this.name.equals(((Student) o).name)) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
