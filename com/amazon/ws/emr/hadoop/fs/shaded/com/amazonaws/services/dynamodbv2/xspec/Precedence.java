package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;

@Immutable
 enum Precedence
{
  Comparator(700),  IN(600),  BETWEEN(500),  Function(400),  Parentheses(300),  NOT(200),  AND(100),  OR(0);
  
  private final int value;
  
  private Precedence(int value)
  {
    this.value = value;
  }
  
  int value()
  {
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.Precedence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */