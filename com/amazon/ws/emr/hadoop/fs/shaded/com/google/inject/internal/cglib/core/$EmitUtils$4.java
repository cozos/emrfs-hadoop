package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import java.util.List;
import java.util.Map;

final class $EmitUtils$4
  implements .ProcessSwitchCallback
{
  private final Map val$buckets;
  private final int val$index;
  private final int val$len;
  private final .CodeEmitter val$e;
  private final .ObjectSwitchCallback val$callback;
  private final .Label val$end;
  private final .Label val$def;
  
  $EmitUtils$4(Map paramMap, int paramInt1, int paramInt2, .CodeEmitter paramCodeEmitter, .ObjectSwitchCallback paramObjectSwitchCallback, .Label paramLabel1, .Label paramLabel2)
  {
    val$buckets = paramMap;val$index = paramInt1;val$len = paramInt2;val$e = paramCodeEmitter;val$callback = paramObjectSwitchCallback;val$end = paramLabel1;val$def = paramLabel2;
  }
  
  public void processCase(int key, .Label ignore_end)
    throws Exception
  {
    List bucket = (List)val$buckets.get(new Integer(key));
    if (val$index + 1 == val$len)
    {
      val$e.pop();
      val$callback.processCase(bucket.get(0), val$end);
    }
    else
    {
      .EmitUtils.access$000(val$e, bucket, val$callback, val$def, val$end, val$index + 1);
    }
  }
  
  public void processDefault()
  {
    val$e.goTo(val$def);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils.4
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */