package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.RuntimeHttpUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

@Deprecated
@SdkInternalApi
public class LegacyRegionXmlLoadUtils
{
  public static RegionMetadata load(URI uri, ClientConfiguration config)
    throws IOException
  {
    return RegionMetadataParser.parse(
      RuntimeHttpUtils.fetchFile(uri, config));
  }
  
  public static RegionMetadata load(File file)
    throws IOException
  {
    return RegionMetadataParser.parse(new BufferedInputStream(new FileInputStream(file)));
  }
  
  public static RegionMetadata load(InputStream stream)
    throws IOException
  {
    return RegionMetadataParser.parse(stream);
  }
  
  public static RegionMetadata load(Class<?> clazz, String name)
    throws IOException
  {
    InputStream stream = clazz.getResourceAsStream(name);
    if (stream == null) {
      throw new FileNotFoundException("No resource '" + name + "' found.");
    }
    return load(stream);
  }
  
  public static RegionMetadata load(ClassLoader classLoader, String name)
    throws IOException
  {
    InputStream stream = classLoader.getResourceAsStream(name);
    if (stream == null) {
      throw new FileNotFoundException("No resource '" + name + "' found.");
    }
    return load(stream);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.LegacyRegionXmlLoadUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */