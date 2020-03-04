package com.treasuregame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.math.Rectangle;

public class ChasingDot extends Rectangle {
	
	//nadajemy wartosci naszej kropce
	
	private Sound eatSound;
	private Texture texture;
	public boolean canEat =true;
	
	public ChasingDot (Texture texture)
	{
		this.canEat=false;
		this.texture = texture;
		this.height = texture.getHeight();
		this.width = texture.getWidth();
		this.eatSound = Gdx.audio.newSound(Gdx.files.internal("golfball.ogg"));
	}
	
	public void draw(SpriteBatch batch)
	{
		batch.draw(texture,x,y);
	}

}
