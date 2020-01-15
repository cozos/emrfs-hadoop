package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

final class $EmitUtils$13
  implements .Transformer
{
  private final .EmitUtils.ParameterTyper val$typer;
  
  $EmitUtils$13(.EmitUtils.ParameterTyper paramParameterTyper)
  {
    val$typer = paramParameterTyper;
  }
  
  public Object transform(Object value)
  {
    return new Integer(val$typer.getParameterTypes((.MethodInfo)value).length);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils.13
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */