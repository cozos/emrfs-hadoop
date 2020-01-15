package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;

public class RangeKeyCondition
{
  private final String attrName;
  private KeyConditions kcond;
  private Object[] values;
  
  public RangeKeyCondition(String attrName)
  {
    InternalUtils.checkInvalidAttrName(attrName);
    this.attrName = attrName;
  }
  
  public String getAttrName()
  {
    return attrName;
  }
  
  public KeyConditions getKeyCondition()
  {
    return kcond;
  }
  
  public Object[] getValues()
  {
    return values == null ? null : (Object[])values.clone();
  }
  
  public RangeKeyCondition eq(Object val)
  {
    kcond = KeyConditions.EQ;
    return withValues(new Object[] { val });
  }
  
  public RangeKeyCondition beginsWith(String val)
  {
    kcond = KeyConditions.BEGINS_WITH;
    return withValues(new Object[] { val });
  }
  
  public RangeKeyCondition between(Object low, Object hi)
  {
    kcond = KeyConditions.BETWEEN;
    return withValues(new Object[] { low, hi });
  }
  
  public RangeKeyCondition ge(Object val)
  {
    kcond = KeyConditions.GE;
    return withValues(new Object[] { val });
  }
  
  public RangeKeyCondition gt(Object val)
  {
    kcond = KeyConditions.GT;
    return withValues(new Object[] { val });
  }
  
  public RangeKeyCondition le(Object val)
  {
    kcond = KeyConditions.LE;
    return withValues(new Object[] { val });
  }
  
  public RangeKeyCondition lt(Object val)
  {
    kcond = KeyConditions.LT;
    return withValues(new Object[] { val });
  }
  
  private RangeKeyCondition withValues(Object... values)
  {
    this.values = values;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.RangeKeyCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */