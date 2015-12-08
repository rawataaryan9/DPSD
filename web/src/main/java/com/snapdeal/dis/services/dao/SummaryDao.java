package com.snapdeal.dis.services.dao;

import java.util.Map;

public interface SummaryDao {

    public Long get(String key, String bin);

	public Map<String, Object> getAllFields(String guid);

}
