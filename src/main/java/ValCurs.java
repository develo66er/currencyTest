import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;
@XStreamAlias("ValCurs")
public class ValCurs {

    @XStreamAsAttribute
    private String Date;
    @XStreamAsAttribute
    private String name;
    @XStreamImplicit(itemFieldName = "Valute")
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
        name = name;
    }

    public List<Valute> getValute() {
        return valute;
    }

    public void setValute(List<Valute> valute) {
        valute = valute;
    }
}
