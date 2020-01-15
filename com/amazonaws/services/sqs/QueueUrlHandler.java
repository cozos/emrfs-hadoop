package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AbstractRequestHandler;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QueueUrlHandler
  extends AbstractRequestHandler
{
  private static final String QUEUE_URL_PARAMETER = "QueueUrl";
  
  public void beforeRequest(Request<?> request)
  {
    Map<String, List<String>> requestParams = request.getParameters();
    List<String> queueURLParam = (List)requestParams.get("QueueUrl");
    if ((queueURLParam != null) && (!queueURLParam.isEmpty()))
    {
      List<String> queueURLParameter = (List)requestParams.remove("QueueUrl");
      String queueUrl = (String)queueURLParameter.iterator().next();
      try
      {
        URI uri = new URI(queueUrl);
        request.setResourcePath(uri.getPath());
        if (uri.getHost() != null)
        {
          URI uriWithoutPath = new URI(uri.toString().replace(uri.getPath(), ""));
          request.setEndpoint(uriWithoutPath);
        }
      }
      catch (URISyntaxException e)
      {
        throw new AmazonClientException("Unable to parse SQS queue URL '" + queueUrl + "'", e);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.QueueUrlHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */