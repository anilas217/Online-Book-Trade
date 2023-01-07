package dev_AnilOrhan.GetirCase.Controller;

import dev_AnilOrhan.GetirCase.Controller.Entity.Book;
import dev_AnilOrhan.GetirCase.Controller.Entity.WareHouse;
import dev_AnilOrhan.GetirCase.Controller.UserRepository.BookRep;
import dev_AnilOrhan.GetirCase.Controller.UserRepository.WarehouseRep;
import dev_AnilOrhan.GetirCase.Controller.model.UserLoginForm;
import dev_AnilOrhan.GetirCase.Controller.model.Addbook;
import dev_AnilOrhan.GetirCase.Controller.model.WareHouseLoginForm;
import dev_AnilOrhan.GetirCase.Controller.model.WareHouseSignUpform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WareHouseLoginSignupController {

    String WareHouseTaxNum;
    @Autowired
    private WarehouseRep warehouseRep;


    @Autowired
    private BookRep bookRep;

    @GetMapping(value = "/WarehouseSignUp")
    String getWareHouseSignup(WareHouseSignUpform wareHouseSignUpform){


        System.out.println(wareHouseSignUpform.getCompanyName());
        System.out.println(wareHouseSignUpform.getVergiNo());

        return "WarehouseSignUp";
    }

    @GetMapping(value = "/WareHouseLogin")
    String getWareHouseLogin(UserLoginForm userLoginForm){
        return "WareHouseLogin";
    }

    @PostMapping(value = "/WarehouseSignUp")
    ModelAndView WarehouseSignUp(WareHouseSignUpform wareHouseSignUpform,Model theModel){
        WareHouse wareHouse=new WareHouse();
        if(wareHouseSignUpform.getCompanyName().isEmpty() || wareHouseSignUpform.getVergiNo().isEmpty()){
            System.out.println("Please fill empty area");
            ModelAndView model = new ModelAndView("/WarehouseSignUp");
            return model;
        }
        else{
            boolean CheckPoint=true;
            Iterable<WareHouse> ware=warehouseRep.findAll();
            List<WareHouse> list = Streamable.of(ware).toList();
            for(int i=0;i<list.size();i++) {
                WareHouse Warehouse=list.get(i);
                if(Warehouse.getCompanyName().contentEquals(wareHouseSignUpform.getCompanyName()) ||
                Warehouse.getTaxNumber().contentEquals(wareHouseSignUpform.getVergiNo())
                ){
                    CheckPoint=false;
                      System.out.println("This Company is already exist");
                }
            }
            if(CheckPoint==true){
                wareHouse.setCompanyName(wareHouseSignUpform.getCompanyName());
                wareHouse.setTaxNumber(wareHouseSignUpform.getVergiNo());
                ModelAndView model = new ModelAndView("/WareHouseUI");
                model.addObject("VergiNo", wareHouseSignUpform.getVergiNo());
System.out.println("Access Approved");
WareHouseTaxNum=wareHouseSignUpform.getVergiNo();
                warehouseRep.save(wareHouse);
                return model;
            }
            else {
                ModelAndView model = new ModelAndView("/WarehouseSignUp");
                return model;
            }
        }
    }

    @PostMapping(value = "/WareHouseLogin")
    String WarehouseLogin(WareHouseLoginForm wareHouseLoginForm, Model theModel){
        if(wareHouseLoginForm.getVergiNo().isEmpty()){
            System.out.println("Please fill empty field");
            return "WareHouseLogin";
        }
        else{
            boolean CheckPoint=false;
            Iterable<WareHouse> us=warehouseRep.findAll();
            List<WareHouse> list = Streamable.of(us).toList();
            for(int i=0;i<list.size();i++) {
                WareHouse wareHouse=list.get(i);

                if(wareHouse.getTaxNumber().contentEquals(wareHouseLoginForm.getVergiNo())){
                    CheckPoint=true;
                }
            }
            if(CheckPoint==true){
                System.out.println("System access");
                theModel.addAttribute("VergiNo", wareHouseLoginForm.getVergiNo());
                WareHouseTaxNum=wareHouseLoginForm.getVergiNo();
         //       new WareHouseController(wareHouseLoginForm.getVergiNo());
                return "WareHouseUI";
            }
            else{
                System.out.println("System not find company");
                return "WareHouseLogin";
            }
        }

    }

    @RequestMapping(value = "/WareHouseUI")
    public String getBook(Addbook addbook){
        Book book=new Book();
        if(addbook.getBookname().isEmpty() || addbook.getAuthorName().isEmpty()){
            System.out.println("Please fill empty field");
            return "WareHouseUI";
        }
        else{
            book.setBookName(addbook.getBookname());
            book.setAuthorName(addbook.getAuthorName());
            book.setStock(addbook.getBookStock());
            book.setPrice(addbook.getBookPrice());
            if(addbook.getBookStock()<1){
                System.out.println("Stock is not less than 1");
                return "WareHouseUI";
            }
            else if(addbook.getBookPrice()<1){
                System.out.println("Stock is not less than 1");
                return "WareHouseUI";

            }
            else{
                Iterable<WareHouse> us=warehouseRep.findAll();
                List<WareHouse> list = Streamable.of(us).toList();
                for(int i=0;i<list.size();i++){
                    WareHouse war=list.get(i);
                    if(war.getTaxNumber().contentEquals(WareHouseTaxNum)){
                        book.setTaxNumer(WareHouseTaxNum);
                        book.setCompanyName(war.getCompanyName());
                        bookRep.save(book);

                    }
                }
                return "WareHouseUI";
            }
        }



    }





}
