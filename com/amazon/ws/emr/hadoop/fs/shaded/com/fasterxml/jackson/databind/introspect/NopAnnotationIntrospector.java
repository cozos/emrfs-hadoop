package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.PackageVersion;
import java.io.Serializable;

public abstract class NopAnnotationIntrospector
  extends AnnotationIntrospector
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public static final NopAnnotationIntrospector instance = new NopAnnotationIntrospector()
  {
    private static final long serialVersionUID = 1L;
    
    public Version version()
    {
      return PackageVersion.VERSION;
    }
  };
  
  public Version version()
  {
    return Version.unknownVersion();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */