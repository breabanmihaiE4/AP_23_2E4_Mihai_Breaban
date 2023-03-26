import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var streamProjects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("Project " + i))
                .toArray(Project[]::new);
        var streamStudents = IntStream.rangeClosed(0, 2)
                .mapToObj(i ->
                        {
                            if (i == 0) {
                                return new Student("Student 0", List.of(streamProjects));
                            } else {
                                if (i == 1) {
                                    return new Student("Student 1", List.of(streamProjects[0], streamProjects[1]));
                                } else {
                                    return new Student("Student 2", List.of(streamProjects[0]));
                                }
                            }
                        }
                )
                .toArray(Student[]::new);

        LinkedList<Student> students = new LinkedList<>(Arrays.asList(streamStudents));
        students.sort(Comparator.comparing(Student::getName));
        students.forEach(student -> {
            System.out.println(student.getName());
        });

        TreeSet<Project> projects = new TreeSet<>(Arrays.asList(streamProjects));
        projects.forEach(project -> {
            System.out.println(project.getName());
        });
    }
}
