package com.codebay.goldeneye.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import com.codebay.goldeneye.models.User;
import com.codebay.goldeneye.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class WebController {  



    // Map of offices(key) and departments(values) for validation.
    private final HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    private final List<String> listMilan =  Arrays.asList("Design", "Business", "Advertising");
    private final List<String> listSpain =  Arrays.asList("Research & development", "Business");
    private final List<String> listNewYork =  Arrays.asList("Business", "Advertising", "Research & development");

    //Lists offices and departments  to show.
    private final List<String> listOffices =  Arrays.asList("Milan", "Spain", "New York");
    private final List<String> listDepartments =  Arrays.asList("Design", "Research & development", "Business", "Advertising");

    private UserService userService = new UserService();
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {

        map.put("Milan", listMilan);
        map.put("Spain", listSpain);
        map.put("New York", listNewYork );


        model.addAttribute("offices", listOffices);
        model.addAttribute("departments", listDepartments);
        model.addAttribute("user", new User());
        
        return "register";
    }
    
    
    @PostMapping("/register")
    public String registerPost(@Valid User user, BindingResult bindingResult, Model model) throws IOException{
        
        //check inputsvalidation Form.
        if (!bindingResult.hasErrors()) {
            
            // call API to delete unappropiated words.
            String response = userService.unappropiatedWords(user);
            if(response == "ERROR"){
                model.addAttribute("APImsg", "unnapropiated words have not been checked"); //Error message.
            }else{

                // passing the String from response to User Class.
                ObjectMapper objectMapper = new ObjectMapper();
                user = objectMapper.readValue(response, User.class);
                model.addAttribute("APImsg", "Cleaned unnapropiated words"); //Information message.
            }
            
            user.generateEmail();  
            
            //checking if the department exists in the selected office.
            if (map.get(user.getOffice()).contains(user.getDepartment())){

                //Checking if the email already exists.
                if (!userService.checkEmail(user.getEmail())){
                    model.addAttribute("notErrors", true); // notErrors variable, to view the user added.
                }else{
                    model.addAttribute("msg", "User Already exists"); //Error message.
                }
            }else{
                model.addAttribute("msg", "The office in " + user.getOffice() + "  not have a " + user.getDepartment() + " deparment"); //Error message.
                
            }
            
            
        }

        model.addAttribute("offices", listOffices);
        model.addAttribute("departments", listDepartments);
        model.addAttribute("user", user);
        
        

        return "register";
    }
    
}