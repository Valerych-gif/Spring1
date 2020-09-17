public class CompanyRow {
    private String companyName;
    private String daughterCompanyName;
    private double daughterCompanyForecast;
    private double daughterCompanyResult;

    public CompanyRow(String companyName, String daughterCompanyName, double daughterCompanyForecast, double daughterCompanyResult) {
        this.companyName = companyName;
        this.daughterCompanyName = daughterCompanyName;
        this.daughterCompanyForecast = daughterCompanyForecast;
        this.daughterCompanyResult = daughterCompanyResult;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDaughterCompanyName() {
        return daughterCompanyName;
    }

    public double getDaughterCompanyForecast() {
        return daughterCompanyForecast;
    }

    public double getDaughterCompanyResult() {
        return daughterCompanyResult;
    }
}
