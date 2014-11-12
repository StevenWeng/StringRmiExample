package com.irsa.example.rmi.impl;

import java.util.Date;
import java.util.Vector;

import com.irsa.example.rmi.Callback;
import com.irsa.example.rmi.CallbackService;

public class CallbackServiceImpl implements CallbackService {
	private Vector<Callback> callbacks;
	
	public CallbackServiceImpl() {
		callbacks = new Vector<>();
		Thread thread = new Thread(new Runnable() {
			
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
		});
		thread.start();
	}

	@Override
	public boolean registry(Callback callback) {
		return getCallbacks().add(callback);
	}

	public Vector<Callback> getCallbacks() {
		return callbacks;
	}

	

}
