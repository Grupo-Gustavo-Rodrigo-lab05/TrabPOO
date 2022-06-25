package com.mygdx.game.Screens;


import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.mygdx.game.Builder;
import com.mygdx.game.Mapa;

public class Renderizador extends Game {
    public SpriteBatch batch;
    public Mapa mapa;

    public Renderizador(){
        this.mapa = new Builder().getMapa();
    }
    @Override
    public void create () {
        batch = new SpriteBatch();
        this.setScreen(new MainMenuScreen(this, mapa));


    }


    @Override
    public void render () {
        super.render();

    }

    public void dispose() {
        batch.dispose();
    }

}

