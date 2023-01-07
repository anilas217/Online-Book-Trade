package dev_AnilOrhan.GetirCase.Controller.Entity;

import javax.persistence.*;

@Entity
@Table(name="WAREHOUSE_DB")
public class WareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String CompanyName;
    private String TaxNumber;

    public WareHouse() {

    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getTaxNumber() {
        return TaxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        TaxNumber = taxNumber;
    }

    public WareHouse(Long id, String companyName, String taxNumber) {
        this.id = id;
        CompanyName = companyName;
        TaxNumber = taxNumber;
    }
}
