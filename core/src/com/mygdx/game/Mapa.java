package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Salas.*;
import com.mygdx.game.Screens.Renderizador;
import com.mygdx.game.Torre.TorreVazia;

public class Mapa extends ApplicationAdapter{
    private SalaBasica[][] salas;
    //Gera uma matriz de salas que sera o mapa no BackEnd//
    public Mapa() {
        this.salas = new SalaBasica[9][5];
        for(int i = 0; i < 7; i++)
            for(int j = 0; j < 5; j++)
                if(i == 1 || i == 3|| i == 5){
                    if(j == 1 || j == 3){
                        salas[i][j] = new SalaTorre(i, j, new TorreVazia(i, j));
                    }
                    else if((j == 2 || j == 4) && i == 1 || i == 5){
                        salas[i][j] = new SalaPedra(i, j);
                    }
                    else if((j == 0 || j == 2) && i == 3){
                        salas[i][j] = new SalaPedra(i, j);
                    }
                    else{
                        salas[i][j] = new SalaCaminho(i, j);
                    }
                }
                else{
                    salas[i][j] = new SalaCaminho(i, j);

                }
    }

    public Sala getSalas(int i, int j){
        return salas[i][j];
    }
}
