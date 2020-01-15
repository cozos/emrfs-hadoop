package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import java.util.List;
import java.util.Map;

final class $EmitUtils$12
  implements .ObjectSwitchCallback
{
  private final .CodeEmitter val$e;
  private final Map val$buckets;
  private final .ObjectSwitchCallback val$callback;
  private final .EmitUtils.ParameterTyper val$cached;
  private final .Label val$def;
  private final .Label val$end;
  
  $EmitUtils$12(.CodeEmitter paramCodeEmitter, Map paramMap, .ObjectSwitchCallback paramObjectSwitchCallback, .EmitUtils.ParameterTyper paramParameterTyper, .Label paramLabel1, .Label paramLabel2)
  {
    val$e = paramCodeEmitter;val$buckets = paramMap;val$callback = paramObjectSwitchCallback;val$cached = paramParameterTyper;val$def = paramLabel1;val$end = paramLabel2;
  }
  
  public void processCase(Object key, .Label dontUseEnd)
    throws Exception
  {
    .EmitUtils.access$800(val$e, (List)val$buckets.get(key), val$callback, val$cached, val$def, val$end);
  }
  
  public void processDefault()
    throws Exception
  {
    val$e.goTo(val$def);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils.12
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */