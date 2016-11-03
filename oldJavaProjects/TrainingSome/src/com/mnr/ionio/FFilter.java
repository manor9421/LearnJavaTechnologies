package com.mnr.ionio;

import java.io.File;
import java.io.FilenameFilter;

public class FFilter implements FilenameFilter {

	String findName;
	
	public FFilter(String s) {
		this.findName = "." + s;
	}
	
	// return true if file if *.findName
	@Override
	public boolean accept(File dir, String name) {
		
		return name.endsWith(findName);
		
	}

}
