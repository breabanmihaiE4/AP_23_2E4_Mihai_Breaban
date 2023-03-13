public class Project implements Comparable{
    private String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Project){
             if (this.name.equals(((Project) o).name)) {
                 return 0;
             } else {
                 return 1;
             }
        } else {
            return 1;
        }
    }
}
