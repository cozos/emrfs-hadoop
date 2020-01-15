package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

@Beta
@Immutable
public final class B
  extends PathOperand
{
  B(String path)
  {
    super(path);
  }
  
  public InCondition in(ByteBuffer... values)
  {
    List<LiteralOperand> list = new LinkedList();
    for (ByteBuffer v : values) {
      list.add(new LiteralOperand(v));
    }
    return new InCondition(this, list);
  }
  
  public InCondition in(byte[]... values)
  {
    List<LiteralOperand> list = new LinkedList();
    for (byte[] v : values) {
      list.add(new LiteralOperand(v));
    }
    return new InCondition(this, list);
  }
  
  public InCondition inByteBufferList(List<ByteBuffer> values)
  {
    List<LiteralOperand> list = new LinkedList();
    for (ByteBuffer v : values) {
      list.add(new LiteralOperand(v));
    }
    return new InCondition(this, list);
  }
  
  public InCondition inBytesList(List<byte[]> values)
  {
    List<LiteralOperand> list = new LinkedList();
    for (byte[] v : values) {
      list.add(new LiteralOperand(v));
    }
    return new InCondition(this, list);
  }
  
  public ComparatorCondition eq(B that)
  {
    return new ComparatorCondition("=", this, that);
  }
  
  public ComparatorCondition eq(ByteBuffer value)
  {
    return new ComparatorCondition("=", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition ne(B that)
  {
    return new ComparatorCondition("<>", this, that);
  }
  
  public ComparatorCondition ne(ByteBuffer value)
  {
    return new ComparatorCondition("<>", this, new LiteralOperand(value));
  }
  
  public IfNotExistsFunction<B> ifNotExists(ByteBuffer defaultValue)
  {
    return new IfNotExistsFunction(this, new LiteralOperand(defaultValue));
  }
  
  public IfNotExistsFunction<B> ifNotExists(B defaultValue)
  {
    return ExpressionSpecBuilder.if_not_exists(this, defaultValue);
  }
  
  public SetAction set(B source)
  {
    return new SetAction(this, source);
  }
  
  public SetAction set(ByteBuffer value)
  {
    return new SetAction(this, new LiteralOperand(value));
  }
  
  public SetAction set(byte[] value)
  {
    return new SetAction(this, new LiteralOperand(value));
  }
  
  public SetAction set(IfNotExistsFunction<B> ifNotExistsFunction)
  {
    return new SetAction(this, ifNotExistsFunction);
  }
  
  public ComparatorCondition eq(byte[] value)
  {
    return new ComparatorCondition("=", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition ne(byte[] value)
  {
    return new ComparatorCondition("<>", this, new LiteralOperand(value));
  }
  
  public IfNotExistsFunction<B> ifNotExists(byte[] defaultValue)
  {
    return new IfNotExistsFunction(this, new LiteralOperand(defaultValue));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.B
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */