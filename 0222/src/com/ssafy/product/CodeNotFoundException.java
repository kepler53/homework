package com.ssafy.product;

public class CodeNotFoundException extends Exception {

	public CodeNotFoundException() {
		super("해당 번호의 상품은 존재하지 않습니다.");
	}
}

