package org.mou.stock.model;

public class Stock {

	private String name; // 股票名字
	private String code; // 股票代码
	private double open_val;// 今日开盘价
	private double close_last_day;// 昨日收盘价
	private double cur_val; // 当前价格
	private double cur_highest;// 今日最高价
	private double cur_lowest;// 今日最低价

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getOpen_val() {
		return open_val;
	}

	public void setOpen_val(double open_val) {
		this.open_val = open_val;
	}

	public double getClose_last_day() {
		return close_last_day;
	}

	public void setClose_last_day(double close_last_day) {
		this.close_last_day = close_last_day;
	}

	public double getCur_val() {
		return cur_val;
	}

	public void setCur_val(double cur_val) {
		this.cur_val = cur_val;
	}

	public double getCur_highest() {
		return cur_highest;
	}

	public void setCur_highest(double cur_highest) {
		this.cur_highest = cur_highest;
	}

	public double getCur_lowest() {
		return cur_lowest;
	}

	public void setCur_lowest(double cur_lowest) {
		this.cur_lowest = cur_lowest;
	}

}
