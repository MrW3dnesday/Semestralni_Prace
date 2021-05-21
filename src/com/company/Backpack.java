package com.company;

import interfaces.IItem;

import java.util.HashMap;

/*
 *  Třída Backpack - Uchovává předměty hráče
 *  Obsahuje metody pro interakci předmětu při interakci s batohem
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class Backpack {

    int maxItems;
    HashMap<String, IItem> itemsInBackpack;

    public Backpack(int maxItems){
        this.maxItems = maxItems;
        itemsInBackpack = new HashMap<>();
    }

    /**
     * Metoda zajišťuje vložení předmětu do batohu a vrací příznak zda došlo k problému
     *
     * @return Vrací příznak provedení
     */
    public char OnPutIn(IItem item){
        //check if item can be put in backpack
        if(item.CanBeInBackpack()){
            //check if backpack is full
            if(itemsInBackpack.size() <= maxItems){
                //check if item is already in backpack
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

    /**
     * Metoda zjistí zda je v batohu předmět s kterým se dá interagovat
     *
     * @return Vrací příznak zda v batohu jsou předemty s který jde nějak interagovat
     */
    public char HaveInteractableItem(){
        int temp = itemsInBackpack.size();
        if(temp == 0){
            return 'E';
        }
        return 'Y';
    }


    /**
     * Metoda zajistí vyndání předmětu z batohu
     *
     * @return Vrací vyndaný předmět
     */
    public IItem OnTakeOut(String itemName){
        IItem removedItem = itemsInBackpack.remove(itemName);
        return removedItem;
    }

    /**
     * Metoda připraví text
     *
     * @return Vrací vyndaný předmět
     */
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
