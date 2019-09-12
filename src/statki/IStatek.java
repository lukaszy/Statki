
package statki;

/**
 *
 * @author Lukasz
 */
public interface IStatek {
    int pobierzLiczbeMasztow();
    Statek.Kierunek pobierzKierunek();
    void trafienie();

    boolean jestZatopiony();

    void ustawNaPolu(Pole pole, int typNumer);
}
