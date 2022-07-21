package sg.edu.nus.iss.d13revision.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.d13revision.models.Person;
import sg.edu.nus.iss.d13revision.models.PersonForm;
import sg.edu.nus.iss.d13revision.services.PersonService;

@Controller
public class PersonController {
    private List<Person> personList = new ArrayList<Person>();

    @Autowired
    PersonService perSvc;

    @Value("${welcome.message}")
    private String message;
    
    @Value("${error.message}")
    private String errorMessage;

    // @PutMapping

    @RequestMapping(value = {"/","/home","/index"}, method=RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping(value="/testRetrieve", method=RequestMethod.GET, produces = "application/json")    
    public @ResponseBody List<Person> getAllPersons(){
        personList = perSvc.getPersons();
        return personList;

    }
    
    @RequestMapping(value = "/personList", method=RequestMethod.GET)
    //if data is not needed for Thymeleaf template to inject, so that it can be placed into the webpage, then Model variable is not needed. 
    // by using Model , it aids to inject data into webpage
    public String personList(Model model){
        personList = perSvc.getPersons();
        model.addAttribute("persons", personList);
        return "personList";
    }

    // empty person form; personform.html to be injected in
    @RequestMapping(value = "/addPerson", method=RequestMethod.GET)
    public String showAddPersonPage(Model model){
        PersonForm pForm = new PersonForm();
        model.addAttribute("personForm", pForm);
        return "addPerson";
    }

    @RequestMapping(value = "/addPerson", method=RequestMethod.POST)
    // using model attribute to parse personForm; when submitted,
    public String savePerson(Model model, @ModelAttribute("personForm") PersonForm personForm){
      
        String fName = personForm.getFirstName();
        String lName = personForm.getLastName();

        if(fName != null && fName.length() > 0 && lName != null && lName.length() >0){
            //define new person
            Person newPerson = new Person(fName, lName);
            perSvc.addPerson(newPerson);

            //saved successfully and redirected to:
            return "redirect:/personList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addPerson";
        

    }

    }
