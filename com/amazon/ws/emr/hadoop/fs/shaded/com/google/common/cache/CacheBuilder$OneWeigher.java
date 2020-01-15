package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

 enum CacheBuilder$OneWeigher
  implements Weigher<Object, Object>
{
  INSTANCE;
  
  private CacheBuilder$OneWeigher() {}
  
  public int weigh(Object key, Object value)
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilder.OneWeigher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */