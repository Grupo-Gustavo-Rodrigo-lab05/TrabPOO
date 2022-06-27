package com.mygdx.game.Inimigos;

import com.badlogic.gdx.graphics.Texture;

//Primeiro Boss Golem - Vida muito alta e velocidade muito baixa
public class InimigoGolem extends InimigoBasico {
    public InimigoGolem() {
        vida = 20000;
        velocidade = 20;
        goldDrop = 25;
        create();
    }

    @Override
    public void create() {
        imagemInimigo = new Texture("BossGolem.png");
    }
}
