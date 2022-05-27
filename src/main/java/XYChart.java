import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;


public class XYChart extends JFrame {

    private JFreeChart xyChart;
    private XYSeriesCollection dataset;

    public XYChart(){
        super("График");
        dataset = new XYSeriesCollection();
    }
    public void createChart(String name, int width, int height,
                            String xAxisName, String yAxisName){
        xyChart = ChartFactory.createXYLineChart(
                name,
                xAxisName,
                yAxisName,
                dataset,
                PlotOrientation.VERTICAL,
                true , true,false);

        // Настройка XYSplineRenderer
        // Precision: the number of line segments between 2 points [default: 5]

        XYSplineRenderer r0 = new XYSplineRenderer();
        r0.setSeriesShapesVisible (0, false);
        xyChart.getXYPlot().setRenderer(0, r0);

        ChartPanel chartPanel = new ChartPanel(xyChart);
        chartPanel.setPreferredSize(new java.awt.Dimension( width , height ));
        setContentPane(chartPanel);
    }

    public void addInXYDataset(XYSeries legend) {
        dataset.addSeries(legend);
    }



}
