package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.output;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.TaggedIOException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.UUID;

public class TaggedOutputStream
  extends ProxyOutputStream
{
  private final Serializable tag = UUID.randomUUID();
  
  public TaggedOutputStream(OutputStream proxy)
  {
    super(proxy);
  }
  
  public boolean isCauseOf(Exception exception)
  {
    return TaggedIOException.isTaggedWith(exception, tag);
  }
  
  public void throwIfCauseOf(Exception exception)
    throws IOException
  {
    TaggedIOException.throwCauseIfTaggedWith(exception, tag);
  }
  
  protected void handleIOException(IOException e)
    throws IOException
  {
    throw new TaggedIOException(e, tag);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.output.TaggedOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */