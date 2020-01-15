package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@Beta
@Immutable
public final class NS
  extends PathOperand
{
  NS(String path)
  {
    super(path);
  }
  
  public ComparatorCondition eq(Number... values)
  {
    return new ComparatorCondition("=", this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public ComparatorCondition eq(NS that)
  {
    return new ComparatorCondition("=", this, that);
  }
  
  public ComparatorCondition ne(Number... values)
  {
    return new ComparatorCondition("<>", this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public ComparatorCondition ne(NS that)
  {
    return new ComparatorCondition("<>", this, that);
  }
  
  public FunctionCondition contains(Number value)
  {
    return new FunctionCondition("contains", this, new LiteralOperand(value));
  }
  
  public SetAction set(Number... values)
  {
    return set(new LinkedHashSet(Arrays.asList(values)));
  }
  
  public AddAction append(Number... values)
  {
    return append(new LinkedHashSet(Arrays.asList(values)));
  }
  
  public <T extends Number> AddAction append(Set<T> values)
  {
    return new AddAction(this, new LiteralOperand(values));
  }
  
  public DeleteAction delete(Number... values)
  {
    return delete(new LinkedHashSet(Arrays.asList(values)));
  }
  
  public <T extends Number> DeleteAction delete(Set<T> values)
  {
    return new DeleteAction(this, new LiteralOperand(values));
  }
  
  public IfNotExistsFunction<NS> ifNotExists(Number... defaultValue)
  {
    return new IfNotExistsFunction(this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(defaultValue))));
  }
  
  public IfNotExistsFunction<NS> ifNotExists(NS defaultValue)
  {
    return new IfNotExistsFunction(this, defaultValue);
  }
  
  public SetAction set(NS source)
  {
    return new SetAction(this, source);
  }
  
  public <T extends Number> SetAction set(Set<T> value)
  {
    return new SetAction(this, new LiteralOperand(value));
  }
  
  public SetAction set(IfNotExistsFunction<NS> ifNotExistsFunction)
  {
    return new SetAction(this, ifNotExistsFunction);
  }
  
  public <T extends Number> ComparatorCondition eq(Set<T> value)
  {
    return new ComparatorCondition("=", this, new LiteralOperand(value));
  }
  
  public <T extends Number> ComparatorCondition ne(Set<T> value)
  {
    return new ComparatorCondition("<>", this, new LiteralOperand(value));
  }
  
  public <T extends Number> IfNotExistsFunction<NS> ifNotExists(Set<T> defaultValue)
  {
    return new IfNotExistsFunction(this, new LiteralOperand(defaultValue));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.NS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */