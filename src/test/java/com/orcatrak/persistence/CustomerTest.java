/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orcatrak.persistence;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author java ee
 */
public class CustomerTest {

    private static ValidatorFactory vf;
    private static Validator validator;

    @BeforeClass
    public static void init() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }

    @AfterClass
    public static void close() {
        vf.close();
    }

    @Test
    public void shouldRaiseNoConstraintViolation() {
        Client customer = new Client(111L, "john", "kusak", "2148029284", "jsfsessions@gmail.com", "1114 fairfield drv", "dallas", "tx", "75247");
        Set<ConstraintViolation<Client>> violations = validator.validate(customer);
        assertEquals(0, violations.size());
    }
    
    @Test
    public void shouldRaiseConstraintViolationCauseInvalidZipcode() { 
        Client customer = new Client(111L, "john", "kusak", "2148029284", "jsfsessions@gmail.com", "1114 fairfield drv", "dallas", "tx", "75000");
        Set<ConstraintViolation<Client>> violations = validator.validate(customer);
        assertEquals(1, violations.size());
        assertEquals("invalid US zip code", violations.iterator().next().getMessage());
        assertEquals("", violations.iterator().next().getInvalidValue());
        assertEquals("com.orcatrak.constraints.ZipCode.message", violations.iterator().next().getMessageTemplate());
    }
}