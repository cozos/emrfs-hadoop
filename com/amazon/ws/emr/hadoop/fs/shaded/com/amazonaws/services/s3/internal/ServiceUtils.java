package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.exception.FileLockException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Md5Utils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URI;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.SSLProtocolException;

public class ServiceUtils
{
  private static final Log LOG = LogFactory.getLog(ServiceUtils.class);
  public static final boolean APPEND_MODE = true;
  public static final boolean OVERWRITE_MODE = false;
  private static final SkipMd5CheckStrategy skipMd5CheckStrategy = SkipMd5CheckStrategy.INSTANCE;
  @Deprecated
  protected static final DateUtils dateUtils = new DateUtils();
  
  public static Date parseIso8601Date(String dateString)
  {
    return DateUtils.parseISO8601Date(dateString);
  }
  
  public static String formatIso8601Date(Date date)
  {
    return DateUtils.formatISO8601Date(date);
  }
  
  public static Date parseRfc822Date(String dateString)
  {
    if (StringUtils.isNullOrEmpty(dateString)) {
      return null;
    }
    return DateUtils.parseRFC822Date(dateString);
  }
  
  public static String formatRfc822Date(Date date)
  {
    return DateUtils.formatRFC822Date(date);
  }
  
  public static byte[] toByteArray(String s)
  {
    return s.getBytes(StringUtils.UTF8);
  }
  
  public static String removeQuotes(String s)
  {
    if (s == null) {
      return null;
    }
    s = s.trim();
    if (s.startsWith("\"")) {
      s = s.substring(1);
    }
    if (s.endsWith("\"")) {
      s = s.substring(0, s.length() - 1);
    }
    return s;
  }
  
  @Deprecated
  public static URL convertRequestToUrl(Request<?> request)
  {
    return convertRequestToUrl(request, false);
  }
  
  @Deprecated
  public static URL convertRequestToUrl(Request<?> request, boolean removeLeadingSlashInResourcePath)
  {
    return convertRequestToUrl(request, removeLeadingSlashInResourcePath, true);
  }
  
  public static URL convertRequestToUrl(Request<?> request, boolean removeLeadingSlashInResourcePath, boolean urlEncode)
  {
    String resourcePath = urlEncode ? SdkHttpUtils.urlEncode(request.getResourcePath(), true) : request.getResourcePath();
    if ((removeLeadingSlashInResourcePath) && 
      (resourcePath.startsWith("/"))) {
      resourcePath = resourcePath.substring(1);
    }
    String urlPath = "/" + resourcePath;
    urlPath = urlPath.replaceAll("(?<=/)/", "%2F");
    StringBuilder url = new StringBuilder(request.getEndpoint().toString());
    url.append(urlPath);
    
    StringBuilder queryParams = new StringBuilder();
    Map<String, List<String>> requestParams = request.getParameters();
    for (Iterator localIterator1 = requestParams.entrySet().iterator(); localIterator1.hasNext();)
    {
      entry = (Map.Entry)localIterator1.next();
      for (String value : (List)entry.getValue())
      {
        queryParams = queryParams.length() > 0 ? queryParams.append("&") : queryParams.append("?");
        queryParams.append((String)entry.getKey())
          .append("=")
          .append(SdkHttpUtils.urlEncode(value, false));
      }
    }
    Map.Entry<String, List<String>> entry;
    url.append(queryParams.toString());
    try
    {
      return new URL(url.toString());
    }
    catch (MalformedURLException e)
    {
      throw new SdkClientException("Unable to convert request to well formed URL: " + e.getMessage(), e);
    }
  }
  
  public static String join(List<String> strings)
  {
    StringBuilder result = new StringBuilder();
    
    boolean first = true;
    for (String s : strings)
    {
      if (!first) {
        result.append(", ");
      }
      result.append(s);
      first = false;
    }
    return result.toString();
  }
  
  public static void downloadObjectToFile(S3Object s3Object, File destinationFile, boolean performIntegrityCheck, boolean appendData)
  {
    downloadToFile(s3Object, destinationFile, performIntegrityCheck, appendData, -1L);
  }
  
  public static void downloadToFile(S3Object s3Object, File dstfile, boolean performIntegrityCheck, boolean appendData, long expectedFileLength)
  {
    createParentDirectoryIfNecessary(dstfile);
    if (!FileLocks.lock(dstfile)) {
      throw new FileLockException("Fail to lock " + dstfile + " for appendData=" + appendData);
    }
    OutputStream outputStream = null;
    try
    {
      long actualLen = dstfile.length();
      if ((appendData) && (actualLen != expectedFileLength)) {
        throw new IllegalStateException("Expected file length to append is " + expectedFileLength + " but actual length is " + actualLen + " for file " + dstfile);
      }
      outputStream = new BufferedOutputStream(new FileOutputStream(dstfile, appendData));
      
      byte[] buffer = new byte['⠀'];
      int bytesRead;
      while ((bytesRead = s3Object.getObjectContent().read(buffer)) > -1) {
        outputStream.write(buffer, 0, bytesRead);
      }
    }
    catch (IOException e)
    {
      s3Object.getObjectContent().abort();
      
      throw new SdkClientException("Unable to store object contents to disk: " + e.getMessage(), e);
    }
    finally
    {
      IOUtils.closeQuietly(outputStream, LOG);
      FileLocks.unlock(dstfile);
      IOUtils.closeQuietly(s3Object.getObjectContent(), LOG);
    }
    if (performIntegrityCheck)
    {
      byte[] clientSideHash = null;
      byte[] serverSideHash = null;
      try
      {
        ObjectMetadata metadata = s3Object.getObjectMetadata();
        if (!skipMd5CheckStrategy.skipClientSideValidationPerGetResponse(metadata))
        {
          clientSideHash = Md5Utils.computeMD5Hash(new FileInputStream(dstfile));
          serverSideHash = BinaryUtils.fromHex(metadata.getETag());
        }
      }
      catch (Exception e)
      {
        LOG.warn("Unable to calculate MD5 hash to validate download: " + e.getMessage(), e);
      }
      if ((clientSideHash != null) && (serverSideHash != null) && (!Arrays.equals(clientSideHash, serverSideHash))) {
        throw new SdkClientException("Unable to verify integrity of data download.  Client calculated content hash didn't match hash calculated by Amazon S3.  The data stored in '" + dstfile.getAbsolutePath() + "' may be corrupt.");
      }
    }
  }
  
  public static void createParentDirectoryIfNecessary(File file)
  {
    File parentDirectory = file.getParentFile();
    if ((parentDirectory == null) || (parentDirectory.mkdirs()) || (parentDirectory.exists())) {
      return;
    }
    throw new SdkClientException("Unable to create directory in the path: " + parentDirectory.getAbsolutePath());
  }
  
  public static S3Object retryableDownloadS3ObjectToFile(File file, RetryableS3DownloadTask retryableS3DownloadTask, boolean appendData)
  {
    boolean hasRetried = false;
    boolean needRetry;
    S3Object s3Object;
    do
    {
      needRetry = false;
      s3Object = retryableS3DownloadTask.getS3ObjectStream();
      if (s3Object == null) {
        return null;
      }
      try
      {
        downloadObjectToFile(s3Object, file, retryableS3DownloadTask
          .needIntegrityCheck(), appendData);
      }
      catch (SdkClientException ace)
      {
        if (!ace.isRetryable())
        {
          s3Object.getObjectContent().abort();
          throw ace;
        }
        if (((ace.getCause() instanceof SocketException)) || ((ace.getCause() instanceof SSLProtocolException))) {
          throw ace;
        }
        needRetry = true;
        if (hasRetried)
        {
          s3Object.getObjectContent().abort();
          throw ace;
        }
        LOG.info("Retry the download of object " + s3Object.getKey() + " (bucket " + s3Object.getBucketName() + ")", ace);
        hasRetried = true;
      }
    } while (needRetry);
    return s3Object;
  }
  
  public static void appendFile(File sourceFile, File destinationFile)
  {
    ValidationUtils.assertNotNull(destinationFile, "destFile");
    ValidationUtils.assertNotNull(sourceFile, "sourceFile");
    if (!FileLocks.lock(sourceFile)) {
      throw new FileLockException("Fail to lock " + sourceFile);
    }
    if (!FileLocks.lock(destinationFile)) {
      throw new FileLockException("Fail to lock " + destinationFile);
    }
    FileChannel in = null;
    FileChannel out = null;
    try
    {
      in = new FileInputStream(sourceFile).getChannel();
      out = new FileOutputStream(destinationFile, true).getChannel();
      long size = in.size();
      
      long count = 33554432L;
      long position = 0L;
      while (position < size) {
        position += in.transferTo(position, 33554432L, out);
      }
      return;
    }
    catch (IOException e)
    {
      throw new SdkClientException("Unable to append file " + sourceFile.getAbsolutePath() + "to destination file " + destinationFile.getAbsolutePath() + "\n" + e.getMessage(), e);
    }
    finally
    {
      IOUtils.closeQuietly(out, LOG);
      IOUtils.closeQuietly(in, LOG);
      FileLocks.unlock(sourceFile);
      FileLocks.unlock(destinationFile);
      try
      {
        if (!sourceFile.delete()) {
          LOG.warn("Failed to delete file " + sourceFile.getAbsolutePath());
        }
      }
      catch (SecurityException exception)
      {
        LOG.warn("Security manager denied delete access to file " + sourceFile.getAbsolutePath());
      }
    }
  }
  
  public static boolean isS3USStandardEndpoint(String endpoint)
  {
    return endpoint.endsWith("s3.amazonaws.com");
  }
  
  public static boolean isS3USEastEndpiont(String endpoint)
  {
    return (isS3USStandardEndpoint(endpoint)) || 
      (endpoint.endsWith("s3-external-1.amazonaws.com"));
  }
  
  public static boolean isS3AccelerateEndpoint(String endpoint)
  {
    return (endpoint.endsWith("s3-accelerate.amazonaws.com")) || 
      (endpoint.endsWith("s3-accelerate.dualstack.amazonaws.com"));
  }
  
  public static Integer getPartCount(GetObjectRequest getObjectRequest, AmazonS3 s3)
  {
    ValidationUtils.assertNotNull(s3, "S3 client");
    ValidationUtils.assertNotNull(getObjectRequest, "GetObjectRequest");
    
    GetObjectMetadataRequest getObjectMetadataRequest = RequestCopyUtils.createGetObjectMetadataRequestFrom(getObjectRequest).withPartNumber(Integer.valueOf(1));
    
    return s3.getObjectMetadata(getObjectMetadataRequest).getPartCount();
  }
  
  @SdkInternalApi
  public static long getPartSize(GetObjectRequest getObjectRequest, AmazonS3 s3, int partNumber)
  {
    ValidationUtils.assertNotNull(s3, "S3 client");
    ValidationUtils.assertNotNull(getObjectRequest, "GetObjectRequest");
    
    GetObjectMetadataRequest getObjectMetadataRequest = RequestCopyUtils.createGetObjectMetadataRequestFrom(getObjectRequest).withPartNumber(Integer.valueOf(partNumber));
    
    return s3.getObjectMetadata(getObjectMetadataRequest).getContentLength();
  }
  
  public static long getLastByteInPart(AmazonS3 s3, GetObjectRequest getObjectRequest, Integer partNumber)
  {
    ValidationUtils.assertNotNull(s3, "S3 client");
    ValidationUtils.assertNotNull(getObjectRequest, "GetObjectRequest");
    ValidationUtils.assertNotNull(partNumber, "partNumber");
    
    GetObjectMetadataRequest getObjectMetadataRequest = RequestCopyUtils.createGetObjectMetadataRequestFrom(getObjectRequest).withPartNumber(partNumber);
    ObjectMetadata metadata = s3.getObjectMetadata(getObjectMetadataRequest);
    return metadata.getContentRange()[1].longValue();
  }
  
  public static abstract interface RetryableS3DownloadTask
  {
    public abstract S3Object getS3ObjectStream();
    
    public abstract boolean needIntegrityCheck();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */