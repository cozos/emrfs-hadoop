package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.Hex;
import java.nio.file.Path;
import java.util.concurrent.Callable;

class MultipartUploadOutputStream$MultipartUploadCallable
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
  
  public MultipartUploadOutputStream$MultipartUploadCallable(MultipartUploadOutputStream paramMultipartUploadOutputStream, int partNumber, Path partFilePath, byte[] md5)
  {
    this.partNumber = partNumber;
    this.partFilePath = partFilePath;
    md5sum = encodeBase64String(md5);
    md5hex = new String(Hex.encodeHex(md5));
  }
  
  public MultipartUploadOutputStream$MultipartUploadCallable(MultipartUploadOutputStream paramMultipartUploadOutputStream, int partNumber, Path partFilePath, String md5, String md5hex)
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
    throws java.io.IOException
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.MultipartUploadOutputStream.MultipartUploadCallable
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */