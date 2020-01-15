package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ComparisonOperator;

public abstract class Filter<T extends Filter<T>>
{
  private final String attribute;
  private ComparisonOperator op;
  private Object[] values;
  
  protected Filter(String attrName)
  {
    InternalUtils.checkInvalidAttrName(attrName);
    attribute = attrName;
  }
  
  public String getAttribute()
  {
    return attribute;
  }
  
  public ComparisonOperator getComparisonOperator()
  {
    return op;
  }
  
  public Object[] getValues()
  {
    return values == null ? null : (Object[])values.clone();
  }
  
  protected T _withValues(Object... values)
  {
    this.values = ((Object[])values.clone());
    return this;
  }
  
  private T _withComparisonOperator(ComparisonOperator op)
  {
    this.op = op;
    return this;
  }
  
  public T eq(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.EQ)._withValues(new Object[] { val });
  }
  
  public T ne(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.NE)._withValues(new Object[] { val });
  }
  
  public T exists()
  {
    return _withComparisonOperator(ComparisonOperator.NOT_NULL);
  }
  
  public T notExist()
  {
    return _withComparisonOperator(ComparisonOperator.NULL);
  }
  
  public T contains(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.CONTAINS)._withValues(new Object[] { val });
  }
  
  public T notContains(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.NOT_CONTAINS)._withValues(new Object[] { val });
  }
  
  public T beginsWith(String val)
  {
    return _withComparisonOperator(ComparisonOperator.BEGINS_WITH)._withValues(new Object[] { val });
  }
  
  public T in(Object... values)
  {
    if ((values == null) || (values.length == 0)) {
      throw new IllegalArgumentException("values must not be null or empty.");
    }
    return _withComparisonOperator(ComparisonOperator.IN)._withValues(values);
  }
  
  public T between(Object low, Object hi)
  {
    return _withComparisonOperator(ComparisonOperator.BETWEEN)._withValues(new Object[] { low, hi });
  }
  
  public T ge(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.GE)._withValues(new Object[] { val });
  }
  
  public T gt(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.GT)._withValues(new Object[] { val });
  }
  
  public T le(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.LE)._withValues(new Object[] { val });
  }
  
  public T lt(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.LT)._withValues(new Object[] { val });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.Filter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */