package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;

@Beta
public final class SetAction
  extends UpdateAction
{
  SetAction(PathOperand attr, UnitOfExpression value)
  {
    super("SET", attr, value);
  }
  
  String asSubstituted(SubstitutionContext context)
  {
    return 
      getPathOperand().asSubstituted(context) + " = " + getValue().asSubstituted(context);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.SetAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */