package com.nexign.model.db;

import org.hibernate.Session;

import java.util.Date;

public class TestHibernate {
    public static void main(String[] args) {
        Purpose purpose = new Purpose();
        purpose.setStartDate(new Date());
        purpose.setDescription("Clean teeth");
        purpose.setRequirementDate(new Date(12));
        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(purpose);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Purpose ID = " + purpose.getPurposeId());

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
    }
}
