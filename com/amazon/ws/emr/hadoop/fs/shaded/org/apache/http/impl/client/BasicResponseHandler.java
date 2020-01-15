package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.HttpResponseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.EntityUtils;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class BasicResponseHandler
  extends AbstractResponseHandler<String>
{
  public String handleEntity(HttpEntity entity)
    throws IOException
  {
    return EntityUtils.toString(entity);
  }
  
  public String handleResponse(HttpResponse response)
    throws HttpResponseException, IOException
  {
    return (String)super.handleResponse(response);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.BasicResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */