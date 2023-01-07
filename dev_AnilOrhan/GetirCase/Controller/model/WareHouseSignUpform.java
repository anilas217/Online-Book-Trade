package dev_AnilOrhan.GetirCase.Controller.model;

public class WareHouseSignUpform {
    private String CompanyName;
    private String VergiNo;

    public WareHouseSignUpform(String companyName, String vergiNo) {
        CompanyName = companyName;
        VergiNo = vergiNo;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getVergiNo() {
        return VergiNo;
    }

    public void setVergiNo(String vergiNo) {
        VergiNo = vergiNo;
    }
}
