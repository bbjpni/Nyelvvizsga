package com.bzsomi;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static ArrayList<String[]> Olvasas(String file){
        ArrayList<String[]> seged = new ArrayList<>();
        try{
            FileReader fr =new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            seged.add(sor.split(";"));
            while (sor != null){
                sor = br.readLine();
                seged.add(sor.split(";"));
            }
            br.close();
            fr.close();
        }catch (FileNotFoundException e)
        {
            e.getMessage();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return seged;
    }

    public static ArrayList<Nyelv> Nyelvek(ArrayList<String[]> jo, ArrayList<String[]> rossz)
    {
        ArrayList<Nyelv> vissza = new ArrayList<>();
        for (int i = 1; i < jo.size(); i++)
        {
            String[] header = jo.get(0);
            String[] joTomb = jo.get(i);
            String[] rosszTomb = rossz.get(i);
            Nyelv most = new Nyelv(joTomb[0]);
            ArrayList<Vizsga> ossz = Vizsgak(most, header, joTomb, rosszTomb);
            for (Vizsga v: ossz) {
                most.vizsgaAdd(v);
            }
        }
        return vissza;
    }

    public static ArrayList<Vizsga> Vizsgak(Nyelv nyelv, String[] header, String[] jo, String[] rossz)
    {
        ArrayList<Vizsga> back = new ArrayList<>();
        for (int i = 1; i < header.length; i++)
        {
            int ev = Integer.parseInt(header[i]);
            int sikeres = Integer.parseInt(jo[i]);
            int sikertelen = Integer.parseInt(rossz[i]);
            Vizsga v = new Vizsga(ev, sikeres, sikertelen);
            back.add(v);
        }
        return back;
    }

    public static void main(String[] args) {
        ArrayList<String[]> jo = Olvasas("sikeres.csv");
        ArrayList<String[]> rossz = Olvasas("sikertelen.csv");
        ArrayList<Nyelv> nyelves = Nyelvek(jo, rossz);
        //System.out.println(String.format(jo.get(0)[1] + " " + jo.get(1)[0] + " - " + jo.get(1)[1] + " " + rossz.get(1)[1]));
    }
}
