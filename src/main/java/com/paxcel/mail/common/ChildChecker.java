package com.paxcel.mail.common;

import org.springframework.stereotype.Component;

@Component
public class ChildChecker {

	public boolean checkChild(int children) {
		// TODO Auto-generated method stub
		return  children>0 ? true : false;
	}

	
}
