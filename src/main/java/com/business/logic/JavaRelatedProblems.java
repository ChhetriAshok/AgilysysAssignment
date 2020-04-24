/**
 * 
 */
package com.business.logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * @author :Ramu Chhetri
 *
 */
public class JavaRelatedProblems {
		
	public String incrementHoursAndMinsInDate(Date date,int hourToAdd,int minsToAdd)
	{
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hourToAdd);
		cal.add(Calendar.MINUTE, minsToAdd);
		
		return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(cal.getTime());
	}
	
	public long getCount(long []arr,long num_to_search)
	{
		ArrayList<Long> num_list=new ArrayList<>();
		for(long num:arr)
			num_list.add(num);	
		
		return	num_list.stream().filter(i->i.equals(num_to_search)).count();
			
	}	
}	
