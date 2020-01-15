package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;
import java.lang.reflect.Method;

public abstract class $KeyFactory
{
  private static final .Signature GET_NAME = .TypeUtils.parseSignature("String getName()");
  private static final .Signature GET_CLASS = .TypeUtils.parseSignature("Class getClass()");
  private static final .Signature HASH_CODE = .TypeUtils.parseSignature("int hashCode()");
  private static final .Signature EQUALS = .TypeUtils.parseSignature("boolean equals(Object)");
  private static final .Signature TO_STRING = .TypeUtils.parseSignature("String toString()");
  private static final .Signature APPEND_STRING = .TypeUtils.parseSignature("StringBuffer append(String)");
  private static final .Type KEY_FACTORY = .TypeUtils.parseType("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core.$KeyFactory");
  private static final int[] PRIMES = { 11, 73, 179, 331, 521, 787, 1213, 1823, 2609, 3691, 5189, 7247, 10037, 13931, 19289, 26627, 36683, 50441, 69403, 95401, 131129, 180179, 247501, 340057, 467063, 641371, 880603, 1209107, 1660097, 2279161, 3129011, 4295723, 5897291, 8095873, 11114263, 15257791, 20946017, 28754629, 39474179, 54189869, 74391461, 102123817, 140194277, 192456917, 264202273, 362693231, 497900099, 683510293, 938313161, 1288102441, 1768288259 };
  public static final .Customizer CLASS_BY_NAME = new .Customizer()
  {
    public void customize(.CodeEmitter e, .Type type)
    {
      if (type.equals(.Constants.TYPE_CLASS)) {
        e.invoke_virtual(.Constants.TYPE_CLASS, .KeyFactory.GET_NAME);
      }
    }
  };
  public static final .Customizer OBJECT_BY_CLASS = new .Customizer()
  {
    public void customize(.CodeEmitter e, .Type type)
    {
      e.invoke_virtual(.Constants.TYPE_OBJECT, .KeyFactory.GET_CLASS);
    }
  };
  
  public static KeyFactory create(Class keyInterface)
  {
    return create(keyInterface, null);
  }
  
  public static KeyFactory create(Class keyInterface, .Customizer customizer)
  {
    return create(keyInterface.getClassLoader(), keyInterface, customizer);
  }
  
  public static KeyFactory create(ClassLoader loader, Class keyInterface, .Customizer customizer)
  {
    Generator gen = new Generator();
    gen.setInterface(keyInterface);
    gen.setCustomizer(customizer);
    gen.setClassLoader(loader);
    return gen.create();
  }
  
  public static class Generator
    extends .AbstractClassGenerator
  {
    private static final .AbstractClassGenerator.Source SOURCE = new .AbstractClassGenerator.Source(.KeyFactory.class.getName());
    private Class keyInterface;
    private .Customizer customizer;
    private int constant;
    private int multiplier;
    
    public Generator()
    {
      super();
    }
    
    protected ClassLoader getDefaultClassLoader()
    {
      return keyInterface.getClassLoader();
    }
    
    public void setCustomizer(.Customizer customizer)
    {
      this.customizer = customizer;
    }
    
    public void setInterface(Class keyInterface)
    {
      this.keyInterface = keyInterface;
    }
    
    public .KeyFactory create()
    {
      setNamePrefix(keyInterface.getName());
      return (.KeyFactory)super.create(keyInterface.getName());
    }
    
    public void setHashConstant(int constant)
    {
      this.constant = constant;
    }
    
    public void setHashMultiplier(int multiplier)
    {
      this.multiplier = multiplier;
    }
    
    protected Object firstInstance(Class type)
    {
      return .ReflectUtils.newInstance(type);
    }
    
    protected Object nextInstance(Object instance)
    {
      return instance;
    }
    
    public void generateClass(.ClassVisitor v)
    {
      .ClassEmitter ce = new .ClassEmitter(v);
      
      Method newInstance = .ReflectUtils.findNewInstance(keyInterface);
      if (!newInstance.getReturnType().equals(Object.class)) {
        throw new IllegalArgumentException("newInstance method must return Object");
      }
      .Type[] parameterTypes = .TypeUtils.getTypes(newInstance.getParameterTypes());
      ce.begin_class(46, 1, getClassName(), .KeyFactory.KEY_FACTORY, new .Type[] { .Type.getType(keyInterface) }, "<generated>");
      
      .EmitUtils.null_constructor(ce);
      .EmitUtils.factory_method(ce, .ReflectUtils.getSignature(newInstance));
      
      int seed = 0;
      .CodeEmitter e = ce.begin_method(1, .TypeUtils.parseConstructor(parameterTypes), null);
      
      e.load_this();
      e.super_invoke_constructor();
      e.load_this();
      for (int i = 0; i < parameterTypes.length; i++)
      {
        seed += parameterTypes[i].hashCode();
        ce.declare_field(18, getFieldName(i), parameterTypes[i], null);
        
        e.dup();
        e.load_arg(i);
        e.putfield(getFieldName(i));
      }
      e.return_value();
      e.end_method();
      
      e = ce.begin_method(1, .KeyFactory.HASH_CODE, null);
      int hc = constant != 0 ? constant : .KeyFactory.PRIMES[(Math.abs(seed) % .KeyFactory.PRIMES.length)];
      int hm = multiplier != 0 ? multiplier : .KeyFactory.PRIMES[(Math.abs(seed * 13) % .KeyFactory.PRIMES.length)];
      e.push(hc);
      for (int i = 0; i < parameterTypes.length; i++)
      {
        e.load_this();
        e.getfield(getFieldName(i));
        .EmitUtils.hash_code(e, parameterTypes[i], hm, customizer);
      }
      e.return_value();
      e.end_method();
      
      e = ce.begin_method(1, .KeyFactory.EQUALS, null);
      .Label fail = e.make_label();
      e.load_arg(0);
      e.instance_of_this();
      e.if_jump(153, fail);
      for (int i = 0; i < parameterTypes.length; i++)
      {
        e.load_this();
        e.getfield(getFieldName(i));
        e.load_arg(0);
        e.checkcast_this();
        e.getfield(getFieldName(i));
        .EmitUtils.not_equals(e, parameterTypes[i], fail, customizer);
      }
      e.push(1);
      e.return_value();
      e.mark(fail);
      e.push(0);
      e.return_value();
      e.end_method();
      
      e = ce.begin_method(1, .KeyFactory.TO_STRING, null);
      e.new_instance(.Constants.TYPE_STRING_BUFFER);
      e.dup();
      e.invoke_constructor(.Constants.TYPE_STRING_BUFFER);
      for (int i = 0; i < parameterTypes.length; i++)
      {
        if (i > 0)
        {
          e.push(", ");
          e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, .KeyFactory.APPEND_STRING);
        }
        e.load_this();
        e.getfield(getFieldName(i));
        .EmitUtils.append_string(e, parameterTypes[i], .EmitUtils.DEFAULT_DELIMITERS, customizer);
      }
      e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, .KeyFactory.TO_STRING);
      e.return_value();
      e.end_method();
      
      ce.end_class();
    }
    
    private String getFieldName(int arg)
    {
      return "FIELD_" + arg;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..KeyFactory
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */