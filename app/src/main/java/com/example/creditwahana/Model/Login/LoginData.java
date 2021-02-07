package com.example.creditwahana.Model.Login;

import com.google.gson.annotations.SerializedName;

public class LoginData {

	@SerializedName("jabatan")
	private String jabatan;

	@SerializedName("name")
	private String name;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("username")
	private String username;

	public void setJabatan(String jabatan){
		this.jabatan = jabatan;
	}

	public String getJabatan(){
		return jabatan;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}