package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConsumedCapacity;
import java.util.List;
import java.util.Map;

public class QueryResultPage<T>
{
  private List<T> results;
  private Map<String, AttributeValue> lastEvaluatedKey;
  private Integer count;
  private Integer scannedCount;
  private ConsumedCapacity consumedCapacity;
  
  public List<T> getResults()
  {
    return results;
  }
  
  public void setResults(List<T> results)
  {
    this.results = results;
  }
  
  public Map<String, AttributeValue> getLastEvaluatedKey()
  {
    return lastEvaluatedKey;
  }
  
  public void setLastEvaluatedKey(Map<String, AttributeValue> lastEvaluatedKey)
  {
    this.lastEvaluatedKey = lastEvaluatedKey;
  }
  
  public Integer getCount()
  {
    return count;
  }
  
  public void setCount(Integer count)
  {
    this.count = count;
  }
  
  public Integer getScannedCount()
  {
    return scannedCount;
  }
  
  public void setScannedCount(Integer scannedCount)
  {
    this.scannedCount = scannedCount;
  }
  
  public ConsumedCapacity getConsumedCapacity()
  {
    return consumedCapacity;
  }
  
  public void setConsumedCapacity(ConsumedCapacity consumedCapacity)
  {
    this.consumedCapacity = consumedCapacity;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.QueryResultPage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */