package com.mygdx.demo.zuccgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AnimatedSprite{
    private float x;
    private float y;
    private float width;
    private float height;

    private float offsetX = 0;
    private float offsetY = 0;

    private Texture[] frames;
    private int currentFrame;


    public AnimatedSprite(){
        this.frames = null;
        this.currentFrame = -1;
    }
    public AnimatedSprite(Texture[] frames){
        setAnimation(frames);
    }
    public void setAnimation(Texture[] frames){
        this.frames = frames;
        this.currentFrame = -1;
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }
    public void setWidth(float width) {
        this.width = width;
        if(frames != null) height = width * frames[0].getHeight() / frames[0].getWidth();
    }
    public void setHeight(float height) {
        this.height = height;
        if(frames != null) width = height * frames[0].getHeight() / frames[0].getWidth();
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void draw(SpriteBatch sb){
        sb.draw(frames[currentFrame], x +offsetX, y + offsetY, width, height);
    }
    public void update(){
        currentFrame++;
        if(currentFrame==frames.length) currentFrame = 0;
    }
    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
    }
    public void setOffsetY(float offsetY) {
        this.offsetY = offsetY;
    }
}
