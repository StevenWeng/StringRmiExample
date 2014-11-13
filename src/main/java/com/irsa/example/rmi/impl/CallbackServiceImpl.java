package com.irsa.example.rmi.impl;

import java.util.Date;
import java.util.Vector;

import com.irsa.example.rmi.Callback;
import com.irsa.example.rmi.CallbackService;

public class CallbackServiceImpl extends Thread implements CallbackService {
	private Vector<Callback> callbacks;
	
	public CallbackServiceImpl() {
		callbacks = new Vector<>();
	}
	
	

	@Override
	public void run() {
		while (true) {
			try {
				Date now = new Date();
				for (Callback callback : getCallbacks()) {
					callback.onReceiveTime(now);
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



	@Override
	public boolean registry(Callback callback) {
		return getCallbacks().add(callback);
	}

	public Vector<Callback> getCallbacks() {
		return callbacks;
	}

	

}
