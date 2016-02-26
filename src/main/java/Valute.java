import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Valute")
public class Valute {
    @XStreamAlias("ID")
    private String id;
    @XStreamAlias("NumCode")
    private String NumCode;
    @XStreamAlias("CharCode")
    private String CharCode;
    @XStreamAlias("Nominal")
    private String Nominal;
    @XStreamAlias("Name")
    private String Name;
    @XStreamAlias("Value")
    private double Value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumCode() {
        return NumCode;
    }

    public void setNumCode(String numCode) {
        NumCode = numCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public void setCharCode(String charCode) {
        CharCode = charCode;
    }

    public String getNominal() {
        return Nominal;
    }

    public void setNominal(String nominal) {
        Nominal = nominal;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }

    public Valute() {
    }




}
