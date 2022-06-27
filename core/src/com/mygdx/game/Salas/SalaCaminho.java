package com.mygdx.game.Salas;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Efeito.Efeito;
import com.mygdx.game.Inimigos.Inimigo;
import com.mygdx.game.Torre.Torre;

import java.util.Iterator;

//Sala pela qual o inimigos podem passar//
public class SalaCaminho extends SalaBasica{
    private Array<Inimigo> enemies;
    protected Efeito[] efeitos;
    private Rectangle salaFront;
    public SalaCaminho(int x, int y) {
        super(x, y);
        enemies = new Array<Inimigo>();
        tipo = 'C';
        this.efeitos = new Efeito[2]; //TROCAR PELO NUMERO DE EFEITOS QUE COLOCARMOS NO JOGO
        for(int j = 0; j < 2; j++)
            efeitos[j] = null;
        enemies = new Array<Inimigo>();
    }

    public void darDano(){
        for (Iterator<Inimigo> it = enemies.iterator(); it.hasNext();){
            Inimigo enemie = it.next();
            for(int i = 0; i < 2; i++){
                if(efeitos[i] != null){
                    enemie.recebeDano(efeitos[i].getDano());
                }
            }
        }
    }

    public boolean possuiEfeito(Efeito efeito) {
       for(int i = 0; i < 2; i++){
           if(efeitos[i] != null){
               if(efeitos[i].getId() == efeito.getId())
                return true;
           }
       }
       return false;
    }

    public void adicionaEfeito(Efeito efeito) {
        if(efeito != null) {
            if (!possuiEfeito(efeito)) {
                int i = 0;
                while (efeitos[i] != null) { //Encontra o primeiro índice vazio no vetor
                    i++;
                }
                efeitos[i] = efeito;
            }
        }
    }
    public void retiraEfeito(Efeito efeito){
        if(efeito != null) {
            if (possuiEfeito(efeito)) {
                for (int i = 0; i < 2; i++) {
                    if (efeitos[i] != null) {
                        if (efeitos[i].getId() == efeito.getId()) {
                            efeitos[i] = null;
                        }
                    }
                }
            }
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
        boolean jaExiste = false;
        for (Iterator<Inimigo> it = enemies.iterator(); it.hasNext();) {
            Inimigo enemie = it.next();
            if (enemie == inimigo) {
                jaExiste = true;
            }
        }
        if(!jaExiste)
            enemies.add(inimigo);
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
