package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;

//Responsável por criar o mapa e o controlador
public class Builder extends ApplicationAdapter{
    private Mapa mapa;

    public Builder() {
        this.mapa = new Mapa();
    }

    public Mapa getMapa(){
        return mapa;
    }
}
