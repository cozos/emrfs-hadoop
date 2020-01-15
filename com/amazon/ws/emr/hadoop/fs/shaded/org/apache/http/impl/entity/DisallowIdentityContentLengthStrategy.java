package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentLengthStrategy;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DisallowIdentityContentLengthStrategy
  implements ContentLengthStrategy
{
  public static final DisallowIdentityContentLengthStrategy INSTANCE = new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategy(0));
  private final ContentLengthStrategy contentLengthStrategy;
  
  public DisallowIdentityContentLengthStrategy(ContentLengthStrategy contentLengthStrategy)
  {
    this.contentLengthStrategy = contentLengthStrategy;
  }
  
  public long determineLength(HttpMessage message)
    throws HttpException
  {
    long result = contentLengthStrategy.determineLength(message);
    if (result == -1L) {
      throw new ProtocolException("Identity transfer encoding cannot be used");
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.DisallowIdentityContentLengthStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */