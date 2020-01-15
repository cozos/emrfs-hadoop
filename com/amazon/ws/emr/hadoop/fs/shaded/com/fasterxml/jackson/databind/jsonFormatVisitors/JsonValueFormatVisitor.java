package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors;

import java.util.Set;

public abstract interface JsonValueFormatVisitor
{
  public abstract void format(JsonValueFormat paramJsonValueFormat);
  
  public abstract void enumTypes(Set<String> paramSet);
  
  public static class Base
    implements JsonValueFormatVisitor
  {
    public void format(JsonValueFormat format) {}
    
    public void enumTypes(Set<String> enums) {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormatVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */