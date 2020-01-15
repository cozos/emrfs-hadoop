package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import java.util.List;

@Beta
public final class InCondition
  extends Condition
{
  private final PathOperand attribute;
  private final List<? extends Operand> operands;
  
  InCondition(PathOperand attribute, List<? extends Operand> operands)
  {
    this.attribute = attribute;
    this.operands = operands;
  }
  
  String asSubstituted(SubstitutionContext context)
  {
    StringBuilder sb = new StringBuilder(attribute.asSubstituted(context)).append(" IN (");
    boolean first = true;
    for (Operand operand : operands) {
      if (first)
      {
        sb.append(operand.asSubstituted(context));
        first = false;
      }
      else
      {
        sb.append(", ").append(operand.asSubstituted(context));
      }
    }
    return ")";
  }
  
  boolean atomic()
  {
    return true;
  }
  
  int precedence()
  {
    return Precedence.IN.value();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.InCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */