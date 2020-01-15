package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SetSecurityTokenServicePreferencesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class SetSecurityTokenServicePreferencesResultStaxUnmarshaller
  implements Unmarshaller<SetSecurityTokenServicePreferencesResult, StaxUnmarshallerContext>
{
  private static SetSecurityTokenServicePreferencesResultStaxUnmarshaller instance;
  
  public SetSecurityTokenServicePreferencesResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    SetSecurityTokenServicePreferencesResult setSecurityTokenServicePreferencesResult = new SetSecurityTokenServicePreferencesResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return setSecurityTokenServicePreferencesResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return setSecurityTokenServicePreferencesResult;
        }
      }
    }
  }
  
  public static SetSecurityTokenServicePreferencesResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SetSecurityTokenServicePreferencesResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SetSecurityTokenServicePreferencesResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */