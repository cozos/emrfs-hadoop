package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AbortedException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.OnFileDelete;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.UploadObjectObserver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class MultiFileOutputStream
  extends OutputStream
  implements OnFileDelete
{
  static final int DEFAULT_PART_SIZE = 5242880;
  private final File root;
  private final String namePrefix;
  private int filesCreated;
  private long partSize = 5242880L;
  private long diskLimit = Long.MAX_VALUE;
  private UploadObjectObserver observer;
  private int currFileBytesWritten;
  private long totalBytesWritten;
  private FileOutputStream os;
  private boolean closed;
  private Semaphore diskPermits;
  
  public MultiFileOutputStream()
  {
    root = new File(System.getProperty("java.io.tmpdir"));
    namePrefix = (yyMMdd_hhmmss() + "." + UUID.randomUUID());
  }
  
  public MultiFileOutputStream(File root, String namePrefix)
  {
    if ((root == null) || (!root.isDirectory()) || (!root.canWrite())) {
      throw new IllegalArgumentException(root + " must be a writable directory");
    }
    if ((namePrefix == null) || (namePrefix.trim().length() == 0)) {
      throw new IllegalArgumentException("Please specify a non-empty name prefix");
    }
    this.root = root;
    this.namePrefix = namePrefix;
  }
  
  public MultiFileOutputStream init(UploadObjectObserver observer, long partSize, long diskLimit)
  {
    if (observer == null) {
      throw new IllegalArgumentException("Observer must be specified");
    }
    this.observer = observer;
    if (diskLimit < partSize << 1) {
      throw new IllegalArgumentException("Maximum temporary disk space must be at least twice as large as the part size: partSize=" + partSize + ", diskSize=" + diskLimit);
    }
    this.partSize = partSize;
    this.diskLimit = diskLimit;
    int max = (int)(diskLimit / partSize);
    diskPermits = (max < 0 ? null : new Semaphore(max));
    return this;
  }
  
  public void write(int b)
    throws IOException
  {
    fos().write(b);
    currFileBytesWritten += 1;
    totalBytesWritten += 1L;
  }
  
  public void write(byte[] b)
    throws IOException
  {
    if (b.length == 0) {
      return;
    }
    fos().write(b);
    currFileBytesWritten += b.length;
    totalBytesWritten += b.length;
  }
  
  public void write(byte[] b, int off, int len)
    throws IOException
  {
    if (b.length == 0) {
      return;
    }
    fos().write(b, off, len);
    currFileBytesWritten += len;
    totalBytesWritten += len;
  }
  
  private FileOutputStream fos()
    throws IOException
  {
    if (closed) {
      throw new IOException("Output stream is already closed");
    }
    if ((os == null) || (currFileBytesWritten >= partSize))
    {
      if (os != null)
      {
        os.close();
        
        observer.onPartCreate(new PartCreationEvent(
          getFile(filesCreated), filesCreated, false, this));
      }
      currFileBytesWritten = 0;
      filesCreated += 1;
      blockIfNecessary();
      File file = getFile(filesCreated);
      os = new FileOutputStream(file);
    }
    return os;
  }
  
  public void onFileDelete(FileDeletionEvent event)
  {
    if (diskPermits != null) {
      diskPermits.release();
    }
  }
  
  private void blockIfNecessary()
  {
    if ((diskPermits == null) || (diskLimit == Long.MAX_VALUE)) {
      return;
    }
    try
    {
      diskPermits.acquire();
    }
    catch (InterruptedException e)
    {
      throw new AbortedException(e);
    }
  }
  
  public void flush()
    throws IOException
  {
    if (os != null) {
      os.flush();
    }
  }
  
  public void close()
    throws IOException
  {
    if (closed) {
      return;
    }
    closed = true;
    if (os != null)
    {
      os.close();
      File lastPart = getFile(filesCreated);
      if (lastPart.length() == 0L)
      {
        if (!lastPart.delete()) {
          LogFactory.getLog(getClass()).debug("Ignoring failure to delete empty file " + lastPart);
        }
      }
      else {
        observer.onPartCreate(new PartCreationEvent(
          getFile(filesCreated), filesCreated, true, this));
      }
    }
  }
  
  public void cleanup()
  {
    for (int i = 0; i < getNumFilesWritten(); i++)
    {
      File f = getFile(i);
      if ((f.exists()) && 
        (!f.delete())) {
        LogFactory.getLog(getClass()).debug("Ignoring failure to delete file " + f);
      }
    }
  }
  
  public int getNumFilesWritten()
  {
    return filesCreated;
  }
  
  public File getFile(int partNumber)
  {
    return new File(root, namePrefix + "." + partNumber);
  }
  
  public long getPartSize()
  {
    return partSize;
  }
  
  public File getRoot()
  {
    return root;
  }
  
  public String getNamePrefix()
  {
    return namePrefix;
  }
  
  public long getTotalBytesWritten()
  {
    return totalBytesWritten;
  }
  
  static String yyMMdd_hhmmss()
  {
    return DateTimeFormat.forPattern("yyMMdd-hhmmss").print(new DateTime());
  }
  
  public boolean isClosed()
  {
    return closed;
  }
  
  public long getDiskLimit()
  {
    return diskLimit;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.MultiFileOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */