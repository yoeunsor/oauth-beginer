/**
 * 
 */
package com.sokkheang.huo.common.dto;

/**
 * @author Sokkheang Huo
 * @version Id: 
 */

public class Foo {
	private long id;
    private String name;
    
    public Foo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Foo(final long id, final String name) {
        super();
        this.id = id;
        this.name = name;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Foo [id=" + id + ", name=" + name + "]";
	}
	
    
}
