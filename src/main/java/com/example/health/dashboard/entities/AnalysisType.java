package com.example.health.dashboard.entities;

import java.util.Objects;

/**
 *
 * @author Andres Canavesi
 */
public class AnalysisType {

    private Long id;
    /**
     *
     */
    private String name;
    /**
     * Ex: Hemograma
     */
    private String group;
    /**
     * ml, g, L, etc
     */
    private String units;
    private Double min;
    private Double max;

    /**
     *
     */
    public AnalysisType() {
    }

    /**
     *
     * @param name
     * @param group
     */
    public AnalysisType(String name, String group) {
        this.name = name;
        this.group = group;
    }

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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getGroup() {
        return group;
    }

    /**
     *
     * @param group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     *
     * @return
     */
    public String getUnits() {
        return units;
    }

    /**
     *
     * @param units
     */
    public void setUnits(String units) {
        this.units = units;
    }

    /**
     *
     * @return
     */
    public Double getMin() {
        return min;
    }

    /**
     *
     * @param min
     */
    public void setMin(Double min) {
        this.min = min;
    }

    /**
     *
     * @return
     */
    public Double getMax() {
        return max;
    }

    /**
     *
     * @param max
     */
    public void setMax(Double max) {
        this.max = max;
    }

    /**
     * Two AnalysisType are equals if they have the same name and the same group
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AnalysisType) {
            AnalysisType other = (AnalysisType) obj;
            return other.getName() != null && other.getGroup() != null
                    && name != null && group != null
                    && other.getName().trim().toLowerCase().equals(name.trim().toLowerCase())
                    && other.getGroup().trim().toLowerCase().equals(group.trim().toLowerCase());
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.name);
        hash = 73 * hash + Objects.hashCode(this.group);
        return hash;
    }

}
