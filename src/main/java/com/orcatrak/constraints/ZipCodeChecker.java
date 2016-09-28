package com.orcatrak.constraints;

import com.orcatrak.collection.ZipCodesCollection;

@USA
public class ZipCodeChecker {

    private Integer zipCode;
    ZipCodesCollection zipCodesCollection = new ZipCodesCollection();
    
    public ZipCodeChecker() { 
    }

    public ZipCodeChecker(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isZipCodeValid(Integer zipCode) {
        // Call an external web service to check zipcode
        if (zipCodesCollection.getZipCodes().containsKey(zipCode)) {
            return true;
        }
        return false;
    }
}

//    HashMap<String[], String> zipCodes = new HashMap<>(); 
//    String[] miZips = {"48043", "48238"};
//    zipCodes.put(miZips, "Michigan");
