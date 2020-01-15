package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

final class DateTimeZone$Stub
  implements Serializable
{
  private static final long serialVersionUID = -6471952376487863581L;
  private transient String iID;
  
  DateTimeZone$Stub(String paramString)
  {
    iID = paramString;
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeUTF(iID);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    iID = paramObjectInputStream.readUTF();
  }
  
  private Object readResolve()
    throws ObjectStreamException
  {
    return DateTimeZone.forID(iID);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone.Stub
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */