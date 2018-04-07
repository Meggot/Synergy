package com.requests;

import com.abstracts.SynergyRequest;

import java.util.Date;

public class ProjectSearchRequest extends SynergyRequest {
    private String searchTitle;
    private Integer searchOwnerId;
    private Date dateFrom;
    private Date dateTo;


    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public Integer getSearchOwnerId() {
        return searchOwnerId;
    }

    public void setSearchOwnerId(Integer searchOwnerId) {
        this.searchOwnerId = searchOwnerId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
