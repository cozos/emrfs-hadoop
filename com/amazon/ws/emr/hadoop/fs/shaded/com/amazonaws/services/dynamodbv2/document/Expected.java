package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ComparisonOperator;

public class Expected
{
  private final String attribute;
  private ComparisonOperator op;
  private Object[] values;
  
  public Expected(String attrName)
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
  
  private Expected _withValues(Object... values)
  {
    this.values = ((Object[])values.clone());
    return this;
  }
  
  private Expected _withComparisonOperator(ComparisonOperator op)
  {
    this.op = op;
    return this;
  }
  
  public Expected eq(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.EQ)._withValues(new Object[] { val });
  }
  
  public Expected ne(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.NE)._withValues(new Object[] { val });
  }
  
  public Expected exists()
  {
    return _withComparisonOperator(ComparisonOperator.NOT_NULL);
  }
  
  public Expected notExist()
  {
    return _withComparisonOperator(ComparisonOperator.NULL);
  }
  
  public Expected contains(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.CONTAINS)._withValues(new Object[] { val });
  }
  
  public Expected notContains(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.NOT_CONTAINS)._withValues(new Object[] { val });
  }
  
  public Expected beginsWith(String val)
  {
    return _withComparisonOperator(ComparisonOperator.BEGINS_WITH)._withValues(new Object[] { val });
  }
  
  public Expected in(Object... values)
  {
    if ((values == null) || (values.length == 0)) {
      throw new IllegalArgumentException("values must not be null or empty.");
    }
    return _withComparisonOperator(ComparisonOperator.IN)._withValues(values);
  }
  
  public Expected between(Object low, Object hi)
  {
    return _withComparisonOperator(ComparisonOperator.BETWEEN)._withValues(new Object[] { low, hi });
  }
  
  public Expected ge(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.GE)._withValues(new Object[] { val });
  }
  
  public Expected gt(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.GT)._withValues(new Object[] { val });
  }
  
  public Expected le(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.LE)._withValues(new Object[] { val });
  }
  
  public Expected lt(Object val)
  {
    return _withComparisonOperator(ComparisonOperator.LT)._withValues(new Object[] { val });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Expected
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */