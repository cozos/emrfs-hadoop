package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.HttpEntityWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class EntityEnclosingRequestWrapper$EntityWrapper
  extends HttpEntityWrapper
{
  EntityEnclosingRequestWrapper$EntityWrapper(EntityEnclosingRequestWrapper paramEntityEnclosingRequestWrapper, HttpEntity entity)
  {
    super(entity);
  }
  
  public void consumeContent()
    throws IOException
  {
    EntityEnclosingRequestWrapper.access$002(this$0, true);
    super.consumeContent();
  }
  
  public InputStream getContent()
    throws IOException
  {
    EntityEnclosingRequestWrapper.access$002(this$0, true);
    return super.getContent();
  }
  
  public void writeTo(OutputStream outstream)
    throws IOException
  {
    EntityEnclosingRequestWrapper.access$002(this$0, true);
    super.writeTo(outstream);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.EntityEnclosingRequestWrapper.EntityWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */