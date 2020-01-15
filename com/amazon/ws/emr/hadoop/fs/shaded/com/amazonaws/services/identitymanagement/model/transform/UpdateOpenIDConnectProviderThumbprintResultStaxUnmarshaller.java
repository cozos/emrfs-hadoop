package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateOpenIDConnectProviderThumbprintResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class UpdateOpenIDConnectProviderThumbprintResultStaxUnmarshaller
  implements Unmarshaller<UpdateOpenIDConnectProviderThumbprintResult, StaxUnmarshallerContext>
{
  private static UpdateOpenIDConnectProviderThumbprintResultStaxUnmarshaller instance;
  
  public UpdateOpenIDConnectProviderThumbprintResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UpdateOpenIDConnectProviderThumbprintResult updateOpenIDConnectProviderThumbprintResult = new UpdateOpenIDConnectProviderThumbprintResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return updateOpenIDConnectProviderThumbprintResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return updateOpenIDConnectProviderThumbprintResult;
        }
      }
    }
  }
  
  public static UpdateOpenIDConnectProviderThumbprintResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateOpenIDConnectProviderThumbprintResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateOpenIDConnectProviderThumbprintResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */