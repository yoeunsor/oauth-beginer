package com.sokkheang.huo.common.api.common.model;

public class Country {
	
	private int id;
	private String countrycode;
	private String countryname;
	private String statuscode;

	public Country() {
	}

	public Country(int id, String countrycode, String countryname, String statuscode) {
		this.id = id;
		this.countrycode = countrycode;
		this.countryname = countryname;
		this.statuscode = statuscode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}

	@Override
	public String toString() {
		return "Country{" +
				"id=" + id +
				", countrycode='" + countrycode + '\'' +
				", countryname='" + countryname + '\'' +
				", statuscode='" + statuscode + '\'' +
				'}';
	}
}
