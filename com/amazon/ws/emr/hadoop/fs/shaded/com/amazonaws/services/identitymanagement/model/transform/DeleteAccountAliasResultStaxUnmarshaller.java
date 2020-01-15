package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccountAliasResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteAccountAliasResultStaxUnmarshaller
  implements Unmarshaller<DeleteAccountAliasResult, StaxUnmarshallerContext>
{
  private static DeleteAccountAliasResultStaxUnmarshaller instance;
  
  public DeleteAccountAliasResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteAccountAliasResult deleteAccountAliasResult = new DeleteAccountAliasResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteAccountAliasResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteAccountAliasResult;
        }
      }
    }
  }
  
  public static DeleteAccountAliasResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteAccountAliasResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteAccountAliasResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */