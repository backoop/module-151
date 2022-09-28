package ch.bbw.lm.dao;

public class DatabaseAccessFactory {
    public static DatabaseAccess createDataBaseAccess(String id) {
        if (id.equals("sql")) {
            return new DatabaseAccess_sql();
        } else if (id.equals("ma")) {
            return new DatabaseAccess_ma();
        } else {
            return null;
        }
    }
}
