package medianAlgorithms;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.geom.Ellipse2D;

/**
 * @author Luke Reynolds
 * @version 1.0
 * @email lreynolds188@gmail.com
 * @website lukereynolds.net
 * @github https://github.com/lreynolds188
 */
public class Plot extends ApplicationFrame {

    /**
     * Plots a graph using the sent parameters with the JFreeChart library.
     *
     * @param appTitle
     * @param title
     * @param xAxisLabel
     * @param yAxisLabel
     * @param dataset
     */
    public Plot(String appTitle, String title, String xAxisLabel, String yAxisLabel, DefaultCategoryDataset dataset) {
        super(appTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                title,
                xAxisLabel,yAxisLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,true,false);

        CategoryPlot plot = (CategoryPlot) lineChart.getPlot();
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);
        renderer.setSeriesShape(0, new Ellipse2D.Double(-3d, -3d, 6d, 6d));

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 1280 , 800 ) );
        setContentPane( chartPanel );
    }
}
