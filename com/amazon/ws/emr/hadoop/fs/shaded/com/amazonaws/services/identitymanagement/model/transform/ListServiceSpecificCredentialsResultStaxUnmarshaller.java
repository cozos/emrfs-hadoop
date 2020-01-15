package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListServiceSpecificCredentialsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ServiceSpecificCredentialMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListServiceSpecificCredentialsResultStaxUnmarshaller
  implements Unmarshaller<ListServiceSpecificCredentialsResult, StaxUnmarshallerContext>
{
  private static ListServiceSpecificCredentialsResultStaxUnmarshaller instance;
  
  public ListServiceSpecificCredentialsResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListServiceSpecificCredentialsResult listServiceSpecificCredentialsResult = new ListServiceSpecificCredentialsResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listServiceSpecificCredentialsResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("ServiceSpecificCredentials", targetDepth)) {
          listServiceSpecificCredentialsResult.withServiceSpecificCredentials(new ArrayList());
        } else if (context.testExpression("ServiceSpecificCredentials/member", targetDepth)) {
          listServiceSpecificCredentialsResult.withServiceSpecificCredentials(new ServiceSpecificCredentialMetadata[] {ServiceSpecificCredentialMetadataStaxUnmarshaller.getInstance()
            .unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listServiceSpecificCredentialsResult;
      }
    }
  }
  
  public static ListServiceSpecificCredentialsResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListServiceSpecificCredentialsResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListServiceSpecificCredentialsResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */