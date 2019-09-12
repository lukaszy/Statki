
package statki;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author lukas
 */

 public class Statki{
    

    public static void main(String[] args) throws FileNotFoundException, IOException, MyException {
        // TODO code application logic here
        int wybierz;
        boolean czyWybor = false;
        boolean zalogowany = false;
        System.out.println("Witaj w grze Statki!");
        System.out.println("1. Załóż konto");
        System.out.println("2. Zaloguj się");
        System.out.println("Wprowadz liczę");
	Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od użytkownika

	wybierz = odczyt.nextInt();
      
        System.out.println(wybierz);
        Rozpocznij roz = new Rozpocznij();
        Menu nowa = new Menu();
        Plansza gra = new Plansza();
        
        
        switch(wybierz)
        {
            case 1:
            {
                roz.zalozKonto();
            }
                
            case 2: 
                while(!roz.zaloguj())
                {
                    System.out.println("Błędna nazwa lub hasło: ");
                }
                System.out.println("Zalogowano: "+roz.nazwa);
                zalogowany = true;
                break; 

            default:
                System.out.println("Wybrano niewlaściwą liczbę");
        }
        if(zalogowany)
        {
            do
            {
                do
                {
                    System.out.println("1. Nowa gra");
                    System.out.println("2. Obejrzyj poprzednie rozgrywki");
                    System.out.println("Wprowadz liczę");
                    wybierz = odczyt.nextInt();

                    switch(wybierz)
                    {
                        case 1:
                        {
                            nowa.nowaGra(roz.nazwa);
                            czyWybor = true;
                            break;
                        }

                        case 2: 
                            nowa.poprzedniaGra(roz.nazwa+".txt");
                            czyWybor = true;
                            break; 

                        default:
                            czyWybor = false;
                            System.out.println("Wybrano niewlaściwą liczbę");
                    }
                }while(!czyWybor);
                System.out.println("3. Wróć do menu");
                wybierz = odczyt.nextInt();
            }while(wybierz==3);
        }
    }
}
