package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemResult;
import java.util.Map;

public class GetItemOutcome
{
  private final GetItemResult result;
  
  public GetItemOutcome(GetItemResult result)
  {
    if (result == null) {
      throw new IllegalArgumentException();
    }
    this.result = result;
  }
  
  public Item getItem()
  {
    Map<String, Object> attributes = InternalUtils.toSimpleMapValue(result.getItem());
    Item item = Item.fromMap(attributes);
    return item;
  }
  
  public GetItemResult getGetItemResult()
  {
    return result;
  }
  
  public String toString()
  {
    return String.valueOf(result);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.GetItemOutcome
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */