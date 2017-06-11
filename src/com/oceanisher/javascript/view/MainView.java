package com.oceanisher.javascript.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.jfree.chart.ChartPanel;

public class MainView {

	JFrame frame;
	JPanel leftPanel;
	GridBagLayout gridBagLayout;
	GridBagConstraints constraints;
	BorderLayout borderLayout;
	
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JComboBox<String> box1 = new JComboBox<>(new String[]{"Odroid"});
	JComboBox<String> box2 = new JComboBox<>(new String[]{"Google-V8"});
	JTextField field = new JTextField("");
	JButton fileButton = new JButton("选择");
	JTextArea area = new JTextArea(25, 20);
	//开始按钮
	JButton button;
	//图表框
	ChartPanel rightPanel;
	
	static File file;
	
	static int count;
	
	static ArrayList<String> list;
	
	public static void main(String [] args){
		MainView view = new MainView();
		view.frame = new JFrame();
		view.leftPanel = new JPanel();
		view.gridBagLayout = new GridBagLayout();
		view.constraints = new GridBagConstraints();
		view.borderLayout = new BorderLayout(10, 10);
		view.frame.setLayout(view.borderLayout);
		view.leftPanel.setLayout(view.gridBagLayout);
		view.frame.add(view.leftPanel, BorderLayout.WEST);
		//left
		view.label1 = new JLabel("选择平台");
		view.label2 = new JLabel("选择引擎");
		view.label3 = new JLabel("选择脚本");
		view.button = new JButton("Start");
		////label
		view.constraints.gridx = 0;
		view.constraints.gridy = 0;		
		view.constraints.ipadx = 0;
		view.constraints.insets.set(0, 20, 15, 0);
		view.constraints.anchor = GridBagConstraints.WEST;
		view.constraints.gridwidth = 20;
		view.constraints.gridheight = 1;
		view.gridBagLayout.setConstraints(view.label1, view.constraints);
		view.leftPanel.add(view.label1);
		
		view.constraints.gridx = 0;
		view.constraints.gridy = 1;		
		view.constraints.ipadx = 0;
		view.constraints.insets.set(0, 20, 15, 0);
		view.constraints.anchor = GridBagConstraints.WEST;
		view.constraints.gridwidth = 20;
		view.constraints.gridheight = 1;
		view.gridBagLayout.setConstraints(view.label2, view.constraints);
		view.leftPanel.add(view.label2);
		
		view.constraints.gridx = 0;
		view.constraints.gridy = 2;		
		view.constraints.ipadx = 0;
		view.constraints.insets.set(0, 20, 15, 0);
		view.constraints.anchor = GridBagConstraints.WEST;
		view.constraints.gridwidth = 20;
		view.constraints.gridheight = 1;
		view.gridBagLayout.setConstraints(view.label3, view.constraints);
		view.leftPanel.add(view.label3);
		////box
		view.constraints.gridx = 1;
		view.constraints.gridy = 0;		
		view.constraints.ipadx = 180;
		view.constraints.insets.set(-10, 80, 0, 0);
		view.constraints.anchor = GridBagConstraints.WEST;
		view.constraints.gridwidth = 20;
		view.constraints.gridheight = 1;
		view.gridBagLayout.setConstraints(view.box1, view.constraints);
		view.leftPanel.add(view.box1);
		
		view.constraints.gridx = 1;
		view.constraints.gridy = 1;		
		view.constraints.ipadx = 160;
		view.constraints.insets.set(-10, 80, 0, 0);
		view.constraints.anchor = GridBagConstraints.WEST;
		view.constraints.gridwidth = 20;
		view.constraints.gridheight = 1;
		view.gridBagLayout.setConstraints(view.box2, view.constraints);
		view.leftPanel.add(view.box2);
		
		view.constraints.gridx = 1;
		view.constraints.gridy = 2;		
		view.constraints.ipadx = 120;
		view.constraints.insets.set(-10, 80, 0, 0);
		view.constraints.anchor = GridBagConstraints.WEST;
		view.constraints.gridwidth = 10;
		view.constraints.gridheight = 1;
		view.field.setEnabled(false);
		view.gridBagLayout.setConstraints(view.field, view.constraints);
		view.leftPanel.add(view.field);
		
		view.constraints.gridx = 2;
		view.constraints.gridy = 2;		
		view.constraints.ipadx = 7;
		view.constraints.insets.set(-10, 260, 0, 0);
		view.constraints.anchor = GridBagConstraints.WEST;
		view.constraints.gridwidth = 10;
		view.constraints.gridheight = 1;
		view.field.setEnabled(false);
		view.gridBagLayout.setConstraints(view.fileButton, view.constraints);
		view.leftPanel.add(view.fileButton);
		
		////area
		view.constraints.gridx = 1;
		view.constraints.gridy = 3;		
		view.constraints.ipadx = 100;
		view.constraints.insets.set(20, 16, 0, 0);
		view.constraints.anchor = GridBagConstraints.WEST;
		view.constraints.gridwidth = 20;
		view.constraints.gridheight = 1;
		view.gridBagLayout.setConstraints(view.area, view.constraints);
		view.leftPanel.add(view.area);
		
		//right
		view.rightPanel = new ChartPanel(ScatterChart.initChart(), true);
		view.frame.add(view.rightPanel, BorderLayout.EAST);
		
		//frame
		view.frame.setTitle("JavaScript离线能耗热点预测");
		view.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		view.frame.setSize(1050, 600);
		view.frame.setVisible(true);
		
		view.fileButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fd = new JFileChooser();
				fd.showOpenDialog(null);
				file = fd.getSelectedFile();
				if(file.getAbsolutePath().endsWith(".js")){

					MainView.analysis();
					//right
					view.rightPanel = new ChartPanel(ScatterChart.initChart2(), true);
					view.frame.add(view.rightPanel, BorderLayout.EAST);
					
					view.field.setText(MainView.file.getName());
					
					view.show();
					
					view.frame.setVisible(true);
				}
			}
		});
		
	}
	
	public static void analysis(){
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		count = 0;
		list = new ArrayList<>();
		
		try {
			
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			String temp;
			while((temp = br.readLine()) != null){
				
				count ++;
				
				for(String e : Energy.energyMap.keySet()){
					if(temp.contains(e)){
						String temp2 = count + "," + e + "," + Energy.energyMap.get(e);
						list.add(temp2);
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				br.close();
				isr.close();
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	public void show(){
		
		StringBuffer str = new StringBuffer();
		str.append(file.getName() + " 能耗热点预测\n");
		str.append("==>" + box1.getSelectedItem().toString() + "\n");
		str.append("==>" + box2.getSelectedItem().toString() + "\n");
		for(String e : MainView.list){
			str.append("--> line " + Integer.parseInt(e.split(",")[0]) + ", energy " + e.split(",")[2] + "\n");
		}
		
		area.setText(str.toString());
	}
}
