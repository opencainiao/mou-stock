package org.mou.stock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.mou.common.JsonUtil;
import org.mou.stock.model.Stock;

public class StockReader {

	private static String url = "http://hq.sinajs.cn/list=";

	public static List<String> readStocks(List<String> codes) {

		List<String> stocks = new ArrayList<String>();

		StringBuilder sb = new StringBuilder();
		for (String code : codes) {
			sb.append(",").append(code);
		}

		url = url + sb.substring(1);

		System.out.println(url);

		URL ur = null;

		BufferedReader reader = null;
		try {
			ur = new URL(url);
			reader = new BufferedReader(new InputStreamReader(ur.openStream(), "GBK"));
			String line;
			while ((line = reader.readLine()) != null) {
				//System.out.println(line);
				stocks.add(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return stocks;
	}
	
	public static void main(String[] args) {
		List<String> codes = new ArrayList<String>();
//		codes.add("600151");
//		codes.add("000830");
		codes.add("300012");
		List<String> stocks = StockFilter.filtStocks(codes);

		List<String> stocksInf = StockReader.readStocks(stocks);
		
		for (String stock_string : stocksInf) {
			
			Stock stock = StockFilter.readStock_Sina(stock_string);
			System.out.println(JsonUtil.getPrettyJsonStr(stock));
			System.out.println(stock_string);
		}
	}
}
