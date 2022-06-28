package com.mygdx.game.Inimigos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

//Interface contendo todos os métodos de um Inimigo que são 'public' (podem ser acessados de fora)
public interface Inimigo {
    //Métodos gerais
    int getVelocidade();
    int getGoldDrop();
    void recebeDano(float dano);
    boolean morre();
    Rectangle getRec();
    void setRec(float x, float y);
    Texture getImagemInimigo();
    void create();
}
