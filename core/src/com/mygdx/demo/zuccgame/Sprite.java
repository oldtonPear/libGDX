package com.mygdx.demo.zuccgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sprite {
    private float x;
    private float y;
    private float width;
    private float height;
    private Texture frame;
    public Sprite(Texture img){
        frame = img;
        x=0;
        y=0;
        width = 1;
        height = frame.getHeight()/frame.getWidth();
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
        height = width * frame.getHeight() / frame.getWidth();
    }
    public void setHeight(float height) {
        this.height = height;
        width = height * frame.getHeight() / frame.getWidth();
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void draw(SpriteBatch sb){
        sb.draw(frame, x, y, width, height);
    }

}
