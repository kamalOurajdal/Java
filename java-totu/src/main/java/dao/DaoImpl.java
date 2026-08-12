package dao;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("Version 1: Base de données");
        return 8;
    }
}
