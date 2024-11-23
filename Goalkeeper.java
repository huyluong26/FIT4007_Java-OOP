package PlayersA;

public class Goalkeeper extends Player{
    private int saves ;
    private float shotStoppingAbility ;
    private float penaltySavePercentage ;

    public Goalkeeper(String playerID, String name, int age, String nationality, String position, int shirtNumber, int numberOfAppearances,
                      double baseSalary, double marketValue,int saves,float shotStoppingAbility,float penaltySavePercentage) {
        super(playerID, name, age, nationality, position, shirtNumber, numberOfAppearances, baseSalary, marketValue);
        this.saves = saves ;
        this.shotStoppingAbility = shotStoppingAbility;
        this.penaltySavePercentage = penaltySavePercentage ;
    }


    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    public float getShotStoppingAbility() {
        return shotStoppingAbility;
    }

    public void setShotStoppingAbility(float shotStoppingAbility) {
        this.shotStoppingAbility = shotStoppingAbility;
    }

    public float getPenaltySavePercentage() {
        return penaltySavePercentage;
    }

    public void setPenaltySavePercentage(float penaltySavePercentage) {
        this.penaltySavePercentage = penaltySavePercentage;
    }

    @Override
    public double salaryCalculation() {
        Config config = new Config();
        if (saves > 15){
            return getBaseSalary() + config.performanceBonus +config.appearancesBonus * getNumberOfAppearances() +config.housingAllowance  ;
        }
        else {
            return getBaseSalary() + config.appearancesBonus *getNumberOfAppearances() + config.housingAllowance;
        }
    }

    @Override
    public boolean parameter() {
        System.out.println("Forward Parameters:");
        System.out.println("Số lần cản phá : " + saves);
        System.out.println("Tỷ lệ cản phá thành công : " +shotStoppingAbility +"%");
        System.out.println("Tỷ lệ bắt luân lưu thành công: " + penaltySavePercentage + "%");
        return false;
    }
}
