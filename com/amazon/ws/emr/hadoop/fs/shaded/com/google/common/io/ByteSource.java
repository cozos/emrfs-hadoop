package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Ascii;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Funnels;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.HashCode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.HashFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Hasher;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Iterator;

public abstract class ByteSource
{
  private static final int BUF_SIZE = 4096;
  
  public CharSource asCharSource(Charset charset)
  {
    return new AsCharSource(charset, null);
  }
  
  public abstract InputStream openStream()
    throws IOException;
  
  public InputStream openBufferedStream()
    throws IOException
  {
    InputStream in = openStream();
    return (in instanceof BufferedInputStream) ? (BufferedInputStream)in : new BufferedInputStream(in);
  }
  
  public ByteSource slice(long offset, long length)
  {
    return new SlicedByteSource(offset, length, null);
  }
  
  public boolean isEmpty()
    throws IOException
  {
    Closer closer = Closer.create();
    try
    {
      InputStream in = (InputStream)closer.register(openStream());
      return in.read() == -1;
    }
    catch (Throwable e)
    {
      throw closer.rethrow(e);
    }
    finally
    {
      closer.close();
    }
  }
  
  public long size()
    throws IOException
  {
    Closer closer = Closer.create();
    long l;
    try
    {
      InputStream in = (InputStream)closer.register(openStream());
      return countBySkipping(in);
    }
    catch (IOException e) {}finally
    {
      closer.close();
    }
    closer = Closer.create();
    try
    {
      InputStream in = (InputStream)closer.register(openStream());
      return countByReading(in);
    }
    catch (Throwable e)
    {
      throw closer.rethrow(e);
    }
    finally
    {
      closer.close();
    }
  }
  
  private long countBySkipping(InputStream in)
    throws IOException
  {
    long count = 0L;
    for (;;)
    {
      long skipped = in.skip(Math.min(in.available(), Integer.MAX_VALUE));
      if (skipped <= 0L)
      {
        if (in.read() == -1) {
          return count;
        }
        if ((count == 0L) && (in.available() == 0)) {
          throw new IOException();
        }
        count += 1L;
      }
      else
      {
        count += skipped;
      }
    }
  }
  
  private static final byte[] countBuffer = new byte['က'];
  
  private long countByReading(InputStream in)
    throws IOException
  {
    long count = 0L;
    long read;
    while ((read = in.read(countBuffer)) != -1L) {
      count += read;
    }
    return count;
  }
  
  public long copyTo(OutputStream output)
    throws IOException
  {
    Preconditions.checkNotNull(output);
    
    Closer closer = Closer.create();
    try
    {
      InputStream in = (InputStream)closer.register(openStream());
      return ByteStreams.copy(in, output);
    }
    catch (Throwable e)
    {
      throw closer.rethrow(e);
    }
    finally
    {
      closer.close();
    }
  }
  
  public long copyTo(ByteSink sink)
    throws IOException
  {
    Preconditions.checkNotNull(sink);
    
    Closer closer = Closer.create();
    try
    {
      InputStream in = (InputStream)closer.register(openStream());
      OutputStream out = (OutputStream)closer.register(sink.openStream());
      return ByteStreams.copy(in, out);
    }
    catch (Throwable e)
    {
      throw closer.rethrow(e);
    }
    finally
    {
      closer.close();
    }
  }
  
  public byte[] read()
    throws IOException
  {
    Closer closer = Closer.create();
    try
    {
      InputStream in = (InputStream)closer.register(openStream());
      return ByteStreams.toByteArray(in);
    }
    catch (Throwable e)
    {
      throw closer.rethrow(e);
    }
    finally
    {
      closer.close();
    }
  }
  
  @Beta
  public <T> T read(ByteProcessor<T> processor)
    throws IOException
  {
    Preconditions.checkNotNull(processor);
    
    Closer closer = Closer.create();
    try
    {
      InputStream in = (InputStream)closer.register(openStream());
      return (T)ByteStreams.readBytes(in, processor);
    }
    catch (Throwable e)
    {
      throw closer.rethrow(e);
    }
    finally
    {
      closer.close();
    }
  }
  
  public HashCode hash(HashFunction hashFunction)
    throws IOException
  {
    Hasher hasher = hashFunction.newHasher();
    copyTo(Funnels.asOutputStream(hasher));
    return hasher.hash();
  }
  
  /* Error */
  public boolean contentEquals(ByteSource other)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 135	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: sipush 4096
    //   8: newarray <illegal type>
    //   10: astore_2
    //   11: sipush 4096
    //   14: newarray <illegal type>
    //   16: astore_3
    //   17: invokestatic 74	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/io/Closer:create	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/io/Closer;
    //   20: astore 4
    //   22: aload 4
    //   24: aload_0
    //   25: invokevirtual 47	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/io/ByteSource:openStream	()Ljava/io/InputStream;
    //   28: invokevirtual 78	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/io/Closer:register	(Ljava/io/Closeable;)Ljava/io/Closeable;
    //   31: checkcast 51	java/io/InputStream
    //   34: astore 5
    //   36: aload 4
    //   38: aload_1
    //   39: invokevirtual 47	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/io/ByteSource:openStream	()Ljava/io/InputStream;
    //   42: invokevirtual 78	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/io/Closer:register	(Ljava/io/Closeable;)Ljava/io/Closeable;
    //   45: checkcast 51	java/io/InputStream
    //   48: astore 6
    //   50: aload 5
    //   52: aload_2
    //   53: iconst_0
    //   54: sipush 4096
    //   57: invokestatic 201	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/io/ByteStreams:read	(Ljava/io/InputStream;[BII)I
    //   60: istore 7
    //   62: aload 6
    //   64: aload_3
    //   65: iconst_0
    //   66: sipush 4096
    //   69: invokestatic 201	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/io/ByteStreams:read	(Ljava/io/InputStream;[BII)I
    //   72: istore 8
    //   74: iload 7
    //   76: iload 8
    //   78: if_icmpne +11 -> 89
    //   81: aload_2
    //   82: aload_3
    //   83: invokestatic 207	java/util/Arrays:equals	([B[B)Z
    //   86: ifne +14 -> 100
    //   89: iconst_0
    //   90: istore 9
    //   92: aload 4
    //   94: invokevirtual 85	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/io/Closer:close	()V
    //   97: iload 9
    //   99: ireturn
    //   100: iload 7
    //   102: sipush 4096
    //   105: if_icmpeq +14 -> 119
    //   108: iconst_1
    //   109: istore 9
    //   111: aload 4
    //   113: invokevirtual 85	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/io/Closer:close	()V
    //   116: iload 9
    //   118: ireturn
    //   119: goto -69 -> 50
    //   122: astore 5
    //   124: aload 4
    //   126: aload 5
    //   128: invokevirtual 89	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/io/Closer:rethrow	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   131: athrow
    //   132: astore 10
    //   134: aload 4
    //   136: invokevirtual 85	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/io/Closer:close	()V
    //   139: aload 10
    //   141: athrow
    // Line number table:
    //   Java source line #309	-> byte code offset #0
    //   Java source line #311	-> byte code offset #5
    //   Java source line #312	-> byte code offset #11
    //   Java source line #314	-> byte code offset #17
    //   Java source line #316	-> byte code offset #22
    //   Java source line #317	-> byte code offset #36
    //   Java source line #319	-> byte code offset #50
    //   Java source line #320	-> byte code offset #62
    //   Java source line #321	-> byte code offset #74
    //   Java source line #322	-> byte code offset #89
    //   Java source line #330	-> byte code offset #92
    //   Java source line #323	-> byte code offset #100
    //   Java source line #324	-> byte code offset #108
    //   Java source line #330	-> byte code offset #111
    //   Java source line #326	-> byte code offset #119
    //   Java source line #327	-> byte code offset #122
    //   Java source line #328	-> byte code offset #124
    //   Java source line #330	-> byte code offset #132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	ByteSource
    //   0	142	1	other	ByteSource
    //   10	72	2	buf1	byte[]
    //   16	67	3	buf2	byte[]
    //   20	115	4	closer	Closer
    //   34	17	5	in1	InputStream
    //   122	5	5	e	Throwable
    //   48	15	6	in2	InputStream
    //   60	41	7	read1	int
    //   72	5	8	read2	int
    //   90	27	9	bool	boolean
    //   132	8	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	92	122	java/lang/Throwable
    //   100	111	122	java/lang/Throwable
    //   119	122	122	java/lang/Throwable
    //   22	92	132	finally
    //   100	111	132	finally
    //   119	134	132	finally
  }
  
  public static ByteSource concat(Iterable<? extends ByteSource> sources)
  {
    return new ConcatenatedByteSource(sources);
  }
  
  public static ByteSource concat(Iterator<? extends ByteSource> sources)
  {
    return concat(ImmutableList.copyOf(sources));
  }
  
  public static ByteSource concat(ByteSource... sources)
  {
    return concat(ImmutableList.copyOf(sources));
  }
  
  public static ByteSource wrap(byte[] b)
  {
    return new ByteArrayByteSource(b);
  }
  
  public static ByteSource empty()
  {
    return EmptyByteSource.INSTANCE;
  }
  
  private final class AsCharSource
    extends CharSource
  {
    private final Charset charset;
    
    private AsCharSource(Charset charset)
    {
      this.charset = ((Charset)Preconditions.checkNotNull(charset));
    }
    
    public Reader openStream()
      throws IOException
    {
      return new InputStreamReader(openStream(), charset);
    }
    
    public String toString()
    {
      String str1 = String.valueOf(String.valueOf(ByteSource.this.toString()));String str2 = String.valueOf(String.valueOf(charset));return 15 + str1.length() + str2.length() + str1 + ".asCharSource(" + str2 + ")";
    }
  }
  
  private final class SlicedByteSource
    extends ByteSource
  {
    private final long offset;
    private final long length;
    
    private SlicedByteSource(long offset, long length)
    {
      Preconditions.checkArgument(offset >= 0L, "offset (%s) may not be negative", new Object[] { Long.valueOf(offset) });
      Preconditions.checkArgument(length >= 0L, "length (%s) may not be negative", new Object[] { Long.valueOf(length) });
      this.offset = offset;
      this.length = length;
    }
    
    public InputStream openStream()
      throws IOException
    {
      return sliceStream(ByteSource.this.openStream());
    }
    
    public InputStream openBufferedStream()
      throws IOException
    {
      return sliceStream(ByteSource.this.openBufferedStream());
    }
    
    private InputStream sliceStream(InputStream in)
      throws IOException
    {
      if (offset > 0L) {
        try
        {
          ByteStreams.skipFully(in, offset);
        }
        catch (Throwable e)
        {
          Closer closer = Closer.create();
          closer.register(in);
          try
          {
            throw closer.rethrow(e);
          }
          finally
          {
            closer.close();
          }
        }
      }
      return ByteStreams.limit(in, length);
    }
    
    public ByteSource slice(long offset, long length)
    {
      Preconditions.checkArgument(offset >= 0L, "offset (%s) may not be negative", new Object[] { Long.valueOf(offset) });
      Preconditions.checkArgument(length >= 0L, "length (%s) may not be negative", new Object[] { Long.valueOf(length) });
      long maxLength = this.length - offset;
      return ByteSource.this.slice(this.offset + offset, Math.min(length, maxLength));
    }
    
    public boolean isEmpty()
      throws IOException
    {
      return (length == 0L) || (super.isEmpty());
    }
    
    public String toString()
    {
      String str = String.valueOf(String.valueOf(ByteSource.this.toString()));long l1 = offset;long l2 = length;return 50 + str.length() + str + ".slice(" + l1 + ", " + l2 + ")";
    }
  }
  
  private static class ByteArrayByteSource
    extends ByteSource
  {
    protected final byte[] bytes;
    
    protected ByteArrayByteSource(byte[] bytes)
    {
      this.bytes = ((byte[])Preconditions.checkNotNull(bytes));
    }
    
    public InputStream openStream()
    {
      return new ByteArrayInputStream(bytes);
    }
    
    public InputStream openBufferedStream()
      throws IOException
    {
      return openStream();
    }
    
    public boolean isEmpty()
    {
      return bytes.length == 0;
    }
    
    public long size()
    {
      return bytes.length;
    }
    
    public byte[] read()
    {
      return (byte[])bytes.clone();
    }
    
    public long copyTo(OutputStream output)
      throws IOException
    {
      output.write(bytes);
      return bytes.length;
    }
    
    public <T> T read(ByteProcessor<T> processor)
      throws IOException
    {
      processor.processBytes(bytes, 0, bytes.length);
      return (T)processor.getResult();
    }
    
    public HashCode hash(HashFunction hashFunction)
      throws IOException
    {
      return hashFunction.hashBytes(bytes);
    }
    
    public String toString()
    {
      String str = String.valueOf(String.valueOf(Ascii.truncate(BaseEncoding.base16().encode(bytes), 30, "...")));return 17 + str.length() + "ByteSource.wrap(" + str + ")";
    }
  }
  
  private static final class EmptyByteSource
    extends ByteSource.ByteArrayByteSource
  {
    private static final EmptyByteSource INSTANCE = new EmptyByteSource();
    
    private EmptyByteSource()
    {
      super();
    }
    
    public CharSource asCharSource(Charset charset)
    {
      Preconditions.checkNotNull(charset);
      return CharSource.empty();
    }
    
    public byte[] read()
    {
      return bytes;
    }
    
    public String toString()
    {
      return "ByteSource.empty()";
    }
  }
  
  private static final class ConcatenatedByteSource
    extends ByteSource
  {
    private final Iterable<? extends ByteSource> sources;
    
    ConcatenatedByteSource(Iterable<? extends ByteSource> sources)
    {
      this.sources = ((Iterable)Preconditions.checkNotNull(sources));
    }
    
    public InputStream openStream()
      throws IOException
    {
      return new MultiInputStream(sources.iterator());
    }
    
    public boolean isEmpty()
      throws IOException
    {
      for (ByteSource source : sources) {
        if (!source.isEmpty()) {
          return false;
        }
      }
      return true;
    }
    
    public long size()
      throws IOException
    {
      long result = 0L;
      for (ByteSource source : sources) {
        result += source.size();
      }
      return result;
    }
    
    public String toString()
    {
      String str = String.valueOf(String.valueOf(sources));return 19 + str.length() + "ByteSource.concat(" + str + ")";
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.ByteSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */