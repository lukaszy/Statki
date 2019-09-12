
package statki;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import statki.Statek.Kierunek;

/**
 *
 * @author Lukasz
 */
public class Plansza {

    public static final int PLANSZA_ROZMIAR = 11;
    public static final int STATEK_ILOSC_TYPOW = 4;

    private Pole[][] pola = new Pole[PLANSZA_ROZMIAR][PLANSZA_ROZMIAR];

    private int licznikStatki;
    private int numerTypuStatku[] = new int[STATEK_ILOSC_TYPOW];
    
    public enum Litery {
		A, B, C, D, E, F, G, H, I, J;
	}
    int x=11;
    int y=11;
    int k=0;
    String [][] plansza = new String[x][y];
    public Plansza(){
        for(int i=0; i<x; i++)
        {
            for(int j=0; j<y; j++)
            {
                if(i==0 && j>0)
                {
                    
                    Litery[] litery = Litery.values();
                    
                    plansza[i][j]=(litery[k]).toString();
                    k++;
                }
                else
                {
                    plansza[i][j]=" ";
                    pola[i][j] = new Pole(i, j, Stan.PUSTE);
                }
                
                if(j==0 && i>0)
                {
                    plansza[i][j]=Integer.toString(i);
                    
                }             
            }
        }
        //plansza[5][7]="X";
    
}
    
    void Rysuj(int yy,int xx, IStatek statek){
        if(statek.pobierzLiczbeMasztow()==1)
        {
            plansza[xx][yy]="X";
        }
        if(statek.pobierzLiczbeMasztow()==2)
        {
            if(statek.pobierzKierunek() == Kierunek.prawo)
            {
                plansza[xx][yy]="X";
                plansza[xx][yy+1]="X";
            }
            if(statek.pobierzKierunek() == Kierunek.lewo)
            {
                plansza[xx][yy]="X";
                plansza[xx][yy-1]="X";
            }
            if(statek.pobierzKierunek() == Kierunek.gora)
            {
                plansza[xx][yy]="X";
                plansza[xx-1][yy]="X";
            }
            if(statek.pobierzKierunek() == Kierunek.dol)
            {
                plansza[xx][yy]="X";
                plansza[xx+1][yy]="X";
            }
        }
        
        if(statek.pobierzLiczbeMasztow()==3)
        {
            if(statek.pobierzKierunek() == Kierunek.prawo)
            {
                plansza[xx][yy]="X";
                plansza[xx][yy+1]="X";
                plansza[xx][yy+2]="X";
            }
            if(statek.pobierzKierunek() == Kierunek.lewo)
            {
                plansza[xx][yy]="X";
                plansza[xx][yy-1]="X";
                plansza[xx][yy-2]="X";
            }
            if(statek.pobierzKierunek() == Kierunek.gora)
            {
                plansza[xx][yy]="X";
                plansza[xx-1][yy]="X";
                plansza[xx-2][yy]="X";
            }
            if(statek.pobierzKierunek() == Kierunek.dol)
            {
                plansza[xx][yy]="X";
                plansza[xx+1][yy]="X";
                plansza[xx+2][yy]="X";
            }
        }
        
        if(statek.pobierzLiczbeMasztow()==4)
        {
            if(statek.pobierzKierunek() == Kierunek.prawo)
            {
                plansza[xx][yy]="X";
                plansza[xx][yy+1]="X";
                plansza[xx][yy+2]="X";
                plansza[xx][yy+3]="X";
            }
            if(statek.pobierzKierunek() == Kierunek.lewo)
            {
                plansza[xx][yy]="X";
                plansza[xx][yy-1]="X";
                plansza[xx][yy-2]="X";
                plansza[xx][yy-3]="X";
                
            }
            if(statek.pobierzKierunek() == Kierunek.gora)
            {
                plansza[xx][yy]="X";
                plansza[xx-1][yy]="X";
                plansza[xx-2][yy]="X";
                plansza[xx-3][yy]="X";
            }
            if(statek.pobierzKierunek() == Kierunek.dol)
            {
                plansza[xx][yy]="X";
                plansza[xx+1][yy]="X";
                plansza[xx+2][yy]="X";
                plansza[xx+3][yy]="X";
            }
        }
        
        
    }
    void wyczyscPlansza()
    {
        for(int i=1;i<11;i++)
        {
            for(int j=1;j<11;j++)
            {
                plansza[i][j] = " ";
            }
            System.out.println("");
        }
    }
    void zaznaczStrzal() {

        for(int i=1;i<11;i++)
        {
            for(int j=1;j<11;j++)
            {
                //pole = pobierzPole(1, 1);
                if(pola[i][j].pobierzStan() == Stan.TRAFIENIE)
                {
                    
                    plansza[i][j] = "O";
                }
                if(pola[i][j].pobierzStan() == Stan.ZATOPIONY)
                {
                    plansza[i][j] = "@";
                }
                if(pola[i][j].pobierzStan() == Stan.PUDLO)
                {
                    plansza[i][j] = "*";
                }
            }
           
        } 
    }
    void zapiszDoPlinku(String nazwa) throws IOException{
        Date date = new Date();
       
        String data = String.format("Data :%td %<tB %<tY ", date );
             
        try (FileWriter zapis = new FileWriter(nazwa+".txt",true)) {
            Scanner odczyt = new Scanner(System.in);
            zapis.write(data+"\r\n ");
            for(int i=0; i<x; i++)
            {
                for(int j=0; j<y; j++)
                {
                    zapis.write(plansza[i][j]+"  ");             
                }
                zapis.write("\r\n");    
            }
        }
    }
    void zapiszRuchDoPlinku(String nazwa) throws IOException{
        try (FileWriter zapis = new FileWriter(nazwa+".txt",true)) {
            Scanner odczyt = new Scanner(System.in);
            for(int i=0; i<x; i++)
            {
                for(int j=0; j<y; j++)
                {
                    zapis.write(plansza[i][j]+"  "); 
                }

            }
        }
    }
    void wyswietlPlansze(){
        for(int i=0; i<x; i++)
        {
            for(int j=0; j<y; j++)
            {
                System.out.print(plansza[i][j]+"  ");
            }
            System.out.println("");
        }
    }

    
    void wyswStany(){
        for(int i=1;i<11;i++)
        {
            for(int j=1;j<11;j++)
            {
                System.out.print(pola[i][j].pobierzStan()+"  ");
            }
            System.out.println("");
        }
    }

   public void dodajStatek(int x, int y, IStatek statek) throws MyException {

        int licznik = statek.pobierzLiczbeMasztow();
        System.out.println("KIERUNEK:"+statek.pobierzKierunek());
        if (numerTypuStatku[licznik - 1]
                == pobierzCalkowitaIloscStatkow(licznik)) {
            throw new MyException("Ustawiłeś wszytkie okrety!");
        }


        Pole[] pole = new Pole[licznik];
        int xUstaw = x, yUstaw = y;
        for (int i = 0; i < licznik; i++) {
            if (statek.pobierzKierunek()== Statek.Kierunek.prawo) {
                xUstaw = x + i;
            } else if (statek.pobierzKierunek()== Statek.Kierunek.lewo) {
                xUstaw = x - i;
            }else if (statek.pobierzKierunek()== Statek.Kierunek.dol) {
                yUstaw = y + i;
            }else if (statek.pobierzKierunek()== Statek.Kierunek.gora) {
                yUstaw = y - i;
            }
            if (jestPozaPlansza(xUstaw, yUstaw)) {
                
                throw new MyException("Statek poza planszą!");
            }

            pole[i] = pola[yUstaw][xUstaw];
            if (jestZajete(pole[i])) {       
                throw new MyException("Pole jest zajęte!");
            }


        }

        for (int i = 0; i < licznik; i++) {
            statek.ustawNaPolu(pole[i], i);
        }


        licznikStatki++;
        numerTypuStatku[licznik - 1]++;

    }
   
   public boolean sprawdzKierunek(int x, int y, int liczbaMasztow, Statek.Kierunek kierunek) throws MyException {

        Pole[] pole = new Pole[liczbaMasztow];
        int xUstaw = x, yUstaw = y;
        for (int i = 0; i < liczbaMasztow; i++) {
            if (kierunek == Statek.Kierunek.prawo) {       
                xUstaw = x + i;
            } else if (kierunek== Statek.Kierunek.lewo) {          
                xUstaw = x - i;
            }else if (kierunek== Statek.Kierunek.dol) {           
                yUstaw = y + i;
            }else if (kierunek== Statek.Kierunek.gora) {    
                yUstaw = y - i;
            }
            if (jestPozaPlansza(xUstaw, yUstaw)) {
                return false;               
            }

            pole[i] = pola[yUstaw][xUstaw];
            if (jestZajete(pole[i])) {             
                return false;
            } 
        }
        return true;
    }

    private boolean jestZajete(Pole pole) {
        for (int x = pole.pobierzX() - 1; x <= pole.pobierzX() + 1; x++) {
            for (int y = pole.pobierzY() - 1; y <= pole.pobierzY() + 1; y++){

                if (jestPozaPlansza(y, x)) {
                    //System.out.println("poza plansza!");
                    continue;
                }

                if (pola[x][y].pobierzStan() != Stan.PUSTE) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void strzal(int x, int y) throws MyException {
        x++;
        if(jestPozaPlansza(x, y)) {
            throw new MyException("Strzał poza planszą!");
        }
        Pole pole = pobierzPole(x, y);

        if (pole.pobierzStan() == Stan.PUDLO ||
                pole.pobierzStan() == Stan.TRAFIENIE ||
                pole.pobierzStan() == Stan.ZATOPIONY) {
            throw new MyException("Już tutaj strzelałeś!");
        }

        if (pole.pobierzStan() == Stan.PUSTE) {
            pole.ustawStan(Stan.PUDLO);
            System.out.println("Pudło!");
        } else if (pole.pobierzStan() == Stan.STATEK) {
            pole.ustawStan(Stan.TRAFIENIE);
            System.out.println("Trafiony!");
            pole.pobierzStatek().trafienie();
            if (pole.pobierzStatek().jestZatopiony()) {
                System.out.println("Zatopiony!");
                licznikStatki--;
            }
        }
    }

    private boolean jestPozaPlansza(int xx, int yy) {
        return xx < 1 || xx >= 11 || yy < 1 || yy >= 11;
    }

    private int pobierzCalkowitaIloscStatkow(int liczbaTyp) {
        return STATEK_ILOSC_TYPOW - liczbaTyp + 1;
    }

    public int pobierzLicznikStatki() {
        return licznikStatki;
    }

    public Pole pobierzPole(int x, int y) {
        return pola[y][x];
    }
}



