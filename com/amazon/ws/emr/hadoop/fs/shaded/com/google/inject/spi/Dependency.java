package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.util.List;
import java.util.Set;

public final class Dependency<T>
{
  private final InjectionPoint injectionPoint;
  private final Key<T> key;
  private final boolean nullable;
  private final int parameterIndex;
  
  Dependency(InjectionPoint injectionPoint, Key<T> key, boolean nullable, int parameterIndex)
  {
    this.injectionPoint = injectionPoint;
    this.key = ((Key).Preconditions.checkNotNull(key, "key"));
    this.nullable = nullable;
    this.parameterIndex = parameterIndex;
  }
  
  public static <T> Dependency<T> get(Key<T> key)
  {
    return new Dependency(null, key, true, -1);
  }
  
  public static Set<Dependency<?>> forInjectionPoints(Set<InjectionPoint> injectionPoints)
  {
    List<Dependency<?>> dependencies = .Lists.newArrayList();
    for (InjectionPoint injectionPoint : injectionPoints) {
      dependencies.addAll(injectionPoint.getDependencies());
    }
    return .ImmutableSet.copyOf(dependencies);
  }
  
  public Key<T> getKey()
  {
    return key;
  }
  
  public boolean isNullable()
  {
    return nullable;
  }
  
  public InjectionPoint getInjectionPoint()
  {
    return injectionPoint;
  }
  
  public int getParameterIndex()
  {
    return parameterIndex;
  }
  
  public int hashCode()
  {
    return .Objects.hashCode(new Object[] { injectionPoint, Integer.valueOf(parameterIndex), key });
  }
  
  public boolean equals(Object o)
  {
    if ((o instanceof Dependency))
    {
      Dependency dependency = (Dependency)o;
      return (.Objects.equal(injectionPoint, injectionPoint)) && (.Objects.equal(Integer.valueOf(parameterIndex), Integer.valueOf(parameterIndex))) && (.Objects.equal(key, key));
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append(key);
    if (injectionPoint != null)
    {
      builder.append("@").append(injectionPoint);
      if (parameterIndex != -1) {
        builder.append("[").append(parameterIndex).append("]");
      }
    }
    return builder.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */