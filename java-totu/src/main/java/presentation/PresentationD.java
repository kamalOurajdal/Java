package presentation;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.IDao;
import metier.IMetier;

public class PresentationD {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("config.txt"))) {
            
            // 1. Récupérer le nom de la classe de l'implémentation de l'interface IDao
            String daoClassName = scanner.nextLine();
            Class<?> daoClass = Class.forName(daoClassName);
            IDao dao = (IDao) daoClass.getConstructor().newInstance();

            // 2. Récupérer le nom de la classe de l'implémentation de l'interface IMetier
            String metierClassName = scanner.nextLine();
            Class<?> metierClass = Class.forName(metierClassName);
            IMetier metier = (IMetier) metierClass.getConstructor().newInstance();

            Method setDaoMethod = metierClass.getDeclaredMethod("setDao", IDao.class);
            setDaoMethod.invoke(metier, dao);

            System.out.println(metier.calcul());
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
