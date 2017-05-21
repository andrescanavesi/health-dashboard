package com.example.health.dashboard.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Andres Canavesi
 */
public class Analysis {

    private Long id;
    private AnalysisType analysisType;
    private Double result;
    private Date date;

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public AnalysisType getAnalysisType() {
        return analysisType;
    }

    /**
     *
     * @param analysisType
     */
    public void setAnalysisType(AnalysisType analysisType) {
        this.analysisType = analysisType;
    }

    /**
     *
     * @return
     */
    public Double getResult() {
        return result;
    }

    /**
     *
     * @param result
     */
    public void setResult(Double result) {
        this.result = result;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @param dateAsString as yyyy/MM/dd
     */
    public void setDateByString(String dateAsString) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            date = dateFormat.parse(dateAsString);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     *
     * @return
     */
    public String getDateAsString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(date);
    }

}
