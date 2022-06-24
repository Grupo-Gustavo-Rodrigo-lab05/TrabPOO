package com.mygdx.game.Salas;

import com.mygdx.game.Inimigos.Inimigo;
import com.mygdx.game.Torre.Torre;
//Interface contendo todas as funções de uma sala//
public interface Sala {
    int getX();

    int getY();

    char getTipo();

    Torre getTorre();
    void setTorre(Torre torre);

    Inimigo[] getInimigo();
}