package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;

@Beta
public final class OrCondition
  extends Condition
{
  private final Condition lhs;
  private final Condition rhs;
  
  OrCondition(Condition lhs, Condition rhs)
  {
    this.lhs = lhs;
    this.rhs = rhs;
  }
  
  String asSubstituted(SubstitutionContext context)
  {
    return lhs.asSubstituted(context) + " OR " + rhs.asSubstituted(context);
  }
  
  public AndCondition and(Condition that)
  {
    return new AndCondition(ExpressionSpecBuilder._(this), that.atomic() ? that : ExpressionSpecBuilder._(that));
  }
  
  boolean atomic()
  {
    return false;
  }
  
  int precedence()
  {
    return Precedence.OR.value();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.OrCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */