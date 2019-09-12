
package statki;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author lukas
 */
public class Menu {
    String wsp;
    int y;
    int x;
    boolean blad = true;
    int iloscCzteromasztowcow = 1;
    int iloscTrzymasztowcow = 2;
    int iloscDwumasztowcow = 3;
    int iloscJednomasztowcow = 4;
    
    Plansza plansza = new Plansza();
        
    void nowaGra(String nazwa) throws IOException, MyException {
        
        
        Scanner scanner = new Scanner(System.in);
        
        wprowadzCzteromasztowce();
        wprowadzTrzymasztowce();
        wprowadzDwumasztowce();
        wprowadzJednomasztowce();

        
        plansza.wyczyscPlansza();
        plansza.wyczyscPlansza();
        while (plansza.pobierzLicznikStatki() > 0) {

            System.out.println("Podaj współrzedne");
            String przesun = scanner.nextLine();
            przesun = przesun.toUpperCase();
            int x = przesun.charAt(0) - 'A';
            int y = przesun.charAt(1) - '0';

            try {
                plansza.strzal(x, y);
                
            } catch (MyException e) {
                System.out.println("Blad:" + e.getMessage());
            }
            plansza.zaznaczStrzal();
            //plansza.zapiszRuchDoPlinku(nazwa);
            plansza.wyswietlPlansze();

        }
        
        System.out.println("Koniec gry!");
        plansza.zapiszDoPlinku(nazwa);
    
}

    
    void poprzedniaGra(String nazwa) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(nazwa));
        String s;
        int i = 1;
        while ((s = in.readLine()) != null)
        {
            System.out.println(s);
            i++;
        }
        in.close();
        
        
         
}

    void wprowadzJednomasztowce() throws MyException
    {
        boolean ponow = false;
        IStatek statek = null;
        int wyborKierunku=0;
        do{
            do
            {
              wyborKierunku=0; 
              System.out.println("Wprowadz dane jednomasztowca");
              wprowadz(); 

              statek = (IStatek) new Jednomasztowiec(Statek.Kierunek.prawo);
              try {                    
                      plansza.dodajStatek(x, y, statek);
                      plansza.Rysuj(x, y,  statek);
                      iloscJednomasztowcow--;
                      //System.out.println("DODAŁ ILOSC: "+iloscJednomasztowcow);
                      ponow = false;
                  } catch (MyException e) {
                      System.out.println("Error:" + e.getMessage());
                      ponow = true;
                  } 
              plansza.wyswietlPlansze();
              System.out.println(ponow);
              if(iloscJednomasztowcow==0) break;
            }while(iloscJednomasztowcow>0);
            
            if(iloscJednomasztowcow==0) break;
        }while(ponow == true);
    }
    
    void wprowadzDwumasztowce() throws MyException
    {
        boolean ponow = false;
        IStatek statek = null;
        int wyborKierunku=0;
        do{
            do
            {
              wyborKierunku=0; 
                do
                {
                    System.out.println("Wprowadz dane dwumasztowca");
                    wprowadz(); 
                    wyborKierunku = wybierzKierunek(x,y,2);
                    System.out.println("MOJ KIERUNEK: "+wyborKierunku);
                    if(wyborKierunku != 0)
                    {
                        switch(wyborKierunku){
                        case 1: statek = (IStatek) new Dwumasztowiec(Statek.Kierunek.prawo); break;
                        case 2: statek = (IStatek) new Dwumasztowiec(Statek.Kierunek.lewo); break;
                        case 3: statek = (IStatek) new Dwumasztowiec(Statek.Kierunek.gora); break;
                        case 4: statek = (IStatek) new Dwumasztowiec(Statek.Kierunek.dol); break;
                        default: System.out.println("W tym miejscu nie mozesz ustawic statku!");
                    }
                    }
                }while(wyborKierunku==0);        
                try {                    
                        plansza.dodajStatek(x, y, statek);
                        plansza.Rysuj(x, y,  statek);
                        iloscDwumasztowcow--;
                        //System.out.println("DODAŁ ILOSC: "+iloscDwumasztowcow);
                        ponow = false;
                    } catch (MyException e) {
                        System.out.println("Error:" + e.getMessage());
                        ponow = true;
                    }
                //plansza.wyswStany();
                plansza.wyswietlPlansze();
                System.out.println(ponow);
                if(iloscDwumasztowcow==0) break;
            }while(iloscDwumasztowcow>0);
            if(iloscDwumasztowcow==0) break;
        }while(ponow == true);
    }
    
    void wprowadzTrzymasztowce() throws MyException
    {
        boolean ponow = false;
        IStatek statek = null;
        int wyborKierunku=0;
        do{
            do
            {
              wyborKierunku=0; 
                do
                {
                    System.out.println("Wprowadz dane trzymasztowca");
                    wprowadz(); 
                    wyborKierunku = wybierzKierunek(x,y,3);
                    System.out.println("MOJ KIERUNEK: "+wyborKierunku);
                    if(wyborKierunku != 0)
                    {
                        switch(wyborKierunku){
                        case 1: statek = (IStatek) new Trzymasztowiec(Statek.Kierunek.prawo); break;
                        case 2: statek = (IStatek) new Trzymasztowiec(Statek.Kierunek.lewo); break;
                        case 3: statek = (IStatek) new Trzymasztowiec(Statek.Kierunek.gora); break;
                        case 4: statek = (IStatek) new Trzymasztowiec(Statek.Kierunek.dol); break;
                        default: System.out.println("W tym miejscu nie mozesz ustawic statku!");
                    }
                    }
                }while(wyborKierunku==0);        
                try {                    
                        plansza.dodajStatek(x, y, statek);
                        plansza.Rysuj(x, y,  statek);
                        iloscTrzymasztowcow--;
                        //System.out.println("DODAŁ ILOSC: "+iloscTrzymasztowcow);
                        ponow = false;
                    } catch (MyException e) {
                        System.out.println("Blad:" + e.getMessage());
                        ponow = true;
                    }
                //plansza.wyswStany();
                plansza.wyswietlPlansze();
                System.out.println(ponow);
                if(iloscTrzymasztowcow==0) break;
            }while(iloscTrzymasztowcow>0);
            if(iloscTrzymasztowcow==0) break;
        }while(ponow == true);
    }
    
    void wprowadzCzteromasztowce() throws MyException
    {
        boolean ponow = false;
        IStatek statek = null;
        int wyborKierunku=0;
        do{
            do
            {
              wyborKierunku=0; 
                do
                {
                    System.out.println("Wprowadz dane czteromasztowca");
                    wprowadz(); 
                    wyborKierunku = wybierzKierunek(x,y,4);
                    System.out.println("MOJ KIERUNEK: "+wyborKierunku);
                    if(wyborKierunku != 0)
                    {
                        switch(wyborKierunku){
                        case 1: statek = (IStatek) new Czteromasztowiec(Statek.Kierunek.prawo); break;
                        case 2: statek = (IStatek) new Czteromasztowiec(Statek.Kierunek.lewo); break;
                        case 3: statek = (IStatek) new Czteromasztowiec(Statek.Kierunek.gora); break;
                        case 4: statek = (IStatek) new Czteromasztowiec(Statek.Kierunek.dol); break;
                        default: System.out.println("W tym miejscu nie mozesz ustawic statku!");
                    }
                    }
                }while(wyborKierunku==0);        
                try {                    
                        plansza.dodajStatek(x, y, statek);
                        plansza.Rysuj(x, y,  statek);
                        iloscCzteromasztowcow--;
                        //System.out.println("DODAŁ ILOSC: "+iloscCzteromasztowcow);
                        ponow = false;
                    } catch (MyException e) {
                        System.out.println("Blad:" + e.getMessage());
                        ponow = true;
                    }
                //plansza.wyswStany();
                plansza.wyswietlPlansze();
                System.out.println(ponow);
                if(iloscCzteromasztowcow==0) break;
            }while(iloscCzteromasztowcow>0);
            if(iloscCzteromasztowcow==0) break;
        }while(ponow == true);
    }
    
    
    
    
    
    void wprowadz()
    {
        do
        {
            
            blad = false;
            Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od użytkownika
            //System.out.println("wprowadzono pozycję");
            wsp = odczyt.next();
            String y_str = wsp.substring(0,1);
            String x_str = wsp.substring(1,2);
            if(wsp.length()==3)
            {
                y_str = wsp.substring(0,1);
                x_str = wsp.substring(1,3);
            }

            if(y_str.equals("A"))
            {
                y_str="1";
            }else if(y_str.equals("B"))
            {
                y_str="2";
            }else if(y_str.equals("C"))
            {
                y_str="3";
            }else if(y_str.equals("D"))
            {
                y_str="4";
            }else if(y_str.equals("E"))
            {
                y_str="5";
            }else if(y_str.equals("F"))
            {
                y_str="6";
            }else if(y_str.equals("G"))
            {
                y_str="7";
            }else if(y_str.equals("H"))
            {
                y_str="8";
            }else if(y_str.equals("I"))
            {
                y_str="9";
            }else if(y_str.equals("J"))
            {
                y_str="10";
            }else{
                System.out.println("Wprowadzono nieprawidłową pozycję");
                blad = true;
            }
            try{
            y = Integer.parseInt(x_str);
            }catch(NumberFormatException  e)
            {
                System.out.println("Nieprawidłowy format");
            }
            if(blad==false)
            {
                x = Integer.parseInt(y_str);
            }
            if(y>10 || y<1) 
            {
                blad = true;
                System.out.println("Wprowadzono nieprawidłową pozycję");
            }
            
        }while(blad == true);
    }

   int wybierzKierunek(int x, int y, int liczbaMasztow) throws MyException
    {
    int wybor = 0;
    boolean czyJestKierunek = false;
    Scanner odczyt = new Scanner(System.in); 
    do{
        
    
    Statek.Kierunek[] kierunki = Statek.Kierunek.values();
            for(Statek.Kierunek k: Statek.Kierunek.values())
            {
                if(k == Statek.Kierunek.prawo)
                {
                    if(plansza.sprawdzKierunek(x, y, liczbaMasztow, k))
                    {
                        System.out.println("1: "+k);
                        czyJestKierunek = true;
                    };
                }else if(k == Statek.Kierunek.lewo)
                {
                    if(plansza.sprawdzKierunek(x, y, liczbaMasztow, k))
                    {
                        System.out.println("2: "+k);
                        czyJestKierunek = true;
                    };
                }else if(k == Statek.Kierunek.gora)
                {
                    if(plansza.sprawdzKierunek(x, y, liczbaMasztow, k))
                    {
                        System.out.println("3: "+k);
                        czyJestKierunek = true;
                    };
                } else if(k == Statek.Kierunek.dol)
                {
                    if(plansza.sprawdzKierunek(x, y, liczbaMasztow, k))
                    {
                        System.out.println("4: "+k);
                        czyJestKierunek = true;
                    };
                }else {
                    System.out.println("BRAK");
                    czyJestKierunek = false;
                    return 0;
                }
                
            }
            if(czyJestKierunek)
            {
                wybor = odczyt.nextInt();
            }else {
                System.out.println("Miejsce zajęte!");
                return 0;
            }
            
    }while(wybor!=1 && wybor !=2&& wybor !=3 && wybor !=4);
            return wybor;

    }


}

 