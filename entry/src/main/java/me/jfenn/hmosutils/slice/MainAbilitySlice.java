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
import me.jfenn.hmosutils.ResourceTable;

/**
 * MainAbilitySlice.
 */
public class MainAbilitySlice extends AbilitySlice {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        Button bt = (Button) findComponentById(ResourceTable.Id_buttondimen);
        Button bt1 = (Button) findComponentById(ResourceTable.Id_buttonimageutil);
        Button bt2 = (Button) findComponentById(ResourceTable.Id_buttoncolorutil);
        bt.setClickedListener(list -> present(new DimenAbilitySlice(), new Intent()));
        bt1.setClickedListener(list -> present(new me.jfenn.hmosutils.slice.ImageAbilitySlice(), new Intent()));
        bt2.setClickedListener(list -> present(new ColorAbilitySlice(), new Intent()));
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
