package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.util.Map;

@Beta
@Immutable
public final class M
  extends PathOperand
{
  M(String attrName)
  {
    super(attrName);
  }
  
  public ComparatorCondition eq(FunctionOperand value)
  {
    return new ComparatorCondition("=", this, value);
  }
  
  public ComparatorCondition eq(M that)
  {
    return new ComparatorCondition("=", this, that);
  }
  
  public ComparatorCondition ne(FunctionOperand value)
  {
    return new ComparatorCondition("<>", this, value);
  }
  
  public ComparatorCondition ne(M that)
  {
    return new ComparatorCondition("<>", this, that);
  }
  
  public IfNotExistsFunction<M> ifNotExists(M defaultValue)
  {
    return new IfNotExistsFunction(this, defaultValue);
  }
  
  public SetAction set(M source)
  {
    return new SetAction(this, source);
  }
  
  public SetAction set(Map<String, ?> value)
  {
    return new SetAction(this, new LiteralOperand(value));
  }
  
  public SetAction set(IfNotExistsFunction<M> ifNotExistsFunction)
  {
    return new SetAction(this, ifNotExistsFunction);
  }
  
  public ComparatorCondition eq(Map<String, ?> value)
  {
    return new ComparatorCondition("=", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition ne(Map<String, ?> value)
  {
    return new ComparatorCondition("<>", this, new LiteralOperand(value));
  }
  
  public IfNotExistsFunction<M> ifNotExists(Map<String, ?> defaultValue)
  {
    return new IfNotExistsFunction(this, new LiteralOperand(defaultValue));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.M
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */