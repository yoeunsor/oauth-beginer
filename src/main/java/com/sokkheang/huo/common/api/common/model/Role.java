package com.sokkheang.huo.common.api.common.model;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String role;
	private String statuscode;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String role, String statuscode) {
		super();
		this.id = id;
		this.role = role;
		this.statuscode = statuscode;
	}

	public Role(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Role(int id) {
		super();
		this.id = id;
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getstatuscode() {
		return statuscode;
	}

	public void setstatuscode(String statuscode) {
		this.statuscode = statuscode;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", statuscode=" + statuscode + "]";
	}

	@Override
	public String getAuthority() {
		return role;
	}
}
