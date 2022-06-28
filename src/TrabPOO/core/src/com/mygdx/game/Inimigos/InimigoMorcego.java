package com.mygdx.game.Inimigos;

import com.badlogic.gdx.graphics.Texture;

//Inimigo Morcego - Vida baixa e velocidade alta
public class InimigoMorcego extends InimigoBasico {
    public InimigoMorcego() {
        vida = 800;
        velocidade = 160;
        goldDrop = 2;
        create();
    }

    @Override
    public void create() {
        imagemInimigo = new Texture("EnemyBat.png");
    }
}
