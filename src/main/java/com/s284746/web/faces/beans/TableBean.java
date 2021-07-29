package com.s284746.web.faces.beans;

import com.s284746.web.faces.struct.Result;
import com.s284746.web.faces.util.SQLProcessor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.*;
import java.util.List;

@ManagedBean(name = "store")
@SessionScoped
public class TableBean implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public List<Result> getData() {
        try {
            return SQLProcessor.loadDataFromDatabase();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
