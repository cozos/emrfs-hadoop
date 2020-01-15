package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.BitSet;

public final class CharsToNameCanonicalizer
{
  public static final int HASH_MULT = 33;
  protected static final int DEFAULT_T_SIZE = 64;
  protected static final int MAX_T_SIZE = 65536;
  static final int MAX_ENTRIES_FOR_REUSE = 12000;
  static final int MAX_COLL_CHAIN_LENGTH = 100;
  static final CharsToNameCanonicalizer sBootstrapSymbolTable = new CharsToNameCanonicalizer();
  protected CharsToNameCanonicalizer _parent;
  private final int _hashSeed;
  protected final int _flags;
  protected boolean _canonicalize;
  protected String[] _symbols;
  protected Bucket[] _buckets;
  protected int _size;
  protected int _sizeThreshold;
  protected int _indexMask;
  protected int _longestCollisionList;
  protected boolean _dirty;
  protected BitSet _overflows;
  
  public static CharsToNameCanonicalizer createRoot()
  {
    long now = System.currentTimeMillis();
    
    int seed = (int)now + (int)(now >>> 32) | 0x1;
    return createRoot(seed);
  }
  
  protected static CharsToNameCanonicalizer createRoot(int hashSeed)
  {
    return sBootstrapSymbolTable.makeOrphan(hashSeed);
  }
  
  private CharsToNameCanonicalizer()
  {
    _canonicalize = true;
    _flags = -1;
    
    _dirty = true;
    _hashSeed = 0;
    _longestCollisionList = 0;
    initTables(64);
  }
  
  private void initTables(int initialSize)
  {
    _symbols = new String[initialSize];
    _buckets = new Bucket[initialSize >> 1];
    
    _indexMask = (initialSize - 1);
    _size = 0;
    _longestCollisionList = 0;
    
    _sizeThreshold = _thresholdSize(initialSize);
  }
  
  private static int _thresholdSize(int hashAreaSize)
  {
    return hashAreaSize - (hashAreaSize >> 2);
  }
  
  private CharsToNameCanonicalizer(CharsToNameCanonicalizer parent, int flags, String[] symbols, Bucket[] buckets, int size, int hashSeed, int longestColl)
  {
    _parent = parent;
    
    _flags = flags;
    _canonicalize = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(flags);
    
    _symbols = symbols;
    _buckets = buckets;
    _size = size;
    _hashSeed = hashSeed;
    
    int arrayLen = symbols.length;
    _sizeThreshold = _thresholdSize(arrayLen);
    _indexMask = (arrayLen - 1);
    _longestCollisionList = longestColl;
    
    _dirty = false;
  }
  
  public CharsToNameCanonicalizer makeChild(int flags)
  {
    String[] symbols;
    Bucket[] buckets;
    int size;
    int hashSeed;
    int longestCollisionList;
    synchronized (this)
    {
      symbols = _symbols;
      buckets = _buckets;
      size = _size;
      hashSeed = _hashSeed;
      longestCollisionList = _longestCollisionList;
    }
    return new CharsToNameCanonicalizer(this, flags, symbols, buckets, size, hashSeed, longestCollisionList);
  }
  
  private CharsToNameCanonicalizer makeOrphan(int seed)
  {
    return new CharsToNameCanonicalizer(null, -1, _symbols, _buckets, _size, seed, _longestCollisionList);
  }
  
  private void mergeChild(CharsToNameCanonicalizer child)
  {
    if (child.size() > 12000)
    {
      synchronized (this)
      {
        initTables(256);
        
        _dirty = false;
      }
    }
    else
    {
      if (child.size() <= size()) {
        return;
      }
      synchronized (this)
      {
        _symbols = _symbols;
        _buckets = _buckets;
        _size = _size;
        _sizeThreshold = _sizeThreshold;
        _indexMask = _indexMask;
        _longestCollisionList = _longestCollisionList;
        
        _dirty = false;
      }
    }
  }
  
  public void release()
  {
    if (!maybeDirty()) {
      return;
    }
    if ((_parent != null) && (_canonicalize))
    {
      _parent.mergeChild(this);
      
      _dirty = false;
    }
  }
  
  public int size()
  {
    return _size;
  }
  
  public int bucketCount()
  {
    return _symbols.length;
  }
  
  public boolean maybeDirty()
  {
    return _dirty;
  }
  
  public int hashSeed()
  {
    return _hashSeed;
  }
  
  public int collisionCount()
  {
    int count = 0;
    for (Bucket bucket : _buckets) {
      if (bucket != null) {
        count += length;
      }
    }
    return count;
  }
  
  public int maxCollisionLength()
  {
    return _longestCollisionList;
  }
  
  public String findSymbol(char[] buffer, int start, int len, int h)
  {
    if (len < 1) {
      return "";
    }
    if (!_canonicalize) {
      return new String(buffer, start, len);
    }
    int index = _hashToIndex(h);
    String sym = _symbols[index];
    if (sym != null)
    {
      if (sym.length() == len)
      {
        int i = 0;
        while (sym.charAt(i) == buffer[(start + i)])
        {
          i++;
          if (i == len) {
            return sym;
          }
        }
      }
      Bucket b = _buckets[(index >> 1)];
      if (b != null)
      {
        sym = b.has(buffer, start, len);
        if (sym != null) {
          return sym;
        }
        sym = _findSymbol2(buffer, start, len, next);
        if (sym != null) {
          return sym;
        }
      }
    }
    return _addSymbol(buffer, start, len, h, index);
  }
  
  private String _findSymbol2(char[] buffer, int start, int len, Bucket b)
  {
    while (b != null)
    {
      String sym = b.has(buffer, start, len);
      if (sym != null) {
        return sym;
      }
      b = next;
    }
    return null;
  }
  
  private String _addSymbol(char[] buffer, int start, int len, int h, int index)
  {
    if (!_dirty)
    {
      copyArrays();
      _dirty = true;
    }
    else if (_size >= _sizeThreshold)
    {
      rehash();
      
      index = _hashToIndex(calcHash(buffer, start, len));
    }
    String newSymbol = new String(buffer, start, len);
    if (JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(_flags)) {
      newSymbol = InternCache.instance.intern(newSymbol);
    }
    _size += 1;
    if (_symbols[index] == null)
    {
      _symbols[index] = newSymbol;
    }
    else
    {
      int bix = index >> 1;
      Bucket newB = new Bucket(newSymbol, _buckets[bix]);
      int collLen = length;
      if (collLen > 100)
      {
        _handleSpillOverflow(bix, newB);
      }
      else
      {
        _buckets[bix] = newB;
        _longestCollisionList = Math.max(collLen, _longestCollisionList);
      }
    }
    return newSymbol;
  }
  
  private void _handleSpillOverflow(int bindex, Bucket newBucket)
  {
    if (_overflows == null)
    {
      _overflows = new BitSet();
      _overflows.set(bindex);
    }
    else if (_overflows.get(bindex))
    {
      if (JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(_flags)) {
        reportTooManyCollisions(100);
      }
      _canonicalize = false;
    }
    else
    {
      _overflows.set(bindex);
    }
    _symbols[(bindex + bindex)] = symbol;
    _buckets[bindex] = null;
    
    _size -= length;
    
    _longestCollisionList = -1;
  }
  
  public int _hashToIndex(int rawHash)
  {
    rawHash += (rawHash >>> 15);
    rawHash ^= rawHash << 7;
    rawHash += (rawHash >>> 3);
    return rawHash & _indexMask;
  }
  
  public int calcHash(char[] buffer, int start, int len)
  {
    int hash = _hashSeed;
    int i = start;
    for (int end = start + len; i < end; i++) {
      hash = hash * 33 + buffer[i];
    }
    return hash == 0 ? 1 : hash;
  }
  
  public int calcHash(String key)
  {
    int len = key.length();
    
    int hash = _hashSeed;
    for (int i = 0; i < len; i++) {
      hash = hash * 33 + key.charAt(i);
    }
    return hash == 0 ? 1 : hash;
  }
  
  private void copyArrays()
  {
    String[] oldSyms = _symbols;
    _symbols = ((String[])Arrays.copyOf(oldSyms, oldSyms.length));
    Bucket[] oldBuckets = _buckets;
    _buckets = ((Bucket[])Arrays.copyOf(oldBuckets, oldBuckets.length));
  }
  
  private void rehash()
  {
    int size = _symbols.length;
    int newSize = size + size;
    if (newSize > 65536)
    {
      _size = 0;
      _canonicalize = false;
      
      _symbols = new String[64];
      _buckets = new Bucket[32];
      _indexMask = 63;
      _dirty = true;
      return;
    }
    String[] oldSyms = _symbols;
    Bucket[] oldBuckets = _buckets;
    _symbols = new String[newSize];
    _buckets = new Bucket[newSize >> 1];
    
    _indexMask = (newSize - 1);
    _sizeThreshold = _thresholdSize(newSize);
    
    int count = 0;
    
    int maxColl = 0;
    for (int i = 0; i < size; i++)
    {
      String symbol = oldSyms[i];
      if (symbol != null)
      {
        count++;
        int index = _hashToIndex(calcHash(symbol));
        if (_symbols[index] == null)
        {
          _symbols[index] = symbol;
        }
        else
        {
          int bix = index >> 1;
          Bucket newB = new Bucket(symbol, _buckets[bix]);
          _buckets[bix] = newB;
          maxColl = Math.max(maxColl, length);
        }
      }
    }
    size >>= 1;
    for (int i = 0; i < size; i++)
    {
      Bucket b = oldBuckets[i];
      while (b != null)
      {
        count++;
        String symbol = symbol;
        int index = _hashToIndex(calcHash(symbol));
        if (_symbols[index] == null)
        {
          _symbols[index] = symbol;
        }
        else
        {
          int bix = index >> 1;
          Bucket newB = new Bucket(symbol, _buckets[bix]);
          _buckets[bix] = newB;
          maxColl = Math.max(maxColl, length);
        }
        b = next;
      }
    }
    _longestCollisionList = maxColl;
    _overflows = null;
    if (count != _size) {
      throw new Error("Internal error on SymbolTable.rehash(): had " + _size + " entries; now have " + count + ".");
    }
  }
  
  protected void reportTooManyCollisions(int maxLen)
  {
    throw new IllegalStateException("Longest collision chain in symbol table (of size " + _size + ") now exceeds maximum, " + maxLen + " -- suspect a DoS attack based on hash collisions");
  }
  
  static final class Bucket
  {
    public final String symbol;
    public final Bucket next;
    public final int length;
    
    public Bucket(String s, Bucket n)
    {
      symbol = s;
      next = n;
      length = (n == null ? 1 : length + 1);
    }
    
    public String has(char[] buf, int start, int len)
    {
      if (symbol.length() != len) {
        return null;
      }
      int i = 0;
      do
      {
        if (symbol.charAt(i) != buf[(start + i)]) {
          return null;
        }
        i++;
      } while (i < len);
      return symbol;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */