package hu.szamalk.modell;

import java.util.List;
import java.util.Objects;

public class Tantargy {
    private String nev;
    private String tanar1;
    private String tanar2;
    private int kredit;
    private  int felev;
    private boolean csak_viszga;

    public Tantargy(String sor) throws NemMegfeleloKreditErtekException {
        String[] s = sor.split(";");
        int kreditErtek=Integer.parseInt(s[1]);
        this.nev = s[0];
        this.tanar1 = s[2];
        if(Objects.equals(s[2], s[3])){
            this.tanar2="-";
        }
        else{
        this.tanar2 = s[3];}
        if (0 < kreditErtek || kreditErtek > 5) {
            this.kredit = kreditErtek;
        } else {
            throw new NemMegfeleloKreditErtekException("A krediérték nem megfelelő");
        }

        this.felev = Integer.parseInt(s[4]);
        if(Objects.equals(s[5], "igen")){
        this.csak_viszga = true;}
        else{this.csak_viszga = false;}
    }

    public int getKredit() {
        return kredit;
    }

    public String getNev() {
        return nev;
    }

    public int getFelev() {
        return felev;
    }

    public boolean isCsak_viszga() {
        return csak_viszga;
    }

    public String getTanar2() {
        return tanar2;
    }

    public String getTanar1() {
        return tanar1;
    }
}

class NemMegfeleloKreditErtekException extends Exception {
    public  NemMegfeleloKreditErtekException(String message) {
        super(message);
    }
}


