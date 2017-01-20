package com.test.springBoot.form;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class PhoneForm {
	@NotEmpty(message="id請勿空白")
	@Length(min=3,message="id長度請超過3")
	private String phoneId;
	
	@NotEmpty(message="名字請勿空白")
	private String phoneName;
	//
	@NotEmpty()
	@Min(value=9999,message="phonePrice.min")
	private String phonePrice;
	
	public String getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}
	public String getPhoneName() {
		return phoneName;
	}
	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}
	public String getPhonePrice() {
		return phonePrice;
	}
	public void setPhonePrice(String phonePrice) {
		this.phonePrice = phonePrice;
	}
	
}
