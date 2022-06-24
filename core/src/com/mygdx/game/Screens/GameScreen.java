package com.mygdx.game.Screens;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.CircleMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.Mapa;

import java.util.Iterator;

public class GameScreen  implements Screen, InputProcessor {
    Texture img;
    TiledMap tiledMap;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;
    private final Renderizador game;
    private SpriteBatch batch;
    public Mapa mapa;
    FitViewport viewport;
    Vector3 touchPosition;
    private Array<Rectangle> enemies;
    private long lastDropTime;
    public GameScreen(final Renderizador game, Mapa mapa){
        this.game = game;
        this.mapa = mapa;
        img = new Texture("inimigo1.png");
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        batch = new SpriteBatch();
        camera.update();
        tiledMap = new TmxMapLoader().load("MyCrappyMap.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        touchPosition = new Vector3();
        Gdx.input.setInputProcessor(this);
        enemies = new Array<Rectangle>();
        spawnEnemies();
    }

    public void spawnEnemies(){
        for (MapObject object : tiledMap.getLayers().get("Spawn").getObjects()) {
            Rectangle Spawn = ((RectangleMapObject) object).getRectangle();
            Rectangle enemie = new Rectangle();
            enemie.x = Spawn.x;
            enemie.y = Spawn.y;
            enemie.width = 64;
            enemie.height = 64;
            enemies.add(enemie);
            lastDropTime = TimeUtils.nanoTime();
        }
    }
    @Override
    public void show() {
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight() );
    }

    @Override
    public void render (float delta) {
        //Limpa a tela, update na camera//
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        game.batch.setProjectionMatrix(camera.combined);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        int i = 1;
        int j = 1;

        //Coloca as texturas das torres nos seus respectivos retangulos//
        for (MapObject object : tiledMap.getLayers().get("objetos").getObjects()) {
            Rectangle rec = ((RectangleMapObject) object).getRectangle();
            mapa.getSalas(i, j).getTorre().create();
            batch.draw(mapa.getSalas(i, j).getTorre().imagemTorre(), rec.x, rec.y);
            if (Gdx.input.justTouched()) {
                touchPosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                this.camera.unproject(touchPosition);
            }
            if (rec.contains(touchPosition.x, touchPosition.y)) {
                game.setScreen(new Mercado(game, mapa, i, j));
            }
            if (i == 1 && j == 1) {
                j = 3;
            } else if (i == 1 && j == 3) {
                i = 3;
                j = 1;
            } else if (i == 3 && j == 1) {
                j = 3;
            } else if (i == 3 && j == 3) {
                i = 5;
                j = 1;
            } else if (i == 5 && j == 1) {
                j = 3;
            }

        }
        //Spawn de inimigos//
        for (Rectangle enemie : enemies) {
            batch.draw(img, enemie.x, enemie.y);
        }
        batch.end();
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000)
            spawnEnemies();
        for (Iterator<Rectangle> it = enemies.iterator(); it.hasNext(); ) {
            Rectangle enemie = it.next();
            //Fazer inimigo tomando dano//
            if(enemie.y > 449)
                enemie.y -= 200 * Gdx.graphics.getDeltaTime();
            else if(enemie.x > 127 && enemie.y > 321){
                enemie.x -= 200 * Gdx.graphics.getDeltaTime();
            }
            else if(enemie.y > 321){
                enemie.y -= 200 * Gdx.graphics.getDeltaTime();
            }
            else if(enemie.x < 383 && enemie.y > 193){
                enemie.x += 200 * Gdx.graphics.getDeltaTime();
            }
            else if(enemie.y > 193){
                enemie.y -= 200 * Gdx.graphics.getDeltaTime();
            }
            else if(enemie.x > 127 && enemie.y > 65){
                enemie.x -= 200 * Gdx.graphics.getDeltaTime();
            }
            else if(enemie.y > 65){
                enemie.y -= 200 * Gdx.graphics.getDeltaTime();
            }
            else if(enemie.x < 383 ){
                enemie.x += 200 * Gdx.graphics.getDeltaTime();
            }
        }
        //Verifica se o mercado ou o invetário foi aberto//
        for (MapObject object : tiledMap.getLayers().get("telas").getObjects()) {
            Rectangle rec = ((RectangleMapObject) object).getRectangle();
            if(Gdx.input.justTouched()){
                touchPosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                this.camera.unproject(touchPosition);
            }
            if(rec.contains(touchPosition.x, touchPosition.y)){
                game.setScreen(new Mercado(game, mapa, 0 ,0));
            }
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


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
