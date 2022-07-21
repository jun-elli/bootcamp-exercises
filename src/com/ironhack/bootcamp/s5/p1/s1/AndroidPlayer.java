package com.ironhack.bootcamp.s5.p1.s1;

public class AndroidPlayer implements Playable {

    private final int MAX_VOLUME = 100;

    private double volume;

    public AndroidPlayer(double volume) {
        this.volume = volume;
    }

    public void play() {
        System.out.println("Playing on Android");
    }

    public void pause() {
        System.out.println("Pausing on Android");
    }

    public void mute() {
        System.out.println("Muting on Android");

    }

    public void increaseVolume(double volume) {
        // This implementation increase the current volume with the value passed by parameter
        this.volume = this.volume + volume > MAX_VOLUME ? MAX_VOLUME : this.volume + volume;
        System.out.println("Current volume: " + this.volume);
    }

    public double getVolume() {
        return volume;
    }
}