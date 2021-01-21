package com.sokkheang.huo.common.api.common.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User_Client implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	@NotEmpty(message = "{validation.firstname}")
    private String firstname;
	
	@NotEmpty(message = "{validation.lastname}")
    private String lastname;
	
	@Size(max = 6, min = 4, message = "{validation.gender}")
    private String gender;
	
	@NotEmpty(message = "{validation.username}")
    private String username;
	
	@NotEmpty(message = "{validation.password}")
    private String password;
	
	@Size(max = 10, min = 9, message = "{validation.telephone}")
    private String telephone;
	
	@Email(message = "{validation.email}")
    private String email;
	
	@NotEmpty(message = "{validation.dateofbirth}")
    private String dateofbirth;
	
	@NotEmpty(message = "{validation.registerdate}")
    private String registerdate;
	
	private boolean enabled;
	
	private List<Country> countries;
	
    private List<Role> roles;
    
    private List<Language> languages;
    
    private List<Image> images;
    
	public User_Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User_Client(int id, String firstname, String lastname, String gender, String username, String password,
			String telephone, String email, String dateofbirth, String registerdate, boolean enabled,
			List<Country> countries, List<Role> roles, List<Language> languages, List<Image> images) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.email = email;
		this.dateofbirth = dateofbirth;
		this.registerdate = registerdate;
		this.enabled = enabled;
		this.countries = countries;
		this.roles = roles;
		this.languages = languages;
		this.images = images;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Language> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User_Client [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", username=" + username + ", password=" + password + ", telephone=" + telephone + ", email=" + email
				+ ", dateofbirth=" + dateofbirth + ", registerdate=" + registerdate + ", enabled=" + enabled
				+ ", countries=" + countries + ", roles=" + roles + ", languages=" + languages + ", images=" + images
				+ "]";
	}
}
