package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

class Funnels$StringCharsetFunnel
  implements Funnel<CharSequence>, Serializable
{
  private final Charset charset;
  
  Funnels$StringCharsetFunnel(Charset charset)
  {
    this.charset = ((Charset)Preconditions.checkNotNull(charset));
  }
  
  public void funnel(CharSequence from, PrimitiveSink into)
  {
    into.putString(from, charset);
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(charset.name()));return 22 + str.length() + "Funnels.stringFunnel(" + str + ")";
  }
  
  public boolean equals(@Nullable Object o)
  {
    if ((o instanceof StringCharsetFunnel))
    {
      StringCharsetFunnel funnel = (StringCharsetFunnel)o;
      return charset.equals(charset);
    }
    return false;
  }
  
  public int hashCode()
  {
    return StringCharsetFunnel.class.hashCode() ^ charset.hashCode();
  }
  
  Object writeReplace()
  {
    return new SerializedForm(charset);
  }
  
  private static class SerializedForm
    implements Serializable
  {
    private final String charsetCanonicalName;
    private static final long serialVersionUID = 0L;
    
    SerializedForm(Charset charset)
    {
      charsetCanonicalName = charset.name();
    }
    
    private Object readResolve()
    {
      return Funnels.stringFunnel(Charset.forName(charsetCanonicalName));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Funnels.StringCharsetFunnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */