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
import ohos.agp.components.Image;
import ohos.agp.components.element.PixelMapElement;
import ohos.global.resource.NotExistException;
import ohos.global.resource.Resource;
import ohos.global.resource.ResourceManager;
import ohos.media.image.PixelMap;
import me.jfenn.hmosutils.ImageUtils;
import me.jfenn.hmosutils.ResourceTable;
import java.io.IOException;
import java.util.Optional;

/**
 * ImageAbilitySlice.
 */
public class ImageAbilitySlice extends AbilitySlice {
    /**
     * onStart.
     *
     * @param intent            intent
     *
     */
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_imageutil);
        Button bt3 = (Button) findComponentById(ResourceTable.Id_imagebutton);
        Button bt4 = (Button) findComponentById(ResourceTable.Id_backbutton);
        bt3.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {

                    Image image = (Image) findComponentById(ResourceTable.Id_imageview);
                    Optional<PixelMapElement> element1 = getElementByResId(ResourceTable.Media_pic1);
                    PixelMap bitmap = ImageUtils.drawableToBitmap(element1.get());
                    image.setPixelMap(bitmap);

                    Image image1 = (Image) findComponentById(ResourceTable.Id_imageview2);
                    Optional<PixelMapElement> element2 = getElementByResId(ResourceTable.Media_pic3);
                    PixelMap bitmap1 = ImageUtils.drawableToBitmap(element2.get());
                    image1.setPixelMap(bitmap1);
            }
        });

        bt4.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                onBackPressed();
            }
        });
    }

    private Optional<PixelMapElement> getElementByResId(int resourceId) {
        ResourceManager resourceManager = getContext().getResourceManager();
        if (resourceManager == null) {
            return Optional.empty();
        }
        Optional<PixelMapElement> element = Optional.empty();
        if (resourceId != 0) {
            try {
                Resource resource = resourceManager.getResource(resourceId);
                element = Utils.prepareElement(resource);
            } catch (IOException | NotExistException e) {
                //it is empty
            }
        }
        return Optional.of(element.get());
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
