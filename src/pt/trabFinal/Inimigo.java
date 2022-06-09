package pt.trabFinal;

public class Inimigo {
    protected int velocidade;
    protected int vida;

    public void recebeDano(int dano) {
        vida -= dano;
        if(vida <= 0)
            morre();
    }

    private void morre() {

    }

}
