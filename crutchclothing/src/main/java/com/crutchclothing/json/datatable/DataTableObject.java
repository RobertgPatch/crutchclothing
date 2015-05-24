package com.crutchclothing.json.datatable;

import java.util.List;

import com.crutchclothing.users.model.User;

public class DataTableObject<T> implements java.io.Serializable{
	private static final long serialVersionUID = -8220588043068200705L;
	private List<T> aaData;
	private int sEcho;
	private Integer iTotalRecords;
	private Integer iTotalDisplayRecords;

	public DataTableObject(){
	}
	
	public List<T> getAaData() {
		return this.aaData;
	}
	
	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}

	public int getSecho() {
		return this.sEcho;
	}
	
	public void setSecho(int sEcho) {
		this.sEcho = sEcho;
	}
	
	public Integer getItotalRecords() {
		return this.iTotalRecords;
	}
	
	public void setItotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	
	public Integer getItotalDisplayRecords() {
		return this.iTotalDisplayRecords;
	}
	
	public void setItotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
} 

