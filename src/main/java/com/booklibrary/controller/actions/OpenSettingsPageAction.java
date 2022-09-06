package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Config;
import com.booklibrary.view.pages.SettingsPage;

import java.util.Set;

public class OpenSettingsPageAction extends ButtonAction {
    public OpenSettingsPageAction(Config config, Set<Book> books) {
        this.buttonText = "Configurações";
        this.page = new SettingsPage(config, books);
    }
}
