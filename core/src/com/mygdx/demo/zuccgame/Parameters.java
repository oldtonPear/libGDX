package com.mygdx.demo.zuccgame;

public class Parameters {
    
    private static float aspectRatio;

    public static float getAspectRatio() {
        return aspectRatio;
    }
    public static void setAspectRatio(float width, float height) {
        aspectRatio = width/height;
    }
}
