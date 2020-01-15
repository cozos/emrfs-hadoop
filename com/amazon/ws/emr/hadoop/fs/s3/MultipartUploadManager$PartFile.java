package com.amazon.ws.emr.hadoop.fs.s3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

final class MultipartUploadManager$PartFile
{
  final Path path;
  final long length;
  
  public String toString()
  {
    return "MultipartUploadManager.PartFile(path=" + path + ", length=" + length + ")";
  }
  
  public MultipartUploadManager$PartFile(Path path, long length)
  {
    this.path = path;this.length = length;
  }
  
  MultipartUploadManager$PartFile(Path path)
    throws IOException
  {
    this(path, Files.size(path));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.MultipartUploadManager.PartFile
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */