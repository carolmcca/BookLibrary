package com.booklibrary.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<String> options;

    public Menu() {
        this.options = new ArrayList<>();
    }
    public Menu(List<String> options) {
        this.options = options;
    }
    public void addOption(String option) {
        this.options.add(option);
    }


}
