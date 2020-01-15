package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface ClassToInstanceMap<B>
  extends Map<Class<? extends B>, B>
{
  public abstract <T extends B> T getInstance(Class<T> paramClass);
  
  public abstract <T extends B> T putInstance(Class<T> paramClass, @Nullable T paramT);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ClassToInstanceMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */