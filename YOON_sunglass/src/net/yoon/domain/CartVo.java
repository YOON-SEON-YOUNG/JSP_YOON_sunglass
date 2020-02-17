package net.yoon.domain;

public class CartVo {
	private int cart_id;
	private String buyer;
	private int sunglasses_num;
	private String sunglasses_name;
	private int buy_price;
	private int buy_count;
	private String sunglasses_img;
	
	public CartVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartVo(int cart_id, String buyer, int sunglasses_num, String sunglasses_name, int buy_price, int buy_count,
			String sunglasses_img) {
		super();
		this.cart_id = cart_id;
		this.buyer = buyer;
		this.sunglasses_num = sunglasses_num;
		this.sunglasses_name = sunglasses_name;
		this.buy_price = buy_price;
		this.buy_count = buy_count;
		this.sunglasses_img = sunglasses_img;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public int getSunglasses_num() {
		return sunglasses_num;
	}

	public void setSunglasses_num(int sunglasses_num) {
		this.sunglasses_num = sunglasses_num;
	}

	public String getSunglasses_name() {
		return sunglasses_name;
	}

	public void setSunglasses_name(String sunglasses_name) {
		this.sunglasses_name = sunglasses_name;
	}

	public int getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(int buy_price) {
		this.buy_price = buy_price;
	}

	public int getBuy_count() {
		return buy_count;
	}

	public void setBuy_count(int buy_count) {
		this.buy_count = buy_count;
	}

	public String getSunglasses_img() {
		return sunglasses_img;
	}

	public void setSunglasses_img(String sunglasses_img) {
		this.sunglasses_img = sunglasses_img;
	}

	@Override
	public String toString() {
		return "CartVo [cart_id=" + cart_id + ", buyer=" + buyer + ", sunglasses_num=" + sunglasses_num
				+ ", sunglasses_name=" + sunglasses_name + ", buy_price=" + buy_price + ", buy_count=" + buy_count
				+ ", sunglasses_img=" + sunglasses_img + "]";
	}
	
	
	
}
