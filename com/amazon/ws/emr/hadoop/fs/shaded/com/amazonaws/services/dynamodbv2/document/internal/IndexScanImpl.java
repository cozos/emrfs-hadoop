package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Index;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.ScanApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;

public class IndexScanImpl
  extends ScanImpl
  implements ScanApi
{
  private final Index index;
  
  public IndexScanImpl(AmazonDynamoDB client, Index index)
  {
    super(client, index.getTable());
    this.index = index;
  }
  
  protected ItemCollection<ScanOutcome> doScan(ScanSpec spec)
  {
    ((ScanRequest)spec.getRequest()).setIndexName(index.getIndexName());
    return super.doScan(spec);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.IndexScanImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */