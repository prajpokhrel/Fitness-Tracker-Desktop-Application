package gui;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import implementation.WeightDB;
import models.Weight;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import database.Connectionfactory;


public class TrendLine {

	private JFrame frmTrendLine;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5;
	private JTextField textField;
	private JLabel lblDay;
	private JLabel label_2;
	private JLabel lblMonth_1;
	private JLabel lblDay_1;
	private Connection connect;
	private JButton btnBack;
	private int ids;

	public TrendLine(int id) {
		ids=id;
		initialize();
		connect=Connectionfactory.getConnection();
	}

	private void initialize() {
		frmTrendLine = new JFrame();
		frmTrendLine.setTitle("Trend Line");
		frmTrendLine.setBounds(450, 100, 580, 430);
		frmTrendLine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrendLine.getContentPane().setLayout(null);
		
		 comboBox_3 = new JComboBox();
		comboBox_3.setBounds(216, 116, 59, 20);
		frmTrendLine.getContentPane().add(comboBox_3);
		for(int i=2018;i<=2027;i++){
			comboBox_3.addItem(i);
		}
		
		 comboBox_4 = new JComboBox();
		comboBox_4.setBounds(278, 116, 57, 20);
		frmTrendLine.getContentPane().add(comboBox_4);
		for(int i=1;i<=12;i++){
			comboBox_4.addItem(i);
		}
		
		 comboBox_5 = new JComboBox();
		comboBox_5.setBounds(338, 116, 57, 20);
		frmTrendLine.getContentPane().add(comboBox_5);
		for(int i=1;i<=31;i++){
			comboBox_5.addItem(i);
		}
		 comboBox = new JComboBox();
		comboBox.setBounds(10, 116, 59, 20);
		frmTrendLine.getContentPane().add(comboBox);
		for(int i=2018;i<=2027;i++){
		comboBox.addItem(i);
		}
					
		 comboBox_1 = new JComboBox();
		comboBox_1.setBounds(72, 116, 59, 20);
		frmTrendLine.getContentPane().add(comboBox_1);
		for(int i=1;i<=12;i++){
			comboBox_1.addItem(i);
		}
	
		 comboBox_2 = new JComboBox();
		comboBox_2.setBounds(134, 116, 59, 20);
		frmTrendLine.getContentPane().add(comboBox_2);
		for(int i=1;i<=31;i++){
			comboBox_2.addItem(i);
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 147, 544, 233);
		frmTrendLine.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("VIEW GRAPH");
		btnNewButton.setBounds(405, 115, 119, 23);		
		frmTrendLine.getContentPane().add(btnNewButton);
		
		JLabel lblYourProgressReport = new JLabel("YOUR PROGRESS REPORT ON CHART");
		lblYourProgressReport.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblYourProgressReport.setBounds(99, 11, 387, 23);
		frmTrendLine.getContentPane().add(lblYourProgressReport);
		
		textField = new JTextField();
		textField.setBounds(3, 11, 86, 20);
		frmTrendLine.getContentPane().add(textField);
		textField.setColumns(10);
		String asdasd=String.valueOf(ids);
		textField.setText(asdasd);
		
		JLabel lblFrom = new JLabel("FROM:");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFrom.setBounds(10, 73, 46, 14);
		frmTrendLine.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("TO:");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTo.setBounds(216, 73, 46, 14);
		frmTrendLine.getContentPane().add(lblTo);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(10, 98, 46, 14);
		frmTrendLine.getContentPane().add(lblYear);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setBounds(72, 98, 46, 14);
		frmTrendLine.getContentPane().add(lblMonth);
		
		lblDay = new JLabel("Day:");
		lblDay.setBounds(134, 98, 46, 14);
		frmTrendLine.getContentPane().add(lblDay);
		
		label_2 = new JLabel("Year:");
		label_2.setBounds(216, 98, 46, 14);
		frmTrendLine.getContentPane().add(label_2);
		
		lblMonth_1 = new JLabel("Month:");
		lblMonth_1.setBounds(278, 98, 46, 14);
		frmTrendLine.getContentPane().add(lblMonth_1);
		
		lblDay_1 = new JLabel("Day:");
		lblDay_1.setBounds(338, 98, 46, 14);
		frmTrendLine.getContentPane().add(lblDay_1);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTrendLine.dispose();
			}
		});
		btnBack.setBounds(485, 11, 69, 23);
		frmTrendLine.getContentPane().add(btnBack);
		frmTrendLine.setVisible(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aa=comboBox.getSelectedItem().toString();
				String bb=comboBox_1.getSelectedItem().toString();
				String cc=comboBox_2.getSelectedItem().toString();
				String dd=comboBox_3.getSelectedItem().toString();
				String ee=comboBox_4.getSelectedItem().toString();
				String ff=comboBox_5.getSelectedItem().toString();
				System.out.println(aa+"-"+bb+"-"+cc);
				Weight wt=new Weight();
				wt.setPeriod1(aa+"-"+bb+"-"+cc);
				wt.setPeriod2(dd+"-"+ee+"-"+ff);
				WeightDB wdb=new WeightDB();
				wdb.getWeight(wt);
				
		        try {
		            String 
		            query="select date,average from weights"
		            + " where Date>='"+wt.getPeriod1()+"' AND Date<='"+wt.getPeriod2()+"' ";
		            JDBCCategoryDataset dataset = new JDBCCategoryDataset(connect,query);
		            JFreeChart chart = ChartFactory.createLineChart("Average Weight Change for period", "Date(Selected Period)","Average Weight", dataset, PlotOrientation.VERTICAL, false, true, true);
		            ChartPanel chartPanel=new ChartPanel(chart);
		            panel.removeAll();
		            panel.add(chartPanel,BorderLayout.CENTER);
		            panel.validate();
		        } catch (SQLException ex) {
		           ex.printStackTrace();
		        }				
			}
		});
	}
}
