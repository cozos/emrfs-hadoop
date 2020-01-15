package com.amazonaws.services.sqs.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AbstractRequestHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class SQSRequestHandler
  extends AbstractRequestHandler
{
  private static final Map<String, String> nonstandardEndpointMap = new HashMap();
  
  static
  {
    nonstandardEndpointMap.put("queue.amazonaws.com", "sqs.us-east-1.amazonaws.com");
    nonstandardEndpointMap.put("us-west-1.queue.amazonaws.com", "sqs.us-west-1.amazonaws.com");
    nonstandardEndpointMap.put("us-west-2.queue.amazonaws.com", "sqs.us-west-2.amazonaws.com");
    nonstandardEndpointMap.put("eu-west-1.queue.amazonaws.com", "sqs.eu-west-1.amazonaws.com");
    nonstandardEndpointMap.put("ap-southeast-1.queue.amazonaws.com", "sqs.ap-southeast-1.amazonaws.com");
    nonstandardEndpointMap.put("ap-northeast-1.queue.amazonaws.com", "sqs.ap-northeast-1.amazonaws.com");
    nonstandardEndpointMap.put("sa-east-1.queue.amazonaws.com", "sqs.sa-east-1.amazonaws.com");
    nonstandardEndpointMap.put("us-gov-west-1.queue.amazonaws.com", "sqs.us-gov-west-1.amazonaws.com");
    nonstandardEndpointMap.put("ap-southeast-2.queue.amazonaws.com", "sqs.ap-southeast-2.amazonaws.com");
  }
  
  public void beforeRequest(Request<?> request)
  {
    URI endpoint = request.getEndpoint();
    if (nonstandardEndpointMap.containsKey(endpoint.getHost()))
    {
      String newHost = (String)nonstandardEndpointMap.get(endpoint.getHost());
      String newEndpoint = endpoint.toString().replaceFirst(endpoint.getHost(), newHost);
      request.setEndpoint(URI.create(newEndpoint));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.internal.SQSRequestHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */