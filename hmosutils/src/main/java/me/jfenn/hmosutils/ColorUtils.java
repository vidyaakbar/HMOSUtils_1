package me.jfenn.hmosutils;

import ohos.agp.colors.HsvColor;
import ohos.agp.colors.RgbColor;
import ohos.agp.utils.Color;


/**
 * ColorUtils.
 */

public class ColorUtils {

    private ColorUtils() {
        //this method is empty
    }

    /**
     * Determine if a color is dark or not, using some magic numbers.
     *
     * @see this confusing wikipedia article (https://en.wikipedia.org/wiki/Luma_%28video%29)
     *
     * @param color         A color int to determine the luminance of.
     * @return              True if the color should be considered "Light".
     */
    public static boolean isColorDark(int color) {
        return getColorDarkness(color) >= 0.5;
    }

    /**
     * Determine the darkness of a color, using some magic numbers.
     *
     * @see this confusing wikipedia article (https://en.wikipedia.org/wiki/Luma_%28video%29)
     *
     * @param color         A color int to determine the luminance of.
     * @return              The darkness of the color; a double between 0 and 1.
     */
    private static double getColorDarkness(int color) {
        if (color == Color.BLACK.getValue()) {
            return 1.0;
        } else if (color == Color.WHITE.getValue() || color == Color.TRANSPARENT.getValue()) {
            return 0.0;
        }
        RgbColor rgbColor = RgbColor.fromArgbInt(color);
        return (1 - (0.259 * rgbColor.getRed() + 0.667 * rgbColor.getGreen() + 0.074 * rgbColor.getBlue()) / 255);
    }

    /**
     * Calculates an opaque color that is equivalent to a translucent color drawn on top of
     * another.
     *
     * @param color         The (transparent) color to be drawn on top.
     * @param background    The (opaque) color to be drawn on top of.
     * @return              The opaque equivalent of the two colors.
     */
    //@ColorInt
    public static int withBackground(int color,  int background) {
        RgbColor rgbColor = RgbColor.fromArgbInt(color);
        RgbColor rgbColor665 = RgbColor.fromArgbInt(background);
        float alpha = Color.alpha(color) / 255f;
        return Color.rgb(
                (int) ((rgbColor.getRed() * alpha) + (rgbColor665.getRed() * (1 - alpha))),
                (int) ((rgbColor.getGreen() * alpha) + (rgbColor665.getGreen() * (1 - alpha))),
                (int) ((rgbColor.getBlue() * alpha) + (rgbColor665.getBlue() * (1 - alpha)))
        );
    }

    /***
     <p>
     </p>* getHSVColorWheelArr.

     * @param saturation         The (transparent) color to be drawn on top.
     *
     * @param brightness         The (transparent) color to be drawn on top.
     * @return arr
     */
    public static int[] getHsvColorWheelArr(float saturation, float brightness) {
        int[] arr = new int[13];
        float h;
        float s;
        float v;
        for (int i = 0; i <= 12; i++) {
            h = ColorUtils.changeParamToFloat1(new float[]{i * 30, saturation, brightness});
            s = ColorUtils.changeParamToFloat2(new float[]{i * 30, saturation, brightness});
            v = ColorUtils.changeParamToFloat3(new float[]{i * 30, saturation, brightness});
            arr[i] = HsvColor.toColor(0, h, s, v);
        }
        return arr;
    }

    public static float changeParamToFloat1(float[] hsv) {
        return hsv[0];
    }

    public static float changeParamToFloat2(float[] hsv) {
        return hsv[1];
    }

    public static float changeParamToFloat3(float[] hsv) {
        return hsv[2];
    }

}
