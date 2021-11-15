package me.jfenn.hmosutils.anim;

import ohos.agp.colors.RgbColor;
import ohos.agp.utils.Color;

/**
 * The AnimatedColor class animates a color int, to a granularity of
 * 1/255. That is, if the difference between the target and current
 * value is 1 or less, it will be ignored and the animation will
 * be regarded as complete.
 */
public class AnimatedColor {

    private AnimatedInteger redValue;
    private AnimatedInteger blueValue;
    private AnimatedInteger greenValue;
    private AnimatedInteger alphaValue;

    /**
     * extract rgb color value from the variable.
     *
     * @param value         The current value.
     */
    public AnimatedColor(int value) {
        redValue = new AnimatedInteger(RgbColor.fromArgbInt(value).getRed());
        greenValue = new AnimatedInteger(RgbColor.fromArgbInt(value).getGreen());
        blueValue = new AnimatedInteger(RgbColor.fromArgbInt(value).getBlue());
        alphaValue = new AnimatedInteger(RgbColor.fromArgbInt(value).getAlpha());

    }

    /**
     * Set the current value to be drawn.
     *
     * @param value         The current value.
     */
    public void set(int value) {
        redValue.set(RgbColor.fromArgbInt(value).getRed());
        blueValue.set(RgbColor.fromArgbInt(value).getBlue());
    }

    /**
     * Set the default value to return to.
     *
     * @param defaultValue  The default value.x
     */
    public void setDefault(int defaultValue) {
        redValue.setDefault(RgbColor.fromArgbInt(defaultValue).getRed());
        greenValue.setDefault(RgbColor.fromArgbInt(defaultValue).getGreen());
        blueValue.setDefault(RgbColor.fromArgbInt(defaultValue).getBlue());
        alphaValue.setDefault(RgbColor.fromArgbInt(defaultValue).getAlpha());
    }

    /**
     * Set the current (and target) value.
     *
     * @param value         The current value.
     */
    public void setCurrent(int value) {

        redValue.setCurrent(RgbColor.fromArgbInt(value).getRed());
        greenValue.setCurrent(RgbColor.fromArgbInt(value).getGreen());
        blueValue.setCurrent(RgbColor.fromArgbInt(value).getBlue());
        alphaValue.setCurrent(RgbColor.fromArgbInt(value).getAlpha());
    }

    /**
     * Get the current value to be drawn.
     *
     * @return              The current value.
     */

    public int val() {
        return Color.argb(
                alphaValue.val(),
                redValue.val(),
                greenValue.val(),
                blueValue.val()
        );
    }

    /**
     * Get the next value about to be drawn, without setting
     * the current value to it.
     *
     * @return              The next value.
     */

    public int nextVal() {
        return nextVal(AnimatedValue.DEFAULT_ANIMATION_DURATION);
    }

    /**
     * Get the next value about to be drawn, without setting
     * the current value to it.
     *
     * @param duration      The duration, in milliseconds, that
     *                      the animation should take.
     * @return              The next value.
     */

    public int nextVal(long duration) {

        return Color.argb(
                alphaValue.nextVal(duration),
                redValue.nextVal(duration),
                greenValue.nextVal(duration),
                blueValue.nextVal(duration)
        );
    }

    /**
     * Get the next value about to be drawn, without setting
     * the current value to it.
     *
     * @param start         The time at which the animation started,
     *                      in milliseconds.
     * @param duration      The duration, in milliseconds, that
     *                      the animation should take.
     * @return              The next value.
     */

    public int nextVal(long start, long duration) {
        return Color.argb(
                alphaValue.nextVal(start, duration),
                redValue.nextVal(start, duration),
                greenValue.nextVal(start, duration),
                blueValue.nextVal(start, duration)
        );
    }

    /**
     * Get the target value that is currently being animated to.
     *
     * @return              The target value.
     */

    public int getTarget() {
        return Color.argb(
                alphaValue.getTarget(),
                redValue.getTarget(),
                greenValue.getTarget(),
                blueValue.getTarget()
        );
    }

    /**
     * Get the default value that the animation should return to.
     *
     * @return              The default value.
     */

    public int getDefault() {
        return Color.argb(
                alphaValue.getDefault(),
                redValue.getDefault(),
                greenValue.getDefault(),
                blueValue.getDefault()
        );
    }

    /**
     * Determine if the target value has been drawn (implying that
     * the animation is complete).
     *
     * @return              True if the target value has supposedly
     *                      been drawn.
     */
    public boolean isTarget() {
        return alphaValue.isTarget() && redValue.isTarget() && greenValue.isTarget() && blueValue.isTarget();
    }

    /**
     * Determine if the default value has been drawn.
     *
     * @return              True if the default value has supposedly
     *                      been drawn.
     */
    public boolean isDefault() {
        return alphaValue.isDefault() && redValue.isDefault() && greenValue.isDefault() && blueValue.isDefault();
    }

    /**
     * Determine if the default value has been set AND is the current
     * target.
     *
     * @return              True if the default value is the current
     *                      target.
     */
    public boolean isTargetDefault() {
        return alphaValue.isTargetDefault()
                && redValue.isTargetDefault() && greenValue.isTargetDefault()
                && blueValue.isTargetDefault();
    }

    /**
     * Animate to the default value.
     */
    public void toDefault() {
        alphaValue.toDefault();
        redValue.toDefault();
        greenValue.toDefault();
        blueValue.toDefault();
    }

    /**
     * Set the value to be animated towards.
     *
     * @param value         The target value.
     */
    public void to(int value) {
        alphaValue.to(RgbColor.fromArgbInt(value).getAlpha());
        redValue.to(RgbColor.fromArgbInt(value).getRed());
        greenValue.to(RgbColor.fromArgbInt(value).getGreen());
        blueValue.to(RgbColor.fromArgbInt(value).getBlue());
    }

    /**
     * Update the current value.
     *
     * @param animate       Whether to animate the change.
     */
    public void next(boolean animate) {
        next(animate, AnimatedValue.DEFAULT_ANIMATION_DURATION);
    }

    /**
     * Update the current value.
     *
     * @param animate       Whether to animate the change.
     * @param duration      The duration, in milliseconds, to animate
     *                      across.
     */
    public void next(boolean animate, long duration) {
        alphaValue.next(animate, duration);
        redValue.next(animate, duration);
        greenValue.next(animate, duration);
        blueValue.next(animate, duration);
    }
}