package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.GetItemOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Item;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import java.util.Map;

@ThreadSafe
public abstract interface GetItemApi
{
  public abstract GetItemOutcome getItemOutcome(PrimaryKey paramPrimaryKey);
  
  public abstract GetItemOutcome getItemOutcome(KeyAttribute... paramVarArgs);
  
  public abstract GetItemOutcome getItemOutcome(String paramString, Object paramObject);
  
  public abstract GetItemOutcome getItemOutcome(String paramString1, Object paramObject1, String paramString2, Object paramObject2);
  
  public abstract GetItemOutcome getItemOutcome(PrimaryKey paramPrimaryKey, String paramString, Map<String, String> paramMap);
  
  public abstract GetItemOutcome getItemOutcome(String paramString1, Object paramObject, String paramString2, Map<String, String> paramMap);
  
  public abstract GetItemOutcome getItemOutcome(String paramString1, Object paramObject1, String paramString2, Object paramObject2, String paramString3, Map<String, String> paramMap);
  
  public abstract Item getItem(String paramString1, Object paramObject, String paramString2, Map<String, String> paramMap);
  
  public abstract Item getItem(String paramString1, Object paramObject1, String paramString2, Object paramObject2, String paramString3, Map<String, String> paramMap);
  
  public abstract GetItemOutcome getItemOutcome(GetItemSpec paramGetItemSpec);
  
  public abstract Item getItem(PrimaryKey paramPrimaryKey);
  
  public abstract Item getItem(KeyAttribute... paramVarArgs);
  
  public abstract Item getItem(String paramString, Object paramObject);
  
  public abstract Item getItem(String paramString1, Object paramObject1, String paramString2, Object paramObject2);
  
  public abstract Item getItem(PrimaryKey paramPrimaryKey, String paramString, Map<String, String> paramMap);
  
  public abstract Item getItem(GetItemSpec paramGetItemSpec);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.GetItemApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */