package com.booklibrary.controller.actions;

import com.booklibrary.model.Database;
import com.booklibrary.view.pages.SearchBookPage;

public class OpenSearchBookPageAction extends ButtonAction {
    public OpenSearchBookPageAction(Database database) {
        this.buttonText = "Procurar Livro";
        this.page = new SearchBookPage(database);
    }
}
