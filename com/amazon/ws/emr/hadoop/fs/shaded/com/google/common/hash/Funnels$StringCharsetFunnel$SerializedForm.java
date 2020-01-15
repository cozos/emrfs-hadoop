package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import java.io.Serializable;
import java.nio.charset.Charset;

class Funnels$StringCharsetFunnel$SerializedForm
  implements Serializable
{
  private final String charsetCanonicalName;
  private static final long serialVersionUID = 0L;
  
  Funnels$StringCharsetFunnel$SerializedForm(Charset charset)
  {
    charsetCanonicalName = charset.name();
  }
  
  private Object readResolve()
  {
    return Funnels.stringFunnel(Charset.forName(charsetCanonicalName));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Funnels.StringCharsetFunnel.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */