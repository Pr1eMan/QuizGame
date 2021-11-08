package com.ifk8edvmat1gabkojginkir.ktuprojektas.Model;

public class Player {
    int USERID;
    String UNAME;
    int SCORE;

    public Player(int USERID, String UNAME, int SCORE) {
        this.USERID = USERID;
        this.UNAME = UNAME;
        this.SCORE = SCORE;
    }
    public Player(){}

    public int getUSERID() {
        return USERID;
    }

    public void setUSERID(int USERID) {
        this.USERID = USERID;
    }

    public String getUNAME() {
        return UNAME;
    }

    public void setUNAME(String UNAME) {
        this.UNAME = UNAME;
    }

    public int getSCORE() {
        return SCORE;
    }

    public void setSCORE(int SCORE) {
        this.SCORE = SCORE;
    }
}

