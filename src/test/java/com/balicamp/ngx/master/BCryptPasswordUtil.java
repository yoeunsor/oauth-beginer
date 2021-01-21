/**
 * 
 */
package com.balicamp.ngx.master;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author <a href="mailto:bagus.sugitayasa@sigma.co.id">GusdeGita</a>
 * @version Id: 
 */
public class BCryptPasswordUtil {
	
	//public static void main(String[] args) {
	public static void main() {
		String pass = "sigma123";
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		
		String hashPwd = bc.encode(pass);
		System.out.println("BCrypt : " + hashPwd);
	}
}
