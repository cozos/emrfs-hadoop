package com.amazon.ws.emr.hadoop.fs.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.EntityUtils;
import java.io.IOException;
import org.slf4j.Logger;

class YarnClient$1
  implements ResponseHandler<String>
{
  YarnClient$1(YarnClient this$0, String paramString) {}
  
  public String handleResponse(HttpResponse response)
    throws IOException
  {
    int status = response.getStatusLine().getStatusCode();
    if (status != 200)
    {
      YarnClient.access$000().warn("Received failed response for {} (HTTP error code {})", val$url, Integer.valueOf(status));
      return "";
    }
    HttpEntity entity = response.getEntity();
    return entity != null ? EntityUtils.toString(entity) : "";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.client.YarnClient.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */