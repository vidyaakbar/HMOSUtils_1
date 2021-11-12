package me.jfenn.hmosutils;

import ohos.agp.components.element.Element;
import ohos.agp.render.Canvas;
import ohos.agp.render.ColorFilter;
import ohos.agp.render.Paint;
import ohos.agp.render.PixelMapHolder;
import ohos.agp.render.Texture;
import ohos.agp.utils.Color;
import ohos.agp.utils.Rect;
import ohos.app.Context;
import ohos.media.image.PixelMap;
import ohos.media.image.common.PixelFormat;
import ohos.media.image.common.Size;
import com.hmos.compat.internal.graphics.ColorUtils;

/**
 * The AlphaColorDrawable draws a color with a tiled
 * white/gray background representing alpha or transparency.
 * Aside from the tiled background, it functions the same
 * as any ColorDrawable.
 */
public class AlphaColorDrawable extends Element {
    private Paint bitmapPaint;
    private Paint paint;
    protected PixelMap tile;

    /**
     * AlphaColorDrawable.
     *
     * @param context Context
     * @param color int color
     */
    public AlphaColorDrawable(Context context, int color) {

        int size = me.jfenn.hmosutils.DimenUtils.dpToPx(context, 8);
        bitmapPaint = new Paint();
        Color hmosColor = AlphaColorDrawable.changeParamToColor(Color.LTGRAY.getValue());
        bitmapPaint.setColor(hmosColor);

        if (tile == null || tile.isReleased()) {
            PixelMap.InitializationOptions options1 = new PixelMap.InitializationOptions();
            options1.size = new Size(size * 4, size * 4);
            options1.pixelFormat = PixelFormat.RGB_565;
            tile = PixelMap.create(options1);
            Texture texture = new Texture(tile);
            Canvas canvas = new Canvas(texture);

            canvas.drawColor(Color.WHITE.getValue(), Canvas.PorterDuffMode.SRC_IN);
            for (int x = 0; x < canvas.getLocalClipBounds().getWidth(); x += size) {
                for (int y = x % (size * 2) == 0 ? 0 : size;
                     y < canvas.getLocalClipBounds().getHeight();
                     y += size * 2) {

                    canvas.drawRect(x, y, x + size, y + size, bitmapPaint);
                }
            }
        }
        paint = new Paint();
        Color hmosColor0 = AlphaColorDrawable.changeParamToColor(color);
        paint.setColor(hmosColor0);
    }

    @Override
    public void drawToCanvas(Canvas canvas) {
        Rect b = getBounds();

        if (paint.getAlpha() < 255) {
            for (int x = b.left; x < b.right; x += tile.getImageInfo().size.width) {
                for (int y = b.top; y < b.bottom; y += tile.getImageInfo().size.height) {
                    PixelMapHolder pixelMapHolder = AlphaColorDrawable.changeParamToPixelMapHolder(tile);
                    canvas.drawPixelMapHolder(pixelMapHolder, x, y, bitmapPaint);
                }
            }
        }
        canvas.drawRect(b.left, b.top, b.right, b.bottom, paint);
    }

    @Override
    public void setAlpha(int alpha) {
        Color hmosColor = AlphaColorDrawable.changeParamToColor(ColorUtils
                .setAlphaComponent(bitmapPaint.getColor().getValue(), alpha));
        bitmapPaint.setColor(hmosColor);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        //this method is empty
    }

    public int getOpacity() {
        return PixelFormat.ARGB_8888.getValue();
    }

    public static PixelMapHolder changeParamToPixelMapHolder(PixelMap pixelMap) {
        return new PixelMapHolder(pixelMap);
    }

    /**
     * changeParamToColor.
     *
     * @param color         The current value
     * @return color
     */
    public static Color changeParamToColor(int color) {
        return new Color(color);
    }
}