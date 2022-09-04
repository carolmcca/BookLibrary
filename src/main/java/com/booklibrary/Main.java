package com.booklibrary;

import javafx.stage.Stage;

public class Main extends javafx.application.Application {
    private Application application;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        application = new Application();
        application.init(stage);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        application.end();
    }
}
