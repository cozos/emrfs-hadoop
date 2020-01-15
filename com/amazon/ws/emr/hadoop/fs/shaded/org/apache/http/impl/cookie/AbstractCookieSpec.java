package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Asserts;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Contract(threading=ThreadingBehavior.SAFE)
public abstract class AbstractCookieSpec
  implements CookieSpec
{
  private final Map<String, CookieAttributeHandler> attribHandlerMap;
  
  public AbstractCookieSpec()
  {
    attribHandlerMap = new ConcurrentHashMap(10);
  }
  
  protected AbstractCookieSpec(HashMap<String, CookieAttributeHandler> map)
  {
    Asserts.notNull(map, "Attribute handler map");
    attribHandlerMap = new ConcurrentHashMap(map);
  }
  
  protected AbstractCookieSpec(CommonCookieAttributeHandler... handlers)
  {
    attribHandlerMap = new ConcurrentHashMap(handlers.length);
    for (CommonCookieAttributeHandler handler : handlers) {
      attribHandlerMap.put(handler.getAttributeName(), handler);
    }
  }
  
  @Deprecated
  public void registerAttribHandler(String name, CookieAttributeHandler handler)
  {
    Args.notNull(name, "Attribute name");
    Args.notNull(handler, "Attribute handler");
    attribHandlerMap.put(name, handler);
  }
  
  protected CookieAttributeHandler findAttribHandler(String name)
  {
    return (CookieAttributeHandler)attribHandlerMap.get(name);
  }
  
  protected CookieAttributeHandler getAttribHandler(String name)
  {
    CookieAttributeHandler handler = findAttribHandler(name);
    Asserts.check(handler != null, "Handler not registered for " + name + " attribute");
    
    return handler;
  }
  
  protected Collection<CookieAttributeHandler> getAttribHandlers()
  {
    return attribHandlerMap.values();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.AbstractCookieSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */