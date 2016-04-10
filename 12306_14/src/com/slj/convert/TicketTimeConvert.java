package com.slj.convert;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;


public class TicketTimeConvert extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		
		String time = arg1[0];
		

		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date11 = null;
		try {
			date11 = df1.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String times = df1.format(date11);
		Timestamp ts = Timestamp.valueOf(time);
		System.out.println(ts +"from tickettimeconversation result");
        return ts;
	}
	
	
	
	
	
	

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
