package net.yoon.domain;

import java.sql.Timestamp;

public class ReviewVo {
	
	// fileds
	private int review_num;
	private String review_subject;
	private String review_content;
	private String review_writer;
	private String review_pass;
	private int review_read_count;
	private int review_ref;
	private int review_re_step;
	private int review_re_level;
	private Timestamp review_reg_date;
	private String review_filename;
	private String review_email;
	
	public ReviewVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewVo(int review_num, String review_subject, String review_content, String review_writer,
			String review_pass, int review_read_count, int review_ref, int review_re_step, int review_re_level,
			Timestamp review_reg_date, String review_filename, String review_email) {
		super();
		this.review_num = review_num;
		this.review_subject = review_subject;
		this.review_content = review_content;
		this.review_writer = review_writer;
		this.review_pass = review_pass;
		this.review_read_count = review_read_count;
		this.review_ref = review_ref;
		this.review_re_step = review_re_step;
		this.review_re_level = review_re_level;
		this.review_reg_date = review_reg_date;
		this.review_filename = review_filename;
		this.review_email = review_email;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public String getReview_subject() {
		return review_subject;
	}

	public void setReview_subject(String review_subject) {
		this.review_subject = review_subject;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public String getReview_writer() {
		return review_writer;
	}

	public void setReview_writer(String review_writer) {
		this.review_writer = review_writer;
	}

	public String getReview_pass() {
		return review_pass;
	}

	public void setReview_pass(String review_pass) {
		this.review_pass = review_pass;
	}

	public int getReview_read_count() {
		return review_read_count;
	}

	public void setReview_read_count(int review_read_count) {
		this.review_read_count = review_read_count;
	}

	public int getReview_ref() {
		return review_ref;
	}

	public void setReview_ref(int review_ref) {
		this.review_ref = review_ref;
	}

	public int getReview_re_step() {
		return review_re_step;
	}

	public void setReview_re_step(int review_re_step) {
		this.review_re_step = review_re_step;
	}

	public int getReview_re_level() {
		return review_re_level;
	}

	public void setReview_re_level(int review_re_level) {
		this.review_re_level = review_re_level;
	}

	public Timestamp getReview_reg_date() {
		return review_reg_date;
	}

	public void setReview_reg_date(Timestamp review_reg_date) {
		this.review_reg_date = review_reg_date;
	}

	public String getReview_filename() {
		return review_filename;
	}

	public void setReview_filename(String review_filename) {
		this.review_filename = review_filename;
	}

	public String getReview_email() {
		return review_email;
	}

	public void setReview_email(String review_email) {
		this.review_email = review_email;
	}

	@Override
	public String toString() {
		return "ReviewVo [review_num=" + review_num + ", review_subject=" + review_subject + ", review_content="
				+ review_content + ", review_writer=" + review_writer + ", review_pass=" + review_pass
				+ ", review_read_count=" + review_read_count + ", review_ref=" + review_ref + ", review_re_step="
				+ review_re_step + ", review_re_level=" + review_re_level + ", review_reg_date=" + review_reg_date
				+ ", review_filename=" + review_filename + ", review_email=" + review_email + "]";
	}
	
	
	
}
