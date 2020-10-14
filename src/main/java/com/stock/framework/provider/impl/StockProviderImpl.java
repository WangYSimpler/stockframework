package com.stock.framework.provider.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.stock.framework.chain.ServiceChain;
import com.stock.framework.domain.Stock;
import com.stock.framework.provider.StockProvider;

public class StockProviderImpl implements StockProvider{

	public BigDecimal getStockNowPrice(String stockCode) {
		return new ServiceChain().getStockNowPrice(stockCode);
	}

	
	public BigDecimal getStockClosePrice(String stockCode) {
		return new ServiceChain().getStockClosePrice(stockCode);
	}

	
	public BigDecimal getStockOpenPrice(String stockCode) {
		return new ServiceChain().getStockOpenPrice(stockCode);
	}

	
	public Map<String, BigDecimal> getMapPrice(List<String> stockCodeList,
			String field) {
		return new ServiceChain().getMapPrice(stockCodeList, field);
	}

	
	public Stock getStockInfo(String stockCode) {
		return new ServiceChain().getStockInfo(stockCode);
	}

	
	public List<Stock> getStockInfoList(List<String> stockCodeList) {
		return new ServiceChain().getStockInfoList(stockCodeList);
	}

	
	public List<Stock> AllMarketAStock() {
		return new ServiceChain().AllMarketAStock();
	}

}
