package khang;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class height {
	public static ArrayList<Double> standard = new ArrayList<Double>();
	private static DefaultCategoryDataset createDataset(List<Integer> chieu_cao) {           // táº¡o phÆ°Æ¡ng thá»©c createDataset de luu du lieu bieu do tang truong 
                                                                      // kinh te vao doi tuong DefaultCategoryDataset

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        // addValue(Number, Comparable, Comparable)
    	standard.add((double) 49);
    	standard.add((double) 53);
    	standard.add((double) 57);
    	standard.add((double) 59);
    	standard.add((double) 62);
    	standard.add((double) 64);
    	standard.add((double) 66);
    	standard.add((double) 67);
    	standard.add((double) 68);
    	standard.add((double) 70);
    	standard.add(71.5);
    	standard.add(72.5);
    	standard.add((double) 74);
        
        for(int i=0; i < chieu_cao.size(); i++) {
            if(i < standard.size()) dataset.addValue(standard.get(i),"standard",""+i);
        	dataset.addValue(chieu_cao.get(i), "client", ""+i);
        }
        return dataset;

    }
	


	// createLineChart(String, String, String, CategoryDataset, PlotOrientation, boolean, boolean, boolean)
	
    public static JFreeChart createLineChart(List<Integer> chieu_cao) {            // tao phuong thuc createLineChart de tao JFreeChart

        JFreeChart lineChart = ChartFactory.createLineChart(

                "Biểu đồ tăng trưởng theo chiều cao cho trẻ".toUpperCase(), // ten cua bieu do

                "Độ tuổi (Tháng)",    // tru.c Ox
                
                "Chiều cao (cm)",     // tru.c Oy
                
                createDataset(chieu_cao),

                PlotOrientation.VERTICAL, true, false, false);      // boolean      legend(standard , client)   tooltips    urls
        lineChart.getTitle().setPaint(Color.blue);  
        
        CategoryPlot p = lineChart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.red);        // ... ngang
        p.setDomainGridlinesVisible(true);
        p.setDomainGridlinePaint(Color.black);     // ... doc
        CategoryItemRenderer renderer =  p.getRenderer();
        renderer.setSeriesPaint(1, Color.red);
        renderer.setSeriesPaint(0, Color.green);
        // luu anh ra thu muc. 
        /*
        try {
			ChartUtilities.saveChartAsJPEG(new File("C:\\Users\\Admin\\eclipse-workspace\\ProjectOOP\\DuLieu\\height.JPEG"), lineChart, 900, 600);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error in chart generation! "+ e);
		}
		*/

        return lineChart;

    }
}