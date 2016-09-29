package com.orcatrak.constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*
 * <ZipCode, String> implements the constraint validator interface (ZipCode) 
 * and the data type to be constraint String... i.e the zip code entered not 
 * null.  This method is evaluated by the bean validation provider each time 
 * a given value is evaluated.  it returns false if the value is not valid; 
 * true otherwise.
 * 
 *         --
 */
public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

    @Inject
    @USA
    private ZipCodeChecker checker;
    private final Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");

    @Override
    public void initialize(ZipCode zipCode) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        Matcher m = zipPattern.matcher(value);
        if (!m.matches()) {
            return false;
        }
        return checker.isZipCodeValid(value);
    }
} 