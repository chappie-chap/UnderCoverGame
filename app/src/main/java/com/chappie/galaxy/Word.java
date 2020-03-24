package com.chappie.galaxy;

public class Word {
    private boolean played;
    private String sWord1;
    private String sWord2;

    Word(String str, String str2, boolean z) {
        this.sWord1 = str;
        this.sWord2 = str2;
        this.played = z;
    }

    String getsWord1() {
        return this.sWord1;
    }

    public void setsWord1(String str) {
        this.sWord1 = str;
    }

    String getsWord2() {
        return this.sWord2;
    }

    public void setsWord2(String str) {
        this.sWord2 = str;
    }

    boolean isPlayed() {
        return this.played;
    }

    public void setPlayed(boolean z) {
        this.played = z;
    }
}
