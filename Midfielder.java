package PlayersA;

public class Midfielder extends Player {
    private int goal ;
    private int assists ;
    private float passingAccuracy ;

    public Midfielder(String playerID, String name, int age, String nationality, String position, int shirtNumber, int numberOfAppearances, double baseSalary,
                      double marketValue ,int goal,int assists,float passingAccuracy ) {
        super(playerID, name, age, nationality, position, shirtNumber, numberOfAppearances, baseSalary, marketValue);
        this.goal = goal ;
        this.assists = assists;
        this.passingAccuracy =passingAccuracy;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public float getPassingAccuracy() {
        return passingAccuracy;
    }

    public void setPassingAccuracy(float passingAccuracy) {
        this.passingAccuracy = passingAccuracy;
    }

    @Override
    public double salaryCalculation() {
        Config config = new Config();
        if (assists > 15){
            return getBaseSalary() + config.performanceBonus +config.appearancesBonus * getNumberOfAppearances() +config.housingAllowance  ;
        }
        else {
            return getBaseSalary() + config.appearancesBonus *getNumberOfAppearances() + config.housingAllowance;
        }
    }

    @Override
    public boolean parameter() {
        System.out.println("Thông số cầu thủ:");
        System.out.println("Bàn thắng: " + goal);
        System.out.println("Kiến tạo: " + assists);
        System.out.println("Tỷ lệ chuyền chính xác: " + passingAccuracy + "%");

        return false;
    }
}
