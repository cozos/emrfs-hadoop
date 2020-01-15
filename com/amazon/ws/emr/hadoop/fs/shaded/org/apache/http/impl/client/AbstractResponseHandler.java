package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.HttpResponseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.EntityUtils;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public abstract class AbstractResponseHandler<T>
  implements ResponseHandler<T>
{
  public T handleResponse(HttpResponse response)
    throws HttpResponseException, IOException
  {
    StatusLine statusLine = response.getStatusLine();
    HttpEntity entity = response.getEntity();
    if (statusLine.getStatusCode() >= 300)
    {
      EntityUtils.consume(entity);
      throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
    }
    return entity == null ? null : handleEntity(entity);
  }
  
  public abstract T handleEntity(HttpEntity paramHttpEntity)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.AbstractResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */