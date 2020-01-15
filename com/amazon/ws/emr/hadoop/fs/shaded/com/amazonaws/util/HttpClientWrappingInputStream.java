package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.HttpClient;
import java.io.InputStream;

class HttpClientWrappingInputStream
  extends SdkFilterInputStream
{
  private final HttpClient client;
  
  public HttpClientWrappingInputStream(HttpClient client, InputStream stream)
  {
    super(stream);
    this.client = client;
  }
  
  /* Error */
  public void close()
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 24	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/internal/SdkFilterInputStream:close	()V
    //   4: aload_0
    //   5: getfield 14	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/HttpClientWrappingInputStream:client	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/http/client/HttpClient;
    //   8: invokeinterface 30 1 0
    //   13: invokeinterface 35 1 0
    //   18: goto +20 -> 38
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 14	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/HttpClientWrappingInputStream:client	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/http/client/HttpClient;
    //   26: invokeinterface 30 1 0
    //   31: invokeinterface 35 1 0
    //   36: aload_1
    //   37: athrow
    //   38: return
    // Line number table:
    //   Java source line #48	-> byte code offset #0
    //   Java source line #50	-> byte code offset #4
    //   Java source line #51	-> byte code offset #18
    //   Java source line #50	-> byte code offset #21
    //   Java source line #51	-> byte code offset #36
    //   Java source line #52	-> byte code offset #38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	HttpClientWrappingInputStream
    //   21	16	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	21	finally
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.HttpClientWrappingInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */