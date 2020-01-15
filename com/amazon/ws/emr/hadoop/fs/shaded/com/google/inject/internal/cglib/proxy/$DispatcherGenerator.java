package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ClassEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ClassInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..MethodInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Signature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..TypeUtils;
import java.util.Iterator;
import java.util.List;

class $DispatcherGenerator
  implements .CallbackGenerator
{
  public static final DispatcherGenerator INSTANCE = new DispatcherGenerator(false);
  public static final DispatcherGenerator PROXY_REF_INSTANCE = new DispatcherGenerator(true);
  private static final .Type DISPATCHER = .TypeUtils.parseType("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy.$Dispatcher");
  private static final .Type PROXY_REF_DISPATCHER = .TypeUtils.parseType("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy.$ProxyRefDispatcher");
  private static final .Signature LOAD_OBJECT = .TypeUtils.parseSignature("Object loadObject()");
  private static final .Signature PROXY_REF_LOAD_OBJECT = .TypeUtils.parseSignature("Object loadObject(Object)");
  private boolean proxyRef;
  
  private $DispatcherGenerator(boolean proxyRef)
  {
    this.proxyRef = proxyRef;
  }
  
  public void generate(.ClassEmitter ce, .CallbackGenerator.Context context, List methods)
  {
    for (Iterator it = methods.iterator(); it.hasNext();)
    {
      .MethodInfo method = (.MethodInfo)it.next();
      if (!.TypeUtils.isProtected(method.getModifiers()))
      {
        .CodeEmitter e = context.beginMethod(ce, method);
        context.emitCallback(e, context.getIndex(method));
        if (proxyRef)
        {
          e.load_this();
          e.invoke_interface(PROXY_REF_DISPATCHER, PROXY_REF_LOAD_OBJECT);
        }
        else
        {
          e.invoke_interface(DISPATCHER, LOAD_OBJECT);
        }
        e.checkcast(method.getClassInfo().getType());
        e.load_args();
        e.invoke(method);
        e.return_value();
        e.end_method();
      }
    }
  }
  
  public void generateStatic(.CodeEmitter e, .CallbackGenerator.Context context, List methods) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..DispatcherGenerator
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */