package com.treasuregame;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.xml.soap.Text;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class ChasseTreasure extends ApplicationAdapter {
	
	
	private Music music;
	private Texture dotTexture, chestTexture;
	private ChasingDot player;
	private Chest ch;
	//private OrthographicCamera camera;
	private int score = 0;
	private BitmapFont font;
	private int speed = 500;
	JDialog dialog;
	
	
	
	SpriteBatch batch;
	
	
	
	
	@Override
	public void create () {
		loadData();
		init();
		
		
		
	}

	private void init() {
		batch = new SpriteBatch();
		music.play();
		font = new BitmapFont();
		
		//camera = new OrthographicCamera(800,600);
		
		player = new ChasingDot(dotTexture);
		ch = new Chest(chestTexture);
			ch.x = MathUtils.random(750);
			ch.y = MathUtils.random(550);
			
		
		
	}

	private void loadData() {
		
		dotTexture = new Texture("ball.png");
		chestTexture = new Texture("chest.png");
		music = Gdx.audio.newMusic(Gdx.files.internal("music.ogg"));
		
		
	}

	@Override
	public void render () {
		update();
		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.draw(batch, "Score: "+score, 10, 580);
		//batch.setProjectionMatrix(camera.combined);
		
		
		ch.draw(batch);
		
		player.draw(batch);
		batch.end();
	}
	
	private void update() {
		handleInput();
		
		
		//camera.update();
		//camera.position.set(player.x + player.width/2,player.y + player.height/2,0);
		
		
			if(isDotEatingChest(ch))  
			{
				
				ch.x = MathUtils.random(750);
				ch.y = MathUtils.random(550);
				score+=1;
				
			}
			
			if(score >=10)
			{
				
				JOptionPane.showMessageDialog(null, "You won!","Game finieshed",JOptionPane.INFORMATION_MESSAGE);
				Gdx.app.exit();
				
				
			}
			
		
	}

	private boolean isDotEatingChest(Chest ch) {
		return player.overlaps(ch);
		
	}

	private void handleInput() {
		if(Gdx.input.isKeyPressed(Keys.A))
		{
			player.x-=speed * Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Keys.D))
		{
			player.x+=speed * Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Keys.W))
		{
			player.y+=speed * Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Keys.S))
		{
			player.y-=speed * Gdx.graphics.getDeltaTime();
		}
		
	}

	@Override
	public void dispose () {
		music.dispose();
		batch.dispose();
		chestTexture.dispose();
		dotTexture.dispose();
		
	}
}
