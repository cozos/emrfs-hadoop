package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSSHPublicKeysResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SSHPublicKeyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListSSHPublicKeysResultStaxUnmarshaller
  implements Unmarshaller<ListSSHPublicKeysResult, StaxUnmarshallerContext>
{
  private static ListSSHPublicKeysResultStaxUnmarshaller instance;
  
  public ListSSHPublicKeysResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListSSHPublicKeysResult listSSHPublicKeysResult = new ListSSHPublicKeysResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listSSHPublicKeysResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("SSHPublicKeys", targetDepth)) {
          listSSHPublicKeysResult.withSSHPublicKeys(new ArrayList());
        } else if (context.testExpression("SSHPublicKeys/member", targetDepth)) {
          listSSHPublicKeysResult.withSSHPublicKeys(new SSHPublicKeyMetadata[] { SSHPublicKeyMetadataStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("IsTruncated", targetDepth)) {
          listSSHPublicKeysResult.setIsTruncated(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Marker", targetDepth)) {
          listSSHPublicKeysResult.setMarker(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listSSHPublicKeysResult;
      }
    }
  }
  
  public static ListSSHPublicKeysResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListSSHPublicKeysResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListSSHPublicKeysResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */