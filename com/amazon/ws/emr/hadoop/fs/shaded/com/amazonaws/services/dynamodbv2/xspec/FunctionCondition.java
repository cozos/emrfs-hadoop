package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;

@Beta
public final class FunctionCondition
  extends Condition
{
  private final String functionId;
  private final PathOperand pathOperand;
  private final Operand operand;
  
  FunctionCondition(String functionId, PathOperand attribute)
  {
    this.functionId = functionId;
    pathOperand = attribute;
    operand = null;
  }
  
  FunctionCondition(String functionId, PathOperand attribute, Operand operand)
  {
    this.functionId = functionId;
    pathOperand = attribute;
    this.operand = operand;
  }
  
  String asSubstituted(SubstitutionContext context)
  {
    StringBuilder sb = new StringBuilder(functionId).append("(").append(pathOperand
      .asSubstituted(context));
    if (operand != null) {
      sb.append(", ").append(operand.asSubstituted(context));
    }
    return ")";
  }
  
  String getFunctionId()
  {
    return functionId;
  }
  
  PathOperand getPathOperand()
  {
    return pathOperand;
  }
  
  Operand getOperand()
  {
    return operand;
  }
  
  boolean atomic()
  {
    return true;
  }
  
  int precedence()
  {
    return Precedence.Function.value();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.FunctionCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */