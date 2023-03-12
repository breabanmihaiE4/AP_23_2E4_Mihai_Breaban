import java.util.Collections;
import java.util.List;

public class Company {

    private String companyName;
    //List<String> companyName = new List<String>();

    public Person(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    Collections.sort(companyName);
}
