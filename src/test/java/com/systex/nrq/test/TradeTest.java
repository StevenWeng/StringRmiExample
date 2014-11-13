package com.systex.nrq.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TradeTest {
	public static final SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMdd");
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNormal() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(Long.parseLong(String.format(
				"%.0f", 16387.0)) * 86400000);
		String tradeDay = fmtDate.format(calendar.getTime());
		assertEquals("20141113", tradeDay);
	}
	
	@Test
	public void testException() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(Long.parseLong(String.format(
				"%.0f", 0.0)) * 86400000);
		String tradeDay = fmtDate.format(calendar.getTime());
		assertEquals("19700101", tradeDay);
	}
	
	@Test
	public void testMemoryRef(){
		ConcurrentHashMap<Integer, Double> mapMemory = new ConcurrentHashMap<Integer, Double>();
		mapMemory.put(1, 11D);
		LinkedHashMap<Integer, Double> map = new LinkedHashMap<Integer, Double>();
		map.putAll(mapMemory);
		mapMemory.put(1, 111D);
		assertEquals(Double.valueOf(11D), map.get(1));
	}

}
