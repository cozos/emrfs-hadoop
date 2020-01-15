package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..AbstractClassGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..AbstractClassGenerator.Source;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ReflectUtils;

public class $FastClass$Generator
  extends .AbstractClassGenerator
{
  private static final .AbstractClassGenerator.Source SOURCE = new .AbstractClassGenerator.Source((.FastClass.class$net$sf$cglib$reflect$FastClass == null ? (.FastClass.class$net$sf$cglib$reflect$FastClass = .FastClass.class$("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect.$FastClass")) : .FastClass.class$net$sf$cglib$reflect$FastClass).getName());
  private Class type;
  
  public $FastClass$Generator()
  {
    super(SOURCE);
  }
  
  public void setType(Class type)
  {
    this.type = type;
  }
  
  public .FastClass create()
  {
    setNamePrefix(type.getName());
    return (.FastClass)super.create(type.getName());
  }
  
  protected ClassLoader getDefaultClassLoader()
  {
    return type.getClassLoader();
  }
  
  public void generateClass(.ClassVisitor v)
    throws Exception
  {
    new .FastClassEmitter(v, getClassName(), type);
  }
  
  protected Object firstInstance(Class type)
  {
    return .ReflectUtils.newInstance(type, new Class[] { .FastClass.class$java$lang$Class == null ? (.FastClass.class$java$lang$Class = .FastClass.class$("java.lang.Class")) : .FastClass.class$java$lang$Class }, new Object[] { this.type });
  }
  
  protected Object nextInstance(Object instance)
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastClass.Generator
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */