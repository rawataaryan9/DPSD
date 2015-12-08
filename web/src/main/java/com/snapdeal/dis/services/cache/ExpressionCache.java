package com.snapdeal.dis.services.cache;

/**
 * Created by kanuj on 19/11/15.
 */

import com.snapdeal.base.annotations.Cache;

import java.util.HashMap;
import java.util.Map;

@Cache(name = "expressionCache")
public class ExpressionCache {
    public Map<String, Integer> expressionMap = new HashMap<>();


    public void loadExpression(String name, Integer id) {
        expressionMap.put(name, id);
    }


    public Integer getExpressionIdByName(String expressionName) {
        return expressionMap.get(expressionName);
    }

}
