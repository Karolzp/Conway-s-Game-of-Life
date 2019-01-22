package com.Controller;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    public Button startBtn;
    public Slider speedSlider;
    public BorderPane MainStage;

    public static BorderPane StaticMainStage;

    private BoardController boardController;
    private GameLoop gameLoop;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.StaticMainStage = this.MainStage;
        this.boardController = new BoardController();
        this.gameLoop = new GameLoop(this.boardController);
        addListenerToSpeedSlider();
    }

    private void addListenerToSpeedSlider() {
        speedSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {

                int newSpeed = 1000 / newValue.intValue();
                gameLoop.changeLoopSpeed(newSpeed);
            }
        });
    }

    @FXML
    void handleStartBtn() {
        this.gameLoop.handleStartBtn(startBtn);
    }

    @FXML
    void handleClearBtn() {
        this.boardController.clearBoard();
        this.gameLoop.handleClearBtn();
        this.startBtn.setText("START");
    }

    @FXML
    void handleGosperGliderGunBtn() {
        this.boardController.createGosperGliderGun();
    }

    @FXML
    void handleQuitBtn() {
        System.exit(0);
    }
}
