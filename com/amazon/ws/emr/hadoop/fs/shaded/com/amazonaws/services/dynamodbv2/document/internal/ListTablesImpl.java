package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.TableCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.ListTablesApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.ListTablesSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesResult;

public class ListTablesImpl
  implements ListTablesApi
{
  private final AmazonDynamoDB client;
  
  public ListTablesImpl(AmazonDynamoDB client)
  {
    this.client = client;
  }
  
  public TableCollection<ListTablesResult> listTables(ListTablesSpec spec)
  {
    return doList(spec);
  }
  
  public TableCollection<ListTablesResult> listTables()
  {
    return doList(new ListTablesSpec());
  }
  
  public TableCollection<ListTablesResult> listTables(String exclusiveStartTableName)
  {
    return doList(new ListTablesSpec()
      .withExclusiveStartTableName(exclusiveStartTableName));
  }
  
  public TableCollection<ListTablesResult> listTables(String exclusiveStartTableName, int maxResultSize)
  {
    return doList(new ListTablesSpec()
      .withExclusiveStartTableName(exclusiveStartTableName)
      .withMaxResultSize(maxResultSize));
  }
  
  public TableCollection<ListTablesResult> listTables(int maxResultSize)
  {
    return doList(new ListTablesSpec()
      .withMaxResultSize(maxResultSize));
  }
  
  private TableCollection<ListTablesResult> doList(ListTablesSpec spec)
  {
    return new ListTablesCollection(client, spec);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.ListTablesImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */