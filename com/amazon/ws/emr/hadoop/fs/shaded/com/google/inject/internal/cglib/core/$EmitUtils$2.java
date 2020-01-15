package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import java.util.List;
import java.util.Map;

final class $EmitUtils$2
  implements .ProcessSwitchCallback
{
  private final Map val$buckets;
  private final .CodeEmitter val$e;
  private final .ObjectSwitchCallback val$callback;
  private final .Label val$def;
  private final .Label val$end;
  
  $EmitUtils$2(Map paramMap, .CodeEmitter paramCodeEmitter, .ObjectSwitchCallback paramObjectSwitchCallback, .Label paramLabel1, .Label paramLabel2)
  {
    val$buckets = paramMap;val$e = paramCodeEmitter;val$callback = paramObjectSwitchCallback;val$def = paramLabel1;val$end = paramLabel2;
  }
  
  public void processCase(int key, .Label ignore_end)
    throws Exception
  {
    List bucket = (List)val$buckets.get(new Integer(key));
    .EmitUtils.access$000(val$e, bucket, val$callback, val$def, val$end, 0);
  }
  
  public void processDefault()
  {
    val$e.goTo(val$def);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils.2
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */