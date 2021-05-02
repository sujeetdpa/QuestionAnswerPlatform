package question.answer.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import question.answer.platform.model.Company;
import question.answer.platform.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable Long id){
        return companyService.getCompany(id);
    }

    @GetMapping("/all")
    public List<Company> getCompanies(){
        return companyService.findAll();
    }

    @PostMapping("/add")
    public Company addCompany(@RequestBody Company company){
        return companyService.save(company);
    }

    @PutMapping("/update/{id}")
    public Company updateCompany(@PathVariable Long id,@RequestBody Company company){
        return companyService.updateCompany(id,company);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Long id){
        return companyService.deleteCompany(id);
    }
}
