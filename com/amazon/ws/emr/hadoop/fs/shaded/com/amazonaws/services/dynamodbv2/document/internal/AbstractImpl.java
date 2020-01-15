package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Table;

abstract class AbstractImpl
{
  private final Table table;
  private final AmazonDynamoDB client;
  
  protected AbstractImpl(AmazonDynamoDB client, Table table)
  {
    this.client = client;
    this.table = table;
  }
  
  public final Table getTable()
  {
    return table;
  }
  
  final AmazonDynamoDB getClient()
  {
    return client;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.AbstractImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */