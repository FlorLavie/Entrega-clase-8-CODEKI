package codoacodo.vuelosapi.controller;

import codoacodo.vuelosapi.model.Company;
import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("")
    public List<Company> allCompanies(){
        return companyService.allCompanies();
    }

    @PostMapping  ("/add")
    public void createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
    }
}
