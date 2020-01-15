package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.EntryTransformer;
import javax.annotation.Nullable;

class NativeDynamoDBEntityStore$1
  implements Maps.EntryTransformer<String, AttributeValueUpdate, AttributeValue>
{
  NativeDynamoDBEntityStore$1(NativeDynamoDBEntityStore this$0) {}
  
  public AttributeValue transformEntry(@Nullable String key, @Nullable AttributeValueUpdate value)
  {
    return value.getValue();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBEntityStore.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */