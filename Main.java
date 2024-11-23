import java.util.Scanner;
import Management.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Team team = new Team();
        while (true) {
            System.out.println("=====================Quản lý đội bóng ==================");
            System.out.println("1.Quản lý cầu thủ ");
            System.out.println("2.Quản lý trận đấu ");
            System.out.println("3.Thông kê ");
            System.out.println("0.Thoát");
            System.out.println("========================================================");
            System.out.println("Nhập lựa chọn:");
            int choices = scanner.nextInt();
            if (choices == 1) {
                while (true) {
                    System.out.println("=====================Menu==================");
                    System.out.println("1.Thêm cầu thủ");
                    System.out.println("2.Bán cầu thủ");
                    System.out.println("3.Hiển thị thông tin cầu thủ");
                    System.out.println("4.Tính lương cầu thủ");
                    System.out.println("5.Tìm kiếm cầu thủ");
                    System.out.println("6.Sắp xếp theo lương");
                    System.out.println("7.Ghi file lữu diệu");
                    System.out.println("8.Đọc file dữ liệu");
                    System.out.println("0.Thoát");
                    System.out.println("===========================================");
                    System.out.println("Nhập lựa chọn:");
                    int choice = scanner.nextInt();
                    if(choice == 1){
                        team.addAPlayer();
                    }
                    if(choice == 2){
                        team.RemovePlayer();
                    }
                    if(choice == 3){
                        team.DisplayInformation();
                    }
                    if(choice == 4){
                        team.calculateSalary();
                    }
                    if(choice == 5 ){
                        team.SeachPlayer();
                    }
                    if(choice == 7){
                        team.writeToFile();
                    }
                    if(choice == 6){
                        team.sortPlayersBySalary();
                    }
                    if(choice == 8){
                        team.readFromFile();
                    }
                    else if (choice == 0){
                        break;
                    }
                }
        }
            if (choices == 2) {
                while (true) {
                    System.out.println("=====================Menu==================");
                    System.out.println("1.Thêm thông tin trận đấu");
                    System.out.println("2.Ghi file dữ liệu trận đấu");
                    System.out.println("3.Đọc file dữ liệu trận đấu");
                    System.out.println("4.Hiển thị thông tin trận đấu");
                    System.out.println("5.Xoá dữ liệu trận đấu theo mã");
                    System.out.println("6.Tìm trận đấu theo mã");
                    System.out.println("0.Thoát");
                    System.out.println("===========================================");
                    System.out.println("Nhập lựa chọn:");
                    int choice = scanner.nextInt();
                    if(choice == 1){
                        team.addAMatch();
                    }
                    if(choice == 2){
                        team.writeMatchToFile();
                    }
                    if(choice == 3){
                        team.readMatchFromFile();
                    }
                    if(choice == 4){
                        team.DisplayMatchesInformation();
                    }
                    if(choice == 5 ){
                        team.RemoveMatch();
                    }
                    if(choice == 6){
                        team.SearchMatch();
                    }
                    else if (choice == 0){
                        break;
                    }
                }
            }
            if (choices == 3) {
                while (true) {
                    System.out.println("=====================Menu==================");
                    System.out.println("1.Tổng bàn thắng và kiến tạo của đội bóng");
                    System.out.println("2.Tổng bàn thắng, bàn thua");
                    System.out.println("3.Tổng trận thắng, hòa, thua");
                    System.out.println("4.Giá trị đội hình");
                    System.out.println("0.Thoát");
                    System.out.println("===========================================");
                    System.out.println("Nhập lựa chọn:");
                    int choice = scanner.nextInt();
                    if(choice == 1){
                        team.calculateTotalGoalsAndAssists();
                    }
                    if(choice == 2){
                        team.calculateTotalGoalsAndConceded();
                    }
                    if(choice == 3){
                        team.calculateMatchResults();
                    }
                    if(choice == 4){
                        team.calculateTotalMarketValue();
                    }
                    else if (choice == 0){
                        break;
                    }
                }
            }
            if(choices == 0){
                break;
            }
    }
}}