package net.yoon.domain;

import java.sql.Timestamp;

public class SunglassesVo {
	
	// fileds
	private int sunglasses_num;
	private String sunglasses_kind;
	private String sunglasses_name;
	private int sunglasses_price;
	private int sunglasses_count;
	private String sunglasses_img;
	private String sunglasses_content;
	private String sunglasses_writer;
	private int discount_rate;
	private Timestamp reg_date;
	
	public SunglassesVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SunglassesVo(int sunglasses_num, String sunglasses_kind, String sunglasses_name, int sunglasses_price,
			int sunglasses_count, String sunglasses_img, String sunglasses_content, String sunglasses_writer,
			int discount_rate, Timestamp reg_date) {
		super();
		this.sunglasses_num = sunglasses_num;
		this.sunglasses_kind = sunglasses_kind;
		this.sunglasses_name = sunglasses_name;
		this.sunglasses_price = sunglasses_price;
		this.sunglasses_count = sunglasses_count;
		this.sunglasses_img = sunglasses_img;
		this.sunglasses_content = sunglasses_content;
		this.sunglasses_writer = sunglasses_writer;
		this.discount_rate = discount_rate;
		this.reg_date = reg_date;
	}



	public int getSunglasses_num() {
		return sunglasses_num;
	}
	public void setSunglasses_num(int sunglasses_num) {
		this.sunglasses_num = sunglasses_num;
	}
	public String getSunglasses_kind() {
		return sunglasses_kind;
	}
	public void setSunglasses_kind(String sunglasses_kind) {
		this.sunglasses_kind = sunglasses_kind;
	}
	public String getSunglasses_name() {
		return sunglasses_name;
	}
	public void setSunglasses_name(String sunglasses_name) {
		this.sunglasses_name = sunglasses_name;
	}
	public int getSunglasses_price() {
		return sunglasses_price;
	}
	public void setSunglasses_price(int sunglasses_price) {
		this.sunglasses_price = sunglasses_price;
	}
	public int getSunglasses_count() {
		return sunglasses_count;
	}
	public void setSunglasses_count(int sunglasses_count) {
		this.sunglasses_count = sunglasses_count;
	}
	public String getSunglasses_img() {
		return sunglasses_img;
	}
	public void setSunglasses_img(String sunglasses_img) {
		this.sunglasses_img = sunglasses_img;
	}
	public String getSunglasses_content() {
		return sunglasses_content;
	}
	public void setSunglasses_content(String sunglasses_content) {
		this.sunglasses_content = sunglasses_content;
	}
	public int getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(int discount_rate) {
		this.discount_rate = discount_rate;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	
	public String getSunglasses_writer() {
		return sunglasses_writer;
	}


	public void setSunglasses_writer(String sunglasses_writer) {
		this.sunglasses_writer = sunglasses_writer;
	}


	@Override
	public String toString() {
		return "SunglassesVo [sunglasses_num=" + sunglasses_num + ", sunglasses_kind=" + sunglasses_kind
				+ ", sunglasses_name=" + sunglasses_name + ", sunglasses_price=" + sunglasses_price
				+ ", sunglasses_count=" + sunglasses_count + ", sunglasses_img=" + sunglasses_img
				+ ", sunglasses_content=" + sunglasses_content + ", sunglasses_writer=" + sunglasses_writer
				+ ", discount_rate=" + discount_rate + ", reg_date=" + reg_date + "]";
	}


	

	
}
