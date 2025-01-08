package coe528.project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import static javafx.application.Application.launch;

public class App extends Application {

    private Scene loginPage, managerPage, customerPage;
    private static ArrayList<CustomerAccount> customers = new ArrayList<>();
    private static Manager admin = new Manager();
    private CustomerAccount tempCust;
    private int index = -1;

    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        File dir = new File(currentDirectory);
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith((".txt"))) {
                try (Scanner readFile = new Scanner(file)) {
                    String un = readFile.next();
                    String pw = readFile.next();
                    int balance = Integer.parseInt(readFile.next());
                    customers.add(new CustomerAccount(un, pw));
                    for (CustomerAccount c : customers) {
                        if (c.getUsername().equals(un))
                            c.depositMoney(balance - 100);
                        c.setAccountLevel();
                    }
                } catch (Exception e3) {
                }
            }
        }
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Login Screen: Please login below!");

        TextField username = new TextField();
        TextField password = new TextField();
        TextField createPassword = new TextField();
        TextField createUsername = new TextField();
        TextField depositMoney = new TextField();
        TextField withdrawMoney = new TextField();
        TextField userToDelete = new TextField();
        TextField op = new TextField();
        Button button = new Button("Proceed!");

        button.setOnAction(e -> {
            String inputtedFileName = username.getText();
            String inputtedPassword = password.getText();
            File f = new File(inputtedFileName + ".txt");
            if (f.exists()) {
                try (Scanner readFile = new Scanner(f)) {
                    String usernameOnFile = readFile.next();
                    String passwordOnFile = readFile.next();

                    if (inputtedFileName.equals(usernameOnFile) && inputtedPassword.equals(passwordOnFile)) {
                        if (usernameOnFile.equals("Manager")) {
                            window.setScene(managerPage);
                            username.clear();
                            password.clear();
                        } else {
                            for (int i = 0; i < customers.size(); i++) {
                                if (customers.get(i).getUsername().equals(inputtedFileName)) {
                                    tempCust = customers.get(i);
                                    index = i;
                                }
                            }
                            window.setScene(customerPage);
                            username.clear();
                            password.clear();
                        }
                    } else
                        showAlert("ERROR!", "You have entered the wrong password!");
                } catch (Exception e1) {
                    System.out.println("WOOPSIE!");
                }
            } else {
                showAlert("ERROR!", "That username does not exist!");
            }
        });

        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(new javafx.scene.control.Label("Username:"), username,
                new javafx.scene.control.Label("Password:"), password, button);
        loginPage = new Scene(layout1, 1000, 700);

        VBox layout2 = new VBox(10);
        Button createCustomerBtn = new Button("Create Customer's Account");
        createCustomerBtn.setOnAction(e -> {
            customers.add(new CustomerAccount(createUsername.getText(),createPassword.getText()));
            createUsername.clear();
                createPassword.clear();
            // Logic to create a new customer
            showAlert("Update!", "A new customer account has been created.");
        });

        Button deleteCustomerBtn = new Button("Delete Customer's Account");
        deleteCustomerBtn.setOnAction(e -> {
            
            // Logic to delete a customer
             String deleteThisUsername = createUsername.getText();
           for(int i = 0; i < customers.size() ; i++){
               if(customers.get(i).getUsername().equals(deleteThisUsername)){
                   admin.deleteCustomer(customers.get(i));
                   customers.remove(i);
                   createUsername.clear();
                
                  // userToDelete.clear(); //removing text from field
                   break;
               }
  /*             else if (i >= customers.size() || i == 0)
                   AlertBox.display("Error", "File Not Found!");   */
           }        
            showAlert("Update!", "The customer's account has been deleted.");
        });

        Button managerLogoutBtn = new Button("Logout");
        managerLogoutBtn.setOnAction(e -> window.setScene(loginPage));

        layout2.getChildren().addAll(new javafx.scene.control.Label("In order to create a new customer account, make sure to enter a new username and password and click the 'Create Customer's Account' button. To delete a customer's account, type in the account information and click 'Delete Customer's Account'. You may also logout."),
                new javafx.scene.control.Label("Customer's username:"), createUsername, new javafx.scene.control.Label("New Customer's password:"),
                createPassword, createCustomerBtn, deleteCustomerBtn, managerLogoutBtn);
        managerPage = new Scene(layout2, 1000, 700);

        VBox layout3 = new VBox(10);
        Button getBalanceBtn = new Button("Your Current Balance");
        getBalanceBtn.setOnAction(e -> showAlert("Current Balance:", "Your current Balance is $" + tempCust.getBalance()));

        Button getCurrentLevelBtn = new Button("Your Current Membership level");
        getCurrentLevelBtn.setOnAction(e -> showAlert("Your current Membership level is: ", tempCust.getAccountLevel()));

        Button depositBtn = new Button("Deposit Money");
        depositBtn.setOnAction(e -> {
            // Logic to deposit money
            try{
                int amount = Integer.parseInt(depositMoney.getText());
                tempCust.depositMoney(amount);
                depositMoney.clear();
            }
            catch(NumberFormatException e1){
                     UpdateMessage.display("ERROR!", "you must input an integer");  
                     depositMoney.clear();
            }      
            showAlert("Update!", "Money has been deposited!");
        });

        Button withdrawBtn = new Button("Withdraw Money");
        withdrawBtn.setOnAction(e -> {
            // Logic to withdraw money
            try{
                int amount = Integer.parseInt(withdrawMoney.getText());
                tempCust.withdrawMoney(amount);
                withdrawMoney.clear();
            }
            catch(NumberFormatException e1){
                     UpdateMessage.display("ERROR!", "you must input an integer");  
                     withdrawMoney.clear();
            }      
            showAlert("Update", "Money has been withdrawn!");
        });

        Button completeTransactionBtn = new Button("Complete Online Purchase");
        completeTransactionBtn.setOnAction(e -> {
            // Logic to complete transaction
            try{
                int amount = Integer.parseInt(op.getText());
                tempCust.onlinePurchase(amount);
                op.clear();
            }
            catch(NumberFormatException e1){
                     UpdateMessage.display("ERROR!", "you must input an integer");
                     op.clear();
            }  
            showAlert("Update!", "Online Puchase has been completed.");
        });

        Button customerLogoutBtn = new Button("Logout");
        customerLogoutBtn.setOnAction(e -> {
               try{
                FileWriter writeToFile = new FileWriter(tempCust.getUsername() + ".txt");
                writeToFile.write(tempCust.getUsername() + "\n");
                writeToFile.write(tempCust.getPassword() + "\n");
                writeToFile.write(""+tempCust.getBalance());
                writeToFile.close();
            }
            catch(Exception w){}
            
            window.setScene(loginPage);
            depositMoney.clear();
            withdrawMoney.clear();
            op.clear(); //online purchase 
                
                
                
                
        });

        layout3.getChildren().addAll(getBalanceBtn, getCurrentLevelBtn,
                new javafx.scene.control.Label("\n\nEnter deposit amount: "), depositMoney,
                depositBtn, new javafx.scene.control.Label("\n\nEnter withdraw amount:"),
                withdrawMoney, withdrawBtn, new javafx.scene.control.Label("\n\nEnter price of purchase online:"),
                op, completeTransactionBtn, new javafx.scene.control.Label("\n\n\n"), customerLogoutBtn);
        customerPage = new Scene(layout3, 1000, 700);

        window.setScene(loginPage);
        window.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
