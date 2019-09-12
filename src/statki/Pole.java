
package statki;

/**
 *
 * @author Lukasz
 */
public class Pole {
    private final int x;
    private final int y;
    private Stan stan;
    private Statek statek;

    public Pole(int x, int y, Stan stan) {
        this.x = x;
        this.y = y;
        this.stan = stan;

    }

    public void ustawStatek(Statek statek) {
        this.statek = statek;
    }

    public void ustawStan(Stan stan) {
        this.stan = stan;
    }

    public Stan pobierzStan() {
        return stan;
    }

    public int pobierzY() {
        return y;
    }

    public int pobierzX() {
        return x;
    }

    public Statek pobierzStatek() {
        return statek;
    }
    
}
