package com.bookSystem.useCase;


public abstract class AddOrder implements IUserLoginManager{
    private final DBbookManager order;

    public AddOrder(DBbookManager order){
    this.order = order;}

    public void execute(){order.addOrder();}
    }
    /*
    Need to add addOrder() method in DBBookManager.
     */


