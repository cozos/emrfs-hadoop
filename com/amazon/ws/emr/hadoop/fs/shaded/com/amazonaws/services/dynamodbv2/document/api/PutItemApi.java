package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Expected;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Item;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import java.util.Map;

@ThreadSafe
public abstract interface PutItemApi
{
  public abstract PutItemOutcome putItem(Item paramItem);
  
  public abstract PutItemOutcome putItem(Item paramItem, Expected... paramVarArgs);
  
  public abstract PutItemOutcome putItem(Item paramItem, String paramString, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract PutItemOutcome putItem(PutItemSpec paramPutItemSpec);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.PutItemApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */