package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.s3.InputStreamWithInfo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.concurrent.Callable;
import org.apache.hadoop.classification.InterfaceAudience.Private;
import org.apache.hadoop.classification.InterfaceStability.Unstable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Progressable;

@InterfaceAudience.Private
public abstract interface NativeFileSystemStore
{
  public abstract void initialize(URI paramURI, Configuration paramConfiguration)
    throws IOException;
  
  public abstract void storeFile(String paramString, File paramFile, byte[] paramArrayOfByte, Progressable paramProgressable)
    throws IOException;
  
  public abstract void storeFile(String paramString, File paramFile, byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract void storeEmptyFile(String paramString)
    throws IOException;
  
  public abstract FileMetadata retrieveMetadata(String paramString)
    throws IOException;
  
  public abstract InputStream retrieve(String paramString)
    throws IOException;
  
  public abstract InputStream retrieve(String paramString, long paramLong)
    throws IOException;
  
  public abstract InputStreamWithInfo retrieveInputStreamWithInfo(String paramString, long paramLong, boolean paramBoolean)
    throws IOException;
  
  public abstract PartialListing list(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
    throws IOException;
  
  public abstract void delete(String paramString)
    throws IOException;
  
  public abstract void deleteAll(List<String> paramList)
    throws IOException;
  
  public abstract void copy(String paramString1, String paramString2)
    throws IOException;
  
  public abstract List<Callable<String>> createCopyCallables(String paramString1, String paramString2)
    throws IOException;
  
  public abstract void invalidateCache(String paramString);
  
  @InterfaceStability.Unstable
  public abstract InputStreamWithInfo retrieveSelectObjectContentInputStreamWithInfo(String paramString, Configuration paramConfiguration, long paramLong)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.NativeFileSystemStore
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */