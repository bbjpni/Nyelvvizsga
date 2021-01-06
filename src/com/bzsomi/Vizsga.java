package com.bzsomi;

public class Vizsga {
    private int ev;
    private int sikeres;
    private int sikertelen;

    public Vizsga(int ev, int sikeres, int sikertelen){
        this.ev = ev;
        this.sikeres = sikeres;
        this.sikertelen = sikertelen;
    }

    public int getEv() { return this.ev; }

    public int getSikeres() { return this.sikeres; }

    public int getSikertelen() { return this.sikertelen; }

    @Override
    public String toString() {
        return this.ev +" - "+ this.sikeres + " : " +this.sikertelen;
    }
}
