package com.lyt.date;

import java.util.Calendar;

import org.apache.commons.lang.time.DateFormatUtils;

/** 
 * @Title: LoopDate.java 
 * @Package com.lyt.date 
 * @Description: TODO
 * @author 李银涛
 * @date 2016年10月31日 下午3:04:01 
 * @version V1.0 
 */
public class LoopDate {

	public static void main(String[] args) {
		Calendar reportCalendar = Calendar.getInstance();  
        reportCalendar.set(2015, 3, 1);  //从20150401开始
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.set(2015, 3, 10); //到20150410结束
        while(reportCalendar.compareTo(endCalendar)<=0){
            String reportDate = DateFormatUtils.format(reportCalendar.getTime(), "yyyyMMdd");
            System.out.println(reportDate);
            reportCalendar.add(Calendar.DATE, 1);
        }
	}

}

