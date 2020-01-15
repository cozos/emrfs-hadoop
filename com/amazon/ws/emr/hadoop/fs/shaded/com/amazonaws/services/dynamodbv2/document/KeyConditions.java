package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ComparisonOperator;

public enum KeyConditions
{
  EQ(ComparisonOperator.EQ),  LE(ComparisonOperator.LE),  LT(ComparisonOperator.LT),  GE(ComparisonOperator.GE),  GT(ComparisonOperator.GT),  BEGINS_WITH(ComparisonOperator.BEGINS_WITH),  BETWEEN(ComparisonOperator.BETWEEN);
  
  private final ComparisonOperator comparisonOperator;
  
  private KeyConditions(ComparisonOperator comparisonOperator)
  {
    this.comparisonOperator = comparisonOperator;
  }
  
  public ComparisonOperator toComparisonOperator()
  {
    return comparisonOperator;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyConditions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */