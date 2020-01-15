package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Page;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Table;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.TableCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.ListTablesSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesResult;

class ListTablesCollection
  extends TableCollection<ListTablesResult>
{
  private final AmazonDynamoDB client;
  private final ListTablesSpec spec;
  private final String startKey;
  
  public ListTablesCollection(AmazonDynamoDB client, ListTablesSpec spec)
  {
    this.client = client;
    this.spec = spec;
    startKey = spec.getExclusiveStartTableName();
  }
  
  public Page<Table, ListTablesResult> firstPage()
  {
    ListTablesRequest request = (ListTablesRequest)spec.getRequest();
    request.setExclusiveStartTableName(startKey);
    
    request.setLimit(InternalUtils.minimum(spec
      .getMaxResultSize(), spec
      .getMaxPageSize()));
    
    ListTablesResult result = client.listTables(request);
    setLastLowLevelResult(result);
    return new ListTablesPage(client, spec, request, 0, result);
  }
  
  public Integer getMaxResultSize()
  {
    return spec.getMaxResultSize();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.ListTablesCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */