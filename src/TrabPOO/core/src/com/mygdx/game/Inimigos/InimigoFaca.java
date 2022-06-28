package com.mygdx.game.Inimigos;

import com.badlogic.gdx.graphics.Texture;

//Inimigo com Faca - Vida e velocidade médias
public class InimigoFaca extends InimigoBasico {
    public InimigoFaca() {
        vida = 1000;
        velocidade = 100;
        goldDrop = 1;
        create();
    }

    @Override
    public void create() {
        imagemInimigo = new Texture("EnemyKnife.png");
    }
}
