package com.s284746.web.faces.beans;

import com.s284746.web.faces.event.DataDeleter;
import com.s284746.web.faces.util.Calculation;
import com.s284746.web.faces.util.SQLProcessor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.*;
import java.sql.SQLException;

@SuppressWarnings("deprecation") // deprecated classes are required for this task
@ManagedBean(name = "function")
@SessionScoped
public class FunctionBean implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private double x;
    private double y;
    private double r;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean getResult() throws SQLException, IOException {
        boolean result = Calculation.belongsToArea(x, y, r);
        SQLProcessor.saveResult(DataDeleter.userid, x, y, r, result);
        return result;
    }

    public void setX(double val) {
        x = val;
    }

    public void setY(double val) {
        y = val;
    }

    public void setR(double val) {
        r = val;
    }
}