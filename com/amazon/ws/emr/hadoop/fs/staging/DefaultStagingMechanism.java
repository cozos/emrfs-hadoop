package com.amazon.ws.emr.hadoop.fs.staging;

import com.amazon.ws.emr.hadoop.fs.s3n.FileStatusFactory;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagingMetadataStore;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagingStatus;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingPath;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingPathConverter;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingRoot;
import java.io.IOException;
import java.util.function.UnaryOperator;
import javax.annotation.Nonnull;
import lombok.NonNull;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.staging.UnsupportedStagingDirectoryOperationException;

public final class DefaultStagingMechanism
  implements StagingMechanism
{
  @NonNull
  private final StagingPathConverter pathConverter;
  @NonNull
  private final StagingMetadataStore store;
  @NonNull
  private final UnaryOperator<Path> pathQualifier;
  @NonNull
  private final FileStatusFactory fileStatusFactory;
  
  public static class DefaultStagingMechanismBuilder
  {
    private StagingPathConverter pathConverter;
    private StagingMetadataStore store;
    private UnaryOperator<Path> pathQualifier;
    private FileStatusFactory fileStatusFactory;
    
    public String toString()
    {
      return "DefaultStagingMechanism.DefaultStagingMechanismBuilder(pathConverter=" + pathConverter + ", store=" + store + ", pathQualifier=" + pathQualifier + ", fileStatusFactory=" + fileStatusFactory + ")";
    }
    
    public DefaultStagingMechanism build()
    {
      return new DefaultStagingMechanism(pathConverter, store, pathQualifier, fileStatusFactory);
    }
    
    public DefaultStagingMechanismBuilder fileStatusFactory(FileStatusFactory fileStatusFactory)
    {
      this.fileStatusFactory = fileStatusFactory;return this;
    }
    
    public DefaultStagingMechanismBuilder pathQualifier(UnaryOperator<Path> pathQualifier)
    {
      this.pathQualifier = pathQualifier;return this;
    }
    
    public DefaultStagingMechanismBuilder store(StagingMetadataStore store)
    {
      this.store = store;return this;
    }
    
    public DefaultStagingMechanismBuilder pathConverter(StagingPathConverter pathConverter)
    {
      this.pathConverter = pathConverter;return this;
    }
  }
  
  DefaultStagingMechanism(@NonNull StagingPathConverter pathConverter, @NonNull StagingMetadataStore store, @NonNull UnaryOperator<Path> pathQualifier, @NonNull FileStatusFactory fileStatusFactory)
  {
    if (pathConverter == null) {
      throw new NullPointerException("pathConverter");
    }
    if (store == null) {
      throw new NullPointerException("store");
    }
    if (pathQualifier == null) {
      throw new NullPointerException("pathQualifier");
    }
    if (fileStatusFactory == null) {
      throw new NullPointerException("fileStatusFactory");
    }
    this.pathConverter = pathConverter;this.store = store;this.pathQualifier = pathQualifier;this.fileStatusFactory = fileStatusFactory;
  }
  
  public static DefaultStagingMechanismBuilder builder()
  {
    return new DefaultStagingMechanismBuilder();
  }
  
  public boolean isStagingDirectoryPath(@Nonnull Path path)
  {
    Path qualifiedPath = (Path)pathQualifier.apply(path);
    return pathConverter.isStagingPath(qualifiedPath);
  }
  
  public boolean hasStagingDirectory(@Nonnull Path destinationPath, @Nonnull String stageName)
    throws IOException
  {
    return store.hasStagingDirectory(getStagingRoot(destinationPath, stageName));
  }
  
  public Path makeStagingDirectory(@Nonnull Path destinationPath, @Nonnull String stageName)
    throws IOException
  {
    Path qualifiedDestinationPath = (Path)pathQualifier.apply(destinationPath);
    if (pathConverter.isStagingPath(qualifiedDestinationPath)) {
      throw new UnsupportedStagingDirectoryOperationException(String.format("Cannot create a staging directory under a staging directory (destinationPath: %s, stageName: %s)", new Object[] { qualifiedDestinationPath, stageName }));
    }
    StagingRoot stagingRoot = StagingRoot.of(qualifiedDestinationPath, stageName);
    store.makeStagingDirectory(stagingRoot);
    return pathConverter.toHadoopPath(stagingRoot);
  }
  
  public void publishStagingDirectory(@Nonnull Path outputPath, @Nonnull String stageName)
    throws IOException
  {
    store.publishStagingDirectory(getStagingRoot(outputPath, stageName));
  }
  
  public void deleteStagingDirectory(@Nonnull Path destinationPath, @Nonnull String stageName)
    throws IOException
  {
    store.deleteStagingDirectory(getStagingRoot(destinationPath, stageName));
  }
  
  public FileStatus getFileStatus(@Nonnull Path path)
    throws IOException
  {
    Path qualifiedDestinationPath = (Path)pathQualifier.apply(path);
    StagingPath stagingPath = pathConverter.toStagingPath(qualifiedDestinationPath);
    return toFileStatus(store.getStatus(stagingPath));
  }
  
  private StagingRoot getStagingRoot(Path destinationPath, String stageName)
  {
    Path qualifiedDestinationPath = (Path)pathQualifier.apply(destinationPath);
    return StagingRoot.of(qualifiedDestinationPath, stageName);
  }
  
  private FileStatus toFileStatus(StagingStatus status)
  {
    Path path = pathConverter.toHadoopPath(status.getPath());
    if (status.isDirectory()) {
      return fileStatusFactory.newDirectory(path);
    }
    return fileStatusFactory.newFile(path, status.getLength(), status.getModificationTime());
  }
  
  public void close()
    throws IOException
  {
    store.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.DefaultStagingMechanism
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */