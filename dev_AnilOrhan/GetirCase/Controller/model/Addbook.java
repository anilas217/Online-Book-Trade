package dev_AnilOrhan.GetirCase.Controller.model;

public class Addbook {

    private String Bookname;
    private String AuthorName;
    private Integer BookStock;
    private Integer BookPrice;

    public Addbook(String bookname, String authorName, Integer bookStock, Integer bookPrice) {
        Bookname = bookname;
        AuthorName = authorName;
        BookStock = bookStock;
        BookPrice = bookPrice;
    }

    public String getBookname() {
        return Bookname;
    }

    public void setBookname(String bookname) {
        Bookname = bookname;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public Integer getBookStock() {
        return BookStock;
    }

    public void setBookStock(Integer bookStock) {
        BookStock = bookStock;
    }

    public Integer getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        BookPrice = bookPrice;
    }
}
