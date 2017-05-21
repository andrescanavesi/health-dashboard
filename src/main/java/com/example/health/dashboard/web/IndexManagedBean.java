package com.example.health.dashboard.web;

import com.example.health.dashboard.entities.Analysis;
import com.example.health.dashboard.entities.AnalysisType;
import com.example.health.dashboard.util.CsvDataLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Andres Canavesi
 */
@Named(value = "indexManagedBean")
@ViewScoped
@ManagedBean
public class IndexManagedBean {

    private static final Logger LOG = Logger.getLogger(IndexManagedBean.class.getName());

    private Map<AnalysisType, List<Analysis>> analysisMap = new HashMap<>();
    private List<LineChartModel> lineCharts;

    private String csvContent;
    private Boolean skipFirstLine = Boolean.FALSE;

    /**
     *
     */
    @PostConstruct
    public void init() {

    }

    /**
     *
     * @return
     */
    public List<LineChartModel> getLineCharts() {
        return lineCharts;
    }

    private void createLineCharts() {
        lineCharts = new ArrayList<>();
        for (Map.Entry<AnalysisType, List<Analysis>> entry : analysisMap.entrySet()) {
            AnalysisType key = entry.getKey();
            List<Analysis> value = entry.getValue();
            LineChartModel model = new LineChartModel();
            model.setSeriesColors("036fab,93b75f,cc6666");

            LineChartSeries seriesResult = new LineChartSeries();
            seriesResult.setLabel("Results");
            LineChartSeries seriesMin = new LineChartSeries();
            seriesMin.setLabel("Min");
            LineChartSeries seriesMax = new LineChartSeries();
            seriesMax.setLabel("Max");
            for (Analysis analysis : value) {
                seriesResult.set(analysis.getDateAsString(), analysis.getResult());
                seriesMin.set(analysis.getDateAsString(), analysis.getAnalysisType().getMin());
                seriesMax.set(analysis.getDateAsString(), analysis.getAnalysisType().getMax());
            }

            model.addSeries(seriesResult);
            model.addSeries(seriesMin);
            model.addSeries(seriesMax);

            model.setTitle(key.getName());
            model.setZoom(false);
            model.getAxis(AxisType.Y).setLabel("Results");
            model.setLegendPosition("nw");

            DateAxis axis = new DateAxis("");
            axis.setTickAngle(-50);
            axis.setTickFormat("%b %#d, %y");

            model.getAxes().put(AxisType.X, axis);

            lineCharts.add(model);

        }
    }

    /**
     *
     * @return
     */
    public String getCsvContent() {
        return csvContent;
    }

    /**
     *
     * @param csvContent
     */
    public void setCsvContent(String csvContent) {
        this.csvContent = csvContent;
    }

    /**
     *
     */
    public void processCsv() {
        try {
            CsvDataLoader dataLoader = new CsvDataLoader();
            analysisMap = dataLoader.loadFromString(csvContent, skipFirstLine);
            createLineCharts();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", e.getMessage()));

        }
    }

    /**
     *
     * @return
     */
    public Boolean getSkipFirstLine() {
        return skipFirstLine;
    }

    /**
     *
     * @param skipFirstLine
     */
    public void setSkipFirstLine(Boolean skipFirstLine) {
        this.skipFirstLine = skipFirstLine;
    }

}
