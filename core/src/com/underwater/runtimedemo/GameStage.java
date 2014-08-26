package com.underwater.runtimedemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.actor.SpriteAnimation;

public class GameStage extends Stage {

	private SpriteAnimation sheep; 
	private CompositeItem cloud;
	
	public GameStage(SceneLoader sceneLoader) {
		
		addActor(sceneLoader.sceneActor);
		
		sheep = (SpriteAnimation) sceneLoader.sceneActor.getItemById("sheep");
		sheep.pause();
		
		sheep.setOriginX(sheep.getWidth()/2);
		
		cloud = sceneLoader.sceneActor.getCompositeById("cloud1");
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		
		if(Gdx.input.isKeyPressed(Keys.A)) {
			sheep.setX(sheep.getX() - 200*delta);
			sheep.setScaleX(-1);
			sheep.resume();
		} else if(Gdx.input.isKeyPressed(Keys.D)) {
			sheep.setX(sheep.getX() + 200*delta);
			sheep.setScaleX(1);
			sheep.resume();
		} else {
			sheep.pause();
		}
		
		float directionalDelta  = sheep.getX() - cloud.getX();
		
		if(directionalDelta > 20) {
			cloud.setX(cloud.getX() + 50*delta);
		}
		if(directionalDelta < 20) {
			cloud.setX(cloud.getX() - 50*delta);
		}
		
		
	}
	
}
