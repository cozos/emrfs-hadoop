package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Nullable;
import java.util.Map;

public abstract class FailableCache<K, V>
{
  private final Map<K, Object> delegate = new .MapMaker().makeComputingMap(new .Function()
  {
    public Object apply(@.Nullable K key)
    {
      Errors errors = new Errors();
      V result = null;
      try
      {
        result = create(key, errors);
      }
      catch (ErrorsException e)
      {
        errors.merge(e.getErrors());
      }
      return errors.hasErrors() ? errors : result;
    }
  });
  
  protected abstract V create(K paramK, Errors paramErrors)
    throws ErrorsException;
  
  public V get(K key, Errors errors)
    throws ErrorsException
  {
    Object resultOrError = delegate.get(key);
    if ((resultOrError instanceof Errors))
    {
      errors.merge((Errors)resultOrError);
      throw errors.toException();
    }
    V result = (V)resultOrError;
    return result;
  }
  
  boolean remove(K key)
  {
    return delegate.remove(key) != null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.FailableCache
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */