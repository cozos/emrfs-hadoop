package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@Beta
@Immutable
public final class BS
  extends PathOperand
{
  BS(String path)
  {
    super(path);
  }
  
  public ComparatorCondition eq(byte[]... values)
  {
    return new ComparatorCondition("=", this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public ComparatorCondition eq(ByteBuffer... values)
  {
    return new ComparatorCondition("=", this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public ComparatorCondition eq(BS that)
  {
    return new ComparatorCondition("=", this, that);
  }
  
  public ComparatorCondition ne(byte[]... values)
  {
    return new ComparatorCondition("<>", this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public ComparatorCondition ne(ByteBuffer... values)
  {
    return new ComparatorCondition("<>", this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public ComparatorCondition ne(BS that)
  {
    return new ComparatorCondition("<>", this, that);
  }
  
  public FunctionCondition contains(byte[] value)
  {
    return new FunctionCondition("contains", this, new LiteralOperand(value));
  }
  
  public FunctionCondition contains(ByteBuffer value)
  {
    return new FunctionCondition("contains", this, new LiteralOperand(value));
  }
  
  public final SetAction set(byte[]... value)
  {
    return new SetAction(this, new LiteralOperand(value));
  }
  
  public final SetAction set(ByteBuffer... value)
  {
    return new SetAction(this, new LiteralOperand(value));
  }
  
  public AddAction append(byte[]... values)
  {
    return new AddAction(this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public AddAction append(ByteBuffer... values)
  {
    return new AddAction(this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public DeleteAction delete(byte[]... values)
  {
    return new DeleteAction(this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public DeleteAction delete(ByteBuffer... values)
  {
    return new DeleteAction(this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(values))));
  }
  
  public IfNotExistsFunction<BS> ifNotExists(byte[]... defaultValue)
  {
    return new IfNotExistsFunction(this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(defaultValue))));
  }
  
  public IfNotExistsFunction<BS> ifNotExists(ByteBuffer... defaultValue)
  {
    return new IfNotExistsFunction(this, new LiteralOperand(new LinkedHashSet(
      Arrays.asList(defaultValue))));
  }
  
  public IfNotExistsFunction<BS> ifNotExists(BS defaultValue)
  {
    return new IfNotExistsFunction(this, defaultValue);
  }
  
  public SetAction set(BS source)
  {
    return new SetAction(this, source);
  }
  
  public SetAction set(Set<byte[]> value)
  {
    return new SetAction(this, new LiteralOperand(value));
  }
  
  public SetAction set(IfNotExistsFunction<BS> ifNotExistsFunction)
  {
    return new SetAction(this, ifNotExistsFunction);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.BS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */