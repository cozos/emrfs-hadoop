package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AttributeValueMarshaller;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttributeValue
  implements Serializable, Cloneable, StructuredPojo
{
  private String s;
  private String n;
  private ByteBuffer b;
  private List<String> sS;
  private List<String> nS;
  private List<ByteBuffer> bS;
  private Map<String, AttributeValue> m;
  private List<AttributeValue> l;
  private Boolean nULLValue;
  private Boolean bOOL;
  
  public AttributeValue() {}
  
  public AttributeValue(String s)
  {
    setS(s);
  }
  
  public AttributeValue(List<String> sS)
  {
    setSS(sS);
  }
  
  public void setS(String s)
  {
    this.s = s;
  }
  
  public String getS()
  {
    return s;
  }
  
  public AttributeValue withS(String s)
  {
    setS(s);
    return this;
  }
  
  public void setN(String n)
  {
    this.n = n;
  }
  
  public String getN()
  {
    return n;
  }
  
  public AttributeValue withN(String n)
  {
    setN(n);
    return this;
  }
  
  public void setB(ByteBuffer b)
  {
    this.b = b;
  }
  
  public ByteBuffer getB()
  {
    return b;
  }
  
  public AttributeValue withB(ByteBuffer b)
  {
    setB(b);
    return this;
  }
  
  public List<String> getSS()
  {
    return sS;
  }
  
  public void setSS(Collection<String> sS)
  {
    if (sS == null)
    {
      this.sS = null;
      return;
    }
    this.sS = new ArrayList(sS);
  }
  
  public AttributeValue withSS(String... sS)
  {
    if (this.sS == null) {
      setSS(new ArrayList(sS.length));
    }
    for (String ele : sS) {
      this.sS.add(ele);
    }
    return this;
  }
  
  public AttributeValue withSS(Collection<String> sS)
  {
    setSS(sS);
    return this;
  }
  
  public List<String> getNS()
  {
    return nS;
  }
  
  public void setNS(Collection<String> nS)
  {
    if (nS == null)
    {
      this.nS = null;
      return;
    }
    this.nS = new ArrayList(nS);
  }
  
  public AttributeValue withNS(String... nS)
  {
    if (this.nS == null) {
      setNS(new ArrayList(nS.length));
    }
    for (String ele : nS) {
      this.nS.add(ele);
    }
    return this;
  }
  
  public AttributeValue withNS(Collection<String> nS)
  {
    setNS(nS);
    return this;
  }
  
  public List<ByteBuffer> getBS()
  {
    return bS;
  }
  
  public void setBS(Collection<ByteBuffer> bS)
  {
    if (bS == null)
    {
      this.bS = null;
      return;
    }
    this.bS = new ArrayList(bS);
  }
  
  public AttributeValue withBS(ByteBuffer... bS)
  {
    if (this.bS == null) {
      setBS(new ArrayList(bS.length));
    }
    for (ByteBuffer ele : bS) {
      this.bS.add(ele);
    }
    return this;
  }
  
  public AttributeValue withBS(Collection<ByteBuffer> bS)
  {
    setBS(bS);
    return this;
  }
  
  public Map<String, AttributeValue> getM()
  {
    return m;
  }
  
  public void setM(Map<String, AttributeValue> m)
  {
    this.m = m;
  }
  
  public AttributeValue withM(Map<String, AttributeValue> m)
  {
    setM(m);
    return this;
  }
  
  public AttributeValue addMEntry(String key, AttributeValue value)
  {
    if (null == m) {
      m = new HashMap();
    }
    if (m.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    m.put(key, value);
    return this;
  }
  
  public AttributeValue clearMEntries()
  {
    m = null;
    return this;
  }
  
  public List<AttributeValue> getL()
  {
    return l;
  }
  
  public void setL(Collection<AttributeValue> l)
  {
    if (l == null)
    {
      this.l = null;
      return;
    }
    this.l = new ArrayList(l);
  }
  
  public AttributeValue withL(AttributeValue... l)
  {
    if (this.l == null) {
      setL(new ArrayList(l.length));
    }
    for (AttributeValue ele : l) {
      this.l.add(ele);
    }
    return this;
  }
  
  public AttributeValue withL(Collection<AttributeValue> l)
  {
    setL(l);
    return this;
  }
  
  public void setNULL(Boolean nULLValue)
  {
    this.nULLValue = nULLValue;
  }
  
  public Boolean getNULL()
  {
    return nULLValue;
  }
  
  public AttributeValue withNULL(Boolean nULLValue)
  {
    setNULL(nULLValue);
    return this;
  }
  
  public Boolean isNULL()
  {
    return nULLValue;
  }
  
  public void setBOOL(Boolean bOOL)
  {
    this.bOOL = bOOL;
  }
  
  public Boolean getBOOL()
  {
    return bOOL;
  }
  
  public AttributeValue withBOOL(Boolean bOOL)
  {
    setBOOL(bOOL);
    return this;
  }
  
  public Boolean isBOOL()
  {
    return bOOL;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getS() != null) {
      sb.append("S: ").append(getS()).append(",");
    }
    if (getN() != null) {
      sb.append("N: ").append(getN()).append(",");
    }
    if (getB() != null) {
      sb.append("B: ").append(getB()).append(",");
    }
    if (getSS() != null) {
      sb.append("SS: ").append(getSS()).append(",");
    }
    if (getNS() != null) {
      sb.append("NS: ").append(getNS()).append(",");
    }
    if (getBS() != null) {
      sb.append("BS: ").append(getBS()).append(",");
    }
    if (getM() != null) {
      sb.append("M: ").append(getM()).append(",");
    }
    if (getL() != null) {
      sb.append("L: ").append(getL()).append(",");
    }
    if (getNULL() != null) {
      sb.append("NULL: ").append(getNULL()).append(",");
    }
    if (getBOOL() != null) {
      sb.append("BOOL: ").append(getBOOL());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof AttributeValue)) {
      return false;
    }
    AttributeValue other = (AttributeValue)obj;
    if (((other.getS() == null ? 1 : 0) ^ (getS() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getS() != null) && (!other.getS().equals(getS()))) {
      return false;
    }
    if (((other.getN() == null ? 1 : 0) ^ (getN() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getN() != null) && (!other.getN().equals(getN()))) {
      return false;
    }
    if (((other.getB() == null ? 1 : 0) ^ (getB() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getB() != null) && (!other.getB().equals(getB()))) {
      return false;
    }
    if (((other.getSS() == null ? 1 : 0) ^ (getSS() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSS() != null) && (!other.getSS().equals(getSS()))) {
      return false;
    }
    if (((other.getNS() == null ? 1 : 0) ^ (getNS() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNS() != null) && (!other.getNS().equals(getNS()))) {
      return false;
    }
    if (((other.getBS() == null ? 1 : 0) ^ (getBS() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBS() != null) && (!other.getBS().equals(getBS()))) {
      return false;
    }
    if (((other.getM() == null ? 1 : 0) ^ (getM() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getM() != null) && (!other.getM().equals(getM()))) {
      return false;
    }
    if (((other.getL() == null ? 1 : 0) ^ (getL() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getL() != null) && (!other.getL().equals(getL()))) {
      return false;
    }
    if (((other.getNULL() == null ? 1 : 0) ^ (getNULL() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNULL() != null) && (!other.getNULL().equals(getNULL()))) {
      return false;
    }
    if (((other.getBOOL() == null ? 1 : 0) ^ (getBOOL() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBOOL() != null) && (!other.getBOOL().equals(getBOOL()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getS() == null ? 0 : getS().hashCode());
    hashCode = 31 * hashCode + (getN() == null ? 0 : getN().hashCode());
    hashCode = 31 * hashCode + (getB() == null ? 0 : getB().hashCode());
    hashCode = 31 * hashCode + (getSS() == null ? 0 : getSS().hashCode());
    hashCode = 31 * hashCode + (getNS() == null ? 0 : getNS().hashCode());
    hashCode = 31 * hashCode + (getBS() == null ? 0 : getBS().hashCode());
    hashCode = 31 * hashCode + (getM() == null ? 0 : getM().hashCode());
    hashCode = 31 * hashCode + (getL() == null ? 0 : getL().hashCode());
    hashCode = 31 * hashCode + (getNULL() == null ? 0 : getNULL().hashCode());
    hashCode = 31 * hashCode + (getBOOL() == null ? 0 : getBOOL().hashCode());
    return hashCode;
  }
  
  public AttributeValue clone()
  {
    try
    {
      return (AttributeValue)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    AttributeValueMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */