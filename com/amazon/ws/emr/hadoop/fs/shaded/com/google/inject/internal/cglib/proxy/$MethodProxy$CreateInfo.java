package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..AbstractClassGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..GeneratorStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..NamingPolicy;

class $MethodProxy$CreateInfo
{
  Class c1;
  Class c2;
  .NamingPolicy namingPolicy;
  .GeneratorStrategy strategy;
  boolean attemptLoad;
  
  public $MethodProxy$CreateInfo(Class c1, Class c2)
  {
    this.c1 = c1;
    this.c2 = c2;
    .AbstractClassGenerator fromEnhancer = .AbstractClassGenerator.getCurrent();
    if (fromEnhancer != null)
    {
      namingPolicy = fromEnhancer.getNamingPolicy();
      strategy = fromEnhancer.getStrategy();
      attemptLoad = fromEnhancer.getAttemptLoad();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..MethodProxy.CreateInfo
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */