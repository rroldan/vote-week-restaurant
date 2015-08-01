package org.taxidermia.voteweekrestaurant.common;

import org.apache.log4j.Logger;

/**
 * Clase que especifica validaciones generales
 */
public class AssertionConcern {
    static Logger logger = Logger.getLogger(AssertionConcern.class);

    protected AssertionConcern() {
        super();
    }

    protected void assertArgumentNotNull(Object anObject, String aMessage) {
        if (anObject == null) {
            IllegalArgumentException illegalArgumentException= new IllegalArgumentException(aMessage);
            logger.debug(illegalArgumentException);
            throw illegalArgumentException;
        }
    }

    protected void assertArgumentNotEmpty(String aString, String aMessage) {
        if (aString == null || aString.trim().isEmpty()) {
            IllegalArgumentException illegalArgumentException= new IllegalArgumentException(aMessage);
            logger.debug(illegalArgumentException);
            throw illegalArgumentException;
        }
    }

    protected void assertArgumentRange(long aValue, long aMinimum, long aMaximum, String aMessage) {
        if (aValue < aMinimum || aValue > aMaximum) {
            IllegalArgumentException illegalArgumentException= new IllegalArgumentException(aMessage);
            logger.debug(illegalArgumentException);
            throw illegalArgumentException;
        }
    }


}
