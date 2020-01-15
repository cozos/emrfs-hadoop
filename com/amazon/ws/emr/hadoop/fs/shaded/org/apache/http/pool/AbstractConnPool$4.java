package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool;

class AbstractConnPool$4
  implements PoolEntryCallback<T, C>
{
  AbstractConnPool$4(AbstractConnPool paramAbstractConnPool, long paramLong) {}
  
  public void process(PoolEntry<T, C> entry)
  {
    if (entry.isExpired(val$now)) {
      entry.close();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.AbstractConnPool.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */