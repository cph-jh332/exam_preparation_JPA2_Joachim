/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import entity.EBook;
import entity.PaperBook;
import facade.DbFacade;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author craci
 */
public class Tester {
    public static void main(String[] args) {
         DbFacade dbf = new DbFacade(Persistence.createEntityManagerFactory("JPAPu"));
         
         EBook eBook = new EBook();
         eBook.setAuthor("lala");
         eBook.setDownloadUrl("lalala.com");
         eBook.setPrice(333);
         eBook.setSizeMB(32.5);
         eBook.setTitle("Lulaba");
         dbf.addEBook(eBook);
         
         PaperBook pb = new PaperBook();
         pb.setAuthor("luala");
         pb.setInStock(22);
         pb.setPrice(321);
         pb.setTitle("Tutata");
         pb.setShippingWeight(5);
         dbf.addPaperBook(pb);
         
         List<EBook> eBooks = dbf.getAllEBooks();
         for (EBook eBook1 : eBooks) {
             System.out.println(eBook1);
        }
         List<PaperBook> paperBooks = dbf.getAllPaperBooks();
         for (PaperBook eBook1 : paperBooks) {
             System.out.println(eBook1);
        }
         
        System.out.println(dbf.changeEBookTitle(1l));
        System.out.println(dbf.changePaperBookTitle(2l));
        
        if(dbf.removeEBook(1l)){
            System.out.println("Book1 Removed");
        }
        
        if(dbf.removePaperBook(2l)){
            System.out.println("Book2 Removed");
        }
    }
}
