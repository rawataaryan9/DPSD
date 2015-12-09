package com.snapdeal.dis.convertor;

import com.snapdeal.dis.services.entity.ExpressionDO;
import com.snapdeal.dis.services.sro.ExpressionSRO;
import com.snapdeal.dis.services.entity.ExpressionDO;
import com.snapdeal.dis.services.sro.ExpressionSRO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Date;
import java.util.List;

public class ExpressionDOToSRO {
	
	public static ExpressionSRO convertDOToSRO(ExpressionDO expDO){
		
		Date createdDate = expDO.getCreatedTime();
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String createdDateStr = format.format(createdDate);
		System.out.println(expDO.getExecutionMode().toString()+" execution mode SRO "+" isdeleted "+expDO.isDeleted());
		ExpressionSRO expSRO = new ExpressionSRO(expDO.getId(), expDO.getNamespace(), expDO.getReferenceName(), expDO.getExpression(), expDO.getExecutionMode().toString(), expDO.isDeleted(), expDO.getCreatedBy(), createdDateStr);
		return expSRO;
	}
	
	public static List<ExpressionSRO> convertDOToSROList(List<ExpressionDO> ListDO){
		List<ExpressionSRO> ListSRO = new ArrayList<ExpressionSRO>();
		
		for (ExpressionDO expDO : ListDO ){
			ListSRO.add(convertDOToSRO(expDO));
		}
		
		return ListSRO;
	}
	
}
