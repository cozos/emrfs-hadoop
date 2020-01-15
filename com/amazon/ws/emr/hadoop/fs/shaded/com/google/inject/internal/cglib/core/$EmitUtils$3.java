package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

final class $EmitUtils$3
  implements .Transformer
{
  private final int val$index;
  
  $EmitUtils$3(int paramInt)
  {
    val$index = paramInt;
  }
  
  public Object transform(Object value)
  {
    return new Integer(((String)value).charAt(val$index));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils.3
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */