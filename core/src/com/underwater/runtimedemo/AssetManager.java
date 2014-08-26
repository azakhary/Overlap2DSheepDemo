package com.underwater.runtimedemo;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.uwsoft.editor.renderer.IResource;
import com.uwsoft.editor.renderer.MySkin;
import com.uwsoft.editor.renderer.data.ProjectInfoVO;

public class AssetManager implements IResource {
	
	private TextureAtlas mainPack;
	
	private HashMap<String, ParticleEffect> particleEffects = new HashMap<String, ParticleEffect>();
	
	private HashMap<String, TextureAtlas> animations = new HashMap<String, TextureAtlas>();
	
	public AssetManager() {
		
	}
	
	public void loadAssets() {
		
		mainPack = new TextureAtlas(Gdx.files.internal("orig/pack.atlas"));
		
		ParticleEffect rain  = new ParticleEffect();
		rain.load(Gdx.files.internal("particles/rain"), mainPack);
		particleEffects.put("rain", rain);
		
		ParticleEffect firefly  = new ParticleEffect();
		firefly.load(Gdx.files.internal("particles/firefly"), mainPack);
		particleEffects.put("firefly", firefly);
		
		
		animations.put("sheep", new TextureAtlas(Gdx.files.internal("sprite-animations/sheep/sheep.atlas")));
		
	}

	@Override
	public TextureAtlas getAtlas() {
		return mainPack;
	}

	@Override
	public TextureRegion getAsset(String name) {
		return mainPack.findRegion(name);
	}

	@Override
	public MySkin getSkin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectInfoVO getProjectVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParticleEffect getParticle(String name) {
		return particleEffects.get(name);
	}

	@Override
	public ArrayList<ParticleEffect> getParticles() {
		return (ArrayList<ParticleEffect>) particleEffects.values();
	}

	@Override
	public TextureAtlas getSkeletonAtlas(String animationName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TextureAtlas getSpriteAnimationAtlas(String animationName) {
		return animations.get(animationName);
	}

	@Override
	public FileHandle getSkeletonJSON(String animationName) {
		// TODO Auto-generated method stub
		return null;
	}

}
