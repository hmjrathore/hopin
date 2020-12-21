public class Customer {
    private int id;
    private int employees;
    private String name;
    private String size;
    private ContactInfo contactInfo;

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public int getId() {
        return id;
    }

    public int getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }


    private class ContactInfo {
        private String email;
        private String name;

        public String getEmail() {return email;}

        public String getName() {return name;}
    }
}
