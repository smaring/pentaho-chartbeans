/*
 * Copyright 2007 Pentaho Corporation.  All rights reserved. 
 * This software was developed by Pentaho Corporation and is provided under the terms 
 * of the Mozilla Public License, Version 1.1, or any later version. You may not use 
 * this file except in compliance with the license. If you need a copy of the license, 
 * please go to http://www.mozilla.org/MPL/MPL-1.1.txt. The Original Code is the Pentaho 
 * BI Platform.  The Initial Developer is Pentaho Corporation.
 *
 * Software distributed under the Mozilla Public License is distributed on an "AS IS" 
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or  implied. Please refer to 
 * the license for the specific language governing your rights and limitations.
 *
 * Created 3/25/2008 
 * @author Ravi Hasija 
 */

package org.pentaho.experimental.chart.css.parser.stylehandler;

import org.pentaho.reporting.libraries.css.model.StyleKey;
import org.pentaho.reporting.libraries.css.parser.CSSValueReadHandler;
import org.pentaho.reporting.libraries.css.values.CSSStringType;
import org.pentaho.reporting.libraries.css.values.CSSStringValue;
import org.pentaho.reporting.libraries.css.values.CSSValue;
import org.w3c.css.sac.LexicalUnit;

/**
 *  The style parser for the <code>-x-pentaho-chart-label-text</code> style.
 * 
 * @author Ravi Hasija
 */
public class ChartLabelTextReadHandler implements CSSValueReadHandler
{
  public ChartLabelTextReadHandler()
  {
  }

  /**
   * Parses the LexicalUnit and returns the CSSValue 
   *
   * @param value
   * @return
   */
  public CSSValue createValue(StyleKey name, LexicalUnit value)
  {
    CSSValue labelText = null;
    
    if (value.getLexicalUnitType() == LexicalUnit.SAC_STRING_VALUE) {
      labelText = new CSSStringValue (CSSStringType.STRING, value.getStringValue());
    } 
    
    return labelText;
  }
}
