package de.rubbs.sfgtt.db;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * From konqis fit-precinct project
 * Created by konqi on 16.08.2015.
 */
public class OfyService {
    static {
        ObjectifyService.register(Match.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}