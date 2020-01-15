package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import java.io.Serializable;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public final class HttpVersion
  extends ProtocolVersion
  implements Serializable
{
  private static final long serialVersionUID = -5856653513894415344L;
  public static final String HTTP = "HTTP";
  public static final HttpVersion HTTP_0_9 = new HttpVersion(0, 9);
  public static final HttpVersion HTTP_1_0 = new HttpVersion(1, 0);
  public static final HttpVersion HTTP_1_1 = new HttpVersion(1, 1);
  
  public HttpVersion(int major, int minor)
  {
    super("HTTP", major, minor);
  }
  
  public ProtocolVersion forVersion(int major, int minor)
  {
    if ((major == this.major) && (minor == this.minor)) {
      return this;
    }
    if (major == 1)
    {
      if (minor == 0) {
        return HTTP_1_0;
      }
      if (minor == 1) {
        return HTTP_1_1;
      }
    }
    if ((major == 0) && (minor == 9)) {
      return HTTP_0_9;
    }
    return new HttpVersion(major, minor);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpVersion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */