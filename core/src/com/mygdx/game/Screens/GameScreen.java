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
import com.mygdx.game.Inimigos.Inimigo;
import com.mygdx.game.Inimigos.InimigoZumbi;
import com.mygdx.game.Mapa;
import com.mygdx.game.Salas.SalaCaminho;
import com.mygdx.game.Salas.SalaPedra;
import com.mygdx.game.Salas.SalaTorre;
import com.mygdx.game.Torre.TorreVazia;

import java.util.Iterator;
import java.util.Objects;

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
    private Array<Inimigo> enemies;
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
        enemies = new Array<Inimigo>();
        spawnEnemies();
        int contador = 0;
        if(contador == 0){
            ligaSalas();
            contador++;
        }
    }
    public void ligaSalas(){
        //ARRUMAR ESSA LOGICA//
        String linha ;
        String coluna;
        for(int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if (mapa.getSalas(i, j).getTipo() == 'C') {
                    linha = String.valueOf(i);
                    coluna = String.valueOf(j);
                    linha = linha + coluna;
                    mapa.getSalas(i, j).setRec(((RectangleMapObject) tiledMap.getLayers().get("caminho").getObjects().get(linha)).getRectangle());
                }
                if(mapa.getSalas(i, j).getTipo() == 'T'){
                    linha = String.valueOf(i);
                    coluna = String.valueOf(j);
                    linha = linha + coluna;
                    mapa.getSalas(i, j).setRec(((RectangleMapObject) tiledMap.getLayers().get("objetos").getObjects().get(linha)).getRectangle());
                }
            }
        }
    }
    public void spawnEnemies(){
        for (MapObject object : tiledMap.getLayers().get("Spawn").getObjects()) {
            Rectangle Spawn = ((RectangleMapObject) object).getRectangle();
            Inimigo enemie = new InimigoZumbi();
            enemie.setRec(Spawn.x, Spawn.y);
            enemies.add(enemie);
            lastDropTime = TimeUtils.nanoTime();
            mapa.getSalas(0, 4).addInimigo(enemie);
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

        //Coloca as texturas das torres nos seus respectivos retangulos e gera os efeitos das torres nas casas ao redor//
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if(mapa.getSalas(i, j).getTipo() == 'T') {
                    mapa.getSalas(i, j).getTorre().create();
                    batch.draw(mapa.getSalas(i, j).getTorre().imagemTorre(), mapa.getSalas(i, j).getRec().x, mapa.getSalas(i, j).getRec().y);
                    if (mapa.getSalas(i, j).getTorre().TorreTipo() != 'V') {
                        for (int m = -1; m <= 1; m++) {
                            for (int z = -1; z <= 1; z++) {
                                if (mapa.getSalas(i + m, j + z).getTipo() == 'C' && m != z && m != -z) {
                                    mapa.getSalas(i + m, j + z).adicionaEfeito(mapa.getSalas(i, j).getTorre().getEfeitoTorre());
                                    batch.draw(mapa.getSalas(i, j).getTorre().getEfeitoTorre().getImagemEfeito(), mapa.getSalas(i + m, j + z).getRec().x, mapa.getSalas(i + m, j + z).getRec().y);
                                }
                            }
                        }
                    }
                    if (Gdx.input.justTouched()) {
                        touchPosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                        this.camera.unproject(touchPosition);
                    }
                    if (mapa.getSalas(i, j).getRec().contains(touchPosition.x, touchPosition.y)) {
                        game.setScreen(new Mercado(game, mapa, i, j));
                    }
                }
            }
        }
        //Spawn de inimigos//
        for (Inimigo enemie : enemies) {
            batch.draw(img, enemie.getRec().x, enemie.getRec().y);
        }
        batch.end();
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000)
            spawnEnemies();
        for (Iterator<Inimigo> it = enemies.iterator(); it.hasNext(); ) {
            Inimigo enemie = it.next();
            //Fazer inimigo tomando dano//
            if(enemie.getRec().y > 449)
                enemie.getRec().y -= 200 * Gdx.graphics.getDeltaTime();
            else if(enemie.getRec().x > 127 && enemie.getRec().y > 321){
                enemie.getRec().x -= 100 * Gdx.graphics.getDeltaTime();
            }
            else if(enemie.getRec().y > 321){
                enemie.getRec().y -= 100 * Gdx.graphics.getDeltaTime();
            }
            else if(enemie.getRec().x < 383 && enemie.getRec().y > 193){
                enemie.getRec().x += 100 * Gdx.graphics.getDeltaTime();
            }
            else if(enemie.getRec().y > 193){
                enemie.getRec().y -= 100 * Gdx.graphics.getDeltaTime();
            }
            else if(enemie.getRec().x > 127 && enemie.getRec().y > 65){
                enemie.getRec().x -= 100 * Gdx.graphics.getDeltaTime();
            }
            else if(enemie.getRec().y > 65){
                enemie.getRec().y -= 100 * Gdx.graphics.getDeltaTime();
            }
            else if(enemie.getRec().x < 383 ){
                enemie.getRec().x += 100 * Gdx.graphics.getDeltaTime();
            }
        }

        //Ver em qual sala esta cada inimigo//
//        for (int linha = 0; linha < 7; linha ++) {
//            for (int coluna = 0; coluna < 5; coluna++){
//                if(mapa.getSalas(linha, coluna).getTipo() == 'C') {
//                    for (Iterator<Inimigo> it = enemies.iterator(); it.hasNext(); ) {
//                        Inimigo enemie = it.next();
//                        if (mapa.getSalas(linha, coluna).getRec().contains(enemie.getRec().x, enemie.getRec().y)) {
//                            mapa.getSalas(linha, coluna).addInimigo(enemie);
//
//                        }
//
//                    }
//                }
//            }
//        }
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
