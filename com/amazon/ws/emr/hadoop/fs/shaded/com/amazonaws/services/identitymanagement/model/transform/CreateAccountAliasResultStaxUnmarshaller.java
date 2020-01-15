package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateAccountAliasResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class CreateAccountAliasResultStaxUnmarshaller
  implements Unmarshaller<CreateAccountAliasResult, StaxUnmarshallerContext>
{
  private static CreateAccountAliasResultStaxUnmarshaller instance;
  
  public CreateAccountAliasResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    CreateAccountAliasResult createAccountAliasResult = new CreateAccountAliasResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return createAccountAliasResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return createAccountAliasResult;
        }
      }
    }
  }
  
  public static CreateAccountAliasResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CreateAccountAliasResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateAccountAliasResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */