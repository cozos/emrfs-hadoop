package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

final class XpathUtils$1
  implements ErrorHandler
{
  public void warning(SAXParseException e)
    throws SAXException
  {
    if (XpathUtils.access$000().isDebugEnabled()) {
      XpathUtils.access$000().debug("xml parse warning: " + e.getMessage(), e);
    }
  }
  
  public void fatalError(SAXParseException e)
    throws SAXException
  {
    throw e;
  }
  
  public void error(SAXParseException e)
    throws SAXException
  {
    if (XpathUtils.access$000().isDebugEnabled()) {
      XpathUtils.access$000().debug("xml parse error: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XpathUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */