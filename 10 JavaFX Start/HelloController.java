package org.example.multiuserchatinterface;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HelloController {

    public void initialize() {
        Platform.runLater(() -> message.requestFocus());
    }
    @FXML
    protected TextArea message;

    @FXML
    protected TextArea chat;

    @FXML
    protected void onSendButtonClick() {
        chat.setText(chat.getText() + message.getText());
        message.clear();
        message.requestFocus();
    }

    @FXML
    protected void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            onSendButtonClick();
        }
    }
}