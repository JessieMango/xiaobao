package com.hqgj.xb.bean.highcharts;


public class Point{

   
    private String x;

 
    private String y;

    private String selected;
    private String  sliced;

    private String color;

    private String name;

    public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public String getSliced() {
		return sliced;
	}

	public void setSliced(String sliced) {
		this.sliced = sliced;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point() {
    }
}