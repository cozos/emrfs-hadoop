package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import java.io.Serializable;

final class MessageDigestHashFunction$SerializedForm
  implements Serializable
{
  private final String algorithmName;
  private final int bytes;
  private final String toString;
  private static final long serialVersionUID = 0L;
  
  private MessageDigestHashFunction$SerializedForm(String algorithmName, int bytes, String toString)
  {
    this.algorithmName = algorithmName;
    this.bytes = bytes;
    this.toString = toString;
  }
  
  private Object readResolve()
  {
    return new MessageDigestHashFunction(algorithmName, bytes, toString);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.MessageDigestHashFunction.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */