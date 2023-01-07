package dev_AnilOrhan.GetirCase.Controller.Entity;

import javax.persistence.*;

@Entity
@Table(name="BOOK_DB")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

  private  String TaxNumer;
    private String CompanyName;
    private String BookName;
    private String AuthorName;
    private Integer Stock;
    private Integer Price;

    public Book(String taxNumer, String companyName, String bookName, String authorName, Integer stock, Integer price) {
        TaxNumer = taxNumer;
        CompanyName = companyName;
        BookName = bookName;
        AuthorName = authorName;
        Stock = stock;
        Price = price;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxNumer() {
        return TaxNumer;
    }

    public void setTaxNumer(String taxNumer) {
        TaxNumer = taxNumer;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer stock) {
        Stock = stock;
    }
}
