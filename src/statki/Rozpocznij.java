
package statki;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Lukasz
 */
class Rozpocznij {
    String nazwa="";
     boolean zaloguj() throws FileNotFoundException{
         
        Scanner odczyt = new Scanner(System.in);
        Scanner odczyt_z_pliku = new Scanner(new File("uzytkownicy.txt"));
        
        String haslo;
        String pomNazwa;
        String pom2Nazwa;
        
        String pomHaslo;
        String pom2Haslo;
        System.out.println("Wprowadz nazwę gracza");
        nazwa = odczyt.nextLine();
        System.out.println("Wprowadz hasło");
        haslo = odczyt.nextLine();
        //System.out.println("wpisane haslo: "+haslo);
        while (odczyt_z_pliku.hasNextLine())
                {
                    String linia = odczyt_z_pliku.nextLine();
                    Scanner sc = new Scanner(linia);
                    pomNazwa = sc.nextLine();
                   
                    pom2Nazwa = pomNazwa.substring(6,pomNazwa.length());
                    pom2Nazwa = pom2Nazwa.trim();
                    //System.out.println("nazwa: "+pom2Nazwa);
                    
                    linia = odczyt_z_pliku.nextLine();
                    sc = new Scanner(linia);
                    //System.out.println("haslo: "+linia);
                    pomHaslo = sc.next();
                    pom2Haslo = pomHaslo.substring(6,pomHaslo.length());
                    pom2Haslo = pom2Haslo.trim();
                    //System.out.println("haslo: "+pom2Haslo);
                    if(pom2Nazwa.equals(nazwa) && pom2Haslo.equals(haslo))
                    {
                        System.out.println("Logowanie przebiegło pomyślnie");
                        return true;
                    }
               
                }
        return false;

     }
     
     void zalozKonto() throws IOException{       
        FileWriter zapis = new FileWriter("uzytkownicy.txt",true);
        Scanner odczyt = new Scanner(System.in);
        String nazwa;
        String haslo;
        do{
        System.out.println("Wprowadz nazwę gracza");
        nazwa = odczyt.nextLine();
        }while(czyIstniejeUzytkownik(nazwa));
        System.out.println("Wprowadz hasło");
        haslo = odczyt.nextLine();
        System.out.println(nazwa+haslo);
        zapis.write("\r\n"+"login:"+nazwa+"\r\n");
        zapis.write("haslo:"+haslo); 
        zapis.close();
        System.out.println("Rejestracja przebiegło pomyślnie. \nTeraz możesz się zalogować");
    }
     
     boolean czyIstniejeUzytkownik(String sprawdzNazwa) throws FileNotFoundException{
         
        Scanner odczyt = new Scanner(System.in);
        Scanner odczyt_z_pliku = new Scanner(new File("uzytkownicy.txt"));
        
        String haslo;
        String pomNazwa;
        String pom2Nazwa;

        //System.out.println("wpisane haslo: "+haslo);
        while (odczyt_z_pliku.hasNextLine())
                {
                    String linia = odczyt_z_pliku.nextLine();
                    Scanner sc = new Scanner(linia);
                    pomNazwa = sc.nextLine();
                   
                    pom2Nazwa = pomNazwa.substring(6,pomNazwa.length());
                    pom2Nazwa = pom2Nazwa.trim();
                    //System.out.println("nazwa: "+pom2Nazwa);
                    
                    linia = odczyt_z_pliku.nextLine();
                    sc = new Scanner(linia);
                    //System.out.println("haslo: "+linia);
                    
                    //System.out.println("haslo: "+pom2Haslo);
                    if(pom2Nazwa.equals(sprawdzNazwa))
                    {
                        System.out.println("Użytkownik już istnieje");
                        return true;
                    }
                
                }
        return false;

     }

    

    
    
}
