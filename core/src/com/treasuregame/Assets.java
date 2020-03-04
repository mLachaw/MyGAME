package com.treasuregame;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {
	
	public AssetManager manager = new AssetManager();
	
	public void load ()
	{
		manager.load("ball.png",Texture.class);
		manager.load("chest.png",Texture.class);
		manager.load("golfball.png",Sound.class);
	}

	@Override
	public void dispose() {
		manager.dispose();
	}

}
