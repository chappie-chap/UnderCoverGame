package com.chappie.galaxy;

public class Game {
    private String Name;
    private int Point;
    private String Role;
    private String SecretWord;
    private boolean isEliminate;
    private boolean isReady;
    private int jumlah;

    /* access modifiers changed from: package-private */
    int getPoint() {
        return this.Point;
    }

    /* access modifiers changed from: package-private */
    void setPoint(int i) {
        this.Point = i;
    }

    /* access modifiers changed from: package-private */
    int getJumlah() {
        return this.jumlah;
    }

    /* access modifiers changed from: package-private */
    void setJumlah(int i) {
        this.jumlah = i;
    }

    /* access modifiers changed from: package-private */
    boolean isEliminate() {
        return this.isEliminate;
    }

    /* access modifiers changed from: package-private */
    void setEliminate(boolean z) {
        this.isEliminate = z;
    }

    /* access modifiers changed from: package-private */
    boolean isReady() {
        return this.isReady;
    }

    /* access modifiers changed from: package-private */
    void setReady(boolean z) {
        this.isReady = z;
    }

    /* access modifiers changed from: package-private */
    String getRole() {
        return this.Role;
    }

    /* access modifiers changed from: package-private */
    void setRole(String str) {
        this.Role = str;
    }

    /* access modifiers changed from: package-private */
    String getSecretWord() {
        return this.SecretWord;
    }

    /* access modifiers changed from: package-private */
    void setSecretWord(String str) {
        this.SecretWord = str;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String str) {
        this.Name = str;
    }

    Game(String str, String str2, String str3, boolean z, boolean z2, int i) {
        this.Name = str;
        this.Role = str2;
        this.SecretWord = str3;
        this.isReady = z;
        this.isEliminate = z2;
        this.Point = i;
    }
}
