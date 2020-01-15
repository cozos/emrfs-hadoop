package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import java.util.List;
import java.util.Map;
import java.util.Set;

class LiteralOperand
  extends Operand
{
  private final Object value;
  
  LiteralOperand()
  {
    value = null;
  }
  
  LiteralOperand(Object value)
  {
    this.value = value;
  }
  
  LiteralOperand(Set<?> value)
  {
    this.value = value;
  }
  
  LiteralOperand(List<?> value)
  {
    this.value = value;
  }
  
  LiteralOperand(Map<String, ?> value)
  {
    this.value = value;
  }
  
  LiteralOperand(boolean value)
  {
    this.value = Boolean.valueOf(value);
  }
  
  final String asSubstituted(SubstitutionContext context)
  {
    return context.valueTokenFor(value);
  }
  
  public String toString()
  {
    return String.valueOf(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.LiteralOperand
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */