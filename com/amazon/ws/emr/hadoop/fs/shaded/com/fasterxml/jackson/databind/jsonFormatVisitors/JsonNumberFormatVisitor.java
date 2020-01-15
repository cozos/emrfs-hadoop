package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;

public abstract interface JsonNumberFormatVisitor
  extends JsonValueFormatVisitor
{
  public abstract void numberType(JsonParser.NumberType paramNumberType);
  
  public static class Base
    extends JsonValueFormatVisitor.Base
    implements JsonNumberFormatVisitor
  {
    public void numberType(JsonParser.NumberType type) {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNumberFormatVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */