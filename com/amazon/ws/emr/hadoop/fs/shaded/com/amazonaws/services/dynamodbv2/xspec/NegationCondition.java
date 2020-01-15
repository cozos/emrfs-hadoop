package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;

@Beta
public final class NegationCondition
  extends Condition
{
  private final Condition condition;
  
  NegationCondition(Condition condition)
  {
    this.condition = condition;
  }
  
  String asSubstituted(SubstitutionContext context)
  {
    if (precedence() > condition.precedence()) {
      return "NOT " + ExpressionSpecBuilder._(condition).asSubstituted(context);
    }
    return "NOT " + condition.asSubstituted(context);
  }
  
  boolean atomic()
  {
    return true;
  }
  
  int precedence()
  {
    return Precedence.NOT.value();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.NegationCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */