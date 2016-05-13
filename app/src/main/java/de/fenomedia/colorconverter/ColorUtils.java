package de.fenomedia.colorconverter;

/**
 * Created by a.mörke on 06.05.2016.
 *
 * Class calculates all color convertions
 *
 */
public class ColorUtils {

    /**
     * Returns the cmyk according to the rgb parameters
     *
     * @param red
     * @param green
     * @param blue
     * @return float[]
     */

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

    /**
     * Returns the rgb value according to the cmyk parameters
     * @param cyan
     * @param magenta
     * @param yellow
     * @param key
     * @return int[]
     */

    public static int[] getRGB(float cyan, float magenta, float yellow, float key){
        int[] arrReturn = new int[3];
        arrReturn[0] = Math.round (255 * (1-cyan) * (1-key));
        arrReturn[1] = Math.round (255 * (1-magenta) * (1-key));
        arrReturn[2] = Math.round (255 * (1-yellow) * (1-key));
        return arrReturn;
    }


}
