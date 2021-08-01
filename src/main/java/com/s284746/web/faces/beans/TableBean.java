package com.s284746.web.faces.beans;

import com.s284746.web.faces.struct.Result;
import com.s284746.web.faces.util.SQLProcessor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.*;
import java.util.List;

@SuppressWarnings("deprecation") // deprecated classes are required for this task
@ManagedBean(name = "store")
@SessionScoped
public class TableBean implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String username;
    private int userid;

    public List<Result> getData() {
        try {
            return SQLProcessor.loadDataFromDatabase(0); // TODO: 01/08/2021
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
