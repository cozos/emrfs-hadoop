package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CRC32ChecksumCalculatingInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.HttpEntityWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.io.InputStream;

public class CRC32ChecksumResponseInterceptor
  implements HttpResponseInterceptor
{
  public void process(HttpResponse response, HttpContext context)
    throws HttpException, IOException
  {
    HttpEntity entity = response.getEntity();
    
    Header[] headers = response.getHeaders("x-amz-crc32");
    if ((entity == null) || (headers == null) || (headers.length == 0)) {
      return;
    }
    HttpEntity crc32ResponseEntity = new HttpEntityWrapper(entity)
    {
      private final InputStream content = new CRC32ChecksumCalculatingInputStream(wrappedEntity
        .getContent());
      
      public InputStream getContent()
        throws IOException
      {
        return content;
      }
      
      /* Error */
      public void writeTo(java.io.OutputStream outstream)
        throws IOException
      {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual 46	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/http/apache/client/impl/CRC32ChecksumResponseInterceptor$1:getContent	()Ljava/io/InputStream;
        //   4: aload_1
        //   5: invokestatic 52	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/IOUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
        //   8: pop2
        //   9: aload_0
        //   10: invokevirtual 46	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/http/apache/client/impl/CRC32ChecksumResponseInterceptor$1:getContent	()Ljava/io/InputStream;
        //   13: invokevirtual 58	java/io/InputStream:close	()V
        //   16: goto +13 -> 29
        //   19: astore_2
        //   20: aload_0
        //   21: invokevirtual 46	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/http/apache/client/impl/CRC32ChecksumResponseInterceptor$1:getContent	()Ljava/io/InputStream;
        //   24: invokevirtual 58	java/io/InputStream:close	()V
        //   27: aload_2
        //   28: athrow
        //   29: return
        // Line number table:
        //   Java source line #69	-> byte code offset #0
        //   Java source line #71	-> byte code offset #9
        //   Java source line #72	-> byte code offset #16
        //   Java source line #71	-> byte code offset #19
        //   Java source line #72	-> byte code offset #27
        //   Java source line #73	-> byte code offset #29
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	30	0	this	1
        //   0	30	1	outstream	java.io.OutputStream
        //   19	9	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   0	9	19	finally
      }
    };
    response.setEntity(crc32ResponseEntity);
    context.setAttribute(CRC32ChecksumCalculatingInputStream.class.getName(), crc32ResponseEntity
      .getContent());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl.CRC32ChecksumResponseInterceptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */