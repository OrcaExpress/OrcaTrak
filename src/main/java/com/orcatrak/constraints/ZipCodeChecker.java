package com.orcatrak.constraints;

import com.orcatrak.collection.ZipCodesCollection;

@USA
public class ZipCodeChecker {

    private String zipCode;
    ZipCodesCollection zipCodesCollection = new ZipCodesCollection();

    public ZipCodeChecker() {
    }

    public ZipCodeChecker(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isZipCodeValid(String zipCode) {
        // Call an external web service to check zipcode
        return (zipCodesCollection.getZipCodes().containsKey(zipCode));
    }
}

//    HashMap<String[], String> zipCodes = new HashMap<>(); 
//    String[] miZips = {"48043", "48238"};
//    zipCodes.put(miZips, "Michigan");
