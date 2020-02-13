package com.company.easyfood.web.screens.cookbook;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.FileDescriptorResource;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.components.Image;
import com.haulmont.cuba.gui.screen.*;
import com.company.easyfood.entity.Cookbook;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;

@UiController("easyfood_Cookbook.edit")
@UiDescriptor("cookbook-edit.xml")
@EditedEntityContainer("cookbookDc")
@LoadDataBeforeShow
public class CookbookEdit extends StandardEditor<Cookbook> {

    @Inject
    private Image image;

    @Inject
    private FileUploadingAPI fileUploadingAPI;

    @Inject
    private FileUploadField uploadImageBtn;

    @Inject
    private DataManager dataManager;

    @Subscribe
    public void onInit(InitEvent event) {
        uploadImageBtn.addFileUploadSucceedListener(fileUploadSucceedEvent -> {

            FileDescriptor fd = uploadImageBtn.getFileDescriptor();

            try {
                fileUploadingAPI.putFileIntoStorage(uploadImageBtn.getFileId(), fd);
            } catch (FileStorageException e) {
                throw new RuntimeException("Error saving file to FileStorage", e);
            }

            getEditedEntity().setImage(dataManager.commit(fd));

            displayImage();
        });
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        displayImage();
    }

    @Subscribe("clearImageBtn")
    public void onClearImageBtnClick(Button.ClickEvent event) {
        getEditedEntity().setImage(null);
        displayImage();
    }

    private void displayImage() {
        if (getEditedEntity().getImage() != null) {
            image.setSource(FileDescriptorResource.class).setFileDescriptor(getEditedEntity().getImage());
        } else {
        }
    }

}