package com.underwater.runtimedemo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.data.Essentials;

public class RuntimeDemoTwo extends ApplicationAdapter {

	private GameStage stage;
	
	@Override
	public void create () {
		
		Essentials essentials = new Essentials();
		AssetManager assetManager = new AssetManager();
		assetManager.loadAssets();
		essentials.rm = assetManager;
		
		SceneLoader sceneLoader = new SceneLoader(essentials);
		sceneLoader.loadScene(Gdx.files.internal("scenes/MainScene.dt"));
		
		stage = new GameStage(sceneLoader);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
}
