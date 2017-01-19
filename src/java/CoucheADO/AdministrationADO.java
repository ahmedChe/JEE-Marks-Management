/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoucheADO;

import Utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author !l-PazZ0
 */
public class AdministrationADO {
     

    public static long VerifierCompte(int user,String password) 
    {
        long count;
        Session session=HibernateUtil.getSession();
        Query query = session.createQuery("select count (a) from Administration as a where a.codeAdmin= :user and a.password= :pass");
        query.setInteger("user", user);
        query.setString("pass", password);
        query.setCacheable(true);

        final Object obj = query.uniqueResult();
        if (obj==null)
        {
            count=0;
        }
        else
        {
            count = ((Long)query.uniqueResult());
        }
        System.out.println(count);
        return count;
    }
}
