package com.mygdx.game.Inimigos;

import com.badlogic.gdx.graphics.Texture;

public class InimigoOgro extends Inimigo {

    public InimigoOgro() {
        vida = 10000;
        velocidade = 50;
        goldDrop = 10;
        create();
    }

    public void create() {
        imagemInimigo = new Texture("EnemyOgre.png");
    }
}
