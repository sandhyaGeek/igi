package com.odx.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// This is the entity class mapped to the table demo
@Entity
@Table(name="demo")
public class Demo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
    Long id;
	
	@Column(name="name")
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Demo(String longPalindrome) {
		super();
		this.name = longPalindrome;
	}
	public Demo() {
		super();
	}
}
