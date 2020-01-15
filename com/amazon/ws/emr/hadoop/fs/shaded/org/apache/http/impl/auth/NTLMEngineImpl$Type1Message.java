package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import java.util.Locale;

class NTLMEngineImpl$Type1Message
  extends NTLMEngineImpl.NTLMMessage
{
  private final byte[] hostBytes;
  private final byte[] domainBytes;
  private final int flags;
  
  NTLMEngineImpl$Type1Message(String domain, String host)
    throws NTLMEngineException
  {
    this(domain, host, null);
  }
  
  NTLMEngineImpl$Type1Message(String domain, String host, Integer flags)
    throws NTLMEngineException
  {
    this.flags = (flags == null ? getDefaultFlags() : flags.intValue());
    
    String unqualifiedHost = NTLMEngineImpl.access$2200(host);
    
    String unqualifiedDomain = NTLMEngineImpl.access$2300(domain);
    
    hostBytes = (unqualifiedHost != null ? unqualifiedHost.getBytes(NTLMEngineImpl.access$2400()) : null);
    
    domainBytes = (unqualifiedDomain != null ? unqualifiedDomain.toUpperCase(Locale.ROOT).getBytes(NTLMEngineImpl.access$2400()) : null);
  }
  
  NTLMEngineImpl$Type1Message()
  {
    hostBytes = null;
    domainBytes = null;
    flags = getDefaultFlags();
  }
  
  private int getDefaultFlags()
  {
    return -1576500735;
  }
  
  protected void buildMessage()
  {
    int domainBytesLength = 0;
    if (domainBytes != null) {
      domainBytesLength = domainBytes.length;
    }
    int hostBytesLength = 0;
    if (hostBytes != null) {
      hostBytesLength = hostBytes.length;
    }
    int finalLength = 40 + hostBytesLength + domainBytesLength;
    
    prepareResponse(finalLength, 1);
    
    addULong(flags);
    
    addUShort(domainBytesLength);
    addUShort(domainBytesLength);
    
    addULong(hostBytesLength + 32 + 8);
    
    addUShort(hostBytesLength);
    addUShort(hostBytesLength);
    
    addULong(40);
    
    addUShort(261);
    
    addULong(2600);
    
    addUShort(3840);
    if (hostBytes != null) {
      addBytes(hostBytes);
    }
    if (domainBytes != null) {
      addBytes(domainBytes);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.NTLMEngineImpl.Type1Message
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */