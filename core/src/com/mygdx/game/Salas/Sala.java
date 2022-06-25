package com.mygdx.game.Salas;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Efeito;
import com.mygdx.game.Inimigos.Inimigo;
import com.mygdx.game.Inimigos.InimigoZumbi;
import com.mygdx.game.Torre.Torre;
//Interface contendo todas as funções de uma sala//
public interface Sala {
    int getX();

    int getY();

    char getTipo();
    public void adicionaEfeito(Efeito efeito);
    Torre getTorre();
    void setTorre(Torre torre);
    void addInimigo(Inimigo inimigo);
    Inimigo[] getInimigo();
    void setRec(Rectangle rec);
    void remove();
    Rectangle getRec();
}