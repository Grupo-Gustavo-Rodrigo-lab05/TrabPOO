package pt.trabFinal;

public abstract class SalaBasica implements Sala{
    protected int x, y;
    protected char tipo;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getTipo() {
        return tipo;
    }

    public SalaBasica(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
