//package manager;
//
//import models.Car;
//import models.User;
//import org.testng.annotations.DataProvider;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class MyDataProvider {
//    @DataProvider
//    public Iterator<Object[]> loginValidData(){
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"od26il27@gmail.com","27a02a21a"});
//        list.add(new Object[]{"od26il27@gmail.com","27a02a21a"});
//        list.add(new Object[]{"od26il27@gmail.com","27a02a21a"});
//
//        return list.iterator();
//    }
//
//    @DataProvider
//    public Iterator<Object[]> UserValidData(){
//        List<Object[]> list = new ArrayList<>();
//
//        list.add(new Object[]{"Hay","Low","hay@gmail.com","1234567890"});
//        list.add(new Object[]{"Hay","Low","hay@gmail.com","1234567890"});
//        list.add(new Object[]{"Hay","Low","hay@gmail.com","1234567890"});
//
//        return list.iterator();
//    }
//
//    @DataProvider
//    public Iterator<Object[]> addUserValidDataModel(){
//        List<Object[]> list = new ArrayList<>();
//
//        // list.add(new Object[]{"Hay","Low","1234567890","hay@gmail.com","Haifa","Mother"});
//        //list.add(new Object[]{Contact.builder().name("").lasrName("").build()});
//        list.add(new Object[]{new User().withName("").withLastname("").withEmail("").withPassword("")});
//        list.add(new Object[]{new User().withName("").withLastname("").withEmail("").withPassword("")});
//        list.add(new Object[]{new User().withName("").withLastname("").withEmail("").withPassword("")});
//           return list.iterator();
//    }
//
//    @DataProvider
//    public Iterator<Object[]> addUserValidDataCSV() throws IOException {
//        List<Object[]> list = new ArrayList<>();
//
//        BufferedReader reader = new BufferedReader(new FileReader(("src/test/resources/newusers.csv")));
//        String line = reader.readLine();//Mona,Dow,3214598765,mona@gmail.com,Haifa,friend
//
////        while (line!=null){
////            String[]split = line.split(",");
////            list.add(new Object[]{ Contact.builder()
////                    .name(split[0])
////                .lastName(split[1])
////                .description(split[5])
////                .address(split[4])
////                .email(split[3])
////                .phone(split[2])
////                 .build()});
////            line= reader.readLine();
//        //    }
//
//        while (line != null) {
//            String[] split = line.split(",");
//            list.add(new Object[]{new User()
//                    .withName(split[0])
//                    .withLastname(split[1])
//                    .withEmail(split[2])
//                    .withPassword(split[3])
//            });
//            line = reader.readLine();
//        }
//        return list.iterator();
//    }
//
//}
