package com.test;

import java.math.BigDecimal;

import com.stock.framework.provider.StockProvider;
import com.stock.framework.provider.impl.StockProviderImpl;

public class TestPrice {
	
	public static void main(String[] args) {
		
		StockProvider impl = new StockProviderImpl();
		
		BigDecimal tradePrice = impl.getStockNowPrice("603888");
		BigDecimal closePrice = impl.getStockClosePrice("603888");
		
		//System.out.println("" + tradePrice+impl.getStockNowPrice("600000"));
		
		/*List<String> stockCodeList = new ArrayList<String>();
		stockCodeList.add("600000");
		stockCodeList.add("300170");
		stockCodeList.add("002212");
		System.out.println(impl.getMapPrice(stockCodeList , "now"));
		System.out.println(impl.getStockInfo("600000").getStockCode());
		System.out.println(impl.getStockInfoList(stockCodeList).size());
		System.out.println(impl.AllMarketAStock().size());*/
		
		while(true){
			try {
				Thread.sleep(500);
				
				tradePrice = impl.getStockNowPrice("603888");
				System.out.println("成交价" + tradePrice);
				
				// 收盘价
				System.out.println("收盘价" + closePrice);
				System.out.println("开盘价" + impl.getStockOpenPrice("603888"));
				System.out.println("----------------");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
