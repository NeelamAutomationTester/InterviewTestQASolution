import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CostAnalysis {

    @JsonProperty("YearId")
    private String YearId;

    @JsonProperty("GeoRegionId")
    private int GeoRegionId;

    @JsonProperty("CountryId")
    private int CountryId;

    @JsonProperty("RegionId")
    private int RegionId;

    @JsonProperty("SchemeId")
    private int SchemeId;   

    @JsonProperty("SchmTypeId")
    private int SchmTypeId;
    
    @JsonProperty("Cost")
    private BigDecimal Cost;


    public void setYearId(String yearId) {
        this.YearId = yearId;
    }
    public void setGeoRegionId(int geoRegionId) {
        this.GeoRegionId = geoRegionId;
    }
    public void setCountryId(int countryId) {
        this.CountryId = countryId;
    }
    public void setRegionId(int regionId) {
        this.RegionId = regionId;
    }
    public void setSchemeId(int schemeId) {
        this.SchemeId = schemeId;
    }
    public void setSchmTypeId(int schmTypeId) {
        this.SchmTypeId = schmTypeId;
    }
    public void setCost(BigDecimal cost) {
        this.Cost = cost;
    }
    public String getYearId() {
        return YearId;
    }
    public int getGeoRegionId() {
        return GeoRegionId;
    }
    public int getCountryId() {
        return CountryId;
    }
    public int getRegionId() {
        return RegionId;
    }
    public int getSchemeId() {
        return SchemeId;
    }
    public int getSchmTypeId() {
        return SchmTypeId;
    }
    public BigDecimal getCost() {
        return Cost;
    }

    @Override
    public String toString() {
        return "CostAnalysis{" +
                "YearId='" + getYearId() + '\'' +
                ", GeoRegionId=" + getGeoRegionId() +
                ", CountryId=" + getCountryId() +
                ", RegionId=" + getRegionId() +
                ", SchemeId=" + getSchemeId() +
                ", SchmTypeId=" + getSchmTypeId() +
                ", Cost=" + getCost() +
                '}';
    }


}
