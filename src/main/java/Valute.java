import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Valute")
public class Valute {
    @XStreamAlias("ID")
    private String id;
    @XStreamAlias("NumCode")
    private String numCode;
    @XStreamAlias("CharCode")
    private String charCode;
    @XStreamAlias("Nominal")
    private String nominal;
    @XStreamAlias("Name")
    private String name;
    @XStreamAlias("Value")
    private double value;

    public Valute() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
