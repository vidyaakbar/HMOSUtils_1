/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.jfenn.hmosutils.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Text;
import ohos.agp.utils.Color;
import me.jfenn.hmosutils.ColorUtils;
import me.jfenn.hmosutils.ResourceTable;

/**
 * ColorAbilitySlice.
 */
public class ColorAbilitySlice extends AbilitySlice {
    Text colordisplay;
    Text backgrounddisplay;
    Text wbcolor;
    int mi = 0;
    int[] colorary = new int[2];
    String hex = "#%06X";

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_color);
        colordisplay = (Text) findComponentById(ResourceTable.Id_colordisplayid);
        backgrounddisplay = (Text) findComponentById(ResourceTable.Id_backgrounddisplayid);
        wbcolor = (Text) findComponentById(ResourceTable.Id_withbackgroundid);
        Button bt2 = (Button) findComponentById(ResourceTable.Id_button0);
        Button bt3 = (Button) findComponentById(ResourceTable.Id_button1);
        Button bt4 = (Button) findComponentById(ResourceTable.Id_button2);

        bt2.setClickedListener(component -> checkColorValue(0xFF46EA55));

        bt3.setClickedListener(component -> checkColorValue(0xFF52255A));

        bt4.setClickedListener(component -> checkColorValue(0xFF29DAEA));

        Button bt5 = (Button) findComponentById(ResourceTable.Id_button3);
        bt5.setClickedListener(component -> checkColorValue(0xEE674D4D));

        Button bt6 = (Button) findComponentById(ResourceTable.Id_button4);
        bt6.setClickedListener(component -> checkColorValue(0xFF8A29EA));

        Button bt7 = (Button) findComponentById(ResourceTable.Id_button5);
        bt7.setClickedListener(component -> checkColorValue(0xFFF6033B));

        Button bt8 = (Button) findComponentById(ResourceTable.Id_button6);
        bt8.setClickedListener(component -> checkColorValue(0xFF13036E));

        Button bt9 = (Button) findComponentById(ResourceTable.Id_button7);
        bt9.setClickedListener(component -> checkColorValue(0xFFDEF603));

        Button bt10 = (Button) findComponentById(ResourceTable.Id_button8);
        bt10.setClickedListener(component -> checkColorValue(0xFFF5720C));

        Button bt11 = (Button) findComponentById(ResourceTable.Id_button9);
        bt11.setClickedListener(component -> checkColorValue(0xFF6D4561));

        Button bt12 = (Button) findComponentById(ResourceTable.Id_button10);
        bt12.setClickedListener(component -> checkColorValue(0xFF91858D));

        Button bt13 = (Button) findComponentById(ResourceTable.Id_button11);
        bt13.setClickedListener(component -> checkColorValue(0xFFE30E9C));

        Button bt14 = (Button) findComponentById(ResourceTable.Id_colorbutton);
        bt14.setClickedListener(component ->  checkBackgroundValue(colorary[0], colorary[1]));
    }

    /**
     * checkBackgroundValue.
     *
     * @param c         The (transparent) color to be drawn on top.
     *
     * @param b color
     */
    public void checkBackgroundValue(int c, int b) {
        int x = ColorUtils.withBackground(c, b);
        String hexColor = String.format(hex, (0xFFFFFF & x));

        wbcolor.setText("The changed Color is " + hexColor);
        wbcolor.setTextColor(new Color(x));
    }

    /**
     * checkColorValue.
     *
     * @param color color
     */
    public void checkColorValue(int color) {
        String colors = "The Color ";
        int secondcolor;
        int firstcolor;

        if (mi == 0) {
            firstcolor = color;
            boolean y = ColorUtils.isColorDark(firstcolor);
            String hexColor1 = String.format(hex, (0xFFFFFF & firstcolor));
            if (y) {
                colordisplay.setText(colors + hexColor1 + " is Dark");
            } else {
                colordisplay.setText(colors + hexColor1 + " is Light");
            }
            colordisplay.setTextColor(new Color(firstcolor));
            mi++;
            colorary[0] = firstcolor;
        } else if (mi == 1) {
            secondcolor = color;
            boolean y = ColorUtils.isColorDark(secondcolor);
            String hexColor2 = String.format(hex, (0xFFFFFF & secondcolor));

            if (y) {
                backgrounddisplay.setText(colors + hexColor2 + " is Dark");
            } else {
                backgrounddisplay.setText(colors + hexColor2 + " is Light");
            }
            backgrounddisplay.setTextColor(new Color(secondcolor));
            mi++;
            colorary[1] = secondcolor;
            refresh();
        }
    }

    public void refresh() {
        mi = 0;
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

}
