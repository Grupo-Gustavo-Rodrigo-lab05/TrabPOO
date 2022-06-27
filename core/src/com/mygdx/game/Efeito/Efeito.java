package com.mygdx.game.Efeito;

import com.badlogic.gdx.graphics.Texture;

//Interface contendo todos os métodos de um Efeito que são 'public' (podem ser acessados de fora)
public interface Efeito {
    //Métodos gerais
    int getId();
    float getDano();
    Texture getImagemEfeito();
    void create();
}
