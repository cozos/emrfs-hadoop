package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.identity.FileSystemOwner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.function.LongSupplier;
import java.util.function.UnaryOperator;
import lombok.NonNull;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;

public final class BasicFileStatusFactory
  implements FileStatusFactory
{
  private static final long DIRECTORY_LENGTH = 0L;
  private static final long DIRECTORY_BLOCK_SIZE = 0L;
  private static final long DIRECTORY_MODIFICATION_TIME = 0L;
  private static final int BLOCK_REPLICATION = 1;
  private static final long ACCESS_TIME = 0L;
  
  public static class BasicFileStatusFactoryBuilder
  {
    private FileSystemOwner fileSystemOwner;
    private UnaryOperator<Path> pathQualifier;
    private LongSupplier blockSizeSupplier;
    
    public String toString()
    {
      return "BasicFileStatusFactory.BasicFileStatusFactoryBuilder(fileSystemOwner=" + fileSystemOwner + ", pathQualifier=" + pathQualifier + ", blockSizeSupplier=" + blockSizeSupplier + ")";
    }
    
    public BasicFileStatusFactory build()
    {
      return new BasicFileStatusFactory(fileSystemOwner, pathQualifier, blockSizeSupplier);
    }
    
    public BasicFileStatusFactoryBuilder blockSizeSupplier(LongSupplier blockSizeSupplier)
    {
      this.blockSizeSupplier = blockSizeSupplier;return this;
    }
    
    public BasicFileStatusFactoryBuilder pathQualifier(UnaryOperator<Path> pathQualifier)
    {
      this.pathQualifier = pathQualifier;return this;
    }
    
    public BasicFileStatusFactoryBuilder fileSystemOwner(FileSystemOwner fileSystemOwner)
    {
      this.fileSystemOwner = fileSystemOwner;return this;
    }
  }
  
  BasicFileStatusFactory(@NonNull FileSystemOwner fileSystemOwner, @NonNull UnaryOperator<Path> pathQualifier, @NonNull LongSupplier blockSizeSupplier)
  {
    if (fileSystemOwner == null) {
      throw new NullPointerException("fileSystemOwner");
    }
    if (pathQualifier == null) {
      throw new NullPointerException("pathQualifier");
    }
    if (blockSizeSupplier == null) {
      throw new NullPointerException("blockSizeSupplier");
    }
    this.fileSystemOwner = fileSystemOwner;this.pathQualifier = pathQualifier;this.blockSizeSupplier = blockSizeSupplier;
  }
  
  public static BasicFileStatusFactoryBuilder builder()
  {
    return new BasicFileStatusFactoryBuilder();
  }
  
  private static final FsPermission PERMISSION = null;
  @NonNull
  private final FileSystemOwner fileSystemOwner;
  @NonNull
  private final UnaryOperator<Path> pathQualifier;
  @NonNull
  private final LongSupplier blockSizeSupplier;
  
  public FileStatus newDirectory(@NonNull Path path)
  {
    if (path == null) {
      throw new NullPointerException("path");
    }
    return new FileStatus(0L, true, 1, 0L, 0L, 0L, PERMISSION, fileSystemOwner
    
      .getFullUserName(), fileSystemOwner
      .getGroup(), 
      (Path)pathQualifier.apply(path));
  }
  
  public FileStatus newFile(@NonNull Path path, long length, long modificationTime)
  {
    if (path == null) {
      throw new NullPointerException("path");
    }
    Preconditions.checkArgument(length >= 0L, "Length must not be negative");
    return new FileStatus(length, false, 1, blockSizeSupplier
    
      .getAsLong(), modificationTime, 0L, PERMISSION, fileSystemOwner
      
      .getFullUserName(), fileSystemOwner
      .getGroup(), 
      (Path)pathQualifier.apply(path));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.BasicFileStatusFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */