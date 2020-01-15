package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.TableCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.ListTablesSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesResult;

@ThreadSafe
public abstract interface ListTablesApi
{
  public abstract TableCollection<ListTablesResult> listTables();
  
  public abstract TableCollection<ListTablesResult> listTables(String paramString);
  
  public abstract TableCollection<ListTablesResult> listTables(String paramString, int paramInt);
  
  public abstract TableCollection<ListTablesResult> listTables(int paramInt);
  
  public abstract TableCollection<ListTablesResult> listTables(ListTablesSpec paramListTablesSpec);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.ListTablesApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */