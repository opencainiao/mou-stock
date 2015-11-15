package org.mou.stock;

import java.util.ArrayList;
import java.util.List;

import org.mou.common.JsonUtil;
import org.mou.common.StringUtil;
import org.mou.stock.model.Stock;

public class StockFilter {

	/****
	 * 处理一个股票代码，加代码
	 * 
	 * @param code
	 * @return
	 */
	public static String filtStock(String code) {

		if (StringUtil.isEmpty(code)) {
			throw new RuntimeException("股票代码是空，请确认！");
		}
		if (code.length() == 6) {
			if (code.startsWith("60")) {
				return "sh" + code;
			} else if (code.startsWith("00")) {
				return "sz" + code;
			} else if (code.startsWith("30")) {
				return "sz" + code;
			} else {
				throw new RuntimeException("错误的股票代码");
			}
		} else {
			return code;
		}
	}

	/****
	 * 对股票代码组进行前缀编码
	 * 
	 * @param codes
	 * @return
	 */
	public static List<String> filtStocks(List<String> codes) {
		if (codes == null || codes.isEmpty()) {
			throw new RuntimeException("股票代码列表是空，不能处理，请确认！");
		}

		List<String> rtnList = new ArrayList<String>();
		for (String code : codes) {
			rtnList.add(filtStock(code));
		}

		System.out.println(JsonUtil.getPrettyJsonStr(rtnList));
		return rtnList;
	}

	/****
	 * 解析股票数据对象<br>
	 * var hq_str_sz300012=
	 * "华测检测,23.550,23.980,22.720,23.580,22.280,22.720,22.730,12693975,292267432.750,37600,22.720,3900,22.710,17800,22.700,1000,22.690,3500,22.680,40800,22.730,2200,22.740,7900,22.750,4000,22.760,5400,22.790,2015-11-13,15:34:15,00";
	 * 
	 * @param str
	 * @return
	 */
	public static Stock readStock_Sina(String str) {
		
		Stock stock = new Stock();
		
		String[] segs = str.split("=\"");
		String name_seg = segs[0];
		String data_seg = segs[1];
		String[] data = data_seg.split(",");
		// System.out.println(name_seg);
		 System.out.println(data_seg);
		
		stock.setCode(name_seg.substring(name_seg.lastIndexOf("_") + 1));
		stock.setName(data[0]);
		

		return stock;
	}
}
