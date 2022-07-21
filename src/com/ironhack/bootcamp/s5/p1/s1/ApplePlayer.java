package com.ironhack.bootcamp.s5.p1.s1;

public class ApplePlayer implements Playable {
    private final int MAX_VOLUME = 1;
    private double volume;

    public ApplePlayer(double volume) {

        this.volume = volume;
    }

    public void play() {
        System.out.println("Playing on Iphone");
    }

    public void pause() {
        System.out.println("Pausing on Iphone");
    }

    public void mute() {
        System.out.println("Muting on Iphone");
    }

    public void increaseVolume(double volume) {
        // This implementation replace the current volume with the value passed by parameter

        if (volume > MAX_VOLUME) {
            this.volume = MAX_VOLUME;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }

        System.out.println("Current volume: " + this.volume);
    }

    public double getVolume() {
        return volume;
    }
}