package com.paxcel.mail.common;

import org.springframework.stereotype.Component;

@Component
public class ChildChecker {

	public boolean checkChild(int children) {
		return  children>0 ? true : false;
	}

	
}
