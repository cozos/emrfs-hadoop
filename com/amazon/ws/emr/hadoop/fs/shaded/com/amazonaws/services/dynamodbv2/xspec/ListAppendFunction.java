package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;

@Beta
public final class ListAppendFunction
  extends FunctionOperand
{
  private final Operand first;
  private final Operand second;
  
  ListAppendFunction(Operand first, Operand second)
  {
    this.first = first;
    this.second = second;
  }
  
  String asSubstituted(SubstitutionContext context)
  {
    return 
      "list_append(" + first.asSubstituted(context) + ", " + second.asSubstituted(context) + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.ListAppendFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */