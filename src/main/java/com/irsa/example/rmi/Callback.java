package com.irsa.example.rmi;

import java.io.Serializable;
import java.util.Date;

public interface Callback extends Serializable{
	public void onReceiveTime(Date date);
}
