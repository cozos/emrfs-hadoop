package com.amazon.ws.emr.hadoop.fs.files;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ThreadSafe
public final class TemporaryFiles
{
  private static final FileAttribute<Set<PosixFilePermission>> FILE_PERMISSIONS = PosixFilePermissions.asFileAttribute(
    EnumSet.of(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE));
  public static final Logger LOG = LoggerFactory.getLogger(TemporaryFiles.class);
  private final Iterator<Path> directories;
  private final Set<Path> tracked = Sets.newConcurrentHashSet();
  private final AtomicLong namePrefixSequence = new AtomicLong(0L);
  
  public TemporaryFiles(TemporaryDirectories temporaryDirectories)
  {
    directories = temporaryDirectories.cyclingIterator();
  }
  
  private String getNextNamePrefix()
  {
    return String.format("%010d", new Object[] { Long.valueOf(namePrefixSequence.getAndIncrement()) });
  }
  
  public Path create()
    throws IOException
  {
    Path tempPath = ((Path)directories.next()).resolve(getNextNamePrefix());
    tracked.add(tempPath);
    try
    {
      Files.createFile(tempPath, new FileAttribute[] { FILE_PERMISSIONS });
    }
    catch (RuntimeException|IOException e)
    {
      tracked.remove(tempPath);
      throw e;
    }
    return tempPath;
  }
  
  public Path hardLink(Path existing)
    throws IOException
  {
    if (!isTracked(existing)) {
      throw new FileNotFoundException("Cannot create a hard link from an untracked path");
    }
    Path tempPath = existing.resolveSibling(getNextNamePrefix());
    tracked.add(tempPath);
    try
    {
      Files.createLink(tempPath, existing);
    }
    catch (NoSuchFileException e)
    {
      tracked.remove(tempPath);
      
      throw ((FileNotFoundException)new FileNotFoundException("Cannot create a hard link from an untracked path").initCause(e));
    }
    catch (RuntimeException|IOException e)
    {
      tracked.remove(tempPath);
      throw e;
    }
    return tempPath;
  }
  
  public boolean delete(Path existing)
  {
    if (tracked.remove(existing)) {
      return DeleteUtil.deleteIfExistsOrLog(existing);
    }
    return false;
  }
  
  public boolean isTracked(Path path)
  {
    return tracked.contains(path);
  }
  
  public int size()
  {
    return tracked.size();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.files.TemporaryFiles
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */