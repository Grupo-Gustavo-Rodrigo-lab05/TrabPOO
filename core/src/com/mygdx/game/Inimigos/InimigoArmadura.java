package com.mygdx.game.Inimigos;

import com.badlogic.gdx.graphics.Texture;

public class InimigoArmadura extends Inimigo {

    public InimigoArmadura() {
        vida = 7500;
        velocidade = 80;
        goldDrop = 5;
        create();
    }

    public void create() {
        imagemInimigo = new Texture("EnemyArmor.png");
    }

}
