package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;
import java.lang.reflect.Method;

public class $KeyFactory$Generator
  extends .AbstractClassGenerator
{
  private static final .AbstractClassGenerator.Source SOURCE = new .AbstractClassGenerator.Source((.KeyFactory.class$net$sf$cglib$core$KeyFactory == null ? (.KeyFactory.class$net$sf$cglib$core$KeyFactory = .KeyFactory.class$("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core.$KeyFactory")) : .KeyFactory.class$net$sf$cglib$core$KeyFactory).getName());
  private Class keyInterface;
  private .Customizer customizer;
  private int constant;
  private int multiplier;
  
  public $KeyFactory$Generator()
  {
    super(SOURCE);
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
    if (!newInstance.getReturnType().equals(.KeyFactory.class$java$lang$Object == null ? (.KeyFactory.class$java$lang$Object = .KeyFactory.class$("java.lang.Object")) : .KeyFactory.class$java$lang$Object)) {
      throw new IllegalArgumentException("newInstance method must return Object");
    }
    .Type[] parameterTypes = .TypeUtils.getTypes(newInstance.getParameterTypes());
    ce.begin_class(46, 1, getClassName(), .KeyFactory.access$200(), new .Type[] { .Type.getType(keyInterface) }, "<generated>");
    
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
    
    e = ce.begin_method(1, .KeyFactory.access$300(), null);
    int hc = constant != 0 ? constant : .KeyFactory.access$400()[(Math.abs(seed) % .KeyFactory.access$400().length)];
    int hm = multiplier != 0 ? multiplier : .KeyFactory.access$400()[(Math.abs(seed * 13) % .KeyFactory.access$400().length)];
    e.push(hc);
    for (int i = 0; i < parameterTypes.length; i++)
    {
      e.load_this();
      e.getfield(getFieldName(i));
      .EmitUtils.hash_code(e, parameterTypes[i], hm, customizer);
    }
    e.return_value();
    e.end_method();
    
    e = ce.begin_method(1, .KeyFactory.access$500(), null);
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
    
    e = ce.begin_method(1, .KeyFactory.access$600(), null);
    e.new_instance(.Constants.TYPE_STRING_BUFFER);
    e.dup();
    e.invoke_constructor(.Constants.TYPE_STRING_BUFFER);
    for (int i = 0; i < parameterTypes.length; i++)
    {
      if (i > 0)
      {
        e.push(", ");
        e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, .KeyFactory.access$700());
      }
      e.load_this();
      e.getfield(getFieldName(i));
      .EmitUtils.append_string(e, parameterTypes[i], .EmitUtils.DEFAULT_DELIMITERS, customizer);
    }
    e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, .KeyFactory.access$600());
    e.return_value();
    e.end_method();
    
    ce.end_class();
  }
  
  private String getFieldName(int arg)
  {
    return "FIELD_" + arg;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..KeyFactory.Generator
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */