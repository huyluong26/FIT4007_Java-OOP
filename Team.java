package Management;

import MatchPro.*;
import PlayersA.*;
import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Team {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Match> matches = new ArrayList<>();

    public void addAPlayer() {
        try {
            System.out.println("Nhập vào mã cầu thủ :");
            String playerID = scanner.nextLine();
            System.out.println("Nhập vào tên cầu thủ: ");
            String name = scanner.nextLine();
            System.out.println("Nhập vào tuổi cầu thủ: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhập vào quốc tịch: ");
            String nationality = scanner.nextLine();
            System.out.println("Nhập vào số áo thi đấu: ");
            int shirtNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhập vào vị trí thi đấu:");
            String position = scanner.nextLine();
            System.out.println("Nhập vào số lần ra sân: ");
            int numberOfAppearances = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhập vào tên mức lương của cầu thủ: ");
            double baseSalary = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Nhập vào giá trị chuyển nhượng: ");
            double marketValue = scanner.nextDouble();
            scanner.nextLine();

            String pst = position.replaceAll("\\s+", "").toLowerCase();

            if ("tiendao".equalsIgnoreCase(pst)) {
                System.out.println("Nhập vào số bàn thắng : ");
                int goal = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhập vào số kiến tạo : ");
                int assists = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhập vào tỷ lệ rê bóng thành công : ");
                float dribblingSuccessRate = scanner.nextFloat();
                scanner.nextLine();

                Forward newPlayer = new Forward(playerID, name, age, nationality, position, shirtNumber,
                        numberOfAppearances, baseSalary, marketValue, goal, assists, dribblingSuccessRate);
                players.add(newPlayer);
                System.out.println("Thêm thành công");

            } else if ("tienve".equalsIgnoreCase(pst)) {
                System.out.println("Nhập vào số bàn thắng : ");
                int goal = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhập vào số kiến tạo : ");
                int assists = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhập vào tỷ lệ chuyền bóng thành công : ");
                float passingAccuracy = scanner.nextFloat();
                scanner.nextLine();

                Midfielder newPlayer = new Midfielder(
                        playerID, name, age, nationality, position, shirtNumber, numberOfAppearances,
                        baseSalary, marketValue, goal, assists, passingAccuracy);
                players.add(newPlayer);
                System.out.println("Thêm thành công");

            } else if ("hauve".equalsIgnoreCase(pst)) {
                System.out.println("Nhập vào số lần truy cản : ");
                int interceptions = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhập vào tỷ lệ tranh chấp bóng bổng thành công : ");
                float aerialAbility = scanner.nextFloat();
                scanner.nextLine();
                System.out.println("Nhập vào tỷ lệ tắc bóng thành công : ");
                float tackles = scanner.nextFloat();
                scanner.nextLine();

                Defender newPlayer = new Defender(
                        playerID, name, age, nationality, position, shirtNumber, numberOfAppearances,
                        baseSalary, marketValue, interceptions, aerialAbility, tackles);
                players.add(newPlayer);
                System.out.println("Thêm thành công");

            } else if ("thumon".equalsIgnoreCase(pst)) {
                System.out.println("Nhập vào Số lần cản phá : ");
                int saves = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhập vào tỷ lệ cản phá thành công : ");
                float shotStoppingAbility = scanner.nextFloat();
                scanner.nextLine();
                System.out.println("Nhập vào tỷ lệ bắt luân lưu thành công : ");
                float penaltySavePercentage = scanner.nextFloat();
                scanner.nextLine();

                Goalkeeper newPlayer = new Goalkeeper(
                        playerID, name, age, nationality, position, shirtNumber, numberOfAppearances,
                        baseSalary, marketValue, saves, shotStoppingAbility, penaltySavePercentage);
                players.add(newPlayer);
                System.out.println("Thêm thành công");
            } else {
                throw new IllegalArgumentException("Vị trí thi đấu không hợp lệ!");
            }

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Định dạng dữ liệu không hợp lệ. Vui lòng nhập đúng kiểu dữ liệu!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi trong quá trình nhập liệu. Vui lòng thử lại.");
            e.printStackTrace();
        }
    }

    public void DisplayInformation(){
        if (players.isEmpty()) {
            System.out.println("Danh sach cầu thủ rỗng!");
            return;
        }
        System.out.printf("%-20s %-15s %-20s %-15s %-15s %-20s %-20s %-25s %-20s\n"
                ,"Mã cầu thủ", "Số áo","Tên cầu thủ", "Tuổi", "Quốc tịch","Vị trí thi đấu", "Số lần ra sân","Giá trị chuyển nhượng","Lương mỗi tuần ");
        System.out.printf("%-20s %-15s %-20s %-15s %-15s %-20s %-20s %-25s %-20s\n","----------", "-----", "-----------", "----",
                "---------","---------------", "-------------","---------------------", "--------------");
        for (Player player : players) {
            System.out.println(player.toString());

        }
    }

    public void writeToFile() {
        try (FileOutputStream fos = new FileOutputStream("players.dat", false);
             ObjectOutputStream outputStream = new ObjectOutputStream(fos)) {
            outputStream.writeObject(players);
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Không thể mở file để ghi!");
            e.printStackTrace();
        }
    }


    public void readFromFile() {
        players.clear();
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("players.dat"))) {
            @SuppressWarnings("unchecked")
            List<Player> sv = (List<Player>) inputStream.readObject();
            players.addAll(sv);
            System.out.println("Doc file thanh cong!");
        } catch (EOFException e) {
            // Kết thúc tệp, không cần xử lý gì
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Khong the mo file de doc!");
            e.printStackTrace();
        }
    }



    public void RemovePlayer() {
        try {
            System.out.println("Nhập vào mã cầu thủ cần bán: ");
            String playerID = scanner.nextLine();
            boolean playerFound = false;
            Player playerToRemove = null;
            for (Player player : players) {
                if (player.getPlayerID().equalsIgnoreCase(playerID)) {
                    playerToRemove = player;
                    playerFound = true;
                    break;
                }
            }
            if (playerFound && playerToRemove != null) {
                players.remove(playerToRemove);
                System.out.println("Cầu thủ " + playerID + " đã được bán.");
            } else {
                System.out.println("Cầu thủ " + playerID + " không tồn tại trong đội.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Dữ liệu nhập vào không hợp lệ. Vui lòng thử lại.");
            scanner.nextLine();  // Xóa dòng nhập sai

        } catch (ConcurrentModificationException e) {
            System.out.println("Lỗi: Có sự thay đổi đồng thời khi xóa cầu thủ. Vui lòng thử lại.");

        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi. Vui lòng thử lại.");
            e.printStackTrace();
        }
    }


    public void calculateSalary() {
        try {
            System.out.println("Nhập vào mã cầu thủ cần tính lương: ");
            String playerID = scanner.nextLine();
            double totalSalary = 0;
            boolean playerFound = false;
            for (Player player : players) {
                if (player.getPlayerID().equalsIgnoreCase(playerID)) {
                    totalSalary = player.salaryCalculation();
                    playerFound = true;
                    break;
                }
            }
            if (playerFound) {
                System.out.println("Tổng lương của cầu thủ " + playerID + " trên một tuần là: " + totalSalary);
            } else {
                System.out.println("Cầu thủ " + playerID + " không tồn tại trong đội.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Dữ liệu nhập vào không hợp lệ. Vui lòng thử lại.");
            scanner.nextLine();

        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi không xác định. Vui lòng thử lại.");
            e.printStackTrace();
        }
    }


    public void SeachPlayer() {
        System.out.println(players.size());
        try {
            System.out.println("Nhập vào mã cầu thủ cần tìm:");
            String name = scanner.nextLine().trim();
            boolean playerFound = false;

            if (players.isEmpty()) {
                throw new Exception("Danh sách cầu thủ đang trống.");
            }

            for (Player player : players) {
                if (player.getPlayerID().contains(name)) {
                    System.out.println(player.toString());
                    System.out.println("==========Thông số===============");
                    System.out.println(player.parameter());
                    System.out.println("=================================");
                    playerFound = true;
                }
            }
            if (playerFound) {
                System.out.println(name + " đã được tìm thấy.");
            } else {
                System.out.println("Cầu thủ " + name + " không tồn tại trong đội.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Đầu vào không hợp lệ. Vui lòng nhập mã cầu thủ đúng định dạng.");
            scanner.nextLine();
        } catch (NullPointerException e) {
            System.out.println("Lỗi: Không thể tìm kiếm cầu thủ vì có dữ liệu bị thiếu.");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }


    public void  sortPlayersBySalary() {
        if (players.isEmpty()) {
            System.out.println("Danh sach cầu thủ rỗng!");
            return;
        }
        else {
            int n = players.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (players.get(j).salaryCalculation() > players.get(j + 1).salaryCalculation()) {
                        Player temp = players.get(j);
                        players.set(j, players.get(j + 1));
                        players.set(j + 1, temp);
                    }
                }
                System.out.println("Lương cầu thủ đã được sắp xếp ");
            }
        }
    }
    public String getPlayerNameByID(String playerID) {
        for (Player player : players) {
            if (player.getPlayerID().contains(playerID)) {
                return player.getName();
            }
        }
        return "Không tìm thấy cầu thủ với mã " + playerID;
    }
    public void addAMatch() {
        try {
            System.out.println("Nhập vào mã cua trận đấu :");
            String matchID = scanner.nextLine();
            System.out.println("Nhập vào ngày diễn ra trận đấu :");
            String dateOfMatch = scanner.nextLine();
            System.out.println("Nhập vào tên đội nhà: ");
            String homeTeam = scanner.nextLine();
            System.out.println("Nhập vào tên đội đối thủ: ");
            String awayTeam = scanner.nextLine();
            System.out.println("Nhập vào số bàn thắng của " + homeTeam + ":");
            int homeScore = scanner.nextInt();
            System.out.println("Nhập vào số bàn thắng của " + awayTeam + ":");
            int awayScore = scanner.nextInt();
            scanner.nextLine();
            DisplayInformation();
            System.out.println("====== Nhập vào đội hình ra sân ======");
            String nameGK = "", nameLB ="", nameLCB =" ", nameRCB="", nameRB="", nameLCM="", nameRCM="", nameCM="", nameST="", nameRW="", nameLW="";
            for (int i = 0; i < 11; i++) {
                switch (i) {
                    case 0:
                        System.out.println("Nhập vào mã thủ môn:");
                        String gkID = scanner.nextLine();
                        nameGK=getPlayerNameByID(gkID);
                        break;
                    case 1:
                        System.out.println("Nhập vào mã hậu vệ cánh trái:");
                        String LbID = scanner.nextLine();
                        nameLB=getPlayerNameByID(LbID);
                        break;
                    case 2:
                        System.out.println("Nhập vào mã hậu vệ cánh phải:");
                        String rbID = scanner.nextLine();
                        nameRB=getPlayerNameByID(rbID);
                        break;
                    case 3:
                        System.out.println("Nhập vào mã trung vệ trái:");
                        String lcbID = scanner.nextLine();
                        nameLCB=getPlayerNameByID(lcbID);
                        break;
                    case 4:
                        System.out.println("Nhập vào mã trung vệ phải:");
                        String rcbID = scanner.nextLine();
                        nameRCB=getPlayerNameByID(rcbID);
                        break;
                    case 5:
                        System.out.println("Nhập vào mã tiền vệ trái:");
                        String lcmID = scanner.nextLine();
                        nameLCM=getPlayerNameByID(lcmID);
                        break;
                    case 6:
                        System.out.println("Nhập vào mã tiền vệ phải:");
                        String rcmID = scanner.nextLine();
                        nameRCM=getPlayerNameByID(rcmID);
                        break;
                    case 7:
                        System.out.println("Nhập vào mã tiền vệ trung tâm:");
                        String cmID = scanner.nextLine();
                        nameCM=getPlayerNameByID(cmID);
                        break;
                    case 8:
                        System.out.println("Nhập vào mã tiền đạo cánh phải:");
                        String rwID = scanner.nextLine();
                        nameRW=getPlayerNameByID(rwID);
                        break;
                    case 9:
                        System.out.println("Nhập vào mã tiền đạo cánh trái:");
                        String lwID = scanner.nextLine();
                        nameLW=getPlayerNameByID(lwID );
                        break;
                    case 10:
                        System.out.println("Nhập vào mã tiền đạo cắm:");
                        String stID = scanner.nextLine();
                        nameST=getPlayerNameByID(stID);
                        break;
                }
            }
            Match newMatch = new Match(matchID,dateOfMatch,homeTeam, awayTeam,homeScore,awayScore );
            System.out.println("Đội hình ra sân");
            newMatch.Lineup(nameGK , nameLB , nameLCB , nameRCB, nameRB, nameLCM, nameRCM, nameCM, nameST, nameRW, nameLW);
            matches.add(newMatch);
            System.out.println("Thêm trận đấu thành công !");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void writeMatchToFile() {
        try (FileOutputStream fos = new FileOutputStream("matches.dat", false);
             ObjectOutputStream outputStream = new ObjectOutputStream(fos)) {
            outputStream.writeObject(matches);
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Không thể mở file để ghi!");
            e.printStackTrace();
        }
    }


    public void readMatchFromFile() {
        matches.clear();
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("matches.dat"))) {
            @SuppressWarnings("unchecked")
            List<Match> mt = (List<Match>) inputStream.readObject();
            matches.addAll(mt);
            System.out.println("Doc file thanh cong!");
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Khong the mo file de doc!");
            e.printStackTrace();
        }
    }

    public void DisplayMatchesInformation(){
        System.out.println(matches.size());
        if (matches.isEmpty()) {
            System.out.println("Danh sách thông tin trận đấu rỗng!");
            return;
        }
        for (Match match : matches) {
            System.out.println(match.displayMath());


        }
    }

    public void RemoveMatch() {
        try {
            System.out.println("Nhập vào mã trận đấu cần xoá: ");
            String matchID = scanner.nextLine();
            boolean matchFound = false;
            Match matchToRemove = null;
            for (Match match : matches) {
                if (match.getMatchID().equalsIgnoreCase(matchID)) {
                    matchToRemove = match;
                    matchFound = true;
                    break;
                }
            }
            if (matchFound && matchToRemove != null) {
                matches.remove(matchToRemove);
                System.out.println("Lịch sử trận đấu  " + matchID + " đã được xoá.");
            } else {
                System.out.println("Trận đấu" + matchID + " không tồn tại.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Dữ liệu nhập vào không hợp lệ. Vui lòng thử lại.");
            scanner.nextLine();  // Xóa dòng nhập sai

        } catch (ConcurrentModificationException e) {
            System.out.println("Lỗi: Có sự thay đổi đồng thời khi xóa thông tin trận đấu. Vui lòng thử lại.");

        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi. Vui lòng thử lại.");
            e.printStackTrace();
        }
    }

    public void SearchMatch() {
        try {
            System.out.println("Nhập vào mã trận đấu cần tìm:");
            String matchID = scanner.nextLine();
            boolean matchFound = false;
            if (matches.isEmpty()) {
                throw new Exception("Danh sách thông tin trận đấu trống.");
            }
            for (Match match : matches) {
                if (match.getMatchID().equalsIgnoreCase(matchID)) {
                    System.out.println("=================================");
                    System.out.println(match.displayMath());
                    System.out.println("=================================");

                    matchFound = true;
                    break;
                }
            }
            if (matchFound) {
                System.out.println("Trận đấu có mã"+matchID+ " đã được tìm thấy.");
            } else {
                System.out.println("Trận đấu có mã " + matchID + " không tồn tại trong đội.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Đầu vào không hợp lệ. Vui lòng nhập mã trận đấu đúng định dạng.");
            scanner.nextLine();
        } catch (NullPointerException e) {
            System.out.println("Lỗi: Không thể tìm kiếm thông tin trận đấu vì có dữ liệu bị thiếu.");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    public double calculateTotalMarketValue() {
        double totalMarketValue = 0;
        for (Player player : players) {
            totalMarketValue += player.getMarketValue();
        }
        System.out.printf("Tổng giá trị chuyển nhượng của đội hình: %.2f %n", totalMarketValue);
        return totalMarketValue;
    }


    public void calculateTotalGoalsAndConceded() {
        int totalGoals = 0;
        int totalGoalsConceded = 0;

        for (Match match : matches) {
            totalGoals += match.getHomeScore();
            totalGoalsConceded += match.getAwayScore();
        }

        System.out.println("Tổng số bàn thắng đội ghi được: " + totalGoals);
        System.out.println("Tổng số bàn thua đội phải nhận: " + totalGoalsConceded);
    }

    public void calculateMatchResults() {
        int totalWins = 0;
        int totalDraws = 0;
        int totalLosses = 0;

        for (Match match : matches) {
            if (match.getHomeScore() > match.getAwayScore()) {
                totalWins++;
            } else if (match.getHomeScore() == match.getAwayScore()) {
                totalDraws++;
            } else {
                totalLosses++;
            }
        }

        int totalMatches = matches.size();
        double winRate = (totalMatches == 0) ? 0 : ((double) totalWins / totalMatches) * 100;

        System.out.println("Tổng số trận thắng: " + totalWins);
        System.out.println("Tổng số trận hòa: " + totalDraws);
        System.out.println("Tổng số trận thua: " + totalLosses);
        System.out.println("Tổng số trận đấu: " + totalMatches);
        System.out.println("Tỷ lệ thắng: " + String.format("%.2f", winRate) + "%");
    }
    public void calculateTotalGoalsAndAssists() {
        int totalGoals = 0;
        int totalAssists = 0;
        for (Player player : players) {
            if (player instanceof Forward) {
                Forward forward = (Forward) player;
                totalGoals += forward.getGoal();
                totalAssists += forward.getAssists();
                System.out.println("Cầu thủ " + forward.getName() + " (Forward): " +
                        "Bàn thắng = " + forward.getGoal() + ", Kiến tạo = " + forward.getAssists());
            }
            else if (player instanceof Midfielder) {
                Midfielder midfielder = (Midfielder) player;
                totalGoals += midfielder.getGoal();
                totalAssists += midfielder.getAssists();
                System.out.println("Cầu thủ " + midfielder.getName() + " (Midfielder): " +
                        "Bàn thắng = " + midfielder.getGoal() + ", Kiến tạo = " + midfielder.getAssists());
            }
        }
        System.out.println("===========================================");
        System.out.println("Tổng số bàn thắng của các cầu thủ: " + totalGoals);
        System.out.println("Tổng số kiến tạo của các cầu thủ: " + totalAssists);
    }




}

