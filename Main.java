//jdbc boiler plate
//import java.sql.*;
//public class Main {
//    //create connection as it is outside main method
//   private static final String url="jdbc:mysql://localhost:3306/?user=root";
//    private static final String username="root";
//    private static final String password="12345";
//    public static void main(String[] args) {
//        try {
//            //to load drivers
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        //create connection
//        try{
//          Connection connection=DriverManager.getConnection(url,username,password);
//          //Connection interface instance has the method createStatement and the Statement interface instance holds it
//          Statement statement= connection.createStatement();
//
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}



//starting with how to perform crud operations using statement



//retrieveal
//import java.sql.*;
//public class Main {
//    //create connection as it is outside main method
//    private static final String url="jdbc:mysql://localhost:3306/mydb";
//    private static final String username="root";
//    private static final String password="12345";
//    public static void main(String[] args) {
//        try {
//            //to load drivers
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        //create connection
//        try{
//            Connection connection=DriverManager.getConnection(url,username,password);
//            //Connection interface instance has the method createStatement and the Statement interface instance holds it
//            Statement statement= connection.createStatement();
//            String query="SELECT * FROM STUDENTS";
//            //query execute hogi statement inteface ki help se iske instance k pass method hoga executeQuery
//            //data retrive kr rhe h toh executeQuery method use krna hai
//            //data insert update ya delete kr rhe h toh executeUpdate method chalana hai
//
//            //statement.executeQuery(query); this method gives whole table and isko hold krne k liye ve use ResultSet Interface
//            ResultSet resultSet=statement.executeQuery(query);
//            //resultSet.next() give true if next row exist in table otherwise false
//            while(resultSet.next()){
//                // resultset k get k aage wo method use krege jo datatype hoga uss field ka
//                int id=resultSet.getInt("id");
//                String name=resultSet.getString("name");
//                int age=resultSet.getInt("age");
//                double marks=resultSet.getDouble("marks");
//                System.out.println("ID: "+id);
//                System.out.println("NAME: "+name);
//                System.out.println("AGE: "+age);
//                System.out.println("MARKS: "+marks);
//
//            }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}



//insert
//import java.sql.*;
//public class Main {
//    private static final String url="jdbc:mysql://localhost:3306/mydb";
//    private static final String username="root";
//    private static final String password="12345";
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            Connection connection=DriverManager.getConnection(url,username,password);
//            Statement statement= connection.createStatement();
//            String query=String.format("INSERT INTO students(name, age, marks) VALUES('%s', %o, %f)", "SANDEEP", 20, 65.7);
//
//            int rowsAffected=statement.executeUpdate(query);
//           if(rowsAffected>0){
//               System.out.println("DATA INSERTED SUCCESSFULLY");
//           }else{
//               System.out.println("DATA NOT INSERTED");
//           }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}



//UPDATE
//import java.sql.*;
//public class Main {
//    private static final String url="jdbc:mysql://localhost:3306/mydb";
//    private static final String username="root";
//    private static final String password="12345";
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            Connection connection=DriverManager.getConnection(url,username,password);
//            Statement statement= connection.createStatement();
//            String query=String.format("UPDATE students SET marks = %f WHERE id = %d", 85.9 ,2);
//
//            int rowsAffected=statement.executeUpdate(query);
//            if(rowsAffected>0){
//                System.out.println("DATA UPDATED SUCCESSFULLY");
//            }else{
//                System.out.println("DATA NOT UPDATED ");
//            }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}





//delete
//import java.sql.*;
//public class Main {
//    private static final String url="jdbc:mysql://localhost:3306/mydb";
//    private static final String username="root";
//    private static final String password="12345";
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            Connection connection=DriverManager.getConnection(url,username,password);
//            Statement statement= connection.createStatement();
//            String query=String.format("DELETE FROM students WHERE id = 2");
//
//            int rowsAffected=statement.executeUpdate(query);
//            if(rowsAffected>0){
//                System.out.println("DELETED SUCCESSFULLY");
//            }else{
//                System.out.println("DATA NOT DELETED ");
//            }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}





//statement ka use kr rhe h toh sql m queries har baar compile hori hai har baar query likhni padrhi h new variable create krke java m
//or agar function bhi banalo toh bhi query java m ek baar compile hojayega but sql m baar baar compile hoga
//thats why we use prepared statement isme compilation sirf ek baar hoga uske baad sirf values change hongi

//using prepared statememt

//INSERT
//import java.sql.*;
//public class Main {
//    private static final String url="jdbc:mysql://localhost:3306/mydb";
//    private static final String username="root";
//    private static final String password="12345";
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            Connection connection=DriverManager.getConnection(url,username,password);
//            String query="INSERT INTO students (name, age, marks) VALUES(?, ?, ?)";
//            PreparedStatement preparedStatement=connection.prepareStatement(query); //iss line tk hum apni query ko sql k andr compile kr chuke h iske baad isme sirf values change hongi
//            preparedStatement.setString(1,"ANKITA");
//            preparedStatement.setInt(2,18);
//            preparedStatement.setDouble(3,78.3);
//
//            int rowsAffected=preparedStatement.executeUpdate();//statement m yaha execute m query pass hui thee but preparedstatement m hum upr query pass kar chuke hai yaha ni karege dubara
//            if(rowsAffected>0){
//                System.out.println("DATA INSERTED");
//            }else{
//                System.out.println("DATA NOT INSERTED ");
//            }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}






//RETRIEVE
//import java.sql.*;
//public class Main {
//    private static final String url="jdbc:mysql://localhost:3306/mydb";
//    private static final String username="root";
//    private static final String password="12345";
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            Connection connection=DriverManager.getConnection(url,username,password);
//            String query="SELECT * FROM STUDENTS WHERE id = ?";
//            PreparedStatement preparedStatement=connection.prepareStatement(query);
//            preparedStatement.setInt(1,3); // 1 mtlb bhot saare ? hote toh 1 wala ? pr 3 value jayegi
//            ResultSet resultSet=preparedStatement.executeQuery();
//            if(resultSet.next()){
//                double marks=resultSet.getDouble("marks");
//                System.out.println("MARKS: "+ marks);
//            }else{
//                System.out.println("MARKS NOT FOUND");
//            }
//
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}




//update
//import java.sql.*;
//public class Main {
//    private static final String url="jdbc:mysql://localhost:3306/mydb";
//    private static final String username="root";
//    private static final String password="12345";
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            Connection connection=DriverManager.getConnection(url,username,password);
//            String query="UPDATE students SET MARKS = ? WHERE id= ?" ;
//            PreparedStatement preparedStatement=connection.prepareStatement(query);
//            preparedStatement.setDouble(1,99.9);
//            preparedStatement.setInt(2,3);
//            int rowsAffected= preparedStatement.executeUpdate();
//
//            if(rowsAffected>0){
//                System.out.println("MARKS UPDATED ");
//            }else{
//                System.out.println("MARKS NOT UPDATED");
//            }
//
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}



//DELETE
//import java.sql.*;
//public class Main {
//    private static final String url="jdbc:mysql://localhost:3306/mydb";
//    private static final String username="root";
//    private static final String password="12345";
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            Connection connection=DriverManager.getConnection(url,username,password);
//            String query="DELETE FROM students WHERE id= ?" ;
//            PreparedStatement preparedStatement=connection.prepareStatement(query);
//            preparedStatement.setInt(1,3);
//            int rowsAffected= preparedStatement.executeUpdate();
//
//            if(rowsAffected>0){
//                System.out.println("ROW DELETED ");
//            }else{
//                System.out.println("ROW NOT DELETED");
//            }
//
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}


//-------------------------------------------------CRUD OPERATIONS USING PREPARE STATEMENT END -------------------------------------------------------------------------------------------




//batch processing - jese hum insert operation perform karege toh ek ek karke kara abhi tk humne aab kaafi zyada karane hai agar toh hum for loop laagakr user se input le skte h but iski jagah hum batch processing use krte hai jisme batch banakr ek baar m execute kr dia jaata h like example of salary given to employees on date 1;




//INSERT USING STATEMENT
//import java.sql.*;
//import java.util.Scanner;
//
//public class Main {
//    private static final String url="jdbc:mysql://localhost:3306/mydb";
//    private static final String username="root";
//    private static final String password="12345";
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            Connection connection=DriverManager.getConnection(url,username,password);
//            Statement statement= connection.createStatement();
//
//            Scanner sc=new Scanner(System.in);
//while(true){
//    System.out.println("enter name");
//    String name=sc.next();
//    System.out.println("enter age");
//    int age=sc.nextInt();
//    System.out.println("enter marks");
//    double marks=sc.nextDouble();
//    System.out.print("Enter more data(Y/N): ");
//    String choice =sc.next();
//    String query=String.format("INSERT INTO students(name, age, marks) VALUES('%s', %o, %f)", name ,age,marks);
//statement.addBatch(query);
//    if(choice.toUpperCase().equals("N")){
//        break;
//    }
//}
//
//            int[] arr=statement.executeBatch();//aab jab batch exeecute hota hai toh ek arry returun hota h or array  1 or 0 k form mein ayega jitni query utna array ka size or 1 represt krra h query execute hui h or 0 vice versa
//            for(int i =0;i<arr.length;i++){
//                if(arr[i]==0){
//                    System.out.println("QUERY NUMBER "+i+" HAS NOT EXECUTED SUCCESSFULLY");
//                }
//            }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}




//INSERT USING PREPARED STATEMENT
//import java.sql.*;
//import java.util.Scanner;
//
//public class Main {
//    private static final String url="jdbc:mysql://localhost:3306/mydb";
//    private static final String username="root";
//    private static final String password="12345";
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            Connection connection=DriverManager.getConnection(url,username,password);
//            String query="INSERT INTO students(name, age, marks) VALUES(?, ?, ?)";
//            PreparedStatement preparedStatement= connection.prepareStatement(query);
//            Scanner sc=new Scanner(System.in);
//            while(true){
//                System.out.println("enter name");
//                String name=sc.next();
//                System.out.println("enter age");
//                int age=sc.nextInt();
//                System.out.println("enter marks");
//                double marks=sc.nextDouble();
//                System.out.print("Enter more data(Y/N): ");
//                String choice =sc.next();
//                preparedStatement.setString(1,name);
//                preparedStatement.setInt(2,age);
//                preparedStatement.setDouble(3,marks);
//                preparedStatement.addBatch();
//                if(choice.toUpperCase().equals("N")){
//                    break;
//                }
//            }
//
//            int[] arr=preparedStatement.executeBatch();//aab jab batch exeecute hota hai toh ek arry returun hota h or array  1 or 0 k form mein ayega jitni query utna array ka size or 1 represt krra h query execute hui h or 0 vice versa
//            for(int i =0;i<arr.length;i++){
//                if(arr[i]==0){
//                    System.out.println("QUERY NUMBER "+i+" HAS NOT EXECUTED SUCCESSFULLY");
//                }
//            }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}




//-----------------------------------------------------------transaction handing below------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//transaction handling mien data consitency ko maintain krna padta hai
//imporatnt things to maintain data consistency are commit and roll back
//commit karna mtlb changes ko allow krna like eg agar transaction successfull hai paise katgye udr pauch gye toh we can commit
//roll back karna mtlb jese transaction beech m atka toh hum poore transaction ko roll back kardege mtlb usko intial state pr lejayege
//kyuki hume atomicity maintain krdi hai that is either none or complete
 //abhi tk upar sab autocommit horha tha kyuki autoCommit() method by default true hota h
//now we'll make this method false jisse jab hume chaaye  tab he changes commit hoye
//otherwise rollback;



//without commit and rollback
//import java.sql.*;
//import java.util.Scanner;
//
//public class Main {
//    private static final String url="jdbc:mysql://localhost:3306/transactions";
//    private static final String username="root";
//    private static final String password="12345";
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            Connection connection=DriverManager.getConnection(url,username,password);
//           String debit_query="UPDATE account SET balance = balance - ? WHERE account_number = ?";
//            String credit_query="UPDATE account SET balance = balance + ? WHERE account_number = ?";
//            PreparedStatement debitpreparedStatement=connection.prepareStatement(debit_query);
//            PreparedStatement creditpreparedStatement=connection.prepareStatement(credit_query);
//            Scanner sc=new Scanner(System.in);
//            System.out.println("enter amount to send");
//            double amount =sc.nextDouble();
//            System.out.println("enter debit account number");
//            int debit_account_number=sc.nextInt();
//            System.out.println("enter credit account number");
//            int credit_account_number=sc.nextInt();
//            debitpreparedStatement.setDouble(1,amount);
//            debitpreparedStatement.setInt(2,debit_account_number);
//            creditpreparedStatement.setDouble(1,amount);
//            creditpreparedStatement.setInt(2,credit_account_number);
//            if(isSufficient(connection,debit_account_number,amount)){
//                int affectedRows1=debitpreparedStatement.executeUpdate();
//                int affectedRows2=creditpreparedStatement.executeUpdate();
//            }
//            else{
//                System.out.println("INSUFFICIENT BALANCE");
//            }
//
//
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//    private static boolean isSufficient(Connection connection,int account_number,double amount){
//        try{
//    String query="SELECT balance FROM account WHERE account_number = ? ";
//    PreparedStatement preparedStatement=connection.prepareStatement(query);
//    preparedStatement.setInt(1,account_number);
//    ResultSet resultSet=preparedStatement.executeQuery();
//    if(resultSet.next()){
//        double current_balance=resultSet.getDouble("balance");
//        if(current_balance<amount){
//            return false;
//        }
//    }
//        }
//        catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//return true;
//    }
//}






// transaction handling with commit and rollback
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String url="jdbc:mysql://localhost:3306/transactions";
    private static final String username="root";
    private static final String password="12345";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            Connection connection=DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            String debit_query="UPDATE account SET balance = balance - ? WHERE account_number = ?";
            String credit_query="UPDATE account SET balance = balance + ? WHERE account_number = ?";
            PreparedStatement debitpreparedStatement=connection.prepareStatement(debit_query);
            PreparedStatement creditpreparedStatement=connection.prepareStatement(credit_query);
            Scanner sc=new Scanner(System.in);
            System.out.println("enter amount to send");
            double amount =sc.nextDouble();
            if (amount <= 0) {
                System.out.println("Amount must be greater than zero. Transaction aborted.");
                return;
            }
            System.out.println("enter debit account number");
            int debit_account_number=sc.nextInt();
            System.out.println("enter credit account number");
            int credit_account_number=sc.nextInt();
            debitpreparedStatement.setDouble(1,amount);
            debitpreparedStatement.setInt(2,debit_account_number);
            creditpreparedStatement.setDouble(1,amount);
            creditpreparedStatement.setInt(2,credit_account_number);
            debitpreparedStatement.executeUpdate();
            creditpreparedStatement.executeUpdate();
            if(isSufficient(connection,debit_account_number,amount)){
              connection.commit();
                System.out.println("TRANSACTION SUCCESSFULL!!");
            }
            else{
                connection.rollback();
                System.out.println("TRANSACTION UNSUCCESSFULL!! ");
            }


        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private static boolean isSufficient(Connection connection,int account_number,double amount){
        try{
            String query="SELECT balance FROM account WHERE account_number = ? ";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,account_number);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                double current_balance=resultSet.getDouble("balance");
                if(current_balance<amount && current_balance<0 ){
                    return false;
                }
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}
