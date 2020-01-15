package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSAMLProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteSAMLProviderResultStaxUnmarshaller
  implements Unmarshaller<DeleteSAMLProviderResult, StaxUnmarshallerContext>
{
  private static DeleteSAMLProviderResultStaxUnmarshaller instance;
  
  public DeleteSAMLProviderResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteSAMLProviderResult deleteSAMLProviderResult = new DeleteSAMLProviderResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteSAMLProviderResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteSAMLProviderResult;
        }
      }
    }
  }
  
  public static DeleteSAMLProviderResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteSAMLProviderResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteSAMLProviderResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */