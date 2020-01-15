package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Block;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ClassEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CollectionUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Constants;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..DuplicatesPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..MethodInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..MethodInfoTransformer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ObjectSwitchCallback;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ProcessSwitchCallback;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ReflectUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Signature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Transformer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..TypeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..VisibilityPredicate;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class $FastClassEmitter
  extends .ClassEmitter
{
  private static final .Signature CSTRUCT_CLASS = .TypeUtils.parseConstructor("Class");
  private static final .Signature METHOD_GET_INDEX = .TypeUtils.parseSignature("int getIndex(String, Class[])");
  private static final .Signature SIGNATURE_GET_INDEX = new .Signature("getIndex", .Type.INT_TYPE, new .Type[] { .Constants.TYPE_SIGNATURE });
  private static final .Signature TO_STRING = .TypeUtils.parseSignature("String toString()");
  private static final .Signature CONSTRUCTOR_GET_INDEX = .TypeUtils.parseSignature("int getIndex(Class[])");
  private static final .Signature INVOKE = .TypeUtils.parseSignature("Object invoke(int, Object, Object[])");
  private static final .Signature NEW_INSTANCE = .TypeUtils.parseSignature("Object newInstance(int, Object[])");
  private static final .Signature GET_MAX_INDEX = .TypeUtils.parseSignature("int getMaxIndex()");
  private static final .Signature GET_SIGNATURE_WITHOUT_RETURN_TYPE = .TypeUtils.parseSignature("String getSignatureWithoutReturnType(String, Class[])");
  private static final .Type FAST_CLASS = .TypeUtils.parseType("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect.$FastClass");
  private static final .Type ILLEGAL_ARGUMENT_EXCEPTION = .TypeUtils.parseType("IllegalArgumentException");
  private static final .Type INVOCATION_TARGET_EXCEPTION = .TypeUtils.parseType("java.lang.reflect.InvocationTargetException");
  private static final .Type[] INVOCATION_TARGET_EXCEPTION_ARRAY = { INVOCATION_TARGET_EXCEPTION };
  private static final int TOO_MANY_METHODS = 100;
  
  public $FastClassEmitter(.ClassVisitor v, String className, Class type)
  {
    super(v);
    
    .Type base = .Type.getType(type);
    begin_class(46, 1, className, FAST_CLASS, null, "<generated>");
    
    .CodeEmitter e = begin_method(1, CSTRUCT_CLASS, null);
    e.load_this();
    e.load_args();
    e.super_invoke_constructor(CSTRUCT_CLASS);
    e.return_value();
    e.end_method();
    
    .VisibilityPredicate vp = new .VisibilityPredicate(type, false);
    List methods = .ReflectUtils.addAllMethods(type, new ArrayList());
    .CollectionUtils.filter(methods, vp);
    .CollectionUtils.filter(methods, new .DuplicatesPredicate());
    List constructors = new ArrayList(Arrays.asList(type.getDeclaredConstructors()));
    .CollectionUtils.filter(constructors, vp);
    
    emitIndexBySignature(methods);
    
    emitIndexByClassArray(methods);
    
    e = begin_method(1, CONSTRUCTOR_GET_INDEX, null);
    e.load_args();
    List info = .CollectionUtils.transform(constructors, .MethodInfoTransformer.getInstance());
    .EmitUtils.constructor_switch(e, info, new GetIndexCallback(e, info));
    e.end_method();
    
    e = begin_method(1, INVOKE, INVOCATION_TARGET_EXCEPTION_ARRAY);
    e.load_arg(1);
    e.checkcast(base);
    e.load_arg(0);
    invokeSwitchHelper(e, methods, 2, base);
    e.end_method();
    
    e = begin_method(1, NEW_INSTANCE, INVOCATION_TARGET_EXCEPTION_ARRAY);
    e.new_instance(base);
    e.dup();
    e.load_arg(0);
    invokeSwitchHelper(e, constructors, 1, base);
    e.end_method();
    
    e = begin_method(1, GET_MAX_INDEX, null);
    e.push(methods.size() - 1);
    e.return_value();
    e.end_method();
    
    end_class();
  }
  
  private void emitIndexBySignature(List methods)
  {
    .CodeEmitter e = begin_method(1, SIGNATURE_GET_INDEX, null);
    List signatures = .CollectionUtils.transform(methods, new .Transformer()
    {
      public Object transform(Object obj)
      {
        return .ReflectUtils.getSignature((Method)obj).toString();
      }
    });
    e.load_arg(0);
    e.invoke_virtual(.Constants.TYPE_OBJECT, TO_STRING);
    signatureSwitchHelper(e, signatures);
    e.end_method();
  }
  
  private void emitIndexByClassArray(List methods)
  {
    .CodeEmitter e = begin_method(1, METHOD_GET_INDEX, null);
    if (methods.size() > 100)
    {
      List signatures = .CollectionUtils.transform(methods, new .Transformer()
      {
        public Object transform(Object obj)
        {
          String s = .ReflectUtils.getSignature((Method)obj).toString();
          return s.substring(0, s.lastIndexOf(')') + 1);
        }
      });
      e.load_args();
      e.invoke_static(FAST_CLASS, GET_SIGNATURE_WITHOUT_RETURN_TYPE);
      signatureSwitchHelper(e, signatures);
    }
    else
    {
      e.load_args();
      List info = .CollectionUtils.transform(methods, .MethodInfoTransformer.getInstance());
      .EmitUtils.method_switch(e, info, new GetIndexCallback(e, info));
    }
    e.end_method();
  }
  
  private void signatureSwitchHelper(.CodeEmitter e, List signatures)
  {
    .ObjectSwitchCallback callback = new .ObjectSwitchCallback()
    {
      private final .CodeEmitter val$e;
      private final List val$signatures;
      
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
    };
    .EmitUtils.string_switch(e, (String[])signatures.toArray(new String[signatures.size()]), 1, callback);
  }
  
  private static void invokeSwitchHelper(.CodeEmitter e, List members, int arg, .Type base)
  {
    List info = .CollectionUtils.transform(members, .MethodInfoTransformer.getInstance());
    .Label illegalArg = e.make_label();
    .Block block = e.begin_block();
    e.process_switch(getIntRange(info.size()), new .ProcessSwitchCallback()
    {
      private final List val$info;
      private final .CodeEmitter val$e;
      private final int val$arg;
      private final .Type val$base;
      private final .Label val$illegalArg;
      
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
    });
    block.end();
    .EmitUtils.wrap_throwable(block, INVOCATION_TARGET_EXCEPTION);
    e.mark(illegalArg);
    e.throw_exception(ILLEGAL_ARGUMENT_EXCEPTION, "Cannot find matching method/constructor");
  }
  
  private static class GetIndexCallback
    implements .ObjectSwitchCallback
  {
    private .CodeEmitter e;
    private Map indexes = new HashMap();
    
    public GetIndexCallback(.CodeEmitter e, List methods)
    {
      this.e = e;
      int index = 0;
      for (Iterator it = methods.iterator(); it.hasNext();) {
        indexes.put(it.next(), new Integer(index++));
      }
    }
    
    public void processCase(Object key, .Label end)
    {
      e.push(((Integer)indexes.get(key)).intValue());
      e.return_value();
    }
    
    public void processDefault()
    {
      e.push(-1);
      e.return_value();
    }
  }
  
  private static int[] getIntRange(int length)
  {
    int[] range = new int[length];
    for (int i = 0; i < length; i++) {
      range[i] = i;
    }
    return range;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastClassEmitter
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */