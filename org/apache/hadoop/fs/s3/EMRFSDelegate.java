package org.apache.hadoop.fs.s3;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.DelegateToFileSystem;
import org.apache.hadoop.fs.FileSystem;

public class EMRFSDelegate
  extends DelegateToFileSystem
{
  public EMRFSDelegate(URI theUri, Configuration conf)
    throws IOException, URISyntaxException
  {
    super(theUri, FileSystem.get(theUri, conf), conf, "s3", false);
  }
  
  public EMRFSDelegate(URI theUri, FileSystem theFsImpl, Configuration conf, String supportedScheme, boolean authorityRequired)
    throws IOException, URISyntaxException
  {
    super(theUri, FileSystem.get(theUri, conf), conf, "s3", authorityRequired);
  }
  
  public int getUriDefaultPort()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     org.apache.hadoop.fs.s3.EMRFSDelegate
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */