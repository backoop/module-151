package ch.fwesterath.daojokes.dao;

import ch.fwesterath.daojokes.dao.maccess.DataBaseAccesMAccess;
import ch.fwesterath.daojokes.dao.sql.DataBaseAccesSQL;

public class DataBaseAccessFactory {
    public DataBaseAccess getDataBaseAccess(String id) {
        switch (id.toLowerCase()) {
            case "sql":
                return new DataBaseAccesSQL();
            case "maccess":
                return new DataBaseAccesMAccess();
            default:
                return null;
        }
    }
}
