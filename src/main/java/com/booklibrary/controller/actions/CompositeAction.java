package com.booklibrary.controller.actions;

import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CompositeAction extends ButtonAction{
    private final List<ButtonAction> actions;

    public CompositeAction() {
        this.actions = new ArrayList<>();
    }

    public void add(ButtonAction action) {
        this.actions.add(action);
    }

    @Override
    public void execute(Stage stage) {
        for (ButtonAction action : this.actions) {
            action.execute(stage);
        }
    }
}
