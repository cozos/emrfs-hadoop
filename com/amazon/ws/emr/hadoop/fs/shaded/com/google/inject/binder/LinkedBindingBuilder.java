package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import java.lang.reflect.Constructor;

public abstract interface LinkedBindingBuilder<T>
  extends ScopedBindingBuilder
{
  public abstract ScopedBindingBuilder to(Class<? extends T> paramClass);
  
  public abstract ScopedBindingBuilder to(TypeLiteral<? extends T> paramTypeLiteral);
  
  public abstract ScopedBindingBuilder to(Key<? extends T> paramKey);
  
  public abstract void toInstance(T paramT);
  
  public abstract ScopedBindingBuilder toProvider(com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider<? extends T> paramProvider);
  
  public abstract ScopedBindingBuilder toProvider(Class<? extends javax.inject.Provider<? extends T>> paramClass);
  
  public abstract ScopedBindingBuilder toProvider(TypeLiteral<? extends javax.inject.Provider<? extends T>> paramTypeLiteral);
  
  public abstract ScopedBindingBuilder toProvider(Key<? extends javax.inject.Provider<? extends T>> paramKey);
  
  public abstract <S extends T> ScopedBindingBuilder toConstructor(Constructor<S> paramConstructor);
  
  public abstract <S extends T> ScopedBindingBuilder toConstructor(Constructor<S> paramConstructor, TypeLiteral<? extends S> paramTypeLiteral);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.LinkedBindingBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */