package de.fenomedia.colorconverter;

import java.util.ArrayList;

/**
 * Created by a.mörke on 06.05.2016.
 */
public class ColorUtils {
    public static float[] getCMYK(int red, int green, int blue){
        float[] list = new float[4];
        float r;
        float g;
        float b;
        float highestValue;
        r = red / 255f;
        g = green / 255f;
        b = blue / 255f;
        highestValue = Math.max(r, g);
        highestValue = Math.max(highestValue, b);

        list[3] = (float)1-highestValue;

        list[0] = (1-r-list[3]) / (1-list[3]);
        list[1] = (1-g-list[3]) / (1-list[3]);
        list[2] = (1-b-list[3]) / (1-list[3]);
        return list;
    }
}
