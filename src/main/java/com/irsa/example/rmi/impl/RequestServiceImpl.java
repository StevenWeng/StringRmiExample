package com.irsa.example.rmi.impl;

import com.irsa.example.rmi.RequestService;

public class RequestServiceImpl implements RequestService {

	@Override
	public Double getBmi(Double height, Double weight) {
		if (height > 100) {
			height = height / 100;
		}
		return weight / (height * height);
	}

}
