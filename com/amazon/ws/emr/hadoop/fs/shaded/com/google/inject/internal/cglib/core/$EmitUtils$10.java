package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;
import java.util.Map;

final class $EmitUtils$10
  implements .EmitUtils.ParameterTyper
{
  private final Map val$cache;
  
  $EmitUtils$10(Map paramMap)
  {
    val$cache = paramMap;
  }
  
  public .Type[] getParameterTypes(.MethodInfo member)
  {
    .Type[] types = (.Type[])val$cache.get(member);
    if (types == null) {
      val$cache.put(member, types = member.getSignature().getArgumentTypes());
    }
    return types;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils.10
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */