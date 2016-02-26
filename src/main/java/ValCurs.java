import java.util.ArrayList;
import java.util.List;

public class ValCurs {

    private String Date;

    private String name;

    private List<Valute> valute = new ArrayList<Valute>();

    public ValCurs() {
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
