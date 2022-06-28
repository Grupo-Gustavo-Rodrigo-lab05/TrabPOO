package com.mygdx.game.Inimigos;

import com.badlogic.gdx.graphics.Texture;

//Segundo Boss Esqueleto - Vida muito alta e velocidade baixa
public class InimigoEsqueleto extends InimigoBasico {
    public InimigoEsqueleto() {
        vida = 17500;
        velocidade = 40;
        goldDrop = 50;
        create();
    }

    @Override
    public void create() {
        imagemInimigo = new Texture("BossSkeleton.png");
    }
}
