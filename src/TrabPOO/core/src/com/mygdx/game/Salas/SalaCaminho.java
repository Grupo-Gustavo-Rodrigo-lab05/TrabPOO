package com.mygdx.game.Salas;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Efeito.EfeitoBasico;
import com.mygdx.game.Inimigos.InimigoBasico;
import java.util.Iterator;

//Sala que pode conter Inimigos e Efeitos
public class SalaCaminho extends SalaBasica {
    private Array<InimigoBasico> enemies;
    protected EfeitoBasico[] efeitos;

    public SalaCaminho(int x, int y) {
        super(x, y);
        enemies = new Array<InimigoBasico>();
        tipo = 'C';
        this.efeitos = new EfeitoBasico[2];
        for(int j = 0; j < 2; j++)
            efeitos[j] = null;
    }

    @Override
    public void adicionaEfeito(EfeitoBasico efeito) {
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

    @Override
    public void removeEfeito(EfeitoBasico efeito){
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
    public void adicionaInimigo(InimigoBasico inimigo) {
        boolean jaExiste = false;
        for (Iterator<InimigoBasico> it = enemies.iterator(); it.hasNext();) {
            InimigoBasico enemie = it.next();
            if (enemie == inimigo) {
                jaExiste = true;
            }
        }
        if(!jaExiste)
            enemies.add(inimigo);
    }

    @Override
    public void removeInimigo(InimigoBasico enemyRemoved) {
        for (Iterator<InimigoBasico> it = enemies.iterator(); it.hasNext();) {
            InimigoBasico enemy = it.next();
            if (enemyRemoved == enemy) {
                it.remove();
            }
        }
    }

    @Override
    public void darDano() {
        for (Iterator<InimigoBasico> it = enemies.iterator(); it.hasNext();){
            InimigoBasico enemy = it.next();
            for(int i = 0; i < 2; i++) {
                if(efeitos[i] != null) {
                    enemy.recebeDano(efeitos[i].getDano());
                }
            }
        }
    }

    public boolean possuiEfeito(EfeitoBasico efeito) {
       for(int i = 0; i < 2; i++){
           if(efeitos[i] != null) {
               if(efeitos[i].getId() == efeito.getId())
                return true;
           }
       }
       return false;
    }
}
