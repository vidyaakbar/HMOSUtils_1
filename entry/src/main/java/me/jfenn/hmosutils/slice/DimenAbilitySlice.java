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
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import me.jfenn.hmosutils.DimenUtils;
import me.jfenn.hmosutils.ResourceTable;

/**
 * DimenAbilitySlice.
 */
public class DimenAbilitySlice extends AbilitySlice {
    private static final HiLogLabel HI_LOG_LABEL = new HiLogLabel(0, 0, "DimenAbilitySlice");
    int pxToDp;
    private TextField value;
    private Text display;

    /**
     * onStart.
     *
     *
     * @param intent A distance measurement, in pixels.
     *
     *
     */
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_dimension);
        value = (TextField) findComponentById(ResourceTable.Id_Dpinput);
        display = (Text) findComponentById(ResourceTable.Id_display);
        Button bt = (Button) findComponentById(ResourceTable.Id_button);
        Button bt1 = (Button) findComponentById(ResourceTable.Id_buttonpx);
        Button bt2 = (Button) findComponentById(ResourceTable.Id_buttonsptopx);

        bt.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                try {
                    float x;
                    int y;
                    x = Float.parseFloat(value.getText());
                    y = DimenUtils.dpToPx(getContext(), x);
                    String hello = String.valueOf(y);
                    display.setText(hello);
                } catch (Exception exception) {
                    HiLog.error(HI_LOG_LABEL, "DptoPx Exception");
                }
            }
        });

        bt1.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                try {
                    pxToDp = Integer.parseInt(value.getText());
                    float px1 = DimenUtils.pxToDp(getContext(), pxToDp);
                    String h = String.valueOf(px1);
                    display.setText(h);
                } catch (Exception exception) {
                    HiLog.error(HI_LOG_LABEL, "pxToDp Exception");
                }
            }
        });

        bt2.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                try {
                    Float sp = Float.parseFloat(value.getText());
                    int px = DimenUtils.spToPx(getContext(), sp);
                    String h = String.valueOf(px);
                    display.setText(h);
                } catch (Exception exception) {
                    HiLog.error(HI_LOG_LABEL, "spToPx Exception");
                }
            }
        });

        Button bt3 = (Button) findComponentById(ResourceTable.Id_buttonpxtosp);
        bt3.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                try {
                    int px = Integer.parseInt(value.getText());
                    Float sp = DimenUtils.pxToSp(getContext(), px);
                    String h = String.valueOf(sp);
                    display.setText(h);
                } catch (Exception exception) {
                    HiLog.error(HI_LOG_LABEL, "pxToSp Exception");
                }
            }
        });
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
