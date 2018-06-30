package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public String uid;
    public String name;
    public String busines;
    public String primary;
    public String address;
    public String province;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String uid, String name, String busines, String primary, String address, String province) {
        this.uid = uid;
        this.name = name;
        this.busines = busines;
        this.primary = primary;
        this.address = address;
        this.province = province;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("busines", busines);
        result.put("primary", primary);
        result.put("address", address);
        result.put("province", province);

        return result;
    }

    /**
     * This method use to check the rule of the information.
     * @param name
     * @param bn
     * @param prB
     * @param addr
     * @param pro
     * @return
     */
    public static boolean validate(String name, String bn, String prB, String addr, String pro) {
        // case name
        if (name.length() > 48 || name.length() < 2)
            return false;

        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i)))
                return false;
        }

        //case bn

        if (bn.length() != 9)
            return false;


        for (int i = 0; i < bn.length(); i++) {
            if (!Character.isDigit(bn.charAt(i)))
                return false;
        }


        //case prB
        String[] jobs = {"Fisher", "Distributor", "Processor", "Fish Monger"};

        boolean contains = false;
        for (String job : jobs) {
            if (prB.equals(job)) contains = true;
        }
        if (!contains) return false;

        //case addr
        if (addr.length() > 50)
            return false;

        //case pro
        String[] province = {"AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK", "YT", "", " ", "  "};

        boolean contain = false;
        for (String provin : province) {
            if (pro.equals(provin)) contain = true;
        }
        if (!contain) return false;


        return true;
    }
}
