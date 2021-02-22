package com.ssafy.product;

public class DuplicateException extends Exception {

	public DuplicateException(){
		super("중복된 상태입니다.");		
	}
}
