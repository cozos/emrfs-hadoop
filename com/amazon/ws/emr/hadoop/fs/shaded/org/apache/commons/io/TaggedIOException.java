package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io;

import java.io.IOException;
import java.io.Serializable;

public class TaggedIOException
  extends IOExceptionWithCause
{
  private static final long serialVersionUID = -6994123481142850163L;
  private final Serializable tag;
  
  public static boolean isTaggedWith(Throwable throwable, Object tag)
  {
    return (tag != null) && ((throwable instanceof TaggedIOException)) && (tag.equals(tag));
  }
  
  public static void throwCauseIfTaggedWith(Throwable throwable, Object tag)
    throws IOException
  {
    if (isTaggedWith(throwable, tag)) {
      throw ((TaggedIOException)throwable).getCause();
    }
  }
  
  public TaggedIOException(IOException original, Serializable tag)
  {
    super(original.getMessage(), original);
    this.tag = tag;
  }
  
  public Serializable getTag()
  {
    return tag;
  }
  
  public IOException getCause()
  {
    return (IOException)super.getCause();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.TaggedIOException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */