package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Page;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Table;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.ListTablesSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

class ListTablesPage
  extends Page<Table, ListTablesResult>
{
  private final AmazonDynamoDB client;
  private final ListTablesSpec spec;
  private final ListTablesRequest request;
  private final int index;
  private final String lastEvaluatedKey;
  
  public ListTablesPage(AmazonDynamoDB client, ListTablesSpec spec, ListTablesRequest request, int index, ListTablesResult result)
  {
    super(Collections.unmodifiableList(
      toTableList(client, result.getTableNames())), result);
    
    this.client = client;
    this.spec = spec;
    this.request = request;
    this.index = index;
    Integer max = spec.getMaxResultSize();
    if ((max != null) && (index + result.getTableNames().size() > max.intValue())) {
      lastEvaluatedKey = null;
    } else {
      lastEvaluatedKey = result.getLastEvaluatedTableName();
    }
  }
  
  public boolean hasNextPage()
  {
    if (lastEvaluatedKey == null) {
      return false;
    }
    Integer max = spec.getMaxResultSize();
    if (max == null) {
      return true;
    }
    return nextRequestLimit(max.intValue()) > 0;
  }
  
  private int nextRequestLimit(int max)
  {
    int nextIndex = index + size();
    return InternalUtils.minimum(
      Integer.valueOf(max - nextIndex), spec
      .getMaxPageSize()).intValue();
  }
  
  public Page<Table, ListTablesResult> nextPage()
  {
    if (lastEvaluatedKey == null) {
      throw new NoSuchElementException("No more pages");
    }
    Integer max = spec.getMaxResultSize();
    if (max != null)
    {
      int nextLimit = nextRequestLimit(max.intValue());
      if (nextLimit == 0) {
        throw new NoSuchElementException("No more pages");
      }
      request.setLimit(Integer.valueOf(nextLimit));
    }
    request.setExclusiveStartTableName(lastEvaluatedKey);
    ListTablesResult result = client.listTables(request);
    int nextIndex = index + size();
    return new ListTablesPage(client, spec, request, nextIndex, result);
  }
  
  private static List<Table> toTableList(AmazonDynamoDB client, List<String> tableNames)
  {
    if (tableNames == null) {
      return null;
    }
    List<Table> result = new ArrayList(tableNames.size());
    for (String tableName : tableNames) {
      result.add(new Table(client, tableName));
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.ListTablesPage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */