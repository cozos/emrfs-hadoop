package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;

@Beta
public final class IfNotExistsFunction<T>
  extends FunctionOperand
{
  private final PathOperand attr;
  private final Operand operand;
  
  IfNotExistsFunction(PathOperand attr, Operand operand)
  {
    this.attr = attr;
    this.operand = operand;
  }
  
  String asSubstituted(SubstitutionContext context)
  {
    return 
      "if_not_exists(" + attr.asSubstituted(context) + "," + operand.asSubstituted(context) + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.IfNotExistsFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */