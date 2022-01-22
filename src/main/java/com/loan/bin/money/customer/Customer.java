package com.loan.bin.money.customer;

/**
 * Created by Devershi Srivastava on 1/16/2022.
 *
 * com.loan.bin.money.customer.Customer POJO
 *
 */
public abstract class Customer {

    private String name;
    private boolean isPrivate;
    private String accName;
    private String address;
    private String branch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void isPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

}
