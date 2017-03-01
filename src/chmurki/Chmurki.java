

package chmurki;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

/**
 * Główna klasa
 * @author Michal
 * @version 1.00
 */


public class Chmurki extends JFrame{
   
    
    private Timer zegar;
    DaneGry daneGry = new DaneGry();
    Zapis zapis= new Zapis();
    Odtwarzacz odtwarzacz = new Odtwarzacz();
    Chmurka chmurka= new Chmurka();
    Obrazki obrazki = new Obrazki();
    
    


    /**
     * klasa odpowiedzialna za odejmowanie punktow i opadanie chmurki 
     * przy zlym dmuchaniu badz nie dmuchaniu ,
     * losowanie nowej chmurki przy zniszczeniu poprzedniej,
     * zliczanie czasu gry i rozgrywki,
     * zakonczenie gry przy opadnieciu chmurki
     * uruchamiany co 20 ms 
     */
    class Zadanie extends TimerTask{
        public void run(){
            
            if(daneGry.whilePlay()){
                
                daneGry.fallingPanalty();
                
                if(daneGry.checkRightClickingSpeed(chmurka.getPositionY(), chmurka.getCloudType()))
                    chmurka.increasePosY();
                else
                    chmurka.decreasePosY();
                
            }
        daneGry.gameOver(chmurka.getPositionY());
            
        if(daneGry.poziom==3){                
            obrazki.setBackgroundForLevel(daneGry.poziom); 
            if(daneGry.zniszczone_chmurki>=60){
                daneGry.zakoncz=true;
                daneGry.pauza=true;
            }
                
            if(chmurka.getPositionY()<150){
                odtwarzacz.odtworz(2);
                chmurka.setTypeOfCloud(daneGry.poziom);
                
                if(chmurka.getCloudType()==1)
                    obrazki.chmurka_uzyta=obrazki.chmurka1;
                else
                    obrazki.chmurka_uzyta=obrazki.chmurka2;
                
                daneGry.zniszczone_chmurki++;
                daneGry.punkty=daneGry.punkty+20;
                chmurka.setNewHighForLevel(daneGry.poziom);
            }
        }
            
        if(daneGry.poziom==2){                
             
             obrazki.setBackgroundForLevel(daneGry.poziom);
               
            if(daneGry.zniszczone_chmurki>=30){
                daneGry.poziom++;                                   
                chmurka.setTypeOfCloud(3);
                obrazki.chmurka_uzyta=obrazki.chmurka3;
            }
                
            if(chmurka.getPositionY()<150){ 
                odtwarzacz.odtworz(2);                   
                chmurka.setTypeOfCloud(daneGry.poziom);                    
                if(chmurka.getCloudType()==1)                        
                    obrazki.chmurka_uzyta=obrazki.chmurka1;                    
                else                        
                    obrazki.chmurka_uzyta=obrazki.chmurka2;
                    
                daneGry.zniszczone_chmurki++;
                daneGry.punkty=daneGry.punkty+15;
                chmurka.setNewHighForLevel(daneGry.poziom);
            }
        }
            
        if(daneGry.poziom==1){
            chmurka.setTypeOfCloud(1); 
             obrazki.setBackgroundForLevel(daneGry.poziom);
            obrazki.chmurka_uzyta=obrazki.chmurka1;
            if(daneGry.zniszczone_chmurki>=10){
                daneGry.poziom++;
                chmurka.setTypeOfCloud(2); 
                obrazki.chmurka_uzyta=obrazki.chmurka2;
            }
                
            if(chmurka.getPositionY()<150){
                odtwarzacz.odtworz(2);
                daneGry.zniszczone_chmurki++;
                daneGry.punkty=daneGry.punkty+10;
                chmurka.setNewHighForLevel(daneGry.poziom);
            }
        }
        
        
        daneGry.obecny_czas = System.currentTimeMillis();
        if(daneGry.klikniecia_po_czasie!=0){
            daneGry.czas_dmuchania=daneGry.czas_dmuchania+(daneGry.obecny_czas-daneGry.ostatnie_dmuchanie);
            daneGry.ostatnie_dmuchanie=daneGry.obecny_czas;
        }
        else
            daneGry.ostatnie_dmuchanie=daneGry.obecny_czas;
        
        if(daneGry.whilePlay()){
            daneGry.czas_gry=daneGry.czas_gry+(daneGry.obecny_czas-daneGry.ostatni_czas);
            daneGry.ostatni_czas=daneGry.obecny_czas;
        }
        else
            daneGry.ostatni_czas=daneGry.obecny_czas;
        
        if (daneGry.obecny_czas > daneGry.nastepna_sekunda){
            daneGry.nastepna_sekunda += 500;
            daneGry.klikniecia_po_czasie=daneGry.klikniecia;
            daneGry.klikniecia=0;
        }
        repaint();
        }
    }//koniec klasy Zadanie
    
    Chmurki(){
        super("CHMURKI");
        setBounds(50,50,1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        createBufferStrategy(2);

        zegar = new Timer();
        zegar.scheduleAtFixedRate(new Zadanie(),0,20);

        /**
         * zczytuje dane z klawiatury podczas wyswietalania imienia
         */
        this.addKeyListener(new KeyListener(){

            public void keyPressed(KeyEvent e){
                if(daneGry.zakoncz==true & daneGry.zapiszwynik==true) 
                switch(e.getKeyCode()){
                    case KeyEvent.VK_Q:   zapis.imie=zapis.imie+"Q"; break;
                    case KeyEvent.VK_W:   zapis.imie=zapis.imie+"W"; break;
                    case KeyEvent.VK_E:   zapis.imie=zapis.imie+"E"; break;
                    case KeyEvent.VK_R:   zapis.imie=zapis.imie+"R"; break;
                    case KeyEvent.VK_T:   zapis.imie=zapis.imie+"T"; break;
                    case KeyEvent.VK_Y:   zapis.imie=zapis.imie+"Y"; break;
                    case KeyEvent.VK_U:   zapis.imie=zapis.imie+"U"; break;
                    case KeyEvent.VK_I:   zapis.imie=zapis.imie+"I"; break;
                    case KeyEvent.VK_O:   zapis.imie=zapis.imie+"O"; break;
                    case KeyEvent.VK_P:   zapis.imie=zapis.imie+"P"; break;
                    case KeyEvent.VK_A:   zapis.imie=zapis.imie+"A"; break;
                    case KeyEvent.VK_S:   zapis.imie=zapis.imie+"S"; break;
                    case KeyEvent.VK_D:   zapis.imie=zapis.imie+"D"; break;
                    case KeyEvent.VK_F:   zapis.imie=zapis.imie+"F"; break;
                    case KeyEvent.VK_G:   zapis.imie=zapis.imie+"G"; break;
                    case KeyEvent.VK_H:   zapis.imie=zapis.imie+"H"; break;
                    case KeyEvent.VK_J:   zapis.imie=zapis.imie+"J"; break;
                    case KeyEvent.VK_K:   zapis.imie=zapis.imie+"K"; break;
                    case KeyEvent.VK_L:   zapis.imie=zapis.imie+"L"; break;
                    case KeyEvent.VK_Z:   zapis.imie=zapis.imie+"Z"; break;
                    case KeyEvent.VK_X:   zapis.imie=zapis.imie+"X"; break;
                    case KeyEvent.VK_C:   zapis.imie=zapis.imie+"C"; break;
                    case KeyEvent.VK_V:   zapis.imie=zapis.imie+"V"; break;
                    case KeyEvent.VK_B:   zapis.imie=zapis.imie+"B"; break;
                    case KeyEvent.VK_N:   zapis.imie=zapis.imie+"N"; break;
                    case KeyEvent.VK_M:   zapis.imie=zapis.imie+"M"; break;
                    case KeyEvent.VK_ENTER:     daneGry.zapiszwynik=false;
                                                zapis.zapiszWynik();
                                                zapis.domyslne();
                                                odtwarzacz.odtworz(1);
                                                break;
                    case KeyEvent.VK_BACK_SPACE:   if(zapis.imie.length()>0) zapis.imie=zapis.imie.substring(0, zapis.imie.length() - 1); break;
                }
            }

            public void keyReleased(KeyEvent e){
            }

            public void keyTyped(KeyEvent e){
            }
        }
    );
        /**
         * sczytuje miejsca, w ktorych został wcisniety lewy przycisk myszy
         */
        this.addMouseListener(new MouseListener(){

            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                //zliczanie klikniec, gdy nie ma pauzy i gdy gra nie zostala skocznona
                if(daneGry.whilePlay())
                daneGry.klikniecia++;
                //wlaczenie pauzy
                if(e.getX()<880 & e.getX()>770 & e.getY()>35 & e.getY()<85 & daneGry.whilePlay())
                {  
                    daneGry.klikniecia--;
                    daneGry.pauza=true;
                    odtwarzacz.odtworz(1);
                }
                
                //wznowienie gry
                if(e.getX()<580 & e.getX()>400 & e.getY()>200 & e.getY()<260 & daneGry.zakoncz==false & daneGry.pauza==true){
                    daneGry.pauza=false;
                    odtwarzacz.odtworz(1);
                }
                //pokazanie menu zapisu
                if(e.getX()<570 & e.getX()>260 & e.getY()>390 & e.getY()<432 & daneGry.zakoncz==true ){
                    daneGry.zapiszwynik=true;
                    zapis.wpisanieDanych(daneGry.punkty,daneGry.czas_gry,daneGry.czas_dmuchania);
                    odtwarzacz.odtworz(1);
                }
                else
                //zapisanie wyniku
                if(e.getX()<510 & e.getX()>350 & e.getY()>465 & e.getY()<510 & daneGry.zakoncz==true & daneGry.zapiszwynik==true){
                    daneGry.zapiszwynik=false;
                    zapis.zapiszWynik();
                    zapis.domyslne();
                    odtwarzacz.odtworz(1);
                }
                else
                //wylaczenie programu
                if(e.getX()<447 & e.getX()>299 & e.getY()>470 & e.getY()<510 & daneGry.zakoncz==true & daneGry.zapiszwynik==false)
                    System.exit(0);
                else
                //wlaczenie nowej gry
                if((e.getX()<701 & e.getX()>476 & e.getY()>470 & e.getY()<510 & daneGry.zakoncz==true & daneGry.zapiszwynik==false)||(e.getX()<627 & e.getX()>403 & e.getY()>320 & e.getY()<360 & daneGry.pauza==true ) ){                    
                    daneGry.czas_dmuchania=0;
                    daneGry.czas_gry=0;
                    daneGry.ostatni_czas=System.currentTimeMillis();
                    daneGry.poziom =1;
                    chmurka.setTypeOfCloud(1);
                    daneGry.punkty =0;
                    daneGry.zniszczone_chmurki=0;
                    daneGry.zakoncz=false;
                    daneGry.pauza=false;
                    chmurka.setNewHighForLevel(daneGry.poziom);
                    odtwarzacz.odtworz(1);
                }
                
                //zakonczenie gry
                if(e.getX()<600 & e.getX()>400 & e.getY()>410 & e.getY()<460 & daneGry.pauza==true & daneGry.zakoncz==false){
                    daneGry.zakoncz=true;
                    odtwarzacz.odtworz(1);
                }
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
                }
        );
}//koniec klasy Chmurki
    
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        Chmurki okno = new Chmurki(); 
        okno.repaint(); 
    }
    
    /**
     * Metoda odpowiedzialna za rysowanie obiektow na ekranie zaleznie
     * od parametrow boolean
     * 
     * @param g
     */
    public void paint(Graphics g){ 
        try{
        BufferStrategy bstrategy = this.getBufferStrategy();
        Graphics2D g2d = (Graphics2D)bstrategy.getDrawGraphics();
        
        
        
        g2d.drawImage(obrazki.tlo_uzyte, 0,0,null);
        g2d.drawImage(obrazki.wiatrak, 300,640,null);
        g2d.drawImage(obrazki.prog, 0,140,null);
        g2d.drawImage(obrazki.pasek, 0,0,null);
        g2d.drawImage(obrazki.menu, 700,0,null);
        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("Arial",Font.BOLD,20));
        
        try{
        g2d.drawString("Czas: "+daneGry.czas_gry/1000+"s" , 50, 55);
        g2d.drawString("Czas dmuchania: "+daneGry.czas_dmuchania/1000+"s" , 200, 55);
        g2d.drawString("Punkty: "+daneGry.punkty, 500, 55);
        }
        catch(Exception e)
        {
        g2d.drawString("Czas: "+0/1000+"s" , 50, 55);
        g2d.drawString("Czas dmuchania: "+0/1000+"s" , 200, 55);
        g2d.drawString("Punkty: "+0, 500, 55);
        }
        g2d.drawImage(obrazki.chmurka_uzyta, chmurka.getPositionX(),chmurka.getPositionY(),null);
        
        if (daneGry.pauza==true){
            g2d.drawImage(obrazki.pauza_chmura, 150,100,null);
            g2d.setFont(new Font("Arial",Font.BOLD,50));
            g2d.drawString("Wznów" ,400, 256);
            g2d.drawString("Nowa gra" , 400, 356);
            g2d.drawString("Zakoncz" , 400, 456);
        }
        
        if (daneGry.zakoncz==true){            
            g2d.drawImage(obrazki.pauza_chmura, 50,100,null);
            g2d.drawImage(obrazki.pauza_chmura, 250,100,null);
            g2d.setFont(new Font("Arial",Font.BOLD,50));
            g2d.drawString("Punkty: "+daneGry.punkty ,250, 220);
            g2d.drawString("Czas dmuchania: "+daneGry.czas_dmuchania/1000+"s" , 250, 290);
            g2d.drawString("Czas gry: "+daneGry.czas_gry/1000+"s" , 250, 360);
            
            if(daneGry.zapiszwynik==false){
                g2d.drawString("Wyjdz  Nowa gra" , 300, 506);
                g2d.drawString("Zapisz wynik " , 250, 430);
            }
            else
            {
                g2d.drawString("Wpisz imie:"+zapis.imie , 250, 430);
                g2d.drawString("Zapisz " , 350, 500);
            }
        }
        g2d.setFont(new Font("Arial",Font.BOLD,20));
        
        g2d.dispose();
        bstrategy.show();
        
        }
        catch(Exception e)
        {}
    }
    
}//koniec klasy Chmurki