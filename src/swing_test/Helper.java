/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing_test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author durgesh
 */
public class Helper {

    private static SessionFactory factor;

    public static SessionFactory getFactory() {
        if(factor==null)
        factor = new Configuration().configure().buildSessionFactory();
        return factor;
    }

}
