package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.aopalliance.intercept.MethodInterceptor;

public abstract interface ConstructorBinding<T>
  extends Binding<T>, HasDependencies
{
  public abstract InjectionPoint getConstructor();
  
  public abstract Set<InjectionPoint> getInjectableMembers();
  
  public abstract Map<Method, List<MethodInterceptor>> getMethodInterceptors();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ConstructorBinding
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */