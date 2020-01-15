package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedElementBuilder;

public abstract interface PrivateBinder
  extends Binder
{
  public abstract void expose(Key<?> paramKey);
  
  public abstract AnnotatedElementBuilder expose(Class<?> paramClass);
  
  public abstract AnnotatedElementBuilder expose(TypeLiteral<?> paramTypeLiteral);
  
  public abstract PrivateBinder withSource(Object paramObject);
  
  public abstract PrivateBinder skipSources(Class... paramVarArgs);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.PrivateBinder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */