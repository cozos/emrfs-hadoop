package com.amazon.ws.emr.hadoop.fs;

import com.amazon.ws.emr.hadoop.fs.guice.EmrFSProdModule;
import com.amazon.ws.emr.hadoop.fs.s3n.S3NativeFileSystem;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Guice;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Inject;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Injector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Module;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.name.Names;
import com.amazon.ws.emr.hadoop.fs.staging.StagingDirectoryServices;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.EnumSet;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.hadoop.classification.InterfaceAudience.Public;
import org.apache.hadoop.classification.InterfaceStability.Stable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.ContentSummary;
import org.apache.hadoop.fs.CreateFlag;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataInputStreamBuilder;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileAlreadyExistsException;
import org.apache.hadoop.fs.FileChecksum;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsServerDefaults;
import org.apache.hadoop.fs.FsStatus;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Options.ChecksumOpt;
import org.apache.hadoop.fs.ParentNotDirectoryException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.fs.UnsupportedFileSystemException;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.fs.staging.StagingDirectoryCapable;
import org.apache.hadoop.fs.staging.StagingDirectoryService;
import org.apache.hadoop.security.AccessControlException;
import org.apache.hadoop.util.Progressable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@InterfaceAudience.Public
@InterfaceStability.Stable
public class EmrFileSystem
  extends FileSystem
  implements StagingDirectoryCapable
{
  private static final Logger LOG = LoggerFactory.getLogger(EmrFileSystem.class);
  private FileSystem fileSystem = null;
  private boolean initialized = false;
  private boolean useConsistency = false;
  @Inject
  private Injector injector;
  
  public EmrFileSystem() {}
  
  public EmrFileSystem(FileSystem fileSystem)
  {
    this.fileSystem = fileSystem;
  }
  
  public synchronized void initialize(URI uri, Configuration configuration)
    throws IOException
  {
    if (initialized) {
      return;
    }
    Configuration conf = initializeConfiguration(uri, configuration);
    if (fileSystem == null)
    {
      if (injector == null) {
        injector = Guice.createInjector(new Module[] { new EmrFSProdModule(uri, conf) });
      }
      useConsistency = conf.getBoolean("fs.s3.consistent", false);
      FileSystem fs;
      FileSystem fs;
      if (useConsistency) {
        fs = (FileSystem)injector.getInstance(Key.get(FileSystem.class, Names.named("s3n2")));
      } else {
        fs = (FileSystem)injector.getInstance(Key.get(FileSystem.class, Names.named("s3n")));
      }
      LOG.debug("Consistency {}, using {} as filesystem implementation", useConsistency ? "enabled" : "disabled", fs
      
        .getClass().getCanonicalName());
      fs.setConf(conf);
      fs.initialize(uri, conf);
      fileSystem = fs;
    }
    super.initialize(uri, conf);
    initialized = true;
  }
  
  @VisibleForTesting
  Configuration initializeConfiguration(URI uri, Configuration configuration)
  {
    if (!ConfigurationUtils.isLoadConfigurationEnabled(configuration)) {
      return configuration;
    }
    LOG.debug("Loading {} into configuration", "emrfs-site.xml");
    Configuration.addDefaultResource("emrfs-site.xml");
    Configuration newConf = new Configuration();
    newConf.setAllowNullValueProperties(true);
    newConf.addResource(configuration);
    
    String bucketName = uri.getAuthority();
    
    Map<String, String> bucketConfigMap = newConf.getValByRegex("^fs\\.s3\\.bucket\\." + bucketName + "\\..+");
    if (!bucketConfigMap.isEmpty()) {
      for (Map.Entry<String, String> entry : bucketConfigMap.entrySet())
      {
        String newKey = ((String)entry.getKey()).replaceFirst("^fs\\.s3\\.bucket\\." + bucketName + "\\.", "fs.s3.");
        if (newConf.onlyKeyExists((String)entry.getKey()))
        {
          LOG.debug("Unset configuration {} for bucket {} due to {}.", new Object[] { newKey, bucketName, entry
            .getKey() });
          newConf.unset(newKey);
        }
        else
        {
          LOG.debug("Override configuration {} for bucket {} due to {}.", new Object[] { newKey, bucketName, entry
            .getKey() });
          newConf.set(newKey, (String)entry.getValue());
        }
      }
    }
    return newConf;
  }
  
  public String toString()
  {
    return fileSystem.toString();
  }
  
  public void setConf(Configuration conf)
  {
    if (fileSystem != null) {
      fileSystem.setConf(conf);
    }
  }
  
  public Configuration getConf()
  {
    return fileSystem.getConf();
  }
  
  public BlockLocation[] getFileBlockLocations(FileStatus file, long start, long len)
    throws IOException
  {
    return fileSystem.getFileBlockLocations(file, start, len);
  }
  
  public BlockLocation[] getFileBlockLocations(Path p, long start, long len)
    throws IOException
  {
    return fileSystem.getFileBlockLocations(p, start, len);
  }
  
  public FsServerDefaults getServerDefaults()
    throws IOException
  {
    return fileSystem.getServerDefaults();
  }
  
  public FsServerDefaults getServerDefaults(Path p)
    throws IOException
  {
    return fileSystem.getServerDefaults(p);
  }
  
  public Path resolvePath(Path p)
    throws IOException
  {
    return fileSystem.resolvePath(p);
  }
  
  public FSDataInputStream open(Path f, int bufferSize)
    throws IOException
  {
    return fileSystem.open(f, bufferSize);
  }
  
  public FSDataInputStream open(Path f)
    throws IOException
  {
    return fileSystem.open(f);
  }
  
  public FSDataOutputStream create(Path f)
    throws IOException
  {
    return fileSystem.create(f);
  }
  
  public FSDataOutputStream create(Path f, boolean overwrite)
    throws IOException
  {
    return fileSystem.create(f, overwrite);
  }
  
  public FSDataOutputStream create(Path f, Progressable progress)
    throws IOException
  {
    return fileSystem.create(f, progress);
  }
  
  public FSDataOutputStream create(Path f, short replication)
    throws IOException
  {
    return fileSystem.create(f, replication);
  }
  
  public FSDataOutputStream create(Path f, short replication, Progressable progress)
    throws IOException
  {
    return fileSystem.create(f, replication, progress);
  }
  
  public FSDataOutputStream create(Path f, boolean overwrite, int bufferSize)
    throws IOException
  {
    return fileSystem.create(f, overwrite, bufferSize);
  }
  
  public FSDataOutputStream create(Path f, boolean overwrite, int bufferSize, Progressable progress)
    throws IOException
  {
    return fileSystem.create(f, overwrite, bufferSize, progress);
  }
  
  public FSDataOutputStream create(Path f, boolean overwrite, int bufferSize, short replication, long blockSize)
    throws IOException
  {
    return fileSystem.create(f, overwrite, bufferSize, replication, blockSize);
  }
  
  public FSDataOutputStream create(Path f, boolean overwrite, int bufferSize, short replication, long blockSize, Progressable progress)
    throws IOException
  {
    return fileSystem.create(f, overwrite, bufferSize, replication, blockSize, progress);
  }
  
  public FSDataOutputStream create(Path f, FsPermission permission, boolean overwrite, int bufferSize, short replication, long blockSize, Progressable progress)
    throws IOException
  {
    return fileSystem.create(f, permission, overwrite, bufferSize, replication, blockSize, progress);
  }
  
  public FSDataOutputStream create(Path f, FsPermission permission, EnumSet<CreateFlag> flags, int bufferSize, short replication, long blockSize, Progressable progress)
    throws IOException
  {
    return fileSystem.create(f, permission, flags, bufferSize, replication, blockSize, progress);
  }
  
  public FSDataOutputStream create(Path f, FsPermission permission, EnumSet<CreateFlag> flags, int bufferSize, short replication, long blockSize, Progressable progress, Options.ChecksumOpt checksumOpt)
    throws IOException
  {
    return fileSystem.create(f, permission, flags, bufferSize, replication, blockSize, progress, checksumOpt);
  }
  
  public FSDataOutputStream createNonRecursive(Path f, boolean overwrite, int bufferSize, short replication, long blockSize, Progressable progress)
    throws IOException
  {
    return fileSystem.createNonRecursive(f, overwrite, bufferSize, replication, blockSize, progress);
  }
  
  public FSDataOutputStream createNonRecursive(Path f, FsPermission permission, boolean overwrite, int bufferSize, short replication, long blockSize, Progressable progress)
    throws IOException
  {
    return fileSystem.createNonRecursive(f, permission, overwrite, bufferSize, replication, blockSize, progress);
  }
  
  public FSDataOutputStream createNonRecursive(Path f, FsPermission permission, EnumSet<CreateFlag> flags, int bufferSize, short replication, long blockSize, Progressable progress)
    throws IOException
  {
    return fileSystem.createNonRecursive(f, permission, flags, bufferSize, replication, blockSize, progress);
  }
  
  public boolean createNewFile(Path f)
    throws IOException
  {
    return fileSystem.createNewFile(f);
  }
  
  public FSDataOutputStream append(Path f)
    throws IOException
  {
    return fileSystem.append(f);
  }
  
  public FSDataOutputStream append(Path f, int bufferSize)
    throws IOException
  {
    return fileSystem.append(f, bufferSize);
  }
  
  public FSDataOutputStream append(Path f, int bufferSize, Progressable progress)
    throws IOException
  {
    return fileSystem.append(f, bufferSize, progress);
  }
  
  public void concat(Path trg, Path[] psrcs)
    throws IOException
  {
    fileSystem.concat(trg, psrcs);
  }
  
  public short getReplication(Path src)
    throws IOException
  {
    return fileSystem.getReplication(src);
  }
  
  public boolean setReplication(Path src, short replication)
    throws IOException
  {
    return fileSystem.setReplication(src, replication);
  }
  
  public boolean rename(Path src, Path dst)
    throws IOException
  {
    return fileSystem.rename(src, dst);
  }
  
  public boolean delete(Path f)
    throws IOException
  {
    return fileSystem.delete(f);
  }
  
  public boolean delete(Path f, boolean recursive)
    throws IOException
  {
    return fileSystem.delete(f, recursive);
  }
  
  public boolean deleteOnExit(Path f)
    throws IOException
  {
    return fileSystem.deleteOnExit(f);
  }
  
  public boolean cancelDeleteOnExit(Path f)
  {
    return fileSystem.cancelDeleteOnExit(f);
  }
  
  public boolean exists(Path f)
    throws IOException
  {
    return fileSystem.exists(f);
  }
  
  public boolean isDirectory(Path f)
    throws IOException
  {
    return fileSystem.isDirectory(f);
  }
  
  public boolean isFile(Path f)
    throws IOException
  {
    return fileSystem.isFile(f);
  }
  
  public long getLength(Path f)
    throws IOException
  {
    return fileSystem.getLength(f);
  }
  
  public ContentSummary getContentSummary(Path f)
    throws IOException
  {
    return fileSystem.getContentSummary(f);
  }
  
  public FileStatus[] listStatus(Path f)
    throws FileNotFoundException, IOException
  {
    return fileSystem.listStatus(f);
  }
  
  public RemoteIterator<Path> listCorruptFileBlocks(Path path)
    throws IOException
  {
    return fileSystem.listCorruptFileBlocks(path);
  }
  
  public FileStatus[] listStatus(Path f, PathFilter filter)
    throws FileNotFoundException, IOException
  {
    return fileSystem.listStatus(f, filter);
  }
  
  public FileStatus[] listStatus(Path[] files)
    throws FileNotFoundException, IOException
  {
    return fileSystem.listStatus(files);
  }
  
  public FileStatus[] listStatus(Path[] files, PathFilter filter)
    throws FileNotFoundException, IOException
  {
    return fileSystem.listStatus(files, filter);
  }
  
  public FileStatus[] globStatus(Path pathPattern)
    throws IOException
  {
    return fileSystem.globStatus(pathPattern);
  }
  
  public FileStatus[] globStatus(Path pathPattern, PathFilter filter)
    throws IOException
  {
    return fileSystem.globStatus(pathPattern, filter);
  }
  
  public RemoteIterator<LocatedFileStatus> listLocatedStatus(Path f)
    throws FileNotFoundException, IOException
  {
    return fileSystem.listLocatedStatus(f);
  }
  
  public RemoteIterator<LocatedFileStatus> listFiles(Path f, boolean recursive)
    throws FileNotFoundException, IOException
  {
    return fileSystem.listFiles(f, recursive);
  }
  
  public Path getHomeDirectory()
  {
    return fileSystem.getHomeDirectory();
  }
  
  public void setWorkingDirectory(Path new_dir)
  {
    fileSystem.setWorkingDirectory(new_dir);
  }
  
  public Path getWorkingDirectory()
  {
    return fileSystem.getWorkingDirectory();
  }
  
  public boolean mkdirs(Path f)
    throws IOException
  {
    return fileSystem.mkdirs(f);
  }
  
  public boolean mkdirs(Path f, FsPermission permission)
    throws IOException
  {
    return fileSystem.mkdirs(f, permission);
  }
  
  public void copyFromLocalFile(Path src, Path dst)
    throws IOException
  {
    fileSystem.copyFromLocalFile(src, dst);
  }
  
  public void moveFromLocalFile(Path[] srcs, Path dst)
    throws IOException
  {
    fileSystem.moveFromLocalFile(srcs, dst);
  }
  
  public void moveFromLocalFile(Path src, Path dst)
    throws IOException
  {
    fileSystem.moveFromLocalFile(src, dst);
  }
  
  public void copyFromLocalFile(boolean delSrc, Path src, Path dst)
    throws IOException
  {
    fileSystem.copyFromLocalFile(delSrc, src, dst);
  }
  
  public void copyFromLocalFile(boolean delSrc, boolean overwrite, Path[] srcs, Path dst)
    throws IOException
  {
    fileSystem.copyFromLocalFile(delSrc, overwrite, srcs, dst);
  }
  
  public void copyFromLocalFile(boolean delSrc, boolean overwrite, Path src, Path dst)
    throws IOException
  {
    fileSystem.copyFromLocalFile(delSrc, overwrite, src, dst);
  }
  
  public void copyToLocalFile(Path src, Path dst)
    throws IOException
  {
    fileSystem.copyToLocalFile(src, dst);
  }
  
  public void moveToLocalFile(Path src, Path dst)
    throws IOException
  {
    fileSystem.moveToLocalFile(src, dst);
  }
  
  public void copyToLocalFile(boolean delSrc, Path src, Path dst)
    throws IOException
  {
    fileSystem.copyToLocalFile(delSrc, src, dst);
  }
  
  public void copyToLocalFile(boolean delSrc, Path src, Path dst, boolean useRawLocalFileSystem)
    throws IOException
  {
    fileSystem.copyToLocalFile(delSrc, src, dst, useRawLocalFileSystem);
  }
  
  public Path startLocalOutput(Path fsOutputFile, Path tmpLocalFile)
    throws IOException
  {
    return fileSystem.startLocalOutput(fsOutputFile, tmpLocalFile);
  }
  
  public void completeLocalOutput(Path fsOutputFile, Path tmpLocalFile)
    throws IOException
  {
    fileSystem.completeLocalOutput(fsOutputFile, tmpLocalFile);
  }
  
  /* Error */
  public void close()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/amazon/ws/emr/hadoop/fs/EmrFileSystem:fileSystem	Lorg/apache/hadoop/fs/FileSystem;
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 45	com/amazon/ws/emr/hadoop/fs/EmrFileSystem:fileSystem	Lorg/apache/hadoop/fs/FileSystem;
    //   11: invokevirtual 517	org/apache/hadoop/fs/FileSystem:close	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 45	com/amazon/ws/emr/hadoop/fs/EmrFileSystem:fileSystem	Lorg/apache/hadoop/fs/FileSystem;
    //   19: aload_0
    //   20: invokespecial 517	org/apache/hadoop/fs/FileSystem:close	()V
    //   23: goto +10 -> 33
    //   26: astore_1
    //   27: aload_0
    //   28: invokespecial 517	org/apache/hadoop/fs/FileSystem:close	()V
    //   31: aload_1
    //   32: athrow
    //   33: return
    // Line number table:
    //   Java source line #509	-> byte code offset #0
    //   Java source line #510	-> byte code offset #7
    //   Java source line #511	-> byte code offset #14
    //   Java source line #514	-> byte code offset #19
    //   Java source line #515	-> byte code offset #23
    //   Java source line #514	-> byte code offset #26
    //   Java source line #515	-> byte code offset #31
    //   Java source line #516	-> byte code offset #33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	EmrFileSystem
    //   26	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	19	26	finally
  }
  
  public long getUsed()
    throws IOException
  {
    return fileSystem.getUsed();
  }
  
  public long getBlockSize(Path f)
    throws IOException
  {
    return fileSystem.getBlockSize(f);
  }
  
  public long getDefaultBlockSize()
  {
    return fileSystem.getDefaultBlockSize();
  }
  
  public long getDefaultBlockSize(Path f)
  {
    return fileSystem.getDefaultBlockSize(f);
  }
  
  public short getDefaultReplication()
  {
    return fileSystem.getDefaultReplication();
  }
  
  public short getDefaultReplication(Path path)
  {
    return fileSystem.getDefaultReplication(path);
  }
  
  public FileStatus getFileStatus(Path f)
    throws IOException
  {
    return fileSystem.getFileStatus(f);
  }
  
  public void createSymlink(Path target, Path link, boolean createParent)
    throws AccessControlException, FileAlreadyExistsException, FileNotFoundException, ParentNotDirectoryException, UnsupportedFileSystemException, IOException
  {
    fileSystem.createSymlink(target, link, createParent);
  }
  
  public FileStatus getFileLinkStatus(Path f)
    throws AccessControlException, FileNotFoundException, UnsupportedFileSystemException, IOException
  {
    return fileSystem.getFileLinkStatus(f);
  }
  
  public boolean supportsSymlinks()
  {
    return fileSystem.supportsSymlinks();
  }
  
  public Path getLinkTarget(Path f)
    throws IOException
  {
    return fileSystem.getLinkTarget(f);
  }
  
  public FileChecksum getFileChecksum(Path f)
    throws IOException
  {
    return fileSystem.getFileChecksum(f);
  }
  
  public void setVerifyChecksum(boolean verifyChecksum)
  {
    fileSystem.setVerifyChecksum(verifyChecksum);
  }
  
  public void setWriteChecksum(boolean writeChecksum)
  {
    fileSystem.setWriteChecksum(writeChecksum);
  }
  
  public FsStatus getStatus()
    throws IOException
  {
    return fileSystem.getStatus();
  }
  
  public FsStatus getStatus(Path p)
    throws IOException
  {
    return fileSystem.getStatus(p);
  }
  
  public void setPermission(Path p, FsPermission permission)
    throws IOException
  {
    fileSystem.setPermission(p, permission);
  }
  
  public void setOwner(Path p, String username, String groupname)
    throws IOException
  {
    fileSystem.setOwner(p, username, groupname);
  }
  
  public void setTimes(Path p, long mtime, long atime)
    throws IOException
  {
    fileSystem.setTimes(p, mtime, atime);
  }
  
  public Path createSnapshot(Path path, String snapshotName)
    throws IOException
  {
    return fileSystem.createSnapshot(path, snapshotName);
  }
  
  public void renameSnapshot(Path path, String snapshotOldName, String snapshotNewName)
    throws IOException
  {
    fileSystem.renameSnapshot(path, snapshotOldName, snapshotNewName);
  }
  
  public void deleteSnapshot(Path path, String snapshotName)
    throws IOException
  {
    fileSystem.deleteSnapshot(path, snapshotName);
  }
  
  public String getScheme()
  {
    if (fileSystem.getUri() != null) {
      return fileSystem.getUri().getScheme();
    }
    return EmrFsUtils.getDefaultScheme();
  }
  
  public URI getUri()
  {
    return fileSystem.getUri();
  }
  
  public String getCanonicalServiceName()
  {
    return null;
  }
  
  public String getName()
  {
    return fileSystem.getName();
  }
  
  public Path makeQualified(Path path)
  {
    return fileSystem.makeQualified(path);
  }
  
  public FileSystem[] getChildFileSystems()
  {
    return fileSystem.getChildFileSystems();
  }
  
  public void enableCache() {}
  
  public void disableCache() {}
  
  public Path[] getEmptySubDirPaths(Path parent)
    throws IOException
  {
    if (useConsistency) {
      throw new UnsupportedOperationException("getEmptySubDirPaths not supported when consistency is enabled");
    }
    return ((S3NativeFileSystem)fileSystem).getEmptySubDirPaths(parent);
  }
  
  public FSDataInputStreamBuilder openFile(Path path)
  {
    return fileSystem.openFile(path);
  }
  
  public StagingDirectoryService getStagingDirectoryService()
  {
    return StagingDirectoryServices.getService(fileSystem);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.EmrFileSystem
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */