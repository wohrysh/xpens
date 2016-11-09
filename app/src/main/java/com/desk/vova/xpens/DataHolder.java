package com.desk.vova.xpens;

import android.util.Log;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;
//zhopa
/**
 * Created by vova on 10/05/2016.
 */
public class DataHolder {
    private List<Long>              deleted_purchase_ids                                    ;
    private Long                    next_purchase_id                                        ;
    private ArrayList<PurchaseData> purchases              = new ArrayList<PurchaseData>()  ;

    private DataHolder() {
        this.deleted_purchase_ids = new ArrayList<>();
    }
    private static final DataHolder holder = new DataHolder();

    public static DataHolder getInstance() {
        return holder;
    }

    public ArrayList<PurchaseData> getPurchases() {
        return this.purchases;
    }

    public Long retrieveNextPurchaseId() {
        Long ret_val;
        if(deleted_purchase_ids.size()== 0) {
            ret_val = this.next_purchase_id;
            this.next_purchase_id++;
        }
        else {
            ret_val = deleted_purchase_ids.get(0);
            deleted_purchase_ids.remove(0);
        }
        return ret_val;
    }

    public void setNextPurchaseId(Long next_purchase_id) {
        this.next_purchase_id = next_purchase_id;
    }

    public PurchaseData findPurchaseById(int beaver_id) {
        for (int i = 0; i < this.purchases.size(); i++) {
            if (purchases.get(i).getId() == beaver_id) {
                return this.purchases.get(i);
            }
        }
        return null;
    }

    public void removePurchaseById(int deleted_purchase_id) {
        PurchaseData purchase_to_delete = this.findPurchaseById(deleted_purchase_id);
        Assert.assertEquals(false, purchase_to_delete == null);
        this.deleted_purchase_ids.add(purchase_to_delete.getId());
        this.purchases.remove(purchase_to_delete);
    }
}