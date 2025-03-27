package hu.szamalk.modell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TantargyTest {

    @Test
    void nemLehetketeggyezoTanarTeszt() throws NemMegfeleloKreditErtekException {
        Tantargy t = new Tantargy("informatika;4;Kovács Imre;Kovács Imre;3;igen");
        assertEquals(t.getTanar2(),"-");
    }

    @Test
    void rosszKreditErtek() throws NemMegfeleloKreditErtekException {

            Tantargy t;
        assertThrows(t=new Tantargy("informatika;4;Kovács Imre;Kovács Imre;6;igen"),NemMegfeleloKreditErtekException);
    }
}