package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.Screens.Renderizador;

public class Builder extends ApplicationAdapter{
    private Mapa mapa;
    private Controle controle;
    private Renderizador renderizador;

    //Responsavel por criar o mapa e o controlador//
    public Builder() {
        this.mapa = new Mapa();
        this.controle = new Controle();
    }

    public Mapa getMapa(){
        return mapa;
    }

}
