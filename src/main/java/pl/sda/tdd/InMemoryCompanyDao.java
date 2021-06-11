package pl.sda.tdd;

import java.util.concurrent.ConcurrentHashMap;

final class InMemoryCompanyDao implements CompanyDao {

    private final ConcurrentHashMap<String, Company> database = new ConcurrentHashMap<>();

    public boolean existsByVat(String vat) {
        return database.containsKey(vat);
    }

    @Override
    public void save(Company company) {
        database.put(company.getVatNumber(), company);
    }
}
