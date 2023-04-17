package com.klef.jfsd.springboot.entity;

import javax.persistence.OneToMany;

public class claim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		// @Transient
		@OneToMany(mappedBy="claim")
		private List<Items> items = new ArrayList();
	}

}
