
package statki;

/**
 *
 * @author Lukasz
 */
public abstract  class Statek implements IStatek {
    public enum Kierunek{
        lewo, prawo, gora, dol;
        //protected String value;
    }
    int wielkosc;
    Kierunek kierunek;
    private Pole[] zajete;
    private int trafienia;

    public Statek(Kierunek kierunek){
        
        this.kierunek = kierunek;   
        zajete = new Pole[pobierzLiczbeMasztow()];
    }
    public Statek(){
        
             
    }
    @Override
    public boolean jestZatopiony() {
        return trafienia == pobierzLiczbeMasztow();
    }
    @Override
    public void trafienie() {
        trafienia++;
        if(jestZatopiony()) {
            for (int i = 0; i < zajete.length; i++) {
                zajete[i].ustawStan(Stan.ZATOPIONY);
            }
        }
    }
    @Override
    public void ustawNaPolu(Pole pole, int typNumer) {

        pole.ustawStatek(this);
        pole.ustawStan(Stan.STATEK);
        zajete[typNumer] = pole;
    }
    @Override
    public Kierunek pobierzKierunek() {
        return kierunek;
    }
    int rodzajStatki(){
        return wielkosc;
    }
}
class Jednomasztowiec extends Statek{

    Jednomasztowiec(Kierunek kierunek) {
        super(kierunek);
    }

    @Override
    public int pobierzLiczbeMasztow() {
        return 1;
    }
}

class Dwumasztowiec extends Statek{

    public Dwumasztowiec(Kierunek kierunek) {
        super(kierunek);
    }
    
    @Override
    public int pobierzLiczbeMasztow() {
        return 2;
    }
}

class Trzymasztowiec extends Statek{

    public Trzymasztowiec(Kierunek kierunek) {
        super(kierunek);
    }
    @Override
    public int pobierzLiczbeMasztow() {
        return 3;
    }
}
class Czteromasztowiec extends Statek{

    public Czteromasztowiec(Kierunek kierunek) {
        super(kierunek);
    }
    @Override
    public int pobierzLiczbeMasztow() {
        return 4;
    }
}