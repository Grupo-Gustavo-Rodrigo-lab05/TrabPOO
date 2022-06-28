package com.mygdx.game.Inimigos;

import com.badlogic.gdx.graphics.Texture;

//Inimigo com Armadura - Vida alta e velocidade média
public class InimigoArmadura extends InimigoBasico {
    public InimigoArmadura() {
        vida = 2000;
        velocidade = 80;
        goldDrop = 5;
        create();
    }

    @Override
    public void create() {
        imagemInimigo = new Texture("EnemyArmor.png");
    }
}
