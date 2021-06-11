package pl.sda.tdd;

final class CompanyRegistration {

    private final CompanyDao companyDao;

    public CompanyRegistration(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public RegisteredCompany register(CompanyRegistrationForm form) {
        companyDao.save(new Company(form.getName(),
            form.getEmail(),
            form.getVat(),
            form.isVerified()));
        return new RegisteredCompany(form.getName(),
            form.getVat(),
            form.getEmail());
    }
}
