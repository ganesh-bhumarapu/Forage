import javax.persistence.*;

class ERDDataModelRepresentation {

    @Entity
    static class FinancialAdvisor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long advisorId;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String email;

        @Column(nullable = false)
        private String phone;

        public FinancialAdvisor() {
        }

        public FinancialAdvisor(String name, String email, String phone) {
            this.name = name;
            this.email = email;
            this.phone = phone;
        }

        public Long getAdvisorId() {
            return advisorId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    @Entity
    static class Client {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long clientId;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String email;

        @Column(nullable = false)
        private String phone;

        @Column(nullable = false)
        private String address;

        public Client() {
        }

        public Client(String name, String email, String phone, String address) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.address = address;
        }

        public Long getClientId() {
            return clientId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    @Entity
    static class Portfolio {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long portfolioId;

        @ManyToOne
        @JoinColumn(name = "clientId", nullable = false)
        private Client client;

        @Column(nullable = false)
        private double totalValue;

        @Column(nullable = false)
        private String dateCreated;

        @Column(nullable = false)
        private String dateUpdated;

        public Portfolio() {
        }

        public Portfolio(Client client, double totalValue, String dateCreated, String dateUpdated) {
            this.client = client;
            this.totalValue = totalValue;
            this.dateCreated = dateCreated;
            this.dateUpdated = dateUpdated;
        }

        public Long getPortfolioId() {
            return portfolioId;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

        public double getTotalValue() {
            return totalValue;
        }

        public void setTotalValue(double totalValue) {
            this.totalValue = totalValue;
        }

        public String getDateCreated() {
            return dateCreated;
        }

        public void setDateCreated(String dateCreated) {
            this.dateCreated = dateCreated;
        }

        public String getDateUpdated() {
            return dateUpdated;
        }

        public void setDateUpdated(String dateUpdated) {
            this.dateUpdated = dateUpdated;
        }
    }

    @Entity
    static class Security {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long securityId;

        @ManyToOne
        @JoinColumn(name = "portfolioId", nullable = false)
        private Portfolio portfolio;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String category;

        @Column(nullable = false)
        private String purchaseDate;

        @Column(nullable = false)
        private double purchasePrice;

        @Column(nullable = false)
        private int quantity;

        public Security() {
        }

        public Security(Portfolio portfolio, String name, String category, String purchaseDate, double purchasePrice, int quantity) {
            this.portfolio = portfolio;
            this.name = name;
            this.category = category;
            this.purchaseDate = purchaseDate;
            this.purchasePrice = purchasePrice;
            this.quantity = quantity;
        }

        public Long getSecurityId() {
            return securityId;
        }

        public Portfolio getPortfolio() {
            return portfolio;
        }

        public void setPortfolio(Portfolio portfolio) {
            this.portfolio = portfolio;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getPurchaseDate() {
            return purchaseDate;
        }

        public void setPurchaseDate(String purchaseDate) {
            this.purchaseDate = purchaseDate;
        }

        public double getPurchasePrice() {
            return purchasePrice;
        }

        public void setPurchasePrice(double purchasePrice) {
            this.purchasePrice = purchasePrice;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
