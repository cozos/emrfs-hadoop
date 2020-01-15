package com.amazon.ws.emr.hadoop.fs.files;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class TemporaryDirectoriesGenerator
{
  private static final FileAttribute<Set<PosixFilePermission>> DIRECTORY_PERMISSIONS = PosixFilePermissions.asFileAttribute(
    EnumSet.of(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE, PosixFilePermission.OWNER_EXECUTE));
  private final List<Path> directoryPaths;
  private final Random random;
  
  public TemporaryDirectoriesGenerator(List<Path> directoryPaths)
  {
    this(directoryPaths, new Random());
  }
  
  @VisibleForTesting
  TemporaryDirectoriesGenerator(List<Path> directoryPaths, Random random)
  {
    Preconditions.checkNotNull(directoryPaths);
    Preconditions.checkArgument(!directoryPaths.isEmpty());
    this.directoryPaths = new ArrayList(directoryPaths.size());
    this.random = random;
    for (Path directoryPath : directoryPaths)
    {
      Preconditions.checkArgument(Files.isDirectory(directoryPath, new LinkOption[0]), directoryPath + " is not a directory");
      Preconditions.checkArgument(!Files.isSymbolicLink(directoryPath), directoryPath + " is a symbolic link to a directory");
      try
      {
        this.directoryPaths.add(directoryPath.toRealPath(new LinkOption[] { LinkOption.NOFOLLOW_LINKS }));
      }
      catch (IOException e)
      {
        throw new IllegalArgumentException("Cannot form a real path from " + directoryPath + " as directory pathis resolved through a symbolic link", e);
      }
    }
  }
  
  public TemporaryDirectories createTemporaryDirectories()
    throws IOException
  {
    List<Path> temporaryDirectoryPaths = createAndTrack(directoryPaths);
    return new TemporaryDirectories(temporaryDirectoryPaths, randomIndex());
  }
  
  public TemporaryDirectories createTemporaryDirectory()
    throws IOException
  {
    int selectedIndex = randomIndex();
    List<Path> temporaryDirectoryPaths = createAndTrack((Path)directoryPaths.get(selectedIndex));
    return new TemporaryDirectories(temporaryDirectoryPaths);
  }
  
  private int randomIndex()
  {
    return random.nextInt(directoryPaths.size());
  }
  
  private static List<Path> createAndTrack(Path directoryPath)
    throws IOException
  {
    return createAndTrack(Collections.singletonList(directoryPath));
  }
  
  private static List<Path> createAndTrack(List<Path> directoryPaths)
    throws IOException
  {
    List<Path> tempDirectoryPaths = new ArrayList();
    try
    {
      for (Iterator localIterator = directoryPaths.iterator(); localIterator.hasNext();)
      {
        directoryPath = (Path)localIterator.next();
        
        Path tempDirectoryPath = Files.createTempDirectory(directoryPath, "emrfs-", new FileAttribute[] { DIRECTORY_PERMISSIONS });
        TemporaryDirectoryShutdownHook.track(tempDirectoryPath);
        tempDirectoryPaths.add(tempDirectoryPath);
      }
      return tempDirectoryPaths;
    }
    catch (Exception e)
    {
      Path directoryPath;
      for (Path tempDirectoryPath : tempDirectoryPaths)
      {
        DeleteUtil.deleteIfExistsOrLog(tempDirectoryPath);
        TemporaryDirectoryShutdownHook.untrack(tempDirectoryPath);
      }
      throw e;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.files.TemporaryDirectoriesGenerator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */