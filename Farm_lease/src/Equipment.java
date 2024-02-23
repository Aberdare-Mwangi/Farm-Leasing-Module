public class Equipment {
    private final String name;
    private final String type;
    private final String description;
    private final int numEquip;
    private final double
    rentRatePerDay;
    public Equipment ( String name, String type,String description,int numEquip, double rentRatePerDay) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.numEquip = numEquip;
        this.rentRatePerDay = rentRatePerDay;

    }
    public  String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public double getRentRatePerDay(){
        return rentRatePerDay;
    }
    public String getDescription() {return description;}
    }

