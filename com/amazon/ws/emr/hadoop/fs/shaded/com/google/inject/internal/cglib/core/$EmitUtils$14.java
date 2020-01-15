package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import java.util.BitSet;
import java.util.List;
import java.util.Map;

final class $EmitUtils$14
  implements .ProcessSwitchCallback
{
  private final Map val$buckets;
  private final .CodeEmitter val$e;
  private final .ObjectSwitchCallback val$callback;
  private final .EmitUtils.ParameterTyper val$typer;
  private final .Label val$def;
  private final .Label val$end;
  
  $EmitUtils$14(Map paramMap, .CodeEmitter paramCodeEmitter, .ObjectSwitchCallback paramObjectSwitchCallback, .EmitUtils.ParameterTyper paramParameterTyper, .Label paramLabel1, .Label paramLabel2)
  {
    val$buckets = paramMap;val$e = paramCodeEmitter;val$callback = paramObjectSwitchCallback;val$typer = paramParameterTyper;val$def = paramLabel1;val$end = paramLabel2;
  }
  
  public void processCase(int key, .Label dontUseEnd)
    throws Exception
  {
    List bucket = (List)val$buckets.get(new Integer(key));
    .EmitUtils.access$900(val$e, bucket, val$callback, val$typer, val$def, val$end, new BitSet());
  }
  
  public void processDefault()
    throws Exception
  {
    val$e.goTo(val$def);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils.14
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */