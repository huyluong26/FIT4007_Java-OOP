package PlayersA;

public class Defender extends Player{
    private int interceptions ;
    private float aerialAbility;
    private float tackles ;

    public Defender(String playerID, String name, int age, String nationality, String position, int shirtNumber, int numberOfAppearances, double baseSalary,
                    double marketValue,int interceptions,float aerialAbility,float tackles) {
        super(playerID, name, age, nationality, position, shirtNumber, numberOfAppearances, baseSalary, marketValue);
        this.interceptions = interceptions ;
        this.aerialAbility =  aerialAbility ;
        this.tackles = tackles ;
    }


    public int getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }

    public float getAerialAbility() {
        return aerialAbility;
    }

    public void setAerialAbility(float aerialAbility) {
        this.aerialAbility = aerialAbility;
    }

    public float getTackles() {
        return tackles;
    }

    public void setTackles(float tackles) {
        this.tackles = tackles;
    }

    @Override
    public double salaryCalculation() {
        Config config = new Config();
        if (interceptions > 15){
            return getBaseSalary() + config.performanceBonus +config.appearancesBonus * getNumberOfAppearances() +config.housingAllowance  ;
        }
        else {
            return getBaseSalary() + config.appearancesBonus *getNumberOfAppearances() + config.housingAllowance;
        }
    }

    @Override
    public boolean parameter() {
        System.out.println("Thông số cầu thủ:");
        System.out.println("Số lần truy cản: " +interceptions  );
        System.out.println("Tỷ lệ tranh chấp bóng bổng thành công: " +aerialAbility +"%" );
        System.out.println("Tỷ lệ tắc bóng thành công: " + tackles + "%");

        return false;
    }
}
