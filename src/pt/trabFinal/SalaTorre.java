package pt.trabFinal;

public class SalaTorre extends SalaBasica{
    private Torre torre;

    public SalaTorre(int x, int y) {
        super(x, y);

        tipo = 'T';
        this.torre = null;
    }
}
