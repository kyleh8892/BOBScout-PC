/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.gui.graphs;

import bobscout.pc.Team;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author kyleh
 */
public class BarChart{
    
    static ChartPanel chartPanel;
    
    public BarChart (ArrayList<Team> teams){
        CategoryDataset dataset = createDataset(teams);

        JFreeChart chart = createChart(dataset);
        chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);

    }
    
    public static ChartPanel getChartPanel (){
        return chartPanel;
    }
    
    private CategoryDataset createDataset (ArrayList<Team> teams){
        
        var dataset = new DefaultCategoryDataset();
        
        for(Team team : teams){
            team.updateTeamPower();
            dataset.setValue(team.getTeamPower(), "Team Power", team.getTeamName());
        }
        
        return dataset;
    }
    
    private JFreeChart createChart (CategoryDataset dataset){
         JFreeChart barChart = ChartFactory.createBarChart(
                "Ranked Teams by Power",
                "Teams",
                "Power",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);
         
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(0, 0, 204));
        ((BarRenderer) plot.getRenderer()).setBarPainter(new StandardBarPainter());

        return barChart;
    }

}
