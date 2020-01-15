package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;

final class $EmitUtils$9
  implements .ProcessArrayCallback
{
  private final .CodeEmitter val$e;
  private final .EmitUtils.ArrayDelimiters val$d;
  private final .Customizer val$customizer;
  
  $EmitUtils$9(.CodeEmitter paramCodeEmitter, .EmitUtils.ArrayDelimiters paramArrayDelimiters, .Customizer paramCustomizer)
  {
    val$e = paramCodeEmitter;val$d = paramArrayDelimiters;val$customizer = paramCustomizer;
  }
  
  public void processElement(.Type type)
  {
    .EmitUtils.access$300(val$e, type, val$d, val$customizer, this);
    val$e.push(.EmitUtils.ArrayDelimiters.access$400(val$d));
    val$e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, .EmitUtils.access$500());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils.9
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */