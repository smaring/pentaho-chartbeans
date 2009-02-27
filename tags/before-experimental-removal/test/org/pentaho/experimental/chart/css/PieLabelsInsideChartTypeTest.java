package org.pentaho.experimental.chart.css;

import junit.framework.TestCase;
import org.pentaho.experimental.chart.ChartBoot;
import org.pentaho.experimental.chart.ChartDocumentContext;
import org.pentaho.experimental.chart.ChartFactory;
import org.pentaho.experimental.chart.core.ChartDocument;
import org.pentaho.experimental.chart.core.ChartElement;
import org.pentaho.experimental.chart.css.keys.ChartStyleKeys;
import org.pentaho.experimental.chart.css.styles.ChartItemLabelVisibleType;
import org.pentaho.reporting.libraries.css.dom.LayoutStyle;
import org.pentaho.reporting.libraries.css.values.CSSConstant;

public class PieLabelsInsideChartTypeTest extends TestCase {

  @Override
  protected void setUp() throws Exception {
    super.setUp();

    // Boot the charting library - required for parsing configuration
    ChartBoot.getInstance().start();
  }

  public void testPieLabelInsideChartType() throws Exception {
    final ChartDocumentContext cdc = ChartFactory.generateChart(getClass().getResource("PieLabelInsideChartTypeTest.xml")); //$NON-NLS-1$
    final ChartDocument cd = cdc.getChartDocument();
    assertNotNull(cd);
    final ChartElement element = cd.getRootElement();
    assertNotNull(element);

    final CSSConstant[] passValues = new CSSConstant[] {
      ChartItemLabelVisibleType.VISIBLE,
      ChartItemLabelVisibleType.HIDDEN,
      ChartItemLabelVisibleType.HIDDEN,
      ChartItemLabelVisibleType.HIDDEN,
      ChartItemLabelVisibleType.HIDDEN,
    };


    int counter = 0;
    final int lenArray = passValues.length;
    ChartElement child = element.getFirstChildItem();

    while(child != null) {
      final LayoutStyle layoutStyle = child.getLayoutStyle();
      assertNotNull(layoutStyle);
      System.out.println("Expected: "+passValues[counter]+" - Got: "+layoutStyle.getValue(ChartStyleKeys.PIE_LABELS_INSIDE_CHART)); //$NON-NLS-1$ //$NON-NLS-2$
      assertEquals(passValues[counter++], layoutStyle.getValue(ChartStyleKeys.PIE_LABELS_INSIDE_CHART));
      child = child.getNextItem();
    }

    if (counter < lenArray-1) {
      throw new IllegalStateException("Not all tests covered!");  //$NON-NLS-1$
    }
  }
}