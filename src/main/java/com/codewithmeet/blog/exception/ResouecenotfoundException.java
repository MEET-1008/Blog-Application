package com.codewithmeet.blog.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResouecenotfoundException extends RuntimeException {

	String recourcename;
	String fildname;
	int fildvale;	
	public ResouecenotfoundException(String recourcename, String fildname, int fildvale) {
		super(String.format("%s is not found whith %s : %s", recourcename, fildname, fildvale));
		this.recourcename = recourcename;
		this.fildname = fildname;
		this.fildvale = fildvale;
	}

}
