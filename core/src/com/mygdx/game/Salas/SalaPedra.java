package com.mygdx.game.Salas;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Efeito.Efeito;

public class SalaPedra extends SalaCaminho{
    private int vida;

    public SalaPedra(int x, int y) {
        super(x, y);
        tipo = 'P';
    }

    public void recebeDano(int dano) {
        vida -= dano;
        if(vida <= 0)
            morre();
    }

    private void morre() {
        tipo = 'C';
    }

//    public void adicionaEfeito(Efeito efeito) {
//        if(tipo == 'C') {
//            if (!possuiEfeito(efeito)) {
//                int i = 0;
//                while (efeitos[i] != null) { //Encontra o primeiro índice vazio no vetor
//                    i++;
//                }
//                efeitos[i] = efeito;
//            }
//        }
//    }
    public void setRec(Rectangle rec){}

    @Override
    public Rectangle getRec() {
        return null;
    }
}
