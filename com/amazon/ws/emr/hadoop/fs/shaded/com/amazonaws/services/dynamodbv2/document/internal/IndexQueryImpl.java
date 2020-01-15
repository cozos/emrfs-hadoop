package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Index;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.QueryApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;

public class IndexQueryImpl
  extends QueryImpl
  implements QueryApi
{
  private final Index index;
  
  public IndexQueryImpl(AmazonDynamoDB client, Index index)
  {
    super(client, index.getTable());
    this.index = index;
  }
  
  protected ItemCollection<QueryOutcome> doQuery(QuerySpec spec)
  {
    ((QueryRequest)spec.getRequest()).setIndexName(index.getIndexName());
    return super.doQuery(spec);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.IndexQueryImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */