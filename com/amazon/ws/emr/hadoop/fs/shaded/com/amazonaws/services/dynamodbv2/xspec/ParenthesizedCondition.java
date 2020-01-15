package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;

@Beta
public final class ParenthesizedCondition
  extends Condition
{
  private final Condition condition;
  
  public static ParenthesizedCondition getInstance(Condition condition)
  {
    return (condition instanceof ParenthesizedCondition) ? (ParenthesizedCondition)condition : new ParenthesizedCondition(condition);
  }
  
  private ParenthesizedCondition(Condition condition)
  {
    this.condition = condition;
  }
  
  String asSubstituted(SubstitutionContext context)
  {
    return "(" + condition.asSubstituted(context) + ")";
  }
  
  boolean atomic()
  {
    return true;
  }
  
  int precedence()
  {
    return Precedence.Parentheses.value();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.ParenthesizedCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */