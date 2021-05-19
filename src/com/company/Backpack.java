package com.company;

import interfaces.IItem;

import java.util.HashMap;

public class Backpack {

    int maxItems;
    HashMap<String, IItem> itemsInBackpack;

    public Backpack(int maxItems){
        this.maxItems = maxItems;
        itemsInBackpack = new HashMap<String,IItem>();
    }

    public char OnPutIn(IItem item){
        if(item.CanBeInBackpack()){
            if(itemsInBackpack.size() <= maxItems){
                if(!itemsInBackpack.containsKey(item.GetItemName())){
                    itemsInBackpack.put(item.GetItemName(),item);
                    return 'S';
                }else{
                    return 'C';
                }
            }else{
                return 'F';
            }
        }else {
            return 'S';
        }

    }

    public char HaveInteractableItem(){
        int temp = itemsInBackpack.size();
        if(temp == 0){
            return 'E';
        }
        return 'Y';
    }



    public IItem OnTakeOut(String itemName){
        IItem removedItem = itemsInBackpack.remove(itemName);
        return removedItem;
    }

    public String ShowItemsInBackpack(){
        String temp = "";
        for(String key: this.itemsInBackpack.keySet()){
            temp += key + " ";
        }
        return temp;
    }

    public IItem GetItemInBackpack(String itemName){
        return itemsInBackpack.get(itemName);
    }




}
