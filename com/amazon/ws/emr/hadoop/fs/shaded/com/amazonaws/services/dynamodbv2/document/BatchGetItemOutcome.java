package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BatchGetItemOutcome
{
  private final BatchGetItemResult result;
  
  public BatchGetItemOutcome(BatchGetItemResult result)
  {
    if (result == null) {
      throw new IllegalArgumentException();
    }
    this.result = result;
  }
  
  public Map<String, List<Item>> getTableItems()
  {
    Map<String, List<Map<String, AttributeValue>>> res = result.getResponses();
    Map<String, List<Item>> map = new LinkedHashMap(res.size());
    for (Map.Entry<String, List<Map<String, AttributeValue>>> e : res.entrySet())
    {
      String tableName = (String)e.getKey();
      List<Map<String, AttributeValue>> items = (List)e.getValue();
      map.put(tableName, InternalUtils.toItemList(items));
    }
    return map;
  }
  
  public Map<String, KeysAndAttributes> getUnprocessedKeys()
  {
    return result.getUnprocessedKeys();
  }
  
  public BatchGetItemResult getBatchGetItemResult()
  {
    return result;
  }
  
  public String toString()
  {
    return String.valueOf(result);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.BatchGetItemOutcome
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */