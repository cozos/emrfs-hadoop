package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class DynamoDBUtils
{
  public static Long getLongFromItemIfExists(AttributeValue attributeValue)
  {
    if ((attributeValue == null) || (attributeValue.getN() == null) || 
      (attributeValue.getN().length() == 0)) {
      return Long.valueOf(0L);
    }
    return Long.valueOf(Long.parseLong(attributeValue.getN()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.DynamoDBUtils
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */