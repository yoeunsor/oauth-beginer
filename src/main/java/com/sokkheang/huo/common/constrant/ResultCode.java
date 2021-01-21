package com.sokkheang.huo.common.constrant;

/*
 * "001","Data not found !"			
 * "002","Data found !"				
 * "003","Retrieve Data not found !"	
 * "004","Insert data failed !"		
 * "005","Update data failed !"		
 * "006","Remove failed !"			
 * 
 * @author Sokkheang
 *
 **/

public enum ResultCode {

	Not_Found			(	"001","Data not found !"			),
	Found				(	"002","Data found !"				),
	retrieve_not_fount	(	"003","Retrieve Data not found !"	),
	insert_failed		(	"004","Insert data failed !"		),
	update_failed		(	"005","Update data failed !"		),
	remove_failed		(	"006","Remove failed !"				),
	retrieved			(	"007","Retrieve successfully"		),
	inserted			(	"007","Inserted successfully"		),
	updated				(	"007","Updated successfully"		),
	removed				(	"007","Removed successfully"		),
	;
	private final String value;
	private final String description;
	
	private ResultCode(String value, String description) {
		this.value = value;
		this.description = description;
	}
	public String getValue() {
		return value;
	}
	public String getDescription() {
		return description;
	}
	
	
}
