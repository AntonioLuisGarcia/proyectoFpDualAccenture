package agg.interfaces;

import java.sql.Connection;

public interface MesaManagerInterface <T>{

    T getById(Connection con, int id);

    T getAll(Connection con);
}
