package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;

final class $EmitUtils$7
  implements .ProcessArrayCallback
{
  private final .CodeEmitter val$e;
  private final int val$multiplier;
  private final .Customizer val$customizer;
  
  $EmitUtils$7(.CodeEmitter paramCodeEmitter, int paramInt, .Customizer paramCustomizer)
  {
    val$e = paramCodeEmitter;val$multiplier = paramInt;val$customizer = paramCustomizer;
  }
  
  public void processElement(.Type type)
  {
    .EmitUtils.hash_code(val$e, type, val$multiplier, val$customizer);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils.7
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */