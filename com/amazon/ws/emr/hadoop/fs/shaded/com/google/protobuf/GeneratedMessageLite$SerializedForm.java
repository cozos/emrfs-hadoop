package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class GeneratedMessageLite$SerializedForm
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private String messageClassName;
  private byte[] asBytes;
  
  GeneratedMessageLite$SerializedForm(MessageLite regularForm)
  {
    messageClassName = regularForm.getClass().getName();
    asBytes = regularForm.toByteArray();
  }
  
  protected Object readResolve()
    throws ObjectStreamException
  {
    try
    {
      Class messageClass = Class.forName(messageClassName);
      Method newBuilder = messageClass.getMethod("newBuilder", new Class[0]);
      MessageLite.Builder builder = (MessageLite.Builder)newBuilder.invoke(null, new Object[0]);
      
      builder.mergeFrom(asBytes);
      return builder.buildPartial();
    }
    catch (ClassNotFoundException e)
    {
      throw new RuntimeException("Unable to find proto buffer class", e);
    }
    catch (NoSuchMethodException e)
    {
      throw new RuntimeException("Unable to find newBuilder method", e);
    }
    catch (IllegalAccessException e)
    {
      throw new RuntimeException("Unable to call newBuilder method", e);
    }
    catch (InvocationTargetException e)
    {
      throw new RuntimeException("Error calling newBuilder", e.getCause());
    }
    catch (InvalidProtocolBufferException e)
    {
      throw new RuntimeException("Unable to understand proto buffer", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessageLite.SerializedForm
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */