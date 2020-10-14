package com.stock.framework.chain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.stock.framework.domain.Constants;
import com.stock.framework.domain.Stock;
import com.stock.framework.service.StockService;
import com.stock.framework.service.impl.HsStockService;
import com.stock.framework.service.impl.QTStockService;
import com.stock.framework.service.impl.SinaStockService;
import com.stock.framework.service.impl.WYStockService;

public class ServiceChain {
	
	private static final String[] arr = Constants.oneSort.split(",");//配置调用顺序
	private static final HsStockService 	hsStockServiceObj 	= new HsStockService(); 
	private static final QTStockService 	qtStockServiceObj 	= new QTStockService();
	private static final WYStockService 	wyStockServiceObj 	= new WYStockService();
	private static final SinaStockService   sinaStockServiceObj = new SinaStockService();
	
	private StockService getSortStockService(String stockCode,String[] fieldArray){
		
		for(String sort :fieldArray){
			
			if(sort.equals("1")||sort.equals("HS")||sort.equals("hs")){
			
				if (null != hsStockServiceObj.getStockNowPrice(stockCode)){
					return   hsStockServiceObj;
				}
			}
			
			if(sort.equals("2")||sort.equals("QT")||sort.equals("qt")){
				if (null != qtStockServiceObj.getStockNowPrice(stockCode)){
					return   qtStockServiceObj;
				}
			}
			
			if(sort.equals("3")||sort.equals("WY")||sort.equals("wy")){
				if (null != wyStockServiceObj.getStockNowPrice(stockCode)){
					return   wyStockServiceObj;
				}
			}
			
			if(sort.equals("4")||sort.equals("SINA")||sort.equals("sina")){
				if (null != sinaStockServiceObj.getStockNowPrice(stockCode)){
					return  sinaStockServiceObj;
				}
			}
		}
		return null;
	}
	
	//获取股票
	public BigDecimal getStockNowPrice(String stockCode) {
	
		BigDecimal nowPrice = this.getSortStockService(stockCode, arr).getStockNowPrice(stockCode);
		return nowPrice;
		
		 /*BigDecimal nowPrice = null;
		  for(String sort :arr){
			if(sort.equals("1")||sort.equals("HS")||sort.equals("hs")){
				nowPrice=hsStockServiceObj.getStockNowPrice(stockCode);
				if(nowPrice!=null){
					return nowPrice;
				}
			}
			
			if(sort.equals("2")||sort.equals("QT")||sort.equals("qt")){
				nowPrice=qtStockServiceObj.getStockNowPrice(stockCode);
				if(nowPrice!=null){
					return nowPrice;
				}
			}
			
			if(sort.equals("3")||sort.equals("WY")||sort.equals("wy")){
				nowPrice=new WYStockService().getStockNowPrice(stockCode);
				if(nowPrice!=null){
					return nowPrice;
				}
			}
		}
		return null ;*/
		
	}

	public BigDecimal getStockClosePrice(String stockCode) {
		
		BigDecimal closePrice = this.getSortStockService(stockCode,arr).getStockYesPrice(stockCode);
		return closePrice;
		
		//String[] arr = Constants.oneSort.split(",");//配置调用顺序
		/*BigDecimal nowPrice =null;
		for(String sort :arr){
			if(sort.equals("1")||sort.equals("HS")||sort.equals("hs")){
				nowPrice=new HsStockService().getStockYesPrice(stockCode);
				if(nowPrice!=null){
					return nowPrice;
				}
			}
			
			if(sort.equals("2")||sort.equals("QT")||sort.equals("qt")){
				nowPrice=new QTStockService().getStockYesPrice(stockCode);
				if(nowPrice!=null){
					return nowPrice;
				}
			}
			
			if(sort.equals("3")||sort.equals("WY")||sort.equals("wy")){
				nowPrice=new WYStockService().getStockYesPrice(stockCode);
				if(nowPrice!=null){
					return nowPrice;
				}
			}
		}
		return null;*/
	}

	public BigDecimal getStockOpenPrice(String stockCode) {
		
		BigDecimal openPrice = this.getSortStockService(stockCode,arr).getStockOpenPrice(stockCode);
		return openPrice;
		//String[] arr = Constants.oneSort.split(",");//配置调用顺序
		/*BigDecimal nowPrice =null;
		for(String sort :arr){
			if(sort.equals("1")||sort.equals("HS")||sort.equals("hs")){
				nowPrice=new HsStockService().getStockOpenPrice(stockCode);
				if(nowPrice!=null){
					return nowPrice;
				}
			}
			
			if(sort.equals("2")||sort.equals("QT")||sort.equals("qt")){
				nowPrice=new QTStockService().getStockOpenPrice(stockCode);
				if(nowPrice!=null){
					return nowPrice;
				}
			}
			
			if(sort.equals("3")||sort.equals("WY")||sort.equals("wy")){
				nowPrice=new WYStockService().getStockOpenPrice(stockCode);
				if(nowPrice!=null){
					return nowPrice;
				}
			}
		}
		return null;*/
		
	}

	public Map<String, BigDecimal> getMapPrice(List<String> stockCodeList,
			String field) {
		//String[] arr = Constants.oneSort.split(",");//配置调用顺序
		Map<String, BigDecimal> map =null;
		for(String sort :arr){
			if(sort.equals("1")||sort.equals("HS")||sort.equals("hs")){
				map=new HsStockService().getMapPrice(stockCodeList,field);
				if(map!=null&&!map.isEmpty()){
					return map;
				}
			}
			
			if(sort.equals("2")||sort.equals("QT")||sort.equals("qt")){
				map=new QTStockService().getMapPrice(stockCodeList,field);
				if(map!=null&&!map.isEmpty()){
					return map;
				}
			}
			
			if(sort.equals("3")||sort.equals("WY")||sort.equals("wy")){
				map=new WYStockService().getMapPrice(stockCodeList,field);
				if(map!=null&&!map.isEmpty()){
					return map;
				}
			}
		}
		return null;
	}

	public Stock getStockInfo(String stockCode) {
		//String[] arr = Constants.oneSort.split(",");//配置调用顺序
		Stock stock =null;
		for(String sort :arr){
			if(sort.equals("1")||sort.equals("HS")||sort.equals("hs")){
				stock=new HsStockService().getStockInfo(stockCode);
				if(stock!=null){
					return stock;
				}
			}
			
			if(sort.equals("2")||sort.equals("QT")||sort.equals("qt")){
				stock=new QTStockService().getStockInfo(stockCode);
				if(stock!=null){
					return stock;
				}
			}
			
			if(sort.equals("3")||sort.equals("WY")||sort.equals("wy")){
				stock=new WYStockService().getStockInfo(stockCode);
				if(stock!=null){
					return stock;
				}
			}
		}
		return null;
	}

	public List<Stock> getStockInfoList(List<String> stockCodeList) {
		//String[] arr = Constants.oneSort.split(",");//配置调用顺序
		List<Stock> list =null;
		for(String sort :arr){
			if(sort.equals("1")||sort.equals("HS")||sort.equals("hs")){
				list=new HsStockService().getStockInfoList(stockCodeList);
				if(list!=null&&!list.isEmpty()){
					return list;
				}
			}
			
			if(sort.equals("2")||sort.equals("QT")||sort.equals("qt")){
				list=new QTStockService().getStockInfoList(stockCodeList);
				if(list!=null&&!list.isEmpty()){
					return list;
				}
			}
			
			if(sort.equals("3")||sort.equals("WY")||sort.equals("wy")){
				list=new WYStockService().getStockInfoList(stockCodeList);
				if(list!=null&&!list.isEmpty()){
					return list;
				}
			}
		}
		return null;
	}

	public List<Stock> AllMarketAStock() {
		//String[] arr = Constants.allSort.split(",");//配置调用顺序
		List<Stock> list =null;
		for(String sort :arr){
			if(sort.equals("1")||sort.equals("HS")||sort.equals("hs")){
				list=new HsStockService().AllMarketAStock();
				if(list!=null&&!list.isEmpty()){
					return list;
				}
			}
			
			if(sort.equals("2")||sort.equals("QT")||sort.equals("qt")){
				list=new QTStockService().AllMarketAStock();
				if(list!=null&&!list.isEmpty()){
					return list;
				}
			}
			
			if(sort.equals("3")||sort.equals("WY")||sort.equals("wy")){
				list=new WYStockService().AllMarketAStock();
				if(list!=null&&!list.isEmpty()){
					return list;
				}
			}
			
			if(sort.equals("4")||sort.equals("SINA")||sort.equals("sina")){
				list=new SinaStockService().AllMarketAStock();
				if(list!=null&&!list.isEmpty()){
					return list;
				}
			}
		}
		return null;
	}
}
