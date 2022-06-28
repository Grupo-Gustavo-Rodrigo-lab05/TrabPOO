package com.mygdx.game.Inimigos;

import com.badlogic.gdx.graphics.Texture;

//Inimigo Ogro - Vida alta e velocidade baixa
public class InimigoOgro extends InimigoBasico {
    public InimigoOgro() {
        vida = 10000;
        velocidade = 50;
        goldDrop = 10;
        create();
    }

    @Override
    public void create() {
        imagemInimigo = new Texture("EnemyOgre.png");
    }
}
