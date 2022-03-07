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

public class weight {
	public static ArrayList<Double> standard = new ArrayList<Double>();
	private static DefaultCategoryDataset createDataset(List<Integer> can_nang) {           // táº¡o phÆ°Æ¡ng thá»©c createDataset de luu du lieu bieu do tang truong 
                                                                      // kinh te vao doi tuong DefaultCategoryDataset

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
    	standard.add(3.0);
    	standard.add(3.9);
    	standard.add(4.7);
    	standard.add(5.3);
    	standard.add(6.0);
    	standard.add(6.7);
    	standard.add(7.2);
    	standard.add(7.7);
    	standard.add(8.2);
    	standard.add(8.5);
    	standard.add(8.8);
    	standard.add(9.0);
    	standard.add(9.2);
    	
        // addValue(Number, Comparable, Comparable)

        for(int i=0; i < can_nang.size(); i++) {
            if(i < standard.size()) dataset.addValue(standard.get(i),"standard",""+i);
        	dataset.addValue(can_nang.get(i), "client", ""+i);
        }
        
        return dataset;

    }
	


	// createLineChart(String, String, String, CategoryDataset, PlotOrientation, boolean, boolean, boolean)
	
    public static JFreeChart createLineChart(List<Integer> can_nang) {            // tao phuong thuc createLineChart de tao JFreeChart

        JFreeChart lineChart = ChartFactory.createLineChart(

                "Biểu đồ tăng trưởng theo cân nặng cho trẻ".toUpperCase(), // ten cua bieu do

                "Độ tuổi (Tháng)",    // tru.c Ox
                
                "Cân nặng (kg)",     // tru.c Oy
                
                createDataset(can_nang),

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
			ChartUtilities.saveChartAsJPEG(new File("C:\\Users\\Admin\\eclipse-workspace\\ProjectOOP\\DuLieu\\weight.JPEG"), lineChart, 900, 600);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error in chart generation! "+ e);
		}
         */
        return lineChart;

    }

}