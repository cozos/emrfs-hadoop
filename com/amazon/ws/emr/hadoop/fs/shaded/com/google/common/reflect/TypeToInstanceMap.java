package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
public abstract interface TypeToInstanceMap<B>
  extends Map<TypeToken<? extends B>, B>
{
  @Nullable
  public abstract <T extends B> T getInstance(Class<T> paramClass);
  
  @Nullable
  public abstract <T extends B> T putInstance(Class<T> paramClass, @Nullable T paramT);
  
  @Nullable
  public abstract <T extends B> T getInstance(TypeToken<T> paramTypeToken);
  
  @Nullable
  public abstract <T extends B> T putInstance(TypeToken<T> paramTypeToken, @Nullable T paramT);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToInstanceMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */