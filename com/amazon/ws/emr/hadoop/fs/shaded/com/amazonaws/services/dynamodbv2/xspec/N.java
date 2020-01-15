package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.util.LinkedList;
import java.util.List;

@Beta
@Immutable
public final class N
  extends PathOperand
{
  N(String path)
  {
    super(path);
  }
  
  public ComparatorCondition eq(N that)
  {
    return new ComparatorCondition("=", this, that);
  }
  
  public ComparatorCondition ne(N that)
  {
    return new ComparatorCondition("<>", this, that);
  }
  
  public ComparatorCondition le(Number value)
  {
    return new ComparatorCondition("<=", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition le(N that)
  {
    return new ComparatorCondition("<=", this, that);
  }
  
  public ComparatorCondition lt(Number value)
  {
    return new ComparatorCondition("<", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition lt(N that)
  {
    return new ComparatorCondition("<", this, that);
  }
  
  public ComparatorCondition ge(Number value)
  {
    return new ComparatorCondition(">=", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition ge(N that)
  {
    return new ComparatorCondition(">=", this, that);
  }
  
  public ComparatorCondition gt(Number value)
  {
    return new ComparatorCondition(">", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition gt(N that)
  {
    return new ComparatorCondition(">", this, that);
  }
  
  public BetweenCondition between(Number low, Number high)
  {
    return new BetweenCondition(this, new LiteralOperand(low), new LiteralOperand(high));
  }
  
  public AddAction add(Number value)
  {
    return new AddAction(this, new LiteralOperand(value));
  }
  
  public PlusOperation plus(Number value)
  {
    return new PlusOperation(this, new LiteralOperand(value));
  }
  
  public PlusOperation plus(N attr)
  {
    return new PlusOperation(this, attr);
  }
  
  public MinusOperation minus(Number value)
  {
    return new MinusOperation(this, new LiteralOperand(value));
  }
  
  public MinusOperation minus(N attr)
  {
    return new MinusOperation(this, attr);
  }
  
  public final SetAction set(PlusOperation plusOperation)
  {
    return new SetAction(this, plusOperation);
  }
  
  public final SetAction set(MinusOperation minusOperation)
  {
    return new SetAction(this, minusOperation);
  }
  
  public final InCondition in(Number... values)
  {
    List<LiteralOperand> list = new LinkedList();
    for (Number v : values) {
      list.add(new LiteralOperand(v));
    }
    return new InCondition(this, list);
  }
  
  public final <T extends Number> InCondition in(List<T> values)
  {
    List<LiteralOperand> list = new LinkedList();
    for (Number v : values) {
      list.add(new LiteralOperand(v));
    }
    return new InCondition(this, list);
  }
  
  public SetAction set(N source)
  {
    return new SetAction(this, source);
  }
  
  public SetAction set(Number value)
  {
    return new SetAction(this, new LiteralOperand(value));
  }
  
  public SetAction set(IfNotExistsFunction<N> ifNotExistsFunction)
  {
    return new SetAction(this, ifNotExistsFunction);
  }
  
  public ComparatorCondition eq(Number value)
  {
    return new ComparatorCondition("=", this, new LiteralOperand(value));
  }
  
  public ComparatorCondition ne(Number value)
  {
    return new ComparatorCondition("<>", this, new LiteralOperand(value));
  }
  
  public IfNotExistsFunction<N> ifNotExists(Number defaultValue)
  {
    return new IfNotExistsFunction(this, new LiteralOperand(defaultValue));
  }
  
  public IfNotExistsFunction<N> ifNotExists(N defaultValue)
  {
    return ExpressionSpecBuilder.if_not_exists(this, defaultValue);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.N
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */