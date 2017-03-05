package chmurki;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *klasa sluzaca do zapisywania rozgrywki
 * @author Michal
 */
public class Zapis {

    public int punkty;
    public long czas_gry;
    public long czas_dmuchania;
    String imie="Adam";
    
    /**
     *wpisanie danycg gry do klasy Zapis
     * @param punkty1 zdobyte punkty
     * @param czas_gry1 czas gry
     * @param czas_dmuchania1 czas dmuchania
     */
    public void  wpisanieDanych(int punkty1, long czas_gry1, long czas_dmuchania1){
        punkty=punkty1;
        czas_gry=czas_gry1;
        czas_dmuchania=czas_dmuchania1;
        
    }

    /**
     *metoda zapisujaca uzyskany wynik do pliku tekstowego wyniki.txt
     * zapisuje kolejno:
     * czas gry, czas dmuchania, imie, data, punkty 
     */
    public void zapiszWynik(){
        
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wyniki.txt", true)))){
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd;HH:mm:ss");
            Date date = new Date();
            out.println(czas_gry/1000+";"+czas_dmuchania/1000+";"+imie+";"+dateFormat.format(date)+";"+punkty+";");
        }catch (IOException e) {
                System.err.println(e.getMessage());
        }
        
    }

    /**
     *matoda wprowadzajaca domyslne wartosci stanu gry
     */
    public void domyslne(){
        imie="Adam";
        czas_gry=0;
        czas_dmuchania=0;
    }
    
}//koniec klasy Zapis
