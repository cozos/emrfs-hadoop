package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Expected;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import java.util.Map;

@ThreadSafe
public abstract interface DeleteItemApi
{
  public abstract DeleteItemOutcome deleteItem(KeyAttribute... paramVarArgs);
  
  public abstract DeleteItemOutcome deleteItem(PrimaryKey paramPrimaryKey);
  
  public abstract DeleteItemOutcome deleteItem(String paramString, Object paramObject);
  
  public abstract DeleteItemOutcome deleteItem(String paramString1, Object paramObject1, String paramString2, Object paramObject2);
  
  public abstract DeleteItemOutcome deleteItem(PrimaryKey paramPrimaryKey, Expected... paramVarArgs);
  
  public abstract DeleteItemOutcome deleteItem(String paramString, Object paramObject, Expected... paramVarArgs);
  
  public abstract DeleteItemOutcome deleteItem(String paramString1, Object paramObject1, String paramString2, Object paramObject2, Expected... paramVarArgs);
  
  public abstract DeleteItemOutcome deleteItem(PrimaryKey paramPrimaryKey, String paramString, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract DeleteItemOutcome deleteItem(String paramString1, Object paramObject, String paramString2, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract DeleteItemOutcome deleteItem(String paramString1, Object paramObject1, String paramString2, Object paramObject2, String paramString3, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract DeleteItemOutcome deleteItem(DeleteItemSpec paramDeleteItemSpec);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.DeleteItemApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */