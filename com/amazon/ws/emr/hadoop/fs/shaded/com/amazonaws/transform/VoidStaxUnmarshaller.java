package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import javax.xml.stream.events.XMLEvent;

public class VoidStaxUnmarshaller<T>
  implements Unmarshaller<T, StaxUnmarshallerContext>
{
  public T unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    while (!context.nextEvent().isEndDocument()) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.VoidStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */