package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileEntity
  extends AbstractHttpEntity
  implements Cloneable
{
  protected final File file;
  
  @Deprecated
  public FileEntity(File file, String contentType)
  {
    this.file = ((File)Args.notNull(file, "File"));
    setContentType(contentType);
  }
  
  public FileEntity(File file, ContentType contentType)
  {
    this.file = ((File)Args.notNull(file, "File"));
    if (contentType != null) {
      setContentType(contentType.toString());
    }
  }
  
  public FileEntity(File file)
  {
    this.file = ((File)Args.notNull(file, "File"));
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public long getContentLength()
  {
    return file.length();
  }
  
  public InputStream getContent()
    throws IOException
  {
    return new FileInputStream(file);
  }
  
  public void writeTo(OutputStream outstream)
    throws IOException
  {
    Args.notNull(outstream, "Output stream");
    InputStream instream = new FileInputStream(file);
    try
    {
      byte[] tmp = new byte['က'];
      int l;
      while ((l = instream.read(tmp)) != -1) {
        outstream.write(tmp, 0, l);
      }
      outstream.flush();
    }
    finally
    {
      instream.close();
    }
  }
  
  public boolean isStreaming()
  {
    return false;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.FileEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */