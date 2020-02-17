package net.yoon.domain;

import java.sql.Timestamp;

public class BuyVo {

	private int buy_id;
	private String buyer;
	private String sunglasses_num;
	private String sunglasses_name;
	private int sunglasses_price;
	private int sunglasses_count;
	private String sunglasses_img;
	private Timestamp buy_date;
	private String account;
	private String delivery_name;
	private String delivery_tel;
	private String delivery_address;
	private String sanction;
	
	public BuyVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuyVo(int buy_id, String buyer, String sunglasses_num, String sunglasses_name, int sunglasses_price,
			int sunglasses_count, String sunglasses_img, Timestamp buy_date, String account, String delivery_name,
			String delivery_tel, String delivery_address, String sanction) {
		super();
		this.buy_id = buy_id;
		this.buyer = buyer;
		this.sunglasses_num = sunglasses_num;
		this.sunglasses_name = sunglasses_name;
		this.sunglasses_price = sunglasses_price;
		this.sunglasses_count = sunglasses_count;
		this.sunglasses_img = sunglasses_img;
		this.buy_date = buy_date;
		this.account = account;
		this.delivery_name = delivery_name;
		this.delivery_tel = delivery_tel;
		this.delivery_address = delivery_address;
		this.sanction = sanction;
	}

	public int getBuy_id() {
		return buy_id;
	}

	public void setBuy_id(int buy_id) {
		this.buy_id = buy_id;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getSunglasses_num() {
		return sunglasses_num;
	}

	public void setSunglasses_num(String sunglasses_num) {
		this.sunglasses_num = sunglasses_num;
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

	public Timestamp getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(Timestamp buy_date) {
		this.buy_date = buy_date;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDelivery_name() {
		return delivery_name;
	}

	public void setDelivery_name(String delivery_name) {
		this.delivery_name = delivery_name;
	}

	public String getDelivery_tel() {
		return delivery_tel;
	}

	public void setDelivery_tel(String delivery_tel) {
		this.delivery_tel = delivery_tel;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public String getSanction() {
		return sanction;
	}

	public void setSanction(String sanction) {
		this.sanction = sanction;
	}

	@Override
	public String toString() {
		return "BuyVo [buy_id=" + buy_id + ", buyer=" + buyer + ", sunglasses_num=" + sunglasses_num
				+ ", sunglasses_name=" + sunglasses_name + ", sunglasses_price=" + sunglasses_price
				+ ", sunglasses_count=" + sunglasses_count + ", sunglasses_img=" + sunglasses_img + ", buy_date="
				+ buy_date + ", account=" + account + ", delivery_name=" + delivery_name + ", delivery_tel="
				+ delivery_tel + ", delivery_address=" + delivery_address + ", sanction=" + sanction + "]";
	}

	
	
}
