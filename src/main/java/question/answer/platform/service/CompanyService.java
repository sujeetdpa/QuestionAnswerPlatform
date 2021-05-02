package question.answer.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import question.answer.platform.dao.CompanyRepository;
import question.answer.platform.model.Company;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    public Company getCompany(Long id){
         return findById(id);
    }

    public Company findById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new InvalidDataAccessApiUsageException( "Company Not Found with id:" + id));
    }
    public Company findByName(String name){
       return companyRepository.findByName(name).orElseThrow(()->new IllegalStateException("Comapany not found with name"+name));
    }

    public List<Company> findAll() {
       return companyRepository.findAll();
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }
    @Transactional
    public Company updateCompany(Long id, Company company) {
        Company com=findById(id);
        com.setName(company.getName());
        return com;
    }

    public String deleteCompany(Long id) {
        Company com=findById(id);
        companyRepository.deleteById(id);
        return String.format("Successfuly deleted company :%s of id: %s",com.getName(),com.getId());
    }
}
