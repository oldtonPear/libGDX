package com.mygdx.demo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.demo.zuccgame.Parameters;

public class Demo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Camera cam;
	float x;
	
	@Override
	public void create () {
		Parameters.setAspectRatio(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam = new OrthographicCamera(4, 4 * Parameters.getInverseAspectRatio());
		cam.position.set(2f, 2f * Parameters.getInverseAspectRatio(), 0f);
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		cam.update();
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		batch.draw(img, 0, 0, 1, 1);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
