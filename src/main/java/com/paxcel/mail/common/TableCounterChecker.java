package com.paxcel.mail.common;

import org.springframework.stereotype.Component;

@Component
public class TableCounterChecker {
	private static int LG_COUNT=0;
	private static boolean FIRST_FLAG=true;
	
	public boolean checkColumn(int i) {
		LG_COUNT+=i;
		if(LG_COUNT>12) {
			LG_COUNT=i;
			FIRST_FLAG = false;
			return false;
		}else if(FIRST_FLAG) {
			FIRST_FLAG = false;
			return false;
		}
		return true;
	}

	
	public void reSet() {
		LG_COUNT = 0;
		FIRST_FLAG=true;
	}
	

}
