package model;

import java.util.List;

/**
 * Created by 13250 on 2017/6/22.
 */

public class Order {
    private List<String> OrderList;
    public Void SetContent(List<String> orderList){
        this.OrderList=orderList;
        return null;
    }
 public  List<String>GetContent(){
        return  this.OrderList;
  }
}
