package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.metrics;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricType;

public enum DynamoDBRequestMetric
  implements RequestMetricType
{
  DynamoDBConsumedCapacity;
  
  private DynamoDBRequestMetric() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.metrics.DynamoDBRequestMetric
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */