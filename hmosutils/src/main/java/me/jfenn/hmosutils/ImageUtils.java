package me.jfenn.hmosutils;

import ohos.agp.components.element.Element;
import ohos.agp.components.element.PixelMapElement;
import ohos.agp.render.Canvas;
import ohos.agp.render.Texture;
import ohos.media.image.PixelMap;
import ohos.media.image.common.PixelFormat;
import ohos.media.image.common.Size;


/**
 * ImageUtils.
 */
public class ImageUtils {
    private ImageUtils() {

    }

    /**
     * Converts drawables to bitmaps.
     *
     * @param drawable          A Element.
     * @return                  A Pixelmap.
     */
    public static PixelMap drawableToBitmap(Element drawable) {

        if (drawable == null) {
            PixelMap.InitializationOptions options = new PixelMap.InitializationOptions();
            options.size = new Size(1, 1);
            options.pixelFormat = PixelFormat.ARGB_8888;
            return PixelMap.create(options);
        }

        PixelMap bitmap;

        if (drawable instanceof PixelMapElement) {
            PixelMapElement bitmapDrawable = (PixelMapElement) drawable;
            if (bitmapDrawable.getPixelMap() != null) {
                return bitmapDrawable.getPixelMap();
            }
        }

        if (drawable.getWidth() <= 0 || drawable.getHeight() <= 0) {
            PixelMap.InitializationOptions options2 = new PixelMap.InitializationOptions();
            options2.size = new Size(1, 1);
            options2.pixelFormat = PixelFormat.ARGB_8888;
            bitmap = PixelMap.create(options2);
        } else {
            PixelMap.InitializationOptions options3 = new PixelMap.InitializationOptions();

            options3.size = new Size(drawable.getWidth(), drawable.getHeight());
            options3.pixelFormat = PixelFormat.ARGB_8888;
            bitmap = PixelMap.create(options3);
        }
        Texture texture = new Texture(bitmap);
        Canvas canvas = new Canvas(texture);

        drawable.setBounds(0, 0, canvas.getLocalClipBounds().getWidth(), canvas.getLocalClipBounds().getHeight());
        drawable.drawToCanvas(canvas);

        return bitmap;
    }
}
