package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;

//Responsável por criar o mapa e o controlador
public class Builder extends ApplicationAdapter{
    private Mapa mapa;
    private Controle controle;

    public Builder() {
        this.mapa = new Mapa();
        this.controle = new Controle();
    }

    public Mapa getMapa(){
        return mapa;
    }
}
