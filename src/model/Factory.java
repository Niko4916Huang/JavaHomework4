package model;

import java.io.Serializable;

public class Factory   implements Serializable {
	Integer id;
	String Factoryno;
	String Factoryname;
	
	public Factory(String factoryno, String factoryname) {
		super();
		Factoryno = factoryno;
		Factoryname = factoryname;
	}

	public Factory() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFactoryno() {
		return Factoryno;
	}

	public void setFactoryno(String factoryno) {
		Factoryno = factoryno;
	}

	public String getFactoryname() {
		return Factoryname;
	}

	public void setFactoryname(String factoryname) {
		Factoryname = factoryname;
	}

	

}
