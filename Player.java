package PlayersA;

import java.io.Serializable;

abstract public class Player  implements Serializable {

    private String playerID ;
    private String name ;
    private int age ;
    private String nationality;
    private String position ;
    private int shirtNumber;
    private int numberOfAppearances;
    private double baseSalary ;
    private double marketValue ;


    public Player(String playerID,String name, int age, String nationality,String position, int shirtNumber,int numberOfAppearances, double baseSalary, double marketValue) {
        this.playerID = playerID;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.position =position;
        this.shirtNumber = shirtNumber;
        this.numberOfAppearances= numberOfAppearances;
        this.baseSalary = baseSalary;
        this.marketValue = marketValue;
    }

    public Player() {

    }

    public String getPlayerID() {
        return playerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public int getNumberOfAppearances() {
        return numberOfAppearances;
    }

    public void setNumberOfAppearances(int numberOfAppearances) {
        this.numberOfAppearances = numberOfAppearances;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    abstract public double salaryCalculation() ;


    abstract public boolean parameter() ;

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-20s %-15s %-15s %-20s %-20s %-25s %-20s",
                playerID,shirtNumber, name, age, nationality,position,numberOfAppearances, marketValue,baseSalary);
    }
}
