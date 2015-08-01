package org.taxidermia.voteweekrestaurant.common;

/**
 * Clase que especifica validaciones generales
 */
public class AssertionConcern {

    protected AssertionConcern() {
        super();
    }

    protected void assertArgumentNotNull(Object anObject, String aMessage) {
        if (anObject == null) {
            throw new IllegalArgumentException(aMessage);
        }
    }

}
