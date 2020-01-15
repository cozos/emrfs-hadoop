package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;

final class $EmitUtils$8
  implements .ProcessArrayCallback
{
  private final .CodeEmitter val$e;
  private final .Label val$notEquals;
  private final .Customizer val$customizer;
  
  $EmitUtils$8(.CodeEmitter paramCodeEmitter, .Label paramLabel, .Customizer paramCustomizer)
  {
    val$e = paramCodeEmitter;val$notEquals = paramLabel;val$customizer = paramCustomizer;
  }
  
  public void processElement(.Type type)
  {
    .EmitUtils.access$200(val$e, type, val$notEquals, val$customizer, this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils.8
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */