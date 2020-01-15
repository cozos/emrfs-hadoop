package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class $EmitUtils$6
  implements .ProcessSwitchCallback
{
  private final Map val$buckets;
  private final boolean val$skipEquals;
  private final .CodeEmitter val$e;
  private final .ObjectSwitchCallback val$callback;
  private final .Label val$end;
  private final .Label val$def;
  
  $EmitUtils$6(Map paramMap, boolean paramBoolean, .CodeEmitter paramCodeEmitter, .ObjectSwitchCallback paramObjectSwitchCallback, .Label paramLabel1, .Label paramLabel2)
  {
    val$buckets = paramMap;val$skipEquals = paramBoolean;val$e = paramCodeEmitter;val$callback = paramObjectSwitchCallback;val$end = paramLabel1;val$def = paramLabel2;
  }
  
  public void processCase(int key, .Label ignore_end)
    throws Exception
  {
    List bucket = (List)val$buckets.get(new Integer(key));
    .Label next = null;
    Iterator it;
    if ((val$skipEquals) && (bucket.size() == 1))
    {
      if (val$skipEquals) {
        val$e.pop();
      }
      val$callback.processCase((String)bucket.get(0), val$end);
    }
    else
    {
      for (it = bucket.iterator(); it.hasNext();)
      {
        String string = (String)it.next();
        if (next != null) {
          val$e.mark(next);
        }
        if (it.hasNext()) {
          val$e.dup();
        }
        val$e.push(string);
        val$e.invoke_virtual(.Constants.TYPE_OBJECT, .EmitUtils.access$100());
        if (it.hasNext())
        {
          val$e.if_jump(153, next = val$e.make_label());
          val$e.pop();
        }
        else
        {
          val$e.if_jump(153, val$def);
        }
        val$callback.processCase(string, val$end);
      }
    }
  }
  
  public void processDefault()
  {
    val$e.pop();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils.6
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */