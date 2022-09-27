package com.cg.farm.exception;

public class CropNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CropNotFoundException(String msg) {
		super(msg);
	}
}
