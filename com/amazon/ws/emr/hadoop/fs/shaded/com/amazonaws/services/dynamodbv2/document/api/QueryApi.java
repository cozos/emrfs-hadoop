package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.QueryFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.RangeKeyCondition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import java.util.Map;

@ThreadSafe
public abstract interface QueryApi
{
  public abstract ItemCollection<QueryOutcome> query(String paramString, Object paramObject);
  
  public abstract ItemCollection<QueryOutcome> query(KeyAttribute paramKeyAttribute);
  
  public abstract ItemCollection<QueryOutcome> query(KeyAttribute paramKeyAttribute, RangeKeyCondition paramRangeKeyCondition);
  
  public abstract ItemCollection<QueryOutcome> query(String paramString, Object paramObject, RangeKeyCondition paramRangeKeyCondition);
  
  public abstract ItemCollection<QueryOutcome> query(KeyAttribute paramKeyAttribute, RangeKeyCondition paramRangeKeyCondition, QueryFilter... paramVarArgs);
  
  public abstract ItemCollection<QueryOutcome> query(String paramString, Object paramObject, RangeKeyCondition paramRangeKeyCondition, QueryFilter... paramVarArgs);
  
  public abstract ItemCollection<QueryOutcome> query(KeyAttribute paramKeyAttribute, RangeKeyCondition paramRangeKeyCondition, String paramString, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract ItemCollection<QueryOutcome> query(String paramString1, Object paramObject, RangeKeyCondition paramRangeKeyCondition, String paramString2, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract ItemCollection<QueryOutcome> query(KeyAttribute paramKeyAttribute, RangeKeyCondition paramRangeKeyCondition, String paramString1, String paramString2, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract ItemCollection<QueryOutcome> query(String paramString1, Object paramObject, RangeKeyCondition paramRangeKeyCondition, String paramString2, String paramString3, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract ItemCollection<QueryOutcome> query(QuerySpec paramQuerySpec);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.QueryApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */