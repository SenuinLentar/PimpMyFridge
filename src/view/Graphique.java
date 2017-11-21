package view;

import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graphique extends JFrame {

	private XYSeries temperature, humidite;
	private XYSeriesCollection graphique;

	public Graphique() {
		initUI();
	}

	private void initUI() {

		XYDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		add(chartPanel);
		pack();
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(Graphique.HIDE_ON_CLOSE);
	}

	private XYDataset createDataset() {

		temperature = new XYSeries("temperature (°C)");
		
		temperature.add(1, 17);
		temperature.add(2, 14);
		temperature.add(3, 13);
		temperature.add(4, 15);
		temperature.add(5, 14);
		temperature.add(6, 10);

		humidite = new XYSeries("humidité");
		
		humidite.add(1, 24.3);
		humidite.add(2, 22.2);
		humidite.add(3, 21.9);
		humidite.add(4, 25.9);
		humidite.add(5, 19.9);
		humidite.add(6, 23.7);

		graphique = new XYSeriesCollection();
		
		graphique.addSeries(temperature);
		graphique.addSeries(humidite);

		return graphique;
	}
	
	public void fillDataSet(XYSeries temperature, XYSeries humidite) {
		
	}

	private JFreeChart createChart(final XYDataset dataset) {

		JFreeChart chart = ChartFactory.createXYLineChart("Courbe température et humidité", "temps (en minutes)", "",
				dataset, PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		renderer.setSeriesPaint(1, Color.BLUE);
		renderer.setSeriesStroke(1, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(false);
		plot.setDomainGridlinesVisible(false);

		// Grille fond du graphique.
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
		chart.getLegend().setFrame(BlockBorder.NONE);
		return chart;
	}

}
