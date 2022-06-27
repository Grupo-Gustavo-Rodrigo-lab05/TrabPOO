package com.mygdx.game.Torre;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Efeito.EfeitoBasico;

//Interface contendo todos os métodos de uma Torre que são 'public' (podem ser acessados de fora)
public interface Torre {
    //Métodos gerais
    int getX();
    int getY();
    char getTorreTipo();
    EfeitoBasico getEfeitoTorre();
    Texture getImagemTorre();
    void create();
}
