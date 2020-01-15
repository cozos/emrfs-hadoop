package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

class JodaTime$LazyHolder
{
  static final String version = ;
  
  private static String getVersion()
  {
    try
    {
      JarFile jf = Classes.jarFileOf(DateTimeZone.class);
      if (jf == null) {
        return null;
      }
      Manifest mf = jf.getManifest();
      Attributes attrs = mf.getMainAttributes();
      String name = attrs.getValue("Bundle-Name");
      String version = attrs.getValue("Bundle-Version");
      if (("Joda-Time".equals(name)) && (version != null)) {
        return version;
      }
    }
    catch (Exception e)
    {
      InternalLogFactory.getLog(JodaTime.class).debug("FYI", e);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.JodaTime.LazyHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */