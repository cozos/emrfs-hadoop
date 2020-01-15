package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool;

class AbstractConnPool$1
  extends RouteSpecificPool<T, C, E>
{
  AbstractConnPool$1(AbstractConnPool paramAbstractConnPool, Object x0, Object paramObject1)
  {
    super(x0);
  }
  
  protected E createEntry(C conn)
  {
    return this$0.createEntry(val$route, conn);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.AbstractConnPool.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */