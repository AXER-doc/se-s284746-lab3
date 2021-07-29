package com.s284746.web.faces.event;

import com.s284746.web.faces.util.SQLProcessor;

import javax.faces.event.*;

public class DataDeleter implements ActionListener {
    @Override
    public void processAction(ActionEvent actionEvent) throws AbortProcessingException {
        try {
            SQLProcessor.deleteData();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
