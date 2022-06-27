package com.mygdx.game.Inimigos;

import com.badlogic.gdx.graphics.Texture;

public class InimigoFaca extends Inimigo {

    public InimigoFaca() {
        vida = 1000;
        velocidade = 100;
        goldDrop = 1;
        create();
    }

    public void create() {
        imagemInimigo = new Texture("EnemyKnife.png");
    }

}
