package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Collections;
import java.util.List;

public class UninitializedMessageException
  extends RuntimeException
{
  private static final long serialVersionUID = -7466929953374883507L;
  private final List<String> missingFields;
  
  public UninitializedMessageException(MessageLite message)
  {
    super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    
    missingFields = null;
  }
  
  public UninitializedMessageException(List<String> missingFields)
  {
    super(buildDescription(missingFields));
    this.missingFields = missingFields;
  }
  
  public List<String> getMissingFields()
  {
    return Collections.unmodifiableList(missingFields);
  }
  
  public InvalidProtocolBufferException asInvalidProtocolBufferException()
  {
    return new InvalidProtocolBufferException(getMessage());
  }
  
  private static String buildDescription(List<String> missingFields)
  {
    StringBuilder description = new StringBuilder("Message missing required fields: ");
    
    boolean first = true;
    for (String field : missingFields)
    {
      if (first) {
        first = false;
      } else {
        description.append(", ");
      }
      description.append(field);
    }
    return description.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.UninitializedMessageException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */