package pl.sda.cleancode;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

import pl.sda.cleancode.dto.RegisterCompanyForm;

public final class CustomerFacade {

    private final CustomerDao customerDao;
    private final MailSender mailSender;

    public CustomerFacade(CustomerDao customerDao, MailSender mailSender) {
        this.customerDao = requireNonNull(customerDao);
        this.mailSender = requireNonNull(mailSender);
    }

    public void registerCompany(RegisterCompanyForm form) {
        if (customerDao.companyExists(form.getEmail(), form.getVat())) {
            throw new IllegalArgumentException(format("Invalid company form data: %s", form));
        }
        final var company = Company.createFrom(form);
        customerDao.save(company);
        mailSender.sendRegistrationEmail(company);
    }
}
