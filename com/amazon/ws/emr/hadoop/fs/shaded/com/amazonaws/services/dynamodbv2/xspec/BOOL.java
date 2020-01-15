package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.util.LinkedList;
import java.util.List;

@Beta
@Immutable
public final class BOOL
  extends PathOperand
{
  BOOL(String path)
  {
    super(path);
  }
  
  public ComparatorCondition eq(boolean value)
  {
    return new ComparatorCondition("=", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition eq(BOOL that)
  {
    return new ComparatorCondition("=", this, that);
  }
  
  public ComparatorCondition ne(boolean value)
  {
    return new ComparatorCondition("<>", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition ne(BOOL that)
  {
    return new ComparatorCondition("<>", this, that);
  }
  
  public final InCondition in(boolean... values)
  {
    List<LiteralOperand> list = new LinkedList();
    for (boolean v : values) {
      list.add(new LiteralOperand(v));
    }
    return new InCondition(this, list);
  }
  
  public InCondition in(List<Boolean> values)
  {
    List<LiteralOperand> list = new LinkedList();
    for (Boolean v : values) {
      list.add(new LiteralOperand(v));
    }
    return new InCondition(this, list);
  }
  
  public IfNotExistsFunction<BOOL> ifNotExists(boolean defaultValue)
  {
    return new IfNotExistsFunction(this, new LiteralOperand(defaultValue));
  }
  
  public IfNotExistsFunction<BOOL> ifNotExists(BOOL defaultValue)
  {
    return ExpressionSpecBuilder.if_not_exists(this, defaultValue);
  }
  
  public SetAction set(BOOL source)
  {
    return new SetAction(this, source);
  }
  
  public SetAction set(boolean value)
  {
    return new SetAction(this, new LiteralOperand(value));
  }
  
  public SetAction set(IfNotExistsFunction<BOOL> ifNotExistsFunction)
  {
    return new SetAction(this, ifNotExistsFunction);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.BOOL
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */