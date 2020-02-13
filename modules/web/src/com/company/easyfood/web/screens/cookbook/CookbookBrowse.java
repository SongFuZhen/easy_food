package com.company.easyfood.web.screens.cookbook;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.FileDescriptorResource;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.company.easyfood.entity.Cookbook;

import javax.inject.Inject;

@UiController("easyfood_Cookbook.browse")
@UiDescriptor("cookbook-browse.xml")
@LookupComponent("cookbooksTable")
@LoadDataBeforeShow
public class CookbookBrowse extends StandardLookup<Cookbook> {

    @Inject
    private UiComponents uiComponents;

    @Inject
    private GroupTable<Cookbook> cookbooksTable;

    @Subscribe
    public void onInit(InitEvent event) {
        cookbooksTable.addGeneratedColumn("name", entity -> {
            FileDescriptor imageFile = entity.getImage();
            Image image = uiComponents.create(Image.NAME);

            if (imageFile != null) {
                image.setScaleMode(Image.ScaleMode.CONTAIN);
                image.setHeight("40");
                image.setWidth("40");

                image.setSource(FileDescriptorResource.class)
                        .setFileDescriptor(imageFile);
            }

            Label cookbookName = uiComponents.create(Label.NAME);
            cookbookName.setValue(entity.getName());
            cookbookName.setAlignment(Component.Alignment.MIDDLE_LEFT);

            HBoxLayout hBoxLayout = uiComponents.create(HBoxLayout.NAME);
            hBoxLayout.setSpacing(true);
            hBoxLayout.add(image);
            hBoxLayout.add(cookbookName);

            return hBoxLayout;
        });
    }


}