package com.project.SmartStay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String email;
	int Otp;
	String name;
	String sur_name;
	String gender;
	long adhar;
	String address;
	String pass;
	String confirm_pass;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int id, String email, int otp, String name, String sur_name, String gender, long adhar, String address,
			String pass, String confirm_pass) {
		super();
		this.id = id;
		this.email = email;
		Otp = otp;
		this.name = name;
		this.sur_name = sur_name;
		this.gender = gender;
		this.adhar = adhar;
		this.address = address;
		this.pass = pass;
		this.confirm_pass = confirm_pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getOtp() {
		return Otp;
	}
	public void setOtp(int otp) {
		Otp = otp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSur_name() {
		return sur_name;
	}
	public void setSur_name(String sur_name) {
		this.sur_name = sur_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getAdhar() {
		return adhar;
	}
	public void setAdhar(long adhar) {
		this.adhar = adhar;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getConfirm_pass() {
		return confirm_pass;
	}
	public void setConfirm_pass(String confirm_pass) {
		this.confirm_pass = confirm_pass;
	}

	
	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", Otp=" + Otp + ", name=" + name + ", sur_name=" + sur_name
				+ ", gender=" + gender + ", adhar=" + adhar + ", address=" + address + ", pass=" + pass
				+ ", confirm_pass=" + confirm_pass + "]";
	}
	
}
