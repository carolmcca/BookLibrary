package com.booklibrary.controller.actions;

import com.booklibrary.model.Database;
import com.booklibrary.view.pages.MainPage;

public class OpenMainPageAction extends ButtonAction{
    public OpenMainPageAction(Database database) {
        this.buttonText = "Menu Principal";
        this.page = new MainPage(database);
    }
}
