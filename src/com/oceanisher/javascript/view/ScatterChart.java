package com.oceanisher.javascript.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.HashMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;

public class ScatterChart {


	public static JFreeChart jfreeChart;
	
	public ScatterChart(){

	}
	
	public static JFreeChart initChart(){
		
		
		jfreeChart = ChartFactory.createScatterPlot("Energy Scatter Plot", "Line", "Energy Consumption(10*-5J)", null);
		jfreeChart.setBackgroundPaint(Color.white);
		jfreeChart.setBorderPaint(Color.green);
		jfreeChart.setBorderStroke(new BasicStroke(1.5f));
		
		
		return jfreeChart;
	}
	
	public static JFreeChart initChart2(){
		
		//散点
		DefaultXYDataset dataset = new DefaultXYDataset();
		double[][] datas = new double[2][MainView.list.size()];
		
		
		for(int i = 0 ; i < MainView.list.size() ; i++){
			datas[1][i] = Double.parseDouble(MainView.list.get(i).split(",")[2]);
		}
		
		for(int i = 0 ; i < MainView.list.size() ; i++){
			datas[0][i] = Double.parseDouble(MainView.list.get(i).split(",")[0]);
		}
		
		dataset.addSeries("Hotspot", datas);
		
		jfreeChart = ChartFactory.createScatterPlot("Energy Scatter Plot", "Line", "Energy Consumption(10*-5J)", dataset);
		jfreeChart.setBackgroundPaint(Color.white);
		jfreeChart.setBorderPaint(Color.green);
		jfreeChart.setBorderStroke(new BasicStroke(1.5f));
		
		return jfreeChart;
	}
	

}
