package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;

@Beta
public abstract class UpdateAction
  extends UnitOfExpression
{
  private final String operator;
  private final PathOperand attribute;
  private final UnitOfExpression value;
  
  UpdateAction(String operator, PathOperand attribute, UnitOfExpression value)
  {
    this.operator = operator;
    this.attribute = attribute;
    this.value = value;
  }
  
  String asSubstituted(SubstitutionContext context)
  {
    return 
    
      attribute.asSubstituted(context) + " " + value.asSubstituted(context);
  }
  
  final String getOperator()
  {
    return operator;
  }
  
  final PathOperand getPathOperand()
  {
    return attribute;
  }
  
  final UnitOfExpression getValue()
  {
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.UpdateAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */