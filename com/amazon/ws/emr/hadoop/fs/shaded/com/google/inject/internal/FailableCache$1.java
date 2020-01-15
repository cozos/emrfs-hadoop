package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Nullable;

class FailableCache$1
  implements .Function<K, Object>
{
  FailableCache$1(FailableCache paramFailableCache) {}
  
  public Object apply(@.Nullable K key)
  {
    Errors errors = new Errors();
    V result = null;
    try
    {
      result = this$0.create(key, errors);
    }
    catch (ErrorsException e)
    {
      errors.merge(e.getErrors());
    }
    return errors.hasErrors() ? errors : result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.FailableCache.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */