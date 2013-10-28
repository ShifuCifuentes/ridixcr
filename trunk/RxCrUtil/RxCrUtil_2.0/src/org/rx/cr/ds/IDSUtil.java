package org.rx.cr.ds;

import java.sql.Connection;
import org.rx.cr.conf.Config;

public interface IDSUtil {
    public  DSConeccion _DSConneccion(Config conf);
    public  DSConeccion _DSConneccion();
    public  Connection _Conneccion();
}
