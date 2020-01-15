package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..MethodInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ProcessSwitchCallback;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Signature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..TypeUtils;
import java.util.List;

final class $FastClassEmitter$4
  implements .ProcessSwitchCallback
{
  private final List val$info;
  private final .CodeEmitter val$e;
  private final int val$arg;
  private final .Type val$base;
  private final .Label val$illegalArg;
  
  $FastClassEmitter$4(List paramList, .CodeEmitter paramCodeEmitter, int paramInt, .Type paramType, .Label paramLabel)
  {
    val$info = paramList;val$e = paramCodeEmitter;val$arg = paramInt;val$base = paramType;val$illegalArg = paramLabel;
  }
  
  public void processCase(int key, .Label end)
  {
    .MethodInfo method = (.MethodInfo)val$info.get(key);
    .Type[] types = method.getSignature().getArgumentTypes();
    for (int i = 0; i < types.length; i++)
    {
      val$e.load_arg(val$arg);
      val$e.aaload(i);
      val$e.unbox(types[i]);
    }
    val$e.invoke(method, val$base);
    if (!.TypeUtils.isConstructor(method)) {
      val$e.box(method.getSignature().getReturnType());
    }
    val$e.return_value();
  }
  
  public void processDefault()
  {
    val$e.goTo(val$illegalArg);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastClassEmitter.4
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */