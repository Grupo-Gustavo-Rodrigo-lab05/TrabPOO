package pt.trabFinal;

public class Mapa {
    private SalaBasica[][] salas;

    public Mapa() {
        this.salas = new SalaBasica[9][5];
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 5; j++)
                salas[i][j] = new SalaBasica(i, j);
    }
}
