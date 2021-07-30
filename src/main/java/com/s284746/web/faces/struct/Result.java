package com.s284746.web.faces.struct;

import java.io.Serial;
import java.io.Serializable;

public class Result implements Serializable {
	@Serial
    private static final long serialVersionUID = -1640265211557550086L;
    private double x;
    private double y;
    private double r;
    private boolean included;

    public Result(double x, double y, double r, boolean in) {
        this.x = x;
        this.y = y;
        this.r = r;
        included = in;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean isIncluded() {
        return included;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }
}
