package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemResult;
import java.util.Map;

public class PutItemOutcome
{
  private final PutItemResult result;
  
  public PutItemOutcome(PutItemResult result)
  {
    if (result == null) {
      throw new IllegalArgumentException();
    }
    this.result = result;
  }
  
  public Item getItem()
  {
    Map<String, Object> attributes = InternalUtils.toSimpleMapValue(result.getAttributes());
    Item item = Item.fromMap(attributes);
    return item;
  }
  
  public PutItemResult getPutItemResult()
  {
    return result;
  }
  
  public String toString()
  {
    return String.valueOf(result);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PutItemOutcome
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */