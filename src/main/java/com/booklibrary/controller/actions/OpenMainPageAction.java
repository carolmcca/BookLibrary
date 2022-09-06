package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Config;
import com.booklibrary.view.pages.MainPage;

import java.util.Set;

public class OpenMainPageAction extends ButtonAction{
    public OpenMainPageAction(Config config, Set<Book> books) {
        this.buttonText = "Menu Principal";
        this.page = new MainPage(config, books);
    }
}
