package hu.szamalk.modell;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Szak {
    String nev;
   List<Tantargy> tantargyak;
    private transient UUID id;


    public Szak(String nev) throws IOException{
        this.nev = nev;
        this.tantargyak=tantargyakPeldanyositasa();
        this.id=UUID.randomUUID();
    }

    public void szakKiirasa(){
        try {
            ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("targyak.dat"));

            try {
                objKi.writeObject(this);
            } catch (Throwable var6) {
                try {
                    objKi.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }


            }

} catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }}

public void szakbeolvas(){
    try {
        ObjectInputStream objBe = new ObjectInputStream(new FileInputStream("targyak.dat"));{
          this.tantargyak=(Targyak)objBe.readObject();
        }
} catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
}

public List<String> tantargyakBeolvasasaTxtbol() throws IOException {
    String fn = "targyak.txt";
    Path honnan = Path.of(fn);
    List<String> sorok = Files.readAllLines(honnan);
    System.out.println("beolvasott fájl sorai:");
    Iterator var4 = sorok.iterator();

    while(var4.hasNext()) {
        String sor = (String)var4.next();
        System.out.println(sor);
    }

    return sorok;
}



public List<Tantargy> tantargyakPeldanyositasa() throws IOException, NemMegfeleloKreditErtekException {

    this.tantargyak = new ArrayList();
    Iterator var2 = tantargyakBeolvasasaTxtbol().iterator();

    while(var2.hasNext()) {
        String sor = (String)var2.next();
        Tantargy tantargy = new Tantargy(sor);
        this.tantargyak.add(tantargy);

}
    return  this.tantargyak;}



public List<Tantargy> getTantargyakNevSzerint(){


    }

    public List<Tantargy> getTargyakKreditSzerint(){
        return tantargyak.stream().sorted(Comparator.comparingInt(Tantargy::getKredit().collect(Collectors.toList());
    }
public void statisztika() throws IOException {
        String mit="különböző tárgy:"+targyakszama();

    String fn = "kimenet.txt";
    Path hova = Path.of(fn);
    Files.write(hova, mit.getBytes());}

public String targyakszama(){
    Set<String> tantargyak; {
        Set<String> targyak = new HashSet();
        Iterator var2 = this.tantargyak.iterator();

        while(var2.hasNext()) {
            Tantargy tantargy = (Tantargy)var2.next();
            targyak.add(tantargy.getNev());
        }

        return String.valueOf(targyak.size());
    }}

public Set<String> vizsgakentFelveheto(){
    Set<String> tantargyak; {
        Set<String> targyak = new HashSet();
        Iterator var2 = this.tantargyak.iterator();

        while(var2.hasNext()) {
            Tantargy tantargy = (Tantargy)var2.next();
            if(tantargy.isCsak_viszga()){
                targyak.add(String.valueOf(tantargy));
            }
        }
         return targyak;
        }
    }

public int osszesKredit(){
    int osszKredit = 0;

    Tantargy tantargy;
    for(Iterator var2 = this.tantargyak.iterator(); var2.hasNext(); osszKredit += tantargy.getKredit()) {
        tantargy = (Tantargy)var2.next();
    }

    return (double)osszKredit}
}
