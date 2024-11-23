package MatchPro;

import java.io.Serializable;
import java.util.ArrayList;

public class Match implements Serializable {
    private String matchID;
    private String dateOfMatch;
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;


    public Match(String matchID,String dateOfMatch, String homeTeam, String awayTeam, int homeScore, int awayScore) {
        this.matchID = matchID;
        this.dateOfMatch = dateOfMatch;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
    public void Lineup(String nameGK,String nameRB, String nameRCB,String nameLCB, String nameLB, String nameRCM, String nameLCM
            ,String nameCM, String nameRW, String nameST,String nameLW) {
        System.out.println(" __________________________________________________________________ ");
        System.out.println("|                    |    |           |    |                       |");
        System.out.println("|                    |    |___________|    |                       |");
        System.out.println("|                    |     "+ nameGK+"     |                       |");
        System.out.println("|                    |_____________________|                       |");
        System.out.println("|                        -_____________-                           |");
        System.out.println("|"+nameRB+"       "+nameRCB+"       "+nameLCB+"          "+nameLB+"|");
        System.out.println("|                                                                  |");
        System.out.println("|                                                                  |");
        System.out.println("|                                                                  |");
        System.out.println("|                   "+nameRCM+"      "+nameLCM+"                   |");
        System.out.println("|                                                                  |");
        System.out.println("|                            "+nameCM+"                            |");
        System.out.println("|                                                                  |");
        System.out.println("|                                                                  |");
        System.out.println("|                                                                  |");
        System.out.println("|    "+nameRW+"          _________________      "+nameLW+"         |");
        System.out.println("|                     _                      _                     |");
        System.out.println("|                   _                          _                   |");
        System.out.println("|                  _        "+nameST+"           _                 |");
        System.out.println("|__________________________________________________________________|");

    }

    public String displayMath() {
        System.out.println("Mã trận đấu: "+matchID+"\n"+
                "Ngày thi đấu: " + dateOfMatch + "\n" +
                "Kết quả trận đấu: " + homeTeam + " " + homeScore + " - " + awayScore + " " + awayTeam);
        if (homeScore > awayScore) {
            System.out.println("Thắng");
        } else if (awayScore > homeScore) {
            System.out.println("Thua");
        } else {
            System.out.println("Hoà");
        }
        return toString();
    }

    // Getter methods
    public String getDateOfMatch() {
        return dateOfMatch;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public String getMatchID() {
        return matchID;
    }

    //Setter methods
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public void setDateOfMatch(String dateOfMatch) {
        this.dateOfMatch = dateOfMatch;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }
}









