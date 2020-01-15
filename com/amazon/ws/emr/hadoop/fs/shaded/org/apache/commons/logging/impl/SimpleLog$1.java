package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.impl;

import java.io.InputStream;
import java.security.PrivilegedAction;

final class SimpleLog$1
  implements PrivilegedAction<InputStream>
{
  SimpleLog$1(String paramString) {}
  
  public InputStream run()
  {
    ClassLoader threadCL = SimpleLog.access$000();
    if (threadCL != null) {
      return threadCL.getResourceAsStream(val$name);
    }
    return ClassLoader.getSystemResourceAsStream(val$name);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.impl.SimpleLog.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */