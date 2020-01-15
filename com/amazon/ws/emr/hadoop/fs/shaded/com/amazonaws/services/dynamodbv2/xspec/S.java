package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.util.LinkedList;
import java.util.List;

@Beta
@Immutable
public final class S
  extends PathOperand
{
  S(String path)
  {
    super(path);
  }
  
  public FunctionCondition beginsWith(String value)
  {
    return new FunctionCondition("begins_with", this, new LiteralOperand(value));
  }
  
  public FunctionCondition contains(String substring)
  {
    return new FunctionCondition("contains", this, new LiteralOperand(substring));
  }
  
  public ComparatorCondition eq(S that)
  {
    return new ComparatorCondition("=", this, that);
  }
  
  public ComparatorCondition ne(S that)
  {
    return new ComparatorCondition("<>", this, that);
  }
  
  public ComparatorCondition le(String value)
  {
    return new ComparatorCondition("<=", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition le(S that)
  {
    return new ComparatorCondition("<=", this, that);
  }
  
  public ComparatorCondition lt(String value)
  {
    return new ComparatorCondition("<", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition lt(S that)
  {
    return new ComparatorCondition("<", this, that);
  }
  
  public ComparatorCondition ge(String value)
  {
    return new ComparatorCondition(">=", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition ge(S that)
  {
    return new ComparatorCondition(">=", this, that);
  }
  
  public ComparatorCondition gt(String value)
  {
    return new ComparatorCondition(">", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition gt(S that)
  {
    return new ComparatorCondition(">", this, that);
  }
  
  public BetweenCondition between(String low, String high)
  {
    return new BetweenCondition(this, new LiteralOperand(low), new LiteralOperand(high));
  }
  
  public IfNotExistsFunction<S> ifNotExists(S defaultValue)
  {
    return ExpressionSpecBuilder.if_not_exists(this, defaultValue);
  }
  
  public final InCondition in(String... values)
  {
    List<LiteralOperand> list = new LinkedList();
    for (String v : values) {
      list.add(new LiteralOperand(v));
    }
    return new InCondition(this, list);
  }
  
  public final InCondition in(List<String> values)
  {
    List<LiteralOperand> list = new LinkedList();
    for (String v : values) {
      list.add(new LiteralOperand(v));
    }
    return new InCondition(this, list);
  }
  
  public SetAction set(S source)
  {
    return new SetAction(this, source);
  }
  
  public SetAction set(String value)
  {
    return new SetAction(this, new LiteralOperand(value));
  }
  
  public SetAction set(IfNotExistsFunction<S> ifNotExistsFunction)
  {
    return new SetAction(this, ifNotExistsFunction);
  }
  
  public ComparatorCondition eq(String value)
  {
    return new ComparatorCondition("=", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition ne(String value)
  {
    return new ComparatorCondition("<>", this, new LiteralOperand(value));
  }
  
  public IfNotExistsFunction<S> ifNotExists(String defaultValue)
  {
    return new IfNotExistsFunction(this, new LiteralOperand(defaultValue));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.S
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */