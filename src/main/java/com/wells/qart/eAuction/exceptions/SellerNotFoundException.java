package com.wells.qart.eAuction.exceptions;

public class SellerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SellerNotFoundException() {
		super();
	}

	public SellerNotFoundException(String message) {
		super(message);
	}

}
