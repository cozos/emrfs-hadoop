package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ClassEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..MethodInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Signature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..TypeUtils;
import java.util.Iterator;
import java.util.List;

class $FixedValueGenerator
  implements .CallbackGenerator
{
  public static final FixedValueGenerator INSTANCE = new FixedValueGenerator();
  private static final .Type FIXED_VALUE = .TypeUtils.parseType("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy.$FixedValue");
  private static final .Signature LOAD_OBJECT = .TypeUtils.parseSignature("Object loadObject()");
  
  public void generate(.ClassEmitter ce, .CallbackGenerator.Context context, List methods)
  {
    for (Iterator it = methods.iterator(); it.hasNext();)
    {
      .MethodInfo method = (.MethodInfo)it.next();
      .CodeEmitter e = context.beginMethod(ce, method);
      context.emitCallback(e, context.getIndex(method));
      e.invoke_interface(FIXED_VALUE, LOAD_OBJECT);
      e.unbox_or_zero(e.getReturnType());
      e.return_value();
      e.end_method();
    }
  }
  
  public void generateStatic(.CodeEmitter e, .CallbackGenerator.Context context, List methods) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..FixedValueGenerator
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */