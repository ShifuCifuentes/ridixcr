package org.rx.cr.bl;

import org.hibernate.Session;
import org.rx.cr.generic.MVCGeneric;
import org.rx.cr.generic.MVCGenericHibernate;
import org.rx.cr.util.HibernateUtil;

public abstract class BLAbstractHibernate<Tipo> implements MVCGenericHibernate<Tipo> {
    private Session sesion;

    public BLAbstractHibernate() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }
    
    
    protected Session getSesion() {
        return sesion;
    }

    protected void setSesion(Session sesion) {
        this.sesion = sesion;
    }    
}
