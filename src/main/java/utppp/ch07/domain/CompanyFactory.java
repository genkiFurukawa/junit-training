package utppp.ch07.domain;

public class CompanyFactory {
    public static Company create(Object[] data) {
        if (data.length < 2) {
            throw new IllegalArgumentException();
        }

        var companyDomainName = (String) data[0];
        int numberOfEmployees = (int) data[1];

        return new Company(companyDomainName, numberOfEmployees);
    }
}
