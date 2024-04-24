package codoacodo.vuelosapi.services;

import codoacodo.vuelosapi.model.Company;
import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> allCompanies() {
        return companyRepository.findAll();
    }

    public void createCompany(Company company) {
        companyRepository.save(company);
    }
}
