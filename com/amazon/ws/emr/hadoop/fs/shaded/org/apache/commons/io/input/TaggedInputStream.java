package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.TaggedIOException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.UUID;

public class TaggedInputStream
  extends ProxyInputStream
{
  private final Serializable tag = UUID.randomUUID();
  
  public TaggedInputStream(InputStream proxy)
  {
    super(proxy);
  }
  
  public boolean isCauseOf(Throwable exception)
  {
    return TaggedIOException.isTaggedWith(exception, tag);
  }
  
  public void throwIfCauseOf(Throwable throwable)
    throws IOException
  {
    TaggedIOException.throwCauseIfTaggedWith(throwable, tag);
  }
  
  protected void handleIOException(IOException e)
    throws IOException
  {
    throw new TaggedIOException(e, tag);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input.TaggedInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */