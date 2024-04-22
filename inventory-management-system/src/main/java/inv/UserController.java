package inv;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@Controller
public class UserController
{
    @GetMapping
    public String showLoginForm(){
        return"login";
    }
    @PostMapping("/login")
    public String login(@RequestBody MultiValueMap<String , String>data, HttpServletRequest request){

        Integer userId =Integer.valueOf( data.getFirst("uname"));
        System.out.println("fghjk");
        String password = data.getFirst("password");
        request.getSession();
        System.out.println("username :"+userId+" "+"password :"+password);
        return "home";
    }
    @PostMapping("/add")
    public String showForm(){
        return"new-order";
    }
   @PostMapping("/update")
    public String updatedb(){
        return "update";
    }
    @DeleteMapping("/delete")
    public String dele(){
        return "home";
    }

}
