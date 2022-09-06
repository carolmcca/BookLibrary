package com.booklibrary.controller.actions;

import com.booklibrary.model.Database;
import com.booklibrary.view.pages.SettingsPage;

public class OpenSettingsPageAction extends ButtonAction {
    public OpenSettingsPageAction(Database database) {
        this.buttonText = "Configurações";
        this.page = new SettingsPage(database);
    }
}
