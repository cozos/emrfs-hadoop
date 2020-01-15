package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.util.Arrays;
import java.util.List;

@Beta
@Immutable
public final class L
  extends PathOperand
{
  L(String path)
  {
    super(path);
  }
  
  public SetAction set(ListAppendFunction listAppendFunction)
  {
    return new SetAction(this, listAppendFunction);
  }
  
  public FunctionCondition contains(Object value)
  {
    return new FunctionCondition("contains", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition eq(FunctionOperand value)
  {
    return new ComparatorCondition("=", this, value);
  }
  
  public ComparatorCondition eq(L that)
  {
    return new ComparatorCondition("=", this, that);
  }
  
  public ComparatorCondition ne(FunctionOperand value)
  {
    return new ComparatorCondition("<>", this, value);
  }
  
  public ComparatorCondition ne(L that)
  {
    return new ComparatorCondition("<>", this, that);
  }
  
  public IfNotExistsFunction<L> ifNotExists(L that)
  {
    return new IfNotExistsFunction(this, that);
  }
  
  public IfNotExistsFunction<L> ifNotExists(Object... defaultValues)
  {
    return new IfNotExistsFunction(this, new LiteralOperand(
      Arrays.asList(defaultValues)));
  }
  
  public ListAppendFunction listAppend(Object... values)
  {
    return new ListAppendFunction(this, new LiteralOperand(
      Arrays.asList(values)));
  }
  
  public ListAppendFunction listAppend(List<?> values)
  {
    return new ListAppendFunction(this, new LiteralOperand(values));
  }
  
  public ListAppendFunction listAppend(L that)
  {
    return new ListAppendFunction(this, that);
  }
  
  public SetAction set(L source)
  {
    return new SetAction(this, source);
  }
  
  public SetAction set(List<?> value)
  {
    return new SetAction(this, new LiteralOperand(value));
  }
  
  public SetAction set(IfNotExistsFunction<L> ifNotExistsFunction)
  {
    return new SetAction(this, ifNotExistsFunction);
  }
  
  public ComparatorCondition eq(List<?> value)
  {
    return new ComparatorCondition("=", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition ne(List<?> value)
  {
    return new ComparatorCondition("<>", this, new LiteralOperand(value));
  }
  
  public IfNotExistsFunction<L> ifNotExists(List<?> defaultValue)
  {
    return new IfNotExistsFunction(this, new LiteralOperand(defaultValue));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.L
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */