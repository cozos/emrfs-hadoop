package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ClassEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ClassInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CollectionUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Constants;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Local;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..MethodInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ObjectSwitchCallback;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Signature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Transformer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..TypeUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class $MethodInterceptorGenerator
  implements .CallbackGenerator
{
  public static final MethodInterceptorGenerator INSTANCE = new MethodInterceptorGenerator();
  static final String EMPTY_ARGS_NAME = "CGLIB$emptyArgs";
  static final String FIND_PROXY_NAME = "CGLIB$findMethodProxy";
  static final Class[] FIND_PROXY_TYPES = { .Signature.class };
  private static final .Type ABSTRACT_METHOD_ERROR = .TypeUtils.parseType("AbstractMethodError");
  private static final .Type METHOD = .TypeUtils.parseType("java.lang.reflect.Method");
  private static final .Type REFLECT_UTILS = .TypeUtils.parseType("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core.$ReflectUtils");
  private static final .Type METHOD_PROXY = .TypeUtils.parseType("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy.$MethodProxy");
  private static final .Type METHOD_INTERCEPTOR = .TypeUtils.parseType("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy.$MethodInterceptor");
  private static final .Signature GET_DECLARED_METHODS = .TypeUtils.parseSignature("java.lang.reflect.Method[] getDeclaredMethods()");
  private static final .Signature GET_DECLARING_CLASS = .TypeUtils.parseSignature("Class getDeclaringClass()");
  private static final .Signature FIND_METHODS = .TypeUtils.parseSignature("java.lang.reflect.Method[] findMethods(String[], java.lang.reflect.Method[])");
  private static final .Signature MAKE_PROXY = new .Signature("create", METHOD_PROXY, new .Type[] { .Constants.TYPE_CLASS, .Constants.TYPE_CLASS, .Constants.TYPE_STRING, .Constants.TYPE_STRING, .Constants.TYPE_STRING });
  private static final .Signature INTERCEPT = new .Signature("intercept", .Constants.TYPE_OBJECT, new .Type[] { .Constants.TYPE_OBJECT, METHOD, .Constants.TYPE_OBJECT_ARRAY, METHOD_PROXY });
  private static final .Signature FIND_PROXY = new .Signature("CGLIB$findMethodProxy", METHOD_PROXY, new .Type[] { .Constants.TYPE_SIGNATURE });
  private static final .Signature TO_STRING = .TypeUtils.parseSignature("String toString()");
  private static final .Transformer METHOD_TO_CLASS = new .Transformer()
  {
    public Object transform(Object value)
    {
      return ((.MethodInfo)value).getClassInfo();
    }
  };
  private static final .Signature CSTRUCT_SIGNATURE = .TypeUtils.parseConstructor("String, String");
  
  private String getMethodField(.Signature impl)
  {
    return impl.getName() + "$Method";
  }
  
  private String getMethodProxyField(.Signature impl)
  {
    return impl.getName() + "$Proxy";
  }
  
  public void generate(.ClassEmitter ce, .CallbackGenerator.Context context, List methods)
  {
    Map sigMap = new HashMap();
    for (Iterator it = methods.iterator(); it.hasNext();)
    {
      .MethodInfo method = (.MethodInfo)it.next();
      .Signature sig = method.getSignature();
      .Signature impl = context.getImplSignature(method);
      
      String methodField = getMethodField(impl);
      String methodProxyField = getMethodProxyField(impl);
      
      sigMap.put(sig.toString(), methodProxyField);
      ce.declare_field(26, methodField, METHOD, null);
      ce.declare_field(26, methodProxyField, METHOD_PROXY, null);
      ce.declare_field(26, "CGLIB$emptyArgs", .Constants.TYPE_OBJECT_ARRAY, null);
      
      .CodeEmitter e = ce.begin_method(16, impl, method.getExceptionTypes());
      
      superHelper(e, method);
      e.return_value();
      e.end_method();
      
      e = context.beginMethod(ce, method);
      .Label nullInterceptor = e.make_label();
      context.emitCallback(e, context.getIndex(method));
      e.dup();
      e.ifnull(nullInterceptor);
      
      e.load_this();
      e.getfield(methodField);
      if (sig.getArgumentTypes().length == 0) {
        e.getfield("CGLIB$emptyArgs");
      } else {
        e.create_arg_array();
      }
      e.getfield(methodProxyField);
      e.invoke_interface(METHOD_INTERCEPTOR, INTERCEPT);
      e.unbox_or_zero(sig.getReturnType());
      e.return_value();
      
      e.mark(nullInterceptor);
      superHelper(e, method);
      e.return_value();
      e.end_method();
    }
    generateFindProxy(ce, sigMap);
  }
  
  private static void superHelper(.CodeEmitter e, .MethodInfo method)
  {
    if (.TypeUtils.isAbstract(method.getModifiers()))
    {
      e.throw_exception(ABSTRACT_METHOD_ERROR, method.toString() + " is abstract");
    }
    else
    {
      e.load_this();
      e.load_args();
      e.super_invoke(method.getSignature());
    }
  }
  
  public void generateStatic(.CodeEmitter e, .CallbackGenerator.Context context, List methods)
    throws Exception
  {
    e.push(0);
    e.newarray();
    e.putfield("CGLIB$emptyArgs");
    
    .Local thisclass = e.make_local();
    .Local declaringclass = e.make_local();
    .EmitUtils.load_class_this(e);
    e.store_local(thisclass);
    
    Map methodsByClass = .CollectionUtils.bucket(methods, METHOD_TO_CLASS);
    for (Iterator i = methodsByClass.keySet().iterator(); i.hasNext();)
    {
      .ClassInfo classInfo = (.ClassInfo)i.next();
      
      List classMethods = (List)methodsByClass.get(classInfo);
      e.push(2 * classMethods.size());
      e.newarray(.Constants.TYPE_STRING);
      for (int index = 0; index < classMethods.size(); index++)
      {
        .MethodInfo method = (.MethodInfo)classMethods.get(index);
        .Signature sig = method.getSignature();
        e.dup();
        e.push(2 * index);
        e.push(sig.getName());
        e.aastore();
        e.dup();
        e.push(2 * index + 1);
        e.push(sig.getDescriptor());
        e.aastore();
      }
      .EmitUtils.load_class(e, classInfo.getType());
      e.dup();
      e.store_local(declaringclass);
      e.invoke_virtual(.Constants.TYPE_CLASS, GET_DECLARED_METHODS);
      e.invoke_static(REFLECT_UTILS, FIND_METHODS);
      for (int index = 0; index < classMethods.size(); index++)
      {
        .MethodInfo method = (.MethodInfo)classMethods.get(index);
        .Signature sig = method.getSignature();
        .Signature impl = context.getImplSignature(method);
        e.dup();
        e.push(index);
        e.array_load(METHOD);
        e.putfield(getMethodField(impl));
        
        e.load_local(declaringclass);
        e.load_local(thisclass);
        e.push(sig.getDescriptor());
        e.push(sig.getName());
        e.push(impl.getName());
        e.invoke_static(METHOD_PROXY, MAKE_PROXY);
        e.putfield(getMethodProxyField(impl));
      }
      e.pop();
    }
  }
  
  public void generateFindProxy(.ClassEmitter ce, Map sigMap)
  {
    .CodeEmitter e = ce.begin_method(9, FIND_PROXY, null);
    
    e.load_arg(0);
    e.invoke_virtual(.Constants.TYPE_OBJECT, TO_STRING);
    .ObjectSwitchCallback callback = new .ObjectSwitchCallback()
    {
      private final .CodeEmitter val$e;
      private final Map val$sigMap;
      
      public void processCase(Object key, .Label end)
      {
        val$e.getfield((String)val$sigMap.get(key));
        val$e.return_value();
      }
      
      public void processDefault()
      {
        val$e.aconst_null();
        val$e.return_value();
      }
    };
    .EmitUtils.string_switch(e, (String[])sigMap.keySet().toArray(new String[0]), 1, callback);
    
    e.end_method();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..MethodInterceptorGenerator
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */