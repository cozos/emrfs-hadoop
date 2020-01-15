package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;

class ConstructorInjectorStore$1
  extends FailableCache<InjectionPoint, ConstructorInjector<?>>
{
  ConstructorInjectorStore$1(ConstructorInjectorStore paramConstructorInjectorStore) {}
  
  protected ConstructorInjector<?> create(InjectionPoint constructorInjector, Errors errors)
    throws ErrorsException
  {
    return ConstructorInjectorStore.access$000(this$0, constructorInjector, errors);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ConstructorInjectorStore.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */