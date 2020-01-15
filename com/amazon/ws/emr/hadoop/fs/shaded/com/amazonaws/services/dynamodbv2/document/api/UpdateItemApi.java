package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.AttributeUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Expected;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import java.util.Collection;
import java.util.Map;

@ThreadSafe
public abstract interface UpdateItemApi
{
  public abstract UpdateItemOutcome updateItem(PrimaryKey paramPrimaryKey, AttributeUpdate... paramVarArgs);
  
  public abstract UpdateItemOutcome updateItem(String paramString, Object paramObject, AttributeUpdate... paramVarArgs);
  
  public abstract UpdateItemOutcome updateItem(String paramString1, Object paramObject1, String paramString2, Object paramObject2, AttributeUpdate... paramVarArgs);
  
  public abstract UpdateItemOutcome updateItem(PrimaryKey paramPrimaryKey, Collection<Expected> paramCollection, AttributeUpdate... paramVarArgs);
  
  public abstract UpdateItemOutcome updateItem(String paramString, Object paramObject, Collection<Expected> paramCollection, AttributeUpdate... paramVarArgs);
  
  public abstract UpdateItemOutcome updateItem(String paramString1, Object paramObject1, String paramString2, Object paramObject2, Collection<Expected> paramCollection, AttributeUpdate... paramVarArgs);
  
  public abstract UpdateItemOutcome updateItem(PrimaryKey paramPrimaryKey, String paramString, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract UpdateItemOutcome updateItem(String paramString1, Object paramObject, String paramString2, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract UpdateItemOutcome updateItem(String paramString1, Object paramObject1, String paramString2, Object paramObject2, String paramString3, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract UpdateItemOutcome updateItem(PrimaryKey paramPrimaryKey, String paramString1, String paramString2, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract UpdateItemOutcome updateItem(String paramString1, Object paramObject, String paramString2, String paramString3, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract UpdateItemOutcome updateItem(String paramString1, Object paramObject1, String paramString2, Object paramObject2, String paramString3, String paramString4, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract UpdateItemOutcome updateItem(UpdateItemSpec paramUpdateItemSpec);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.UpdateItemApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */