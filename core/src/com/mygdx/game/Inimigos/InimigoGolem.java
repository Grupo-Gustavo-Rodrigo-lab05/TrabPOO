package com.mygdx.game.Inimigos;

import com.badlogic.gdx.graphics.Texture;

public class InimigoGolem extends Inimigo {

    public InimigoGolem() {
        vida = 300000;
        velocidade = 20;
        goldDrop = 25;
        create();
    }

    public void create() {
        imagemInimigo = new Texture("BossGolem.png");
    }

}
