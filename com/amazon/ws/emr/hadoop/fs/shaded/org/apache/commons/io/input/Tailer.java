package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.FileUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Tailer
  implements Runnable
{
  private static final int DEFAULT_DELAY_MILLIS = 1000;
  private static final String RAF_MODE = "r";
  private static final int DEFAULT_BUFSIZE = 4096;
  private final byte[] inbuf;
  private final File file;
  private final long delayMillis;
  private final boolean end;
  private final TailerListener listener;
  private final boolean reOpen;
  private volatile boolean run = true;
  
  public Tailer(File file, TailerListener listener)
  {
    this(file, listener, 1000L);
  }
  
  public Tailer(File file, TailerListener listener, long delayMillis)
  {
    this(file, listener, delayMillis, false);
  }
  
  public Tailer(File file, TailerListener listener, long delayMillis, boolean end)
  {
    this(file, listener, delayMillis, end, 4096);
  }
  
  public Tailer(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen)
  {
    this(file, listener, delayMillis, end, reOpen, 4096);
  }
  
  public Tailer(File file, TailerListener listener, long delayMillis, boolean end, int bufSize)
  {
    this(file, listener, delayMillis, end, false, bufSize);
  }
  
  public Tailer(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen, int bufSize)
  {
    this.file = file;
    this.delayMillis = delayMillis;
    this.end = end;
    
    inbuf = new byte[bufSize];
    
    this.listener = listener;
    listener.init(this);
    this.reOpen = reOpen;
  }
  
  public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end, int bufSize)
  {
    Tailer tailer = new Tailer(file, listener, delayMillis, end, bufSize);
    Thread thread = new Thread(tailer);
    thread.setDaemon(true);
    thread.start();
    return tailer;
  }
  
  public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen, int bufSize)
  {
    Tailer tailer = new Tailer(file, listener, delayMillis, end, reOpen, bufSize);
    Thread thread = new Thread(tailer);
    thread.setDaemon(true);
    thread.start();
    return tailer;
  }
  
  public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end)
  {
    return create(file, listener, delayMillis, end, 4096);
  }
  
  public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen)
  {
    return create(file, listener, delayMillis, end, reOpen, 4096);
  }
  
  public static Tailer create(File file, TailerListener listener, long delayMillis)
  {
    return create(file, listener, delayMillis, false);
  }
  
  public static Tailer create(File file, TailerListener listener)
  {
    return create(file, listener, 1000L, false);
  }
  
  public File getFile()
  {
    return file;
  }
  
  public long getDelay()
  {
    return delayMillis;
  }
  
  public void run()
  {
    RandomAccessFile reader = null;
    try
    {
      long last = 0L;
      long position = 0L;
      while ((run) && (reader == null))
      {
        try
        {
          reader = new RandomAccessFile(file, "r");
        }
        catch (FileNotFoundException e)
        {
          listener.fileNotFound();
        }
        if (reader == null)
        {
          try
          {
            Thread.sleep(delayMillis);
          }
          catch (InterruptedException e) {}
        }
        else
        {
          position = end ? file.length() : 0L;
          last = System.currentTimeMillis();
          reader.seek(position);
        }
      }
      while (run)
      {
        boolean newer = FileUtils.isFileNewer(file, last);
        
        long length = file.length();
        if (length < position)
        {
          listener.fileRotated();
          try
          {
            save = reader;
            reader = new RandomAccessFile(file, "r");
            position = 0L;
          }
          catch (FileNotFoundException e)
          {
            RandomAccessFile save;
            listener.fileNotFound();
          }
        }
        else
        {
          if (length > position)
          {
            position = readLines(reader);
            last = System.currentTimeMillis();
          }
          else if (newer)
          {
            position = 0L;
            reader.seek(position);
            
            position = readLines(reader);
            last = System.currentTimeMillis();
          }
          if (reOpen) {
            IOUtils.closeQuietly(reader);
          }
          try
          {
            Thread.sleep(delayMillis);
          }
          catch (InterruptedException e) {}
          if ((run) && (reOpen))
          {
            reader = new RandomAccessFile(file, "r");
            reader.seek(position);
          }
        }
      }
    }
    catch (Exception e)
    {
      listener.handle(e);
    }
    finally
    {
      IOUtils.closeQuietly(reader);
    }
  }
  
  public void stop()
  {
    run = false;
  }
  
  private long readLines(RandomAccessFile reader)
    throws IOException
  {
    StringBuilder sb = new StringBuilder();
    
    long pos = reader.getFilePointer();
    long rePos = pos;
    
    boolean seenCR = false;
    int num;
    while ((run) && ((num = reader.read(inbuf)) != -1))
    {
      for (int i = 0; i < num; i++)
      {
        byte ch = inbuf[i];
        switch (ch)
        {
        case 10: 
          seenCR = false;
          listener.handle(sb.toString());
          sb.setLength(0);
          rePos = pos + i + 1L;
          break;
        case 13: 
          if (seenCR) {
            sb.append('\r');
          }
          seenCR = true;
          break;
        default: 
          if (seenCR)
          {
            seenCR = false;
            listener.handle(sb.toString());
            sb.setLength(0);
            rePos = pos + i + 1L;
          }
          sb.append((char)ch);
        }
      }
      pos = reader.getFilePointer();
    }
    reader.seek(rePos);
    return rePos;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input.Tailer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */