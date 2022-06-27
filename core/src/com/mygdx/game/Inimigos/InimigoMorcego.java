package com.mygdx.game.Inimigos;

import com.badlogic.gdx.graphics.Texture;

public class InimigoMorcego extends Inimigo {

    public InimigoMorcego() {
        vida = 2500;
        velocidade = 160;
        goldDrop = 2;
        create();
    }

    public void create() {
        imagemInimigo = new Texture("EnemyBat.png");
    }

}
