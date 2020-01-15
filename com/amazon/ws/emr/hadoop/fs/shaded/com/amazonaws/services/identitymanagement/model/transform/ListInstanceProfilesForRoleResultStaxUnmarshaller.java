package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.InstanceProfile;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListInstanceProfilesForRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListInstanceProfilesForRoleResultStaxUnmarshaller
  implements Unmarshaller<ListInstanceProfilesForRoleResult, StaxUnmarshallerContext>
{
  private static ListInstanceProfilesForRoleResultStaxUnmarshaller instance;
  
  public ListInstanceProfilesForRoleResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListInstanceProfilesForRoleResult listInstanceProfilesForRoleResult = new ListInstanceProfilesForRoleResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listInstanceProfilesForRoleResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("InstanceProfiles", targetDepth)) {
          listInstanceProfilesForRoleResult.withInstanceProfiles(new ArrayList());
        } else if (context.testExpression("InstanceProfiles/member", targetDepth)) {
          listInstanceProfilesForRoleResult.withInstanceProfiles(new InstanceProfile[] { InstanceProfileStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("IsTruncated", targetDepth)) {
          listInstanceProfilesForRoleResult.setIsTruncated(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Marker", targetDepth)) {
          listInstanceProfilesForRoleResult.setMarker(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listInstanceProfilesForRoleResult;
      }
    }
  }
  
  public static ListInstanceProfilesForRoleResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListInstanceProfilesForRoleResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListInstanceProfilesForRoleResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */