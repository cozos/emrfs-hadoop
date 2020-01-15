package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ScanFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import java.util.Map;

@ThreadSafe
public abstract interface ScanApi
{
  public abstract ItemCollection<ScanOutcome> scan(ScanFilter... paramVarArgs);
  
  public abstract ItemCollection<ScanOutcome> scan(String paramString, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract ItemCollection<ScanOutcome> scan(String paramString1, String paramString2, Map<String, String> paramMap, Map<String, Object> paramMap1);
  
  public abstract ItemCollection<ScanOutcome> scan(ScanSpec paramScanSpec);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.ScanApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */