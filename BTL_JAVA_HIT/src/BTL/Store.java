
package BTL;

import java.util.List;

public class Store {
    private int storeId;
    private String storeName;
    private String storePhoneNumber;
    private String storeAddress;
    private List<Product> productOfStore;
    private List<Bill> billList;
    private List<Account> listAccount;
    private List<Customer> listCustomer;
    private double totalRevenue;

    public Store() {
    }

    public Store(int storeId, String storeName, String storePhoneNumber, String storeAddress, 
            List<Product> productOfStore, List<Bill> billList, List<Account> listAccount, 
            List<Customer> listCustomer, double totalRevenue) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storePhoneNumber = storePhoneNumber;
        this.storeAddress = storeAddress;
        this.productOfStore = productOfStore;
        this.billList = billList;
        this.listAccount = listAccount;
        this.listCustomer = listCustomer;
        this.totalRevenue = totalRevenue;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStorePhoneNumber() {
        return storePhoneNumber;
    }

    public void setStorePhoneNumber(String storePhoneNumber) {
        this.storePhoneNumber = storePhoneNumber;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public List<Product> getProductOfStore() {
        return productOfStore;
    }

    public void setProductOfStore(List<Product> productOfStore) {
        this.productOfStore = productOfStore;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public List<Account> getListAccount() {
        return listAccount;
    }

    public void setListAccount(List<Account> listAccount) {
        this.listAccount = listAccount;
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return "Store{" + 
                "storeId=" + storeId + 
                ", storeName=" + storeName + 
                ", storePhoneNumber=" + storePhoneNumber + 
                ", storeAddress=" + storeAddress + 
                ", productOfStore=" + productOfStore + 
                ", billList=" + billList + 
                '}';
    }
    
    
}
