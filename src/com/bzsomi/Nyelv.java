package com.bzsomi;

import java.util.ArrayList;
import java.util.List;

public class Nyelv {
    private String nev;
    private ArrayList<Vizsga> vizsgak;

    public Nyelv(String nev){
        this.nev = nev;
        vizsgak = new ArrayList<>();
    }

    public void vizsgaAdd(Vizsga v){
        vizsgak.add(v);
    }

    @Override
    public String toString() {
        return this.nev.toUpperCase();
    }
}

