package dev_AnilOrhan.GetirCase.Controller;

import dev_AnilOrhan.GetirCase.Controller.Entity.User;
import dev_AnilOrhan.GetirCase.Controller.UserRepository.BookRep;
import dev_AnilOrhan.GetirCase.Controller.UserRepository.UserRep;
import dev_AnilOrhan.GetirCase.Controller.model.SignupForm;
import dev_AnilOrhan.GetirCase.Controller.model.UserLoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class UserSignUpLoginController {
    @Autowired
    private UserRep userRep;


    @Autowired
    private BookRep bookRep;

    @GetMapping(value = "/CustomerUI")
    public ModelAndView getAllEmployees() {
        System.out.println("Buuuuuuu");
        ModelAndView mav = new ModelAndView("list-Book");
        mav.addObject("Book", bookRep.findAll());
        return mav;
    }
    public UserSignUpLoginController() {
    }

    @GetMapping(value = "/Main")
    String getMainPage(){
        return "Main";
    }
    @GetMapping(value = "/CustomerSignUp")
    String getSignupPage(){
        return "CustomerSignUp";
    }


    @GetMapping(value = "/CustomerLogin")
    String getCustomerLoginPage(){
        return "CustomerLogin";
    }


    @PostMapping(path = "/CustomerLogin")
    String LoginUser(UserLoginForm userLoginForm){
        if(userLoginForm.getEmail().isEmpty() || userLoginForm.getPassword().isEmpty()){    //Check field is empty or not
            System.out.println("Something is empty");
            return "CustomerLogin";
        }
        else{
            boolean CheckPoint=false;
            Iterable<User> us=userRep.findAll();
            List<User> list = Streamable.of(us).toList();
            for(int i=0;i<list.size();i++) {
                User user1=list.get(i);
                String usermail=userLoginForm.getEmail();
                String userpassword=userLoginForm.getPassword();
                if(usermail.contentEquals(user1.getEmailId()) && userpassword.contentEquals(user1.getPassword())){
                     CheckPoint=true;
                }
            }
            if(CheckPoint==true){                  //Access true
                return "CustomerUI";
            }
            else {
                System.out.println("User can not find");
                return "CustomerLogin";
            }
        }



        }



   @PostMapping(path = "/CustomerSignUp")
    String submitSignUp(SignupForm signupForm){
       boolean flag=true;
      User user=new User();
      if(signupForm.getPassword().isEmpty()||signupForm.getEmail().isEmpty()||signupForm.getFirstName().isEmpty()
      ||signupForm.getLastName().isEmpty()
      ) {
          System.out.println("Something is empty");
          return "CustomerSignUp";
      }
      else{                                               //Control state for check same email or not
          Iterable<User> us=userRep.findAll();
          List<User> list = Streamable.of(us).toList();
          for(int i=0;i<list.size();i++){
              User user1=list.get(i);
              String checkmail=signupForm.getEmail();
              if(checkmail.contentEquals(user1.getEmailId())){
                  flag=false;
              }
          }
          if(flag==true){
              user.setPassword(signupForm.getPassword());
              user.setEmailId(signupForm.getEmail());
              user.setFirstName(signupForm.getFirstName());
              user.setLastName(signupForm.getLastName());
              userRep.save(user);
              return "CustomerUI";
          } else if (flag==false) {
              System.out.println("This mail already Exist");
              return "CustomerSignUp";
          }

       }
           return "CustomerUI";
    }
    @RequestMapping(value = "/Main")
    String submitMain(){
        return "Main";
    }



}
