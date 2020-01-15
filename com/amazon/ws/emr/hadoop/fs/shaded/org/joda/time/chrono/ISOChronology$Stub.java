package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

final class ISOChronology$Stub
  implements Serializable
{
  private static final long serialVersionUID = -6212696554273812441L;
  private transient DateTimeZone iZone;
  
  ISOChronology$Stub(DateTimeZone paramDateTimeZone)
  {
    iZone = paramDateTimeZone;
  }
  
  private Object readResolve()
  {
    return ISOChronology.getInstance(iZone);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(iZone);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    iZone = ((DateTimeZone)paramObjectInputStream.readObject());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology.Stub
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */