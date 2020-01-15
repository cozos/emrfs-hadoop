package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ObjectSwitchCallback;
import java.util.List;

class $FastClassEmitter$3
  implements .ObjectSwitchCallback
{
  private final .CodeEmitter val$e;
  private final List val$signatures;
  private final .FastClassEmitter this$0;
  
  $FastClassEmitter$3(.FastClassEmitter paramFastClassEmitter, .CodeEmitter paramCodeEmitter, List paramList)
  {
    this$0 = paramFastClassEmitter;val$e = paramCodeEmitter;val$signatures = paramList;
  }
  
  public void processCase(Object key, .Label end)
  {
    val$e.push(val$signatures.indexOf(key));
    val$e.return_value();
  }
  
  public void processDefault()
  {
    val$e.push(-1);
    val$e.return_value();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastClassEmitter.3
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */