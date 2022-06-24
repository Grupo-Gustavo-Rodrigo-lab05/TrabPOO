package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Mapa;
import com.mygdx.game.Torre.TorreFogo;
import com.mygdx.game.Torre.TorreRaio;

import java.awt.*;

public class Mercado implements Screen {

    TiledMap tiledMap;
    Mapa mapa;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;
    Vector3 touchPosition;
    private SpriteBatch batch;
    private final Renderizador game;
    Texture imgComprar;
    int x;
    int y;
    Rectangle botao1;
    Rectangle botao2;
    Rectangle botao3;
    Rectangle botao4;
    Rectangle sairButton;
    public Mercado(final Renderizador game, Mapa mapa, int x, int y){
        this.game = game;
        this.mapa = mapa;
        this.x = x;
        this.y = y;

        //Inicializa mapa e camera//
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        imgComprar = new Texture("BotaoComprar.png");
        touchPosition = new Vector3();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.update();
        tiledMap = new TmxMapLoader().load("Mercado.tmx");

        //Inicializa botoes do menu mercado//
        botao1 = ((RectangleMapObject) tiledMap.getLayers().get("botoes").getObjects().get("botao1")).getRectangle();
        botao2 = ((RectangleMapObject) tiledMap.getLayers().get("botoes").getObjects().get("botao2")).getRectangle();
        botao3 = ((RectangleMapObject) tiledMap.getLayers().get("botoes").getObjects().get("botao3")).getRectangle();
        botao4 = ((RectangleMapObject) tiledMap.getLayers().get("botoes").getObjects().get("botao4")).getRectangle();
        sairButton = ((RectangleMapObject) tiledMap.getLayers().get("sair").getObjects().get("sair")).getRectangle();
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        batch = new SpriteBatch();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        //Renderiza o TiledMap//
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        game.batch.setProjectionMatrix(camera.combined);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        //Renderiza os botoes de comprar
        for (MapObject object : tiledMap.getLayers().get("botoes").getObjects()) {
            Rectangle rec1 = ((RectangleMapObject) object).getRectangle();
            batch.draw(imgComprar, rec1.x, rec1.y);
        }
        batch.end();

        //Verifica qual torre foi comprada e troca ela na SalaTorre//
        if(Gdx.input.justTouched()){
            touchPosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            this.camera.unproject(touchPosition);
        }
        if(sairButton.contains(touchPosition.x, touchPosition.y)){
            game.setScreen(new GameScreen(game, mapa));
        }
        if(botao1.contains(touchPosition.x, touchPosition.y)){
            mapa.getSalas(x, y).setTorre(new TorreFogo(x, y));
            game.setScreen(new GameScreen(game, mapa));
        }
        if(botao2.contains(touchPosition.x, touchPosition.y)){
            mapa.getSalas(x, y).setTorre(new TorreRaio(x, y));
            game.setScreen(new GameScreen(game, mapa));
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
