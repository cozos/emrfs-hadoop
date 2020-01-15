package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

final class Initializables
{
  static <T> Initializable<T> of(T instance)
  {
    new Initializable()
    {
      public T get(Errors errors)
        throws ErrorsException
      {
        return (T)val$instance;
      }
      
      public String toString()
      {
        return String.valueOf(val$instance);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Initializables
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */