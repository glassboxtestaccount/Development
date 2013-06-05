package com.glassbox.webinvoice.server.dataaccess;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;
import com.glassbox.webinvoice.shared.entity.Email;
import com.glassbox.webinvoice.shared.entity.Person;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO  {
    
    @PostConstruct
            void test (){
        System.out.println("setted");
    }
    
    @SuppressWarnings("rawtypes")
    public Person findUser(String email) {
        List result = SessionFactoryManager.getSessionFactory().getCurrentSession().createQuery("from Email e where e.emailAddress=:ea").setString("ea", email).list();
        return  result.isEmpty() ? null : ((Email) result.get(0)).getPerson();
    }
}
