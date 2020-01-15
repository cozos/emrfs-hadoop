package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ClassEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..MethodInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..TypeUtils;
import java.util.Iterator;
import java.util.List;

class $NoOpGenerator
  implements .CallbackGenerator
{
  public static final NoOpGenerator INSTANCE = new NoOpGenerator();
  
  public void generate(.ClassEmitter ce, .CallbackGenerator.Context context, List methods)
  {
    for (Iterator it = methods.iterator(); it.hasNext();)
    {
      .MethodInfo method = (.MethodInfo)it.next();
      if ((.TypeUtils.isProtected(context.getOriginalModifiers(method))) && (.TypeUtils.isPublic(method.getModifiers())))
      {
        .CodeEmitter e = .EmitUtils.begin_method(ce, method);
        e.load_this();
        e.load_args();
        e.super_invoke();
        e.return_value();
        e.end_method();
      }
    }
  }
  
  public void generateStatic(.CodeEmitter e, .CallbackGenerator.Context context, List methods) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..NoOpGenerator
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */