package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

final class Scopes$2
  implements Scope
{
  public <T> Provider<T> scope(Key<T> key, Provider<T> unscoped)
  {
    return unscoped;
  }
  
  public String toString()
  {
    return "Scopes.NO_SCOPE";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scopes.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */