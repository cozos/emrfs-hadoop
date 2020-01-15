package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;

@Beta
public abstract class Condition
  extends UnitOfExpression
{
  public final NegationCondition negate()
  {
    return new NegationCondition(this);
  }
  
  public AndCondition and(Condition that)
  {
    return new AndCondition(this, that.atomic() ? that : ExpressionSpecBuilder._(that));
  }
  
  public OrCondition or(Condition that)
  {
    return new OrCondition(this, that.atomic() ? that : ExpressionSpecBuilder._(that));
  }
  
  abstract boolean atomic();
  
  abstract int precedence();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.Condition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */