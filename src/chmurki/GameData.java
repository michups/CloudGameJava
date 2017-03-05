/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmurki;

/**
 *
 * @author Mich
 */
public class DaneGry {
    /**
     *klikniecia brane pod uwage, co 0.5s jest wpisywana wartosc klikniecia
     */
    int klikniecia_po_czasie=0;
    /**
     * zliczane klikniecia, zerowane co 0.5s 
     */
    int klikniecia =0;
    int poziom =1;
    int punkty =0;
    int zniszczone_chmurki=0;
    int spadanie_chmurki=0;
    /**
     * wartosc nastepnego czasu, w ktorym nastapi zliczenie (pol sekundy pozniej niz 
     * czas obecny)
     */
    long nastepna_sekunda = System.currentTimeMillis() + 500;
    /**
     * zmienna zapamietujaca czas ostatniego dmuchania
     * potrzebna przy obliczaniu czasu dmuchania
     */
    long ostatnie_dmuchanie=0;
    /**
     * zmienna zapamietujaca czas ostatniego dmuchania
     * potrzebna przy obliczaniu calkowitego czasu gry
     */
    long ostatni_czas=System.currentTimeMillis();
    long czas_gry =0;
    long czas_dmuchania=0;
    long obecny_czas ;
    
    /**
     * zmienna oznaczajaca wlaczenie pauzy (true - wlaczona)
     */
    boolean pauza = false;
    /**
     * zmienna oznaczajaca zakonczenie gry (true - zakoncz gre)
     */
    boolean zakoncz = false;
    /**
     * zmienna oznaczajaca zapisywanie wyniku(true - umozliwia zapisanie)
     */
    boolean zapiszwynik = false;
    /**
     * zmienna oznaczajaca wyjscie z programu
     */
    boolean wyjdz = false;
    public boolean whilePlay()
    {
        return (pauza==false && zakoncz==false);
    }
    
    public void fallingPanalty()
    {
        if(spadanie_chmurki>=10){
            spadanie_chmurki=0;
            punkty--;
        }
    }
    
    public boolean checkRightClickingSpeed(int cloudPositionY, int cloudType)
    {
        if(cloudType==1){
                    
            if(klikniecia_po_czasie<=1 & klikniecia_po_czasie>0)
                return false;  

            if((klikniecia_po_czasie>1 || klikniecia_po_czasie<=0)& cloudPositionY<700){ 

                if(punkty>0)
                    spadanie_chmurki++;
                    return true;
            }
        }
                
        if(cloudType==2){
            if(klikniecia_po_czasie<=3 & klikniecia_po_czasie>1)
               return false;  
            if((klikniecia_po_czasie>3 || klikniecia_po_czasie<=1)& cloudPositionY<700){
                if(punkty>0)
                    spadanie_chmurki++;
                    return true;  
            }
        }
        if(cloudType==3){
            if(klikniecia_po_czasie<=5 & klikniecia_po_czasie>3)
                return false;  

            if((klikniecia_po_czasie>5 || klikniecia_po_czasie<=3)& cloudPositionY<700){
                if(punkty>0)
                   spadanie_chmurki++;
                   return true;  
            }
        }
        return true;
    }
    public void gameOver(int cloudPosY)
    {
        if(cloudPosY>550){
            zakoncz=true;
            pauza=true;
        }
    }
    public DaneGry()
    {
        
    }
}
