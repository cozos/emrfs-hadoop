package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteOpenIDConnectProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteOpenIDConnectProviderResultStaxUnmarshaller
  implements Unmarshaller<DeleteOpenIDConnectProviderResult, StaxUnmarshallerContext>
{
  private static DeleteOpenIDConnectProviderResultStaxUnmarshaller instance;
  
  public DeleteOpenIDConnectProviderResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteOpenIDConnectProviderResult deleteOpenIDConnectProviderResult = new DeleteOpenIDConnectProviderResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteOpenIDConnectProviderResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteOpenIDConnectProviderResult;
        }
      }
    }
  }
  
  public static DeleteOpenIDConnectProviderResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteOpenIDConnectProviderResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteOpenIDConnectProviderResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */