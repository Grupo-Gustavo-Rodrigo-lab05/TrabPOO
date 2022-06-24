package com.mygdx.game.Salas;

import com.mygdx.game.Efeito;
import com.mygdx.game.Inimigos.Inimigo;
import com.mygdx.game.Torre.Torre;

//Sala pela qual o inimigos podem passar//
public class SalaCaminho extends SalaBasica{
    protected Inimigo[] inimigos;
    protected Efeito[] efeitos;

    public SalaCaminho(int x, int y) {
        super(x, y);

        tipo = 'C';
        this.inimigos = new Inimigo[20]; //TROCAR PELO MAX DE INIMIGOS EM UMA SALA
        for(int i = 0; i < 20; i++)
            inimigos[i] = null;
        this.efeitos = new Efeito[10]; //TROCAR PELO NUMERO DE EFEITOS QUE COLOCARMOS NO JOGO
        for(int j = 0; j < 10; j++)
            efeitos[j] = null;
    }

    public boolean possuiEfeito(Efeito efeito) {
        //Verifica se a sala possui o efeito em questão
        for (int i = 0; i < 10; i++) {
            if(efeitos[i].getId() == efeito.getId())
                return true;
        }
        return false;
    }

    public void adicionaEfeito(Efeito efeito) {
        if(!possuiEfeito(efeito)) {
            int i = 0;
            while (efeitos[i] != null) { //Encontra o primeiro índice vazio no vetor
                i++;
            }
            efeitos[i] = efeito;
        }
    }

    @Override
    public Torre getTorre() {
        return null;
    }

    @Override
    public void setTorre(Torre torre) {

    }

    @Override
    public Inimigo[] getInimigo() {
        return inimigos;
    }
}
