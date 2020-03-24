package com.chappie.galaxy;

class Slider {
    private int image;
    private String number;

    /* access modifiers changed from: package-private */
    String getNumber() {
        return this.number;
    }

    Slider(int i, String str) {
        this.image = i;
        this.number = str;
    }

    /* access modifiers changed from: package-private */
    int getImage() {
        return this.image;
    }
}
