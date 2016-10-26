package com.lyt.date;

import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
  
  
public class DateTest { 
	/**
	 * 计算订单倒计时操作时间差
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static String dateDiff(Date startTime, Date endTime){
		long nd = 1000 * 24 * 60 * 60;//一天的毫秒数
		long nh = 1000 * 60 * 60;//一小时的毫秒数
		long nm = 1000 * 60;//一分钟的毫秒数
		//获得两个时间的毫秒时间差异
		long diff = endTime.getTime() - startTime.getTime();
		if(diff <= 0){
			return "已经过期";
		}
		long day = diff / nd;//计算差多少天
		long hour = diff % nd / nh;//计算差多少小时
		long min = diff % nd % nh / nm;//计算差多少分钟
		String ret = "";
		if(day > 0){
			ret += day + "天";
		}else {
			if(hour > 0){
				ret += hour + "时";
				if(min > 0){
					ret += min + "分";
				}
			}else{
				if(min > 0 ){
					ret += min + "分";
				}
			}
		}
		return ret;
	}
	
    public static void main(String[] args) throws ParseException {  
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
    	Date d = null;
        try {
        	format.setLenient(false); // 指定日期\时间解析是否不严格
			d = format.parse("30/12/2011");
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println(d);  //这是原型输出Date
        System.out.println(format.format(d));  //再一次转换就成了   30/12/2011
        
        
        try {
        	String date = "2015-10-10 10:10:10";
        	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        	Date ticDate = new Date();
        	ticDate = sim.parse(date);
        	System.out.println(ticDate.toLocaleString());//2015-10-10 0:00:00
        } catch (Exception e) {
        	
        }
    }  
    
    
    
} 