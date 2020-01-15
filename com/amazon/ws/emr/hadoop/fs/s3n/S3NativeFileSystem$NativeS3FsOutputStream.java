package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.files.TemporaryDirectories;
import com.amazon.ws.emr.hadoop.fs.files.TemporaryFiles;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.common.Abortable;
import org.apache.hadoop.util.Progressable;
import org.slf4j.Logger;

class S3NativeFileSystem$NativeS3FsOutputStream
  extends OutputStream
  implements Abortable
{
  private final Configuration conf;
  private final NativeFileSystemStore store;
  private final String key;
  private final TemporaryFiles temporaryFiles;
  private final TemporaryDirectories temporaryDirectories;
  private final Path backupFilePath;
  private OutputStream backupStream;
  private MessageDigest digest;
  private boolean closed = false;
  private boolean aborted = false;
  private Progressable progress = null;
  
  public S3NativeFileSystem$NativeS3FsOutputStream(S3NativeFileSystem arg1, Configuration conf, NativeFileSystemStore store, String key, Progressable progress, TemporaryDirectories temporaryDirectories)
    throws IOException
  {
    this.conf = conf;
    this.store = store;
    this.key = key;
    this.temporaryDirectories = temporaryDirectories;
    temporaryFiles = new TemporaryFiles(temporaryDirectories);
    backupFilePath = temporaryFiles.create();
    this.progress = progress;
    S3NativeFileSystem.LOG.info("OutputStream for key '" + key + "' writing to tempfile '" + backupFilePath + "'");
    try
    {
      digest = MessageDigest.getInstance("MD5");
      
      backupStream = new BufferedOutputStream(new DigestOutputStream(new FileOutputStream(backupFilePath.toFile()), digest));
    }
    catch (NoSuchAlgorithmException e)
    {
      S3NativeFileSystem.LOG.warn("Cannot load MD5 digest algorithm,skipping message integrity check.", e);
      backupStream = new BufferedOutputStream(new FileOutputStream(backupFilePath.toFile()));
    }
  }
  
  public void flush()
    throws IOException
  {
    backupStream.flush();
  }
  
  public synchronized void close()
    throws IOException
  {
    if (closed) {
      return;
    }
    try
    {
      backupStream.close();
      if (aborted)
      {
        S3NativeFileSystem.LOG.info("Outputstream for key '" + key + "' was aborted, not performing upload.");
      }
      else
      {
        S3NativeFileSystem.LOG.info("Outputstream for key '" + key + "' is being closed. Beginning upload.");
        byte[] md5Hash = digest == null ? null : digest.digest();
        store.storeFile(key, backupFilePath.toFile(), md5Hash, progress);
      }
    }
    catch (IOException e)
    {
      S3NativeFileSystem.LOG.info("Outputstream for key '" + key + "' failed, marking stream as aborted.");
      aborted = true;
      throw e;
    }
    catch (RuntimeException e)
    {
      S3NativeFileSystem.LOG.info("Outputstream for key '" + key + "' failed, marking stream as aborted.");
      aborted = true;
      throw e;
    }
    finally
    {
      temporaryFiles.delete(backupFilePath);
      temporaryDirectories.close();
      super.close();
      closed = true;
    }
    S3NativeFileSystem.LOG.info("OutputStream for key '" + key + "': upload complete");
  }
  
  public synchronized void abort()
    throws IOException
  {
    aborted = true;
    close();
  }
  
  public void write(int writeByte)
    throws IOException
  {
    backupStream.write(writeByte);
  }
  
  public void write(byte[] writeByte, int off, int len)
    throws IOException
  {
    backupStream.write(writeByte, off, len);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.S3NativeFileSystem.NativeS3FsOutputStream
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */