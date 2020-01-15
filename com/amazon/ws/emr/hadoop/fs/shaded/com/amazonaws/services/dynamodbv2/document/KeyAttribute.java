package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;

public class KeyAttribute
  extends Attribute
{
  public KeyAttribute(String attrName, Object value)
  {
    super(attrName, value);
    InternalUtils.checkInvalidAttrName(attrName);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */