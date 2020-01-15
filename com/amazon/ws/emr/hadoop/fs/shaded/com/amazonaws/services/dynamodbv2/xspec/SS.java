package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@Beta
@Immutable
public final class SS
  extends PathOperand
{
  SS(String path)
  {
    super(path);
  }
  
  public ComparatorCondition eq(String... values)
  {
    return new ComparatorCondition("=", this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public ComparatorCondition eq(SS that)
  {
    return new ComparatorCondition("=", this, that);
  }
  
  public ComparatorCondition ne(String... values)
  {
    return new ComparatorCondition("<>", this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public ComparatorCondition ne(SS that)
  {
    return new ComparatorCondition("<>", this, that);
  }
  
  public FunctionCondition contains(String value)
  {
    return new FunctionCondition("contains", this, new LiteralOperand(value));
  }
  
  public final SetAction set(String... values)
  {
    return new SetAction(this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public final SetAction set(SS source)
  {
    return new SetAction(this, source);
  }
  
  public AddAction append(String... values)
  {
    return new AddAction(this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public AddAction append(Set<String> values)
  {
    return new AddAction(this, new LiteralOperand(values));
  }
  
  public DeleteAction delete(String... values)
  {
    return new DeleteAction(this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public DeleteAction delete(Set<String> values)
  {
    return new DeleteAction(this, new LiteralOperand(values));
  }
  
  public IfNotExistsFunction<SS> ifNotExists(String... defaultValue)
  {
    return new IfNotExistsFunction(this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(defaultValue))));
  }
  
  public IfNotExistsFunction<SS> ifNotExists(SS defaultValue)
  {
    return new IfNotExistsFunction(this, defaultValue);
  }
  
  public SetAction set(Set<String> value)
  {
    return new SetAction(this, new LiteralOperand(value));
  }
  
  public SetAction set(IfNotExistsFunction<SS> ifNotExistsFunction)
  {
    return new SetAction(this, ifNotExistsFunction);
  }
  
  public ComparatorCondition eq(Set<String> value)
  {
    return new ComparatorCondition("=", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition ne(Set<String> value)
  {
    return new ComparatorCondition("<>", this, new LiteralOperand(value));
  }
  
  public IfNotExistsFunction<SS> ifNotExists(Set<String> defaultValue)
  {
    return new IfNotExistsFunction(this, new LiteralOperand(defaultValue));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.SS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */