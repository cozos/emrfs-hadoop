package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.files.TemporaryDirectories;
import com.amazon.ws.emr.hadoop.fs.files.TemporaryFiles;
import com.amazon.ws.emr.hadoop.fs.s3.S3ObjectRequestFactory;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.AbortMultipartUploadEvent;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.AbortMultipartUploadEvent.AbortMultipartUploadEventBuilder;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.CompleteMultipartUploadEvent;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.CompleteMultipartUploadEvent.CompleteMultipartUploadEventBuilder;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ExtraUploadMetadata;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.MultipartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadConstraint;
import com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlan;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.FutureCallback;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListenableFuture;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListeningExecutorService;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.Hex;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.common.Abortable;
import org.apache.hadoop.util.Progressable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MultipartUploadOutputStream
  extends OutputStream
  implements Abortable
{
  public static final Logger LOG = LoggerFactory.getLogger(MultipartUploadOutputStream.class);
  public static final double MAX_PART_SIZE_THRESHOLD_PERCENT = 0.7D;
  private final AmazonS3Lite s3;
  private final ListeningExecutorService exec;
  private final Progressable progressable;
  private final UploadPlan uploadPlan;
  private final String bucket;
  private final String key;
  private final String s3path;
  private final long partSize;
  private final double partsCompletedThresholdPercent;
  private final double fractionPartAvgCompletionTime;
  private final int maxPartAttempts;
  private final ObjectMetadata metadata;
  private final NativeFileSystemStore store;
  private final Configuration conf;
  private final ConcurrentHashMap<Integer, List<MultiPartUploadFuture>> partNumFutureMap;
  private final Object partNumFutureMapHandle = new Object();
  private final Set<Integer> incompletePartNums;
  private int partCount = 0;
  private long currentPartSize = 0L;
  private DigestOutputStream currentOutput;
  private Path currentPath;
  private String uploadId;
  private String serverSideEncryptionKmsKeyId;
  private long totalLength = 0L;
  private boolean multipartUploadInitiated;
  private boolean closed = false;
  private boolean closing = false;
  private final TemporaryFiles temporaryFiles;
  private final TemporaryDirectories temporaryDirectories;
  
  public MultipartUploadOutputStream(AmazonS3Lite s3, Configuration conf, NativeFileSystemStore store, ListeningExecutorService exec, Progressable progressable, UploadPlan uploadPlan, String serverSideEncryptionAlgorithm, String serverSideEncryptionKmsKeyId, TemporaryDirectories temporaryDirectories)
  {
    validateUploadPlan(uploadPlan);
    
    this.s3 = EmrFsUtils.getAmazonS3LiteWithRetryPolicy(s3);
    
    multipartUploadInitiated = false;
    metadata = new ObjectMetadata();
    metadata.setContentType("binary/octet-stream");
    if (!Strings.isNullOrEmpty(serverSideEncryptionAlgorithm))
    {
      metadata.setSSEAlgorithm(serverSideEncryptionAlgorithm);
      this.serverSideEncryptionKmsKeyId = serverSideEncryptionKmsKeyId;
    }
    this.store = store;
    this.exec = exec;
    this.progressable = progressable;
    partNumFutureMap = new ConcurrentHashMap();
    incompletePartNums = Collections.synchronizedSet(new HashSet());
    this.temporaryDirectories = temporaryDirectories;
    temporaryFiles = new TemporaryFiles(temporaryDirectories);
    this.uploadPlan = uploadPlan;
    bucket = uploadPlan.getBucket();
    key = uploadPlan.getKey();
    s3path = ("s3://" + bucket + "/" + key);
    this.conf = conf;
    partSize = ConfigurationUtils.getDefaultPartSize(conf);
    partsCompletedThresholdPercent = ConfigurationUtils.getPartsCompletedThresholdPercent(conf);
    fractionPartAvgCompletionTime = ConfigurationUtils.getFractionPartAvgCompletionTime(conf);
    maxPartAttempts = ConfigurationUtils.getPartAttempts(conf);
    openNewPart();
  }
  
  private static void validateUploadPlan(UploadPlan uploadPlan)
  {
    ExtraUploadMetadata extraUploadMetadata = uploadPlan.getExtraUploadMetadata();
    Preconditions.checkArgument(extraUploadMetadata.getConcurrencyToken() == null, "Expected upload plan not to contain a ConcurrencyToken");
  }
  
  public long getPartSize()
  {
    return partSize;
  }
  
  public double getPartsCompletedThresholdPercent()
  {
    return partsCompletedThresholdPercent;
  }
  
  public double getFractionPartAvgCompletionTime()
  {
    return fractionPartAvgCompletionTime;
  }
  
  public int getMaxPartAttempts()
  {
    return maxPartAttempts;
  }
  
  public void write(byte[] b)
    throws IOException
  {
    write(b, 0, b.length);
  }
  
  public void write(byte[] b, int off, int len)
    throws IOException
  {
    long capacityLeft = capacityLeft();
    int offset = off;
    int length = len;
    while (capacityLeft < length)
    {
      int capacityLeftInt = (int)capacityLeft;
      currentOutput.write(b, offset, capacityLeftInt);
      closeAndSchedulePart();
      offset += capacityLeftInt;
      length -= capacityLeftInt;
      capacityLeft = capacityLeft();
    }
    currentOutput.write(b, offset, length);
    currentPartSize += length;
    totalLength += len;
  }
  
  public void write(int b)
    throws IOException
  {
    if (capacityLeft() < 1L) {
      closeAndSchedulePart();
    }
    currentOutput.write(b);
    currentPartSize += 1L;
    totalLength += 1L;
  }
  
  public void flush() {}
  
  /* Error */
  private void uploadSinglePart()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 290	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:currentOutput	Ljava/security/DigestOutputStream;
    //   4: invokevirtual 309	java/security/DigestOutputStream:close	()V
    //   7: aload_0
    //   8: getfield 290	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:currentOutput	Ljava/security/DigestOutputStream;
    //   11: invokevirtual 313	java/security/DigestOutputStream:getMessageDigest	()Ljava/security/MessageDigest;
    //   14: invokevirtual 319	java/security/MessageDigest:digest	()[B
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 160	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:store	Lcom/amazon/ws/emr/hadoop/fs/s3n/NativeFileSystemStore;
    //   22: aload_0
    //   23: getfield 202	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:key	Ljava/lang/String;
    //   26: aload_0
    //   27: getfield 321	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:currentPath	Ljava/nio/file/Path;
    //   30: invokeinterface 327 1 0
    //   35: aload_1
    //   36: aload_0
    //   37: getfield 164	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:progressable	Lorg/apache/hadoop/util/Progressable;
    //   40: invokeinterface 331 5 0
    //   45: aload_0
    //   46: getfield 189	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:temporaryFiles	Lcom/amazon/ws/emr/hadoop/fs/files/TemporaryFiles;
    //   49: aload_0
    //   50: getfield 321	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:currentPath	Ljava/nio/file/Path;
    //   53: invokevirtual 335	com/amazon/ws/emr/hadoop/fs/files/TemporaryFiles:delete	(Ljava/nio/file/Path;)Z
    //   56: pop
    //   57: goto +18 -> 75
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 189	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:temporaryFiles	Lcom/amazon/ws/emr/hadoop/fs/files/TemporaryFiles;
    //   65: aload_0
    //   66: getfield 321	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:currentPath	Ljava/nio/file/Path;
    //   69: invokevirtual 335	com/amazon/ws/emr/hadoop/fs/files/TemporaryFiles:delete	(Ljava/nio/file/Path;)Z
    //   72: pop
    //   73: aload_2
    //   74: athrow
    //   75: return
    // Line number table:
    //   Java source line #206	-> byte code offset #0
    //   Java source line #207	-> byte code offset #7
    //   Java source line #208	-> byte code offset #18
    //   Java source line #210	-> byte code offset #45
    //   Java source line #211	-> byte code offset #57
    //   Java source line #210	-> byte code offset #60
    //   Java source line #211	-> byte code offset #73
    //   Java source line #212	-> byte code offset #75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	MultipartUploadOutputStream
    //   17	19	1	md5Hash	byte[]
    //   60	14	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	45	60	finally
  }
  
  private MultiPartUploadFuture createMultiPartUploadFuture(long partSize, MultipartUploadCallable multipartUploadCallable, int partNum)
  {
    ListenableFuture<PartETag> future = exec.submit(multipartUploadCallable);
    FutureCallback<PartETag> futureCallBack = new MultipartUploadFutureCallBack(future, partNum);
    Futures.addCallback(future, futureCallBack, exec);
    
    MultiPartUploadFuture multiPartUploadFuture = new MultiPartUploadFuture(partSize, future, multipartUploadCallable);
    DateTime startTime = DateTime.now();
    multiPartUploadFuture.setStartTime(startTime);
    
    return multiPartUploadFuture;
  }
  
  private boolean shouldSpawnNewFuture(MultiPartUploadFuture remFuture)
  {
    long totalTime = 0L;
    int completedFutures = 0;
    for (Map.Entry<Integer, List<MultiPartUploadFuture>> entry : partNumFutureMap.entrySet())
    {
      int partNum = ((Integer)entry.getKey()).intValue();
      if (!incompletePartNums.contains(Integer.valueOf(partNum)))
      {
        MultiPartUploadFuture multipartUploadFuture = (MultiPartUploadFuture)((List)entry.getValue()).get(0);
        if ((multipartUploadFuture.getEndTime() != null) && 
          (multipartUploadFuture.getPartSize() / partSize >= 0.7D))
        {
          totalTime = totalTime + (multipartUploadFuture.getEndTime().getMillis() - multipartUploadFuture.getStartTime().getMillis());
          completedFutures++;
        }
      }
    }
    if (completedFutures == 0) {
      return false;
    }
    double avgCompletionTime = totalTime / completedFutures;
    long timeSinceFutureStarted = DateTime.now().getMillis() - remFuture.getStartTime().getMillis();
    double fractionPartsIncomplete = incompletePartNums.size() / partNumFutureMap.size();
    
    double thresholdTimeForSpawn = (1.0D + fractionPartsIncomplete) * (avgCompletionTime * fractionPartAvgCompletionTime);
    
    LOG.debug("Threshold time before spawn: " + thresholdTimeForSpawn);
    LOG.debug("Time since incomplete future started: " + timeSinceFutureStarted);
    if (timeSinceFutureStarted > thresholdTimeForSpawn)
    {
      LOG.debug("Incomplete future exceeded threshold, will start new one..");
      return true;
    }
    return false;
  }
  
  private void spawnNewFutureIfNeeded(int partNum)
    throws IOException
  {
    List<MultiPartUploadFuture> multiPartUploadFutures = (List)partNumFutureMap.get(Integer.valueOf(partNum));
    LOG.debug("Number of running attempts for: " + partNum + " are: " + multiPartUploadFutures
    
      .size());
    
    MultiPartUploadFuture multiPartUploadFuture = (MultiPartUploadFuture)multiPartUploadFutures.get(multiPartUploadFutures.size() - 1);
    if (shouldSpawnNewFuture(multiPartUploadFuture))
    {
      if (multiPartUploadFutures.size() >= maxPartAttempts)
      {
        LOG.error("Upload attempts for part num: " + partNum + " have already reached max limit of: " + maxPartAttempts + ", will throw exception and fail");
        
        throw new IllegalStateException("Reached max limit of upload attempts for part");
      }
      LOG.debug("Creating new future for partNum: " + partNum);
      
      MultipartUploadCallable multipartUploadCallable = multiPartUploadFuture.getMultiPartUploadCallable();
      
      Path origPartFile = multipartUploadCallable.getPartFilePath();
      Path clonePartPath = SpeculativeUtils.clonePartFileIfNotAlreadyCompleted(temporaryFiles, origPartFile, partNum);
      if (clonePartPath == null) {
        return;
      }
      partCount += 1;
      
      MultipartUploadCallable newMultiPartUploadCallable = new MultipartUploadCallable(multipartUploadCallable.getPartNumber(), clonePartPath, multipartUploadCallable.getMd5sum(), multipartUploadCallable.getMd5hex());
      
      MultiPartUploadFuture newMultipartUploadFuture = createMultiPartUploadFuture(multiPartUploadFuture.getPartSize(), newMultiPartUploadCallable, partNum);
      
      multiPartUploadFutures.add(newMultipartUploadFuture);
    }
  }
  
  private void uploadMultiParts()
    throws ExecutionException, InterruptedException, IOException
  {
    closeAndSchedulePart();
    int partNumbers = partCount;
    while (incompletePartNums.size() != 0)
    {
      int completedFutures = partNumbers - incompletePartNums.size();
      if ((completedFutures > 0) && (completedFutures >= partsCompletedThresholdPercent * partNumbers))
      {
        LOG.debug(completedFutures + " part(s) completed, checking heuristic...");
        Iterator localIterator;
        synchronized (incompletePartNums)
        {
          for (localIterator = incompletePartNums.iterator(); localIterator.hasNext();)
          {
            int partNum = ((Integer)localIterator.next()).intValue();
            spawnNewFutureIfNeeded(partNum);
          }
        }
      }
      if (progressable != null) {
        progressable.progress();
      }
      Thread.sleep(1000L);
    }
    List<PartETag> etags = new ArrayList();
    for (??? = partNumFutureMap.entrySet().iterator(); ((Iterator)???).hasNext();)
    {
      Object entry = (Map.Entry)((Iterator)???).next();
      List<MultiPartUploadFuture> allFutures = (List)((Map.Entry)entry).getValue();
      MultiPartUploadFuture firstFuture = (MultiPartUploadFuture)allFutures.get(0);
      etags.add(firstFuture.getFuture().get());
    }
    uploadPlan.getMultipartDispatcher().complete(getUploadCompletionEvent(etags));
  }
  
  private CompleteMultipartUploadEvent getUploadCompletionEvent(List<PartETag> etags)
  {
    return 
    
      CompleteMultipartUploadEvent.builder().bucket(bucket).key(key).uploadId(uploadId).partETags(etags).totalLength(Long.valueOf(totalLength)).extraUploadMetadata(uploadPlan.getExtraUploadMetadata()).build();
  }
  
  private void uploadSinglePartWithMultipartUpload()
    throws IOException
  {
    ensureMultipartUploadIsInitiated();
    currentOutput.close();
    
    MultipartUploadCallable multipartUploadCallable = new MultipartUploadCallable(partCount, currentPath, currentOutput.getMessageDigest().digest());
    
    PartETag etag = multipartUploadCallable.call();
    List<PartETag> etags = ImmutableList.of(etag);
    uploadPlan.getMultipartDispatcher().complete(getUploadCompletionEvent(etags));
  }
  
  public void close()
    throws IOException
  {
    LOG.info("close closed:" + closed + " " + s3path);
    try
    {
      if (closed) {
        return;
      }
      closing = true;
      if (isMultipartUploadRequired()) {
        doMultiPartUpload();
      } else {
        uploadSinglePart();
      }
    }
    finally
    {
      temporaryDirectories.close();
      closed = true;
    }
  }
  
  private void doMultiPartUpload()
    throws IOException
  {
    try
    {
      if (partCount > 1) {
        uploadMultiParts();
      } else {
        uploadSinglePartWithMultipartUpload();
      }
    }
    catch (Exception e)
    {
      LOG.info("completeMultipartUpload error for key: " + key, e);
      abort();
      throw new IOException("Error closing multipart upload", e);
    }
  }
  
  private boolean isMultipartUploadRequired()
  {
    return (partCount > 1) || (uploadPlan.getConstraint() == UploadConstraint.MULTIPART_UPLOAD);
  }
  
  public void abort()
  {
    LOG.info("abort closed:" + closed + " " + s3path);
    try
    {
      if (closed) {
        return;
      }
      if (multipartUploadInitiated)
      {
        for (Map.Entry<Integer, List<MultiPartUploadFuture>> entry : partNumFutureMap.entrySet())
        {
          List<MultiPartUploadFuture> multiPartUploadFutures = (List)entry.getValue();
          for (MultiPartUploadFuture multipartUploadFuture : multiPartUploadFutures)
          {
            Future<PartETag> future = multipartUploadFuture.getFuture();
            future.cancel(true);
          }
        }
        try
        {
          abortUpload();
        }
        catch (IOException e)
        {
          throw new UncheckedIOException(e);
        }
      }
    }
    finally
    {
      temporaryDirectories.close();
    }
    closed = true;
  }
  
  private void abortUpload()
    throws IOException
  {
    uploadPlan.getMultipartDispatcher().abort(AbortMultipartUploadEvent.builder()
      .bucket(bucket)
      .key(key)
      .uploadId(uploadId)
      .build());
  }
  
  private long capacityLeft()
  {
    return partSize - currentPartSize;
  }
  
  private void openNewPart()
  {
    try
    {
      currentPartSize = 0L;
      partCount += 1;
      currentPath = temporaryFiles.create();
      
      currentOutput = new DigestOutputStream(new BufferedOutputStream(Files.newOutputStream(currentPath, new OpenOption[] { StandardOpenOption.WRITE })), MessageDigest.getInstance("MD5"));
    }
    catch (IOException e)
    {
      throw new RuntimeException("Error creating temporary output stream.", e);
    }
    catch (NoSuchAlgorithmException e)
    {
      throw new RuntimeException("Error creating DigestOutputStream", e);
    }
  }
  
  private void closeAndSchedulePart()
    throws IOException
  {
    ensureMultipartUploadIsInitiated();
    currentOutput.close();
    
    MultipartUploadCallable multipartUploadCallable = new MultipartUploadCallable(partCount, currentPath, currentOutput.getMessageDigest().digest());
    
    incompletePartNums.add(Integer.valueOf(partCount));
    MultiPartUploadFuture multiPartUploadFuture = createMultiPartUploadFuture(Files.size(currentPath), multipartUploadCallable, partCount);
    if (incompletePartNums.contains(Integer.valueOf(partCount)))
    {
      List<MultiPartUploadFuture> multiPartUploadFutures = new ArrayList();
      multiPartUploadFutures.add(multiPartUploadFuture);
      synchronized (partNumFutureMapHandle)
      {
        partNumFutureMap.put(Integer.valueOf(partCount), multiPartUploadFutures);
        
        partNumFutureMapHandle.notify();
      }
    }
    if (!closing) {
      openNewPart();
    }
  }
  
  private void ensureMultipartUploadIsInitiated()
    throws IOException
  {
    if (!multipartUploadInitiated)
    {
      S3ObjectRequestFactory s3ObjectRequestFactory = new S3ObjectRequestFactory(conf, serverSideEncryptionKmsKeyId);
      
      InitiateMultipartUploadRequest request = s3ObjectRequestFactory.newMultipartUploadRequest(bucket, key).withObjectMetadata(metadata);
      
      CannedAccessControlList acl = ConfigurationUtils.getAcl(conf);
      if (acl != null) {
        request.setCannedACL(acl);
      }
      InitiateMultipartUploadResult result = s3.initiateMultipartUpload(request);
      uploadId = result.getUploadId();
      multipartUploadInitiated = true;
    }
  }
  
  private class MultiPartUploadFuture
  {
    private final long partSize;
    private DateTime startTime;
    private DateTime endTime;
    private Future<PartETag> future;
    private MultipartUploadOutputStream.MultipartUploadCallable multipartUploadCallable;
    
    public long getPartSize()
    {
      return partSize;
    }
    
    public DateTime getStartTime()
    {
      return startTime;
    }
    
    public void setStartTime(DateTime startTime)
    {
      this.startTime = startTime;
    }
    
    public DateTime getEndTime()
    {
      return endTime;
    }
    
    public void setEndTime(DateTime endTime)
    {
      this.endTime = endTime;
    }
    
    public Future<PartETag> getFuture()
    {
      return future;
    }
    
    public MultiPartUploadFuture(Future<PartETag> arg3, MultipartUploadOutputStream.MultipartUploadCallable future)
    {
      this.partSize = partSize;
      this.future = future;
      multipartUploadCallable = multiPartUploadCallable;
    }
    
    public MultipartUploadOutputStream.MultipartUploadCallable getMultiPartUploadCallable()
    {
      return multipartUploadCallable;
    }
  }
  
  private class MultipartUploadFutureCallBack
    implements FutureCallback<PartETag>
  {
    private final ListenableFuture<PartETag> future;
    private final int partNum;
    
    public MultipartUploadFutureCallBack(int future)
    {
      this.future = future;
      this.partNum = partNum;
    }
    
    public void onFailure(Throwable arg0)
    {
      if (future.isCancelled())
      {
        MultipartUploadOutputStream.LOG.debug("Multipart Upload for part: " + partNum + " cancelled");
      }
      else
      {
        incompletePartNums.remove(Integer.valueOf(partNum));
        MultipartUploadOutputStream.LOG.debug("Removed " + partNum + " from incomplete partNum set because it failed");
        
        MultipartUploadOutputStream.MultiPartUploadFuture multiPartUploadFuture = new MultipartUploadOutputStream.MultiPartUploadFuture(MultipartUploadOutputStream.this, 0L, future, null);
        List<MultipartUploadOutputStream.MultiPartUploadFuture> newMultipartUploadFutures = new ArrayList();
        
        newMultipartUploadFutures.add(multiPartUploadFuture);
        partNumFutureMap.put(Integer.valueOf(partNum), newMultipartUploadFutures);
        MultipartUploadOutputStream.LOG.debug("Added just the failed future to the list of futures for partNum: " + partNum);
      }
    }
    
    public void onSuccess(PartETag arg0)
    {
      DateTime endTime = DateTime.now();
      synchronized (partNumFutureMapHandle)
      {
        try
        {
          while (partNumFutureMap.get(Integer.valueOf(partNum)) == null) {
            partNumFutureMapHandle.wait();
          }
        }
        catch (InterruptedException e)
        {
          throw new RuntimeException("Thread interrupted in multipart upload future callback's onSuccess", e);
        }
      }
      List<MultipartUploadOutputStream.MultiPartUploadFuture> multiPartUploadFutures = (List)partNumFutureMap.get(Integer.valueOf(partNum));
      MultipartUploadOutputStream.LOG.debug("Total spawned multipart upload futures for partNum: " + partNum + " are: " + multiPartUploadFutures
        .size());
      List<MultipartUploadOutputStream.MultiPartUploadFuture> newMultipartUploadFutures = null;
      for (MultipartUploadOutputStream.MultiPartUploadFuture multiPartUploadFuture : multiPartUploadFutures) {
        if (multiPartUploadFuture.getFuture().isDone())
        {
          multiPartUploadFuture.setEndTime(endTime);
          newMultipartUploadFutures = new ArrayList();
          newMultipartUploadFutures.add(multiPartUploadFuture);
        }
        else
        {
          MultipartUploadOutputStream.LOG.debug("Cancelling future for partNum: " + partNum + " running for: " + 
            (endTime.getMillis() - multiPartUploadFuture.getStartTime().getMillis()) / 1000L + " s");
          multiPartUploadFuture.getFuture().cancel(true);
          
          multiPartUploadFuture.getMultiPartUploadCallable().setShouldCallAbortOnCompletion(true);
        }
      }
      if (newMultipartUploadFutures != null) {
        partNumFutureMap.put(Integer.valueOf(partNum), newMultipartUploadFutures);
      }
      MultipartUploadOutputStream.LOG.debug("Going to remove " + partNum + " from the incomplete part num set");
      incompletePartNums.remove(Integer.valueOf(partNum));
    }
  }
  
  private class MultipartUploadCallable
    implements Callable<PartETag>
  {
    private final int partNumber;
    private final Path partFilePath;
    private final String md5sum;
    private final String md5hex;
    private boolean shouldCallAbortOnCompletion;
    
    public void setShouldCallAbortOnCompletion(boolean shouldCallAbortOnCompletion)
    {
      this.shouldCallAbortOnCompletion = shouldCallAbortOnCompletion;
    }
    
    public String getMd5hex()
    {
      return md5hex;
    }
    
    public int getPartNumber()
    {
      return partNumber;
    }
    
    public Path getPartFilePath()
    {
      return partFilePath;
    }
    
    public String getMd5sum()
    {
      return md5sum;
    }
    
    public MultipartUploadCallable(int partNumber, Path partFilePath, byte[] md5)
    {
      this.partNumber = partNumber;
      this.partFilePath = partFilePath;
      md5sum = encodeBase64String(md5);
      md5hex = new String(Hex.encodeHex(md5));
    }
    
    public MultipartUploadCallable(int partNumber, Path partFilePath, String md5, String md5hex)
    {
      this.partNumber = partNumber;
      this.partFilePath = partFilePath;
      md5sum = md5;
      this.md5hex = md5hex;
    }
    
    private String encodeBase64String(byte[] md5)
    {
      return Base64.encodeBase64String(md5).trim();
    }
    
    /* Error */
    public PartETag call()
      throws IOException
    {
      // Byte code:
      //   0: new 82	com/amazon/ws/emr/hadoop/fs/s3n/ProgressableResettableBufferedFileInputStream
      //   3: dup
      //   4: aload_0
      //   5: getfield 40	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:partFilePath	Ljava/nio/file/Path;
      //   8: invokeinterface 88 1 0
      //   13: aload_0
      //   14: getfield 47	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:this$0	Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;
      //   17: invokestatic 92	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:access$300	(Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;)Lorg/apache/hadoop/util/Progressable;
      //   20: invokespecial 95	com/amazon/ws/emr/hadoop/fs/s3n/ProgressableResettableBufferedFileInputStream:<init>	(Ljava/io/File;Lorg/apache/hadoop/util/Progressable;)V
      //   23: astore_1
      //   24: aconst_null
      //   25: astore_2
      //   26: aload_0
      //   27: getfield 40	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:partFilePath	Ljava/nio/file/Path;
      //   30: invokestatic 101	java/nio/file/Files:size	(Ljava/nio/file/Path;)J
      //   33: lstore_3
      //   34: new 103	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest
      //   37: dup
      //   38: invokespecial 104	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest:<init>	()V
      //   41: aload_0
      //   42: getfield 47	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:this$0	Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;
      //   45: invokestatic 108	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:access$600	(Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;)Ljava/lang/String;
      //   48: invokevirtual 112	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest:withBucketName	(Ljava/lang/String;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest;
      //   51: aload_0
      //   52: getfield 47	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:this$0	Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;
      //   55: invokestatic 115	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:access$500	(Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;)Ljava/lang/String;
      //   58: invokevirtual 118	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest:withKey	(Ljava/lang/String;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest;
      //   61: aload_0
      //   62: getfield 47	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:this$0	Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;
      //   65: invokestatic 121	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:access$400	(Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;)Ljava/lang/String;
      //   68: invokevirtual 124	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest:withUploadId	(Ljava/lang/String;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest;
      //   71: aload_1
      //   72: invokevirtual 128	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest:withInputStream	(Ljava/io/InputStream;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest;
      //   75: aload_0
      //   76: getfield 36	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:partNumber	I
      //   79: invokevirtual 132	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest:withPartNumber	(I)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest;
      //   82: lload_3
      //   83: invokevirtual 136	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest:withPartSize	(J)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest;
      //   86: aload_0
      //   87: getfield 43	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:md5sum	Ljava/lang/String;
      //   90: invokevirtual 139	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest:withMD5Digest	(Ljava/lang/String;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartRequest;
      //   93: astore 5
      //   95: invokestatic 145	java/lang/System:currentTimeMillis	()J
      //   98: lstore 6
      //   100: aload_0
      //   101: getfield 47	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:this$0	Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;
      //   104: invokestatic 149	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:access$700	(Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;)Lcom/amazon/ws/emr/hadoop/fs/s3/lite/AmazonS3Lite;
      //   107: aload 5
      //   109: invokeinterface 155 2 0
      //   114: astore 8
      //   116: invokestatic 145	java/lang/System:currentTimeMillis	()J
      //   119: lload 6
      //   121: lsub
      //   122: lstore 9
      //   124: getstatic 159	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:LOG	Lorg/slf4j/Logger;
      //   127: ldc -95
      //   129: bipush 7
      //   131: anewarray 5	java/lang/Object
      //   134: dup
      //   135: iconst_0
      //   136: aload_0
      //   137: getfield 36	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:partNumber	I
      //   140: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   143: aastore
      //   144: dup
      //   145: iconst_1
      //   146: aload_0
      //   147: getfield 47	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:this$0	Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;
      //   150: invokestatic 170	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:access$800	(Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;)Ljava/lang/String;
      //   153: aastore
      //   154: dup
      //   155: iconst_2
      //   156: aload_0
      //   157: getfield 40	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:partFilePath	Ljava/nio/file/Path;
      //   160: aastore
      //   161: dup
      //   162: iconst_3
      //   163: lload_3
      //   164: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   167: aastore
      //   168: dup
      //   169: iconst_4
      //   170: lload 9
      //   172: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   175: aastore
      //   176: dup
      //   177: iconst_5
      //   178: aload_0
      //   179: getfield 43	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:md5sum	Ljava/lang/String;
      //   182: aastore
      //   183: dup
      //   184: bipush 6
      //   186: aload_0
      //   187: getfield 32	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:md5hex	Ljava/lang/String;
      //   190: aastore
      //   191: invokeinterface 181 3 0
      //   196: aload_0
      //   197: getfield 47	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:this$0	Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;
      //   200: invokestatic 185	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:access$900	(Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;)Z
      //   203: ifeq +17 -> 220
      //   206: aload_0
      //   207: getfield 26	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:shouldCallAbortOnCompletion	Z
      //   210: ifeq +10 -> 220
      //   213: aload_0
      //   214: getfield 47	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:this$0	Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;
      //   217: invokestatic 189	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:access$1000	(Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;)V
      //   220: aload 8
      //   222: invokevirtual 196	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/UploadPartResult:getPartETag	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/model/PartETag;
      //   225: astore 11
      //   227: aload_1
      //   228: ifnull +29 -> 257
      //   231: aload_2
      //   232: ifnull +21 -> 253
      //   235: aload_1
      //   236: invokevirtual 199	java/io/InputStream:close	()V
      //   239: goto +18 -> 257
      //   242: astore 12
      //   244: aload_2
      //   245: aload 12
      //   247: invokevirtual 205	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   250: goto +7 -> 257
      //   253: aload_1
      //   254: invokevirtual 199	java/io/InputStream:close	()V
      //   257: aload_0
      //   258: getfield 47	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:this$0	Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;
      //   261: invokestatic 209	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:access$1100	(Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;)Lcom/amazon/ws/emr/hadoop/fs/files/TemporaryFiles;
      //   264: aload_0
      //   265: getfield 40	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:partFilePath	Ljava/nio/file/Path;
      //   268: invokevirtual 215	com/amazon/ws/emr/hadoop/fs/files/TemporaryFiles:delete	(Ljava/nio/file/Path;)Z
      //   271: pop
      //   272: aload 11
      //   274: areturn
      //   275: astore 13
      //   277: aload 13
      //   279: astore_2
      //   280: aload 13
      //   282: athrow
      //   283: astore 14
      //   285: aload_1
      //   286: ifnull +29 -> 315
      //   289: aload_2
      //   290: ifnull +21 -> 311
      //   293: aload_1
      //   294: invokevirtual 199	java/io/InputStream:close	()V
      //   297: goto +18 -> 315
      //   300: astore 15
      //   302: aload_2
      //   303: aload 15
      //   305: invokevirtual 205	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   308: goto +7 -> 315
      //   311: aload_1
      //   312: invokevirtual 199	java/io/InputStream:close	()V
      //   315: aload 14
      //   317: athrow
      //   318: astore 16
      //   320: aload_0
      //   321: getfield 47	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:this$0	Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;
      //   324: invokestatic 209	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream:access$1100	(Lcom/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream;)Lcom/amazon/ws/emr/hadoop/fs/files/TemporaryFiles;
      //   327: aload_0
      //   328: getfield 40	com/amazon/ws/emr/hadoop/fs/s3n/MultipartUploadOutputStream$MultipartUploadCallable:partFilePath	Ljava/nio/file/Path;
      //   331: invokevirtual 215	com/amazon/ws/emr/hadoop/fs/files/TemporaryFiles:delete	(Ljava/nio/file/Path;)Z
      //   334: pop
      //   335: aload 16
      //   337: athrow
      // Line number table:
      //   Java source line #715	-> byte code offset #0
      //   Java source line #716	-> byte code offset #26
      //   Java source line #717	-> byte code offset #34
      //   Java source line #718	-> byte code offset #72
      //   Java source line #720	-> byte code offset #95
      //   Java source line #721	-> byte code offset #100
      //   Java source line #722	-> byte code offset #116
      //   Java source line #724	-> byte code offset #124
      //   Java source line #725	-> byte code offset #140
      //   Java source line #724	-> byte code offset #191
      //   Java source line #730	-> byte code offset #196
      //   Java source line #731	-> byte code offset #213
      //   Java source line #733	-> byte code offset #220
      //   Java source line #734	-> byte code offset #227
      //   Java source line #735	-> byte code offset #257
      //   Java source line #733	-> byte code offset #272
      //   Java source line #715	-> byte code offset #275
      //   Java source line #734	-> byte code offset #283
      //   Java source line #735	-> byte code offset #318
      //   Java source line #736	-> byte code offset #335
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	338	0	this	MultipartUploadCallable
      //   23	289	1	is	java.io.InputStream
      //   25	278	2	localThrowable3	Throwable
      //   33	131	3	fileSize	long
      //   93	15	5	request	com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest
      //   98	22	6	start	long
      //   114	107	8	result	com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult
      //   122	49	9	uploadTimeMs	long
      //   225	48	11	localPartETag	PartETag
      //   242	4	12	localThrowable	Throwable
      //   275	6	13	localThrowable1	Throwable
      //   283	33	14	localObject1	Object
      //   300	4	15	localThrowable2	Throwable
      //   318	18	16	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   235	239	242	java/lang/Throwable
      //   26	227	275	java/lang/Throwable
      //   26	227	283	finally
      //   275	285	283	finally
      //   293	297	300	java/lang/Throwable
      //   0	257	318	finally
      //   275	320	318	finally
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.MultipartUploadOutputStream
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */