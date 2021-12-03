package com.bookSystem.useCase;

public abstract class DeleteOrder implements IUserLoginManager {
    private final DBbookManager order;

    public DeleteOrder(DBbookManager order) {
        this.order = order;
    }

    public void execute() {
        order.deleteOrder();
     /*
    Need to add addOrder() method in DBBookManager.
     */
    }
}





