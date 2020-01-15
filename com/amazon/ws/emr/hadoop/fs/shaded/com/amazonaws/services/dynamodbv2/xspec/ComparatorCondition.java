package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;

@Beta
public final class ComparatorCondition
  extends Condition
{
  private final String comparator;
  private final Operand lhs;
  private final Operand rhs;
  
  ComparatorCondition(String comparator, Operand lhs, Operand rhs)
  {
    this.comparator = comparator;
    this.lhs = lhs;
    this.rhs = rhs;
  }
  
  String asSubstituted(SubstitutionContext context)
  {
    return 
      lhs.asSubstituted(context) + " " + comparator + " " + rhs.asSubstituted(context);
  }
  
  boolean atomic()
  {
    return true;
  }
  
  int precedence()
  {
    return Precedence.Comparator.value();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.ComparatorCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */