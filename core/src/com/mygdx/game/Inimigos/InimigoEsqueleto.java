package com.mygdx.game.Inimigos;

import com.badlogic.gdx.graphics.Texture;

public class InimigoEsqueleto extends Inimigo {

    public InimigoEsqueleto() {
        vida = 30000;
        velocidade = 40;
        goldDrop = 50;
        create();
    }

    public void create() {
        imagemInimigo = new Texture("BossSkeleton.png");
    }

}
