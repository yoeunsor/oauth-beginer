package com.sokkheang.huo.common.utils;

@SuppressWarnings("unused")
public class Page extends Paging{

	private String fullname;
	private boolean enabled;

	public Page() {
		super();
	}

	public Page(String fullname, boolean enabled) {
		super();
		this.fullname = fullname;
		this.enabled = enabled;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Page [fullname=" + fullname + ", enabled=" + enabled + "]";
	}

	
	
}
