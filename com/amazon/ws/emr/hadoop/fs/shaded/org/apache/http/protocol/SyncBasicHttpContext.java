package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

@Deprecated
public class SyncBasicHttpContext
  extends BasicHttpContext
{
  public SyncBasicHttpContext(HttpContext parentContext)
  {
    super(parentContext);
  }
  
  public SyncBasicHttpContext() {}
  
  public synchronized Object getAttribute(String id)
  {
    return super.getAttribute(id);
  }
  
  public synchronized void setAttribute(String id, Object obj)
  {
    super.setAttribute(id, obj);
  }
  
  public synchronized Object removeAttribute(String id)
  {
    return super.removeAttribute(id);
  }
  
  public synchronized void clear()
  {
    super.clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.SyncBasicHttpContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */