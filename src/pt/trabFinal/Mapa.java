package pt.trabFinal;

public class Mapa {
    private Sala[][] salas;

    public Mapa() {
        this.salas = new Sala[10][10]; //TROCAR PELAS DIMENSOES CORRETAS DO MAPA
        for(int i = 0; i < 10; i++)
            for(int j = 0; j < 10; j++)
                salas[i][j] = new Sala(i, j);
    }
}
