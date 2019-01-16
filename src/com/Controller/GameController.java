package com.Controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    public Button playBtn;
    public Slider speedSlider;
    public BorderPane MainStage;

    public static BorderPane StaticMainStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.StaticMainStage = this.MainStage;
        BoardController boardController = new BoardController();
        GameLoop gameLoop = new GameLoop();


    }
}
