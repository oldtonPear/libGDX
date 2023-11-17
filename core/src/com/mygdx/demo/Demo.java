package com.mygdx.demo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.demo.zuccgame.AnimatedSprite;
import com.mygdx.demo.zuccgame.Parameters;
import com.mygdx.demo.zuccgame.Sprite;

public class Demo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Camera cam;
	Sprite sprite;
	Sprite sprite2;

	AnimatedSprite aSprite1;
	
	@Override
	public void create () {
		Parameters.setAspectRatio(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam = new OrthographicCamera(4, 4 * Parameters.getInverseAspectRatio());
		cam.position.set(2f, 2f * Parameters.getInverseAspectRatio(), 0f);
		batch = new SpriteBatch();
		sprite = new Sprite(new Texture("badlogic.jpg"));
		sprite2 = new Sprite(new Texture("badlogic.jpg"));
		Texture[] frames = new Texture[10];
		for (int i = 0; i < frames.length; i++) {
			frames[i] = new Texture("knight/Knight_02__RUN_00" + i + ".png");
		}
	
		aSprite1 = new AnimatedSprite(frames);
		aSprite1.setWidth(3);
		aSprite1.setOffsetX(-1.5f);
		aSprite1.setOffsetY(-0.55f);
	
	
	}




	@Override
	public void render () {

		aSprite1.update();
		ScreenUtils.clear(1, 0, 0, 1);

		cam.update();
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		sprite.draw(batch);
		sprite2.draw(batch);
		aSprite1.draw(batch);
		batch.end();
		sprite.setX(sprite.getX()+0.01f);
		if(sprite.getX() > 4) sprite.setX(-sprite.getWidth());


		sprite2.setY(sprite2.getY()+0.1f);
		if(sprite2.getY() > 4 * Parameters.getInverseAspectRatio()) sprite2.setY(-sprite2.getHeight());

		aSprite1.setX(aSprite1.getX()+0.01f);
		if(aSprite1.getX() > 4) aSprite1.setX(-aSprite1.getWidth());
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
