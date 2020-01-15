package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;

@Beta
public final class AndCondition
  extends Condition
{
  private final Condition lhs;
  private final Condition rhs;
  
  AndCondition(Condition lhs, Condition rhs)
  {
    this.lhs = lhs;
    this.rhs = rhs;
  }
  
  String asSubstituted(SubstitutionContext context)
  {
    return 
      lhs.asSubstituted(context) + " AND " + rhs.asSubstituted(context);
  }
  
  boolean atomic()
  {
    return (lhs.atomic()) && (rhs.atomic());
  }
  
  int precedence()
  {
    return Precedence.AND.value();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.AndCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */