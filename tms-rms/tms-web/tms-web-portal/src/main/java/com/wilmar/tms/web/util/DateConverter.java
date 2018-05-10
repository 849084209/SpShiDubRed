package com.wilmar.tms.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.alibaba.dubbo.common.utils.StringUtils;

public class DateConverter implements Converter<String, Date> {
	
	@Override
	public Date convert(String source) {
//		System.out.println("DateConverter==>>convert==>>" + source);
		if (StringUtils.isBlank(source)){
			return null;
		}
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			try {
				Long time = new Long(source);
				String d = format.format(time);
				date = format.parse(d);
//				System.out.println("Format To String(Date):" + d);
			} catch (Exception e) {
				date = format.parse(source);
			}
//			System.out.println("Format To Date:" + date);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
