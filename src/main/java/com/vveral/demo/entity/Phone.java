package com.vveral.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="phones")
public class Phone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idphone")
	private Long id;
	
	@ManyToOne()
    @JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@Column
	String number;
	
	@Column
	int citycode;
	
	@Column
	int countrycode;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getCitycode() {
		return citycode;
	}
	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}
	public int getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}
	
}
