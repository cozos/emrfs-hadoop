package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool;

public abstract interface PoolEntryCallback<T, C>
{
  public abstract void process(PoolEntry<T, C> paramPoolEntry);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.PoolEntryCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */