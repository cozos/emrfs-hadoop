package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;

@Beta
public final class BetweenCondition
  extends Condition
{
  private final PathOperand attribute;
  private final Operand min;
  private final Operand max;
  
  BetweenCondition(PathOperand attribute, Operand min, Operand max)
  {
    this.attribute = attribute;
    this.min = min;
    this.max = max;
  }
  
  String asSubstituted(SubstitutionContext context)
  {
    return 
    
      attribute.asSubstituted(context) + " BETWEEN " + min.asSubstituted(context) + " AND " + max.asSubstituted(context);
  }
  
  boolean atomic()
  {
    return true;
  }
  
  int precedence()
  {
    return Precedence.BETWEEN.value();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.BetweenCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */