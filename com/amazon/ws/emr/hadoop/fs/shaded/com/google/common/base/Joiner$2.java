package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.IOException;
import java.util.Iterator;

class Joiner$2
  extends Joiner
{
  Joiner$2(Joiner paramJoiner1, Joiner x0)
  {
    super(x0, null);
  }
  
  public <A extends Appendable> A appendTo(A appendable, Iterator<?> parts)
    throws IOException
  {
    Preconditions.checkNotNull(appendable, "appendable");
    Preconditions.checkNotNull(parts, "parts");
    while (parts.hasNext())
    {
      Object part = parts.next();
      if (part != null)
      {
        appendable.append(this$0.toString(part));
        break;
      }
    }
    while (parts.hasNext())
    {
      Object part = parts.next();
      if (part != null)
      {
        appendable.append(Joiner.access$100(this$0));
        appendable.append(this$0.toString(part));
      }
    }
    return appendable;
  }
  
  public Joiner useForNull(String nullText)
  {
    throw new UnsupportedOperationException("already specified skipNulls");
  }
  
  public Joiner.MapJoiner withKeyValueSeparator(String kvs)
  {
    throw new UnsupportedOperationException("can't use .skipNulls() with maps");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */