package com.skypedal.skypedal_backend.dto;

public class NewRouteDTO {
    private Integer startId;
    private Integer endId;

    public NewRouteDTO() {
    }

    public NewRouteDTO(Integer startId, Integer endId) {
        this.startId = startId;
        this.endId = endId;
    }

    public Integer getStartId() {
        return startId;
    }

    public void setStartId(Integer startId) {
        this.startId = startId;
    }

    public Integer getEndId() {
        return endId;
    }

    public void setEndId(Integer endId) {
        this.endId = endId;
    }
}
