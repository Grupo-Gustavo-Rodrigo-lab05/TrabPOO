package com.mygdx.game.Salas;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Efeito;
import com.mygdx.game.Inimigos.Inimigo;
import com.mygdx.game.Torre.Torre;

//Sala pela qual o inimigos podem passar//
public class SalaCaminho extends SalaBasica{
    private Array<Inimigo> enemies;
    protected Efeito[] efeitos;
    private Rectangle salaFront;
    public SalaCaminho(int x, int y) {
        super(x, y);
        enemies = new Array<Inimigo>();
        tipo = 'C';
        this.efeitos = new Efeito[10]; //TROCAR PELO NUMERO DE EFEITOS QUE COLOCARMOS NO JOGO
        for(int j = 0; j < 10; j++)
            efeitos[j] = null;
        enemies = new Array<Inimigo>();
    }

    public boolean possuiEfeito(Efeito efeito) {
       for(int i = 0; i < 10; i++){
           if(efeitos[i] != null){
               if(efeitos[i].getId() == efeito.getId())
                return true;
           }
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
    public void remove() {

    }


    @Override
    public Torre getTorre() {
        return null;
    }

    @Override
    public void setTorre(Torre torre) {

    }

    @Override
    public void addInimigo(Inimigo inimigo) {
        if(enemies.contains(inimigo, true)) {
            enemies.add(inimigo);
        }

    }

    @Override
    public Inimigo[] getInimigo() {
        return null;
    }

    public Rectangle getRec() {
        return salaFront;
    }

    public void setRec(Rectangle rec){
        this.salaFront = rec;
    }

}
