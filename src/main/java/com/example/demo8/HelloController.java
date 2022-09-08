package com.example.demo8;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    @FXML
    private TextField CusBooking;

    @FXML
    private TableColumn<CustomerViewController, String> CusContCol;

    @FXML
    private TextField CusContact;

    @FXML
    private Button btnCusDel;

    @FXML
    private Button btnEmpDel;

    @FXML
    private TableColumn<CustomerViewController, String> CusBookCol;

    @FXML
    private AnchorPane LoginPane;

    @FXML
    private TextField CusFname;

    @FXML
    private TableColumn<CustomerViewController, String> CusFnameCol;

    @FXML
    private TableColumn<CustomerViewController, String> CusIdCol;

    @FXML
    private TextField CusLname;

    @FXML
    private TableColumn<CustomerViewController, String> CusLnameCol;

    @FXML
    private TableColumn<EmployeeViewController, String> EmpContCol;

    @FXML
    private Button btnCusSave;

    @FXML
    private TextField EmpContact;

    @FXML
    private TextField EmpDOB;

    @FXML
    private TableColumn<EmployeeViewController, String> EmpDOBcol;


    @FXML
    private TableColumn<EmployeeViewController, String> EmpFnameCol;


    @FXML
    private TableColumn<EmployeeViewController, String> EmpIdCol;

    @FXML
    private TextField EmpLname;

    @FXML
    private TableColumn<EmployeeViewController, String> EmpLnameCol;

    @FXML
    private TextField EmpPwd;

    @FXML
    private TableView<EmployeeViewController> EmpTable;

    @FXML
    private TextField Empfname;

    @FXML
    private Button btnEmpSave;

    @FXML
    private ScrollPane scrollEmployeePane;

    @FXML
    private AnchorPane homePane1;

    @FXML
    private TextField payAmount;

    @FXML
    private Button payButton;

    @FXML
    private TextField payContact;

    @FXML
    private TextField payName;

    @FXML
    private Button btnBookings;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnEmployees;

    @FXML
    private Button btnHome;

    @FXML
    private VBox loginvbox;

    @FXML
    private AnchorPane EmpPane;

    @FXML
    private Button btnPayments;

    @FXML
    private Button btnRooms;

    @FXML
    private AnchorPane paneView;

    @FXML
    private Pane pnStatus;

    @FXML
    private Text txtHotelName;

    @FXML
    private Text txtMgmtSystem;

    @FXML
    private Text txtWelcome;


    @FXML
    private Button btnMin1;

    @FXML
    private Button btnSettings;
    @FXML
    private TableColumn<CustomerViewController, String> BookFnameCol;

    @FXML
    private TableColumn<CustomerViewController, String> BookLnameCol;

    @FXML
    private TableView<CustomerViewController> CusTable;

    @FXML
    private TableColumn<CustomerViewController, String> bookingCol;

    @FXML
    private TableView<CustomerViewController> bookingTable;

    @FXML
    private Button btnbookingRefresh;

    @FXML
    private ScrollPane scrollBoookPane;

    @FXML
    void refresh(ActionEvent event) {

    }

    @FXML
    private ImageView imgpool;

    @FXML
    private ImageView imgrooms;

    @FXML
    private ImageView imgwifi;

    @FXML
    private Text txtpool;

    @FXML
    private Text txttrooms;

    @FXML
    private Text txtwifi;


    @FXML
    private Text loginTxtStatus;

    @FXML
    private Button logoutBtn;


    @FXML
    private Button login;

    @FXML
    private TextField pwdtxtfield;

    @FXML
    private PasswordField pwdtxtfield2;

    @FXML
    private TextField usertxtfield;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private Stage stage;
    private Scene scene;
    private Parent root;
    String uname;
    String pwd;
    int TotalCurrentvalue ;

    @FXML
    void loginAction(ActionEvent event) {

         uname = usertxtfield.getText();
         pwd = pwdtxtfield2.getText();


        if (uname.equals("") && pwd.equals(""))
        {
            loginTxtStatus.setText("Please Enters Username & Pasword");
            loginTxtStatus.setFill(Color.rgb(5, 157, 252));
        }
        else{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/hoteldatabase", "root", "");
                pst = con.prepareStatement("select * from employee where fname=? and password=?");


                pst.setString(1, uname);
                pst.setString(2,pwd);


                rs = pst.executeQuery();

                if (rs.next()){
                    loginTxtStatus.setText("LOGIN SUCCESSFUL");
                    loginTxtStatus.setFill(Color.rgb(76, 225, 4));


                    login.getScene().getWindow().hide();

                  Parent toot = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                  Scene scene  = new Scene(toot);
                  Stage stage2 =  new Stage();
                  stage2.initStyle(StageStyle.UNDECORATED);
                  stage2.setScene(scene);
                  stage2.show();




                }
                else {
                    loginTxtStatus.setText("LOGIN FAIL! TRY AGAIN");
                    loginTxtStatus.setFill(Color.rgb(255, 5, 5));
                }

            } catch (SQLException e) {
                e.printStackTrace();

                loginTxtStatus.setText("UNABLE TO ACCESS DATABASE");
                loginTxtStatus.setFill(Color.rgb(76, 225, 4));

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }




    @FXML
    private void setBtnClose() {
        System.exit(0);
    }


    @FXML
    private void setBtnMin1() {
        Stage stage = (Stage) paneView.getScene().getWindow();
        stage.setIconified(true);
    }
//set buttons off before log

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {



        if (event.getSource() == btnHome ) {


            txtWelcome.setText("Welcome Home");
            txtHotelName.setText("CAPITAL VIEW HOTEL");
            txtMgmtSystem.setText("Management System");
            pnStatus.setBackground(new Background(new BackgroundFill(Color.rgb(127, 48, 218), CornerRadii.EMPTY, Insets.EMPTY)));
            AnchorPane pane0 = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
            paneView.getChildren().setAll(pane0);
            /* AnchorPane pane =  FXMLLoader.load(HelloApplication.class.getResource("paymentView.fxml"));
            homePane1.getChildren().setAll(pane); */



        } else if (event.getSource() == btnEmployees) {
            txtHotelName.setText("EMPLOYEES");
            txtMgmtSystem.setText("");
            txtWelcome.setText("");
            pnStatus.setBackground(new Background(new BackgroundFill(Color.rgb(150, 38, 118), CornerRadii.EMPTY, Insets.EMPTY)));
            ScrollPane pane1 = FXMLLoader.load(HelloApplication.class.getResource("employee-view.fxml"));
            paneView.getChildren().setAll(pane1);


        } else if (event.getSource() == btnCustomers) {
            txtHotelName.setText("CUSTOMERS");
            txtMgmtSystem.setText("");
            txtWelcome.setText("");
            pnStatus.setBackground(new Background(new BackgroundFill(Color.rgb(48, 127, 218), CornerRadii.EMPTY, Insets.EMPTY)));
            ScrollPane pane3 = FXMLLoader.load(HelloApplication.class.getResource("customer-view.fxml"));
            paneView.getChildren().setAll(pane3);


        } else if (event.getSource() == btnPayments) {
            txtHotelName.setText("PAYMENTS");
            txtMgmtSystem.setText("");
            txtWelcome.setText("");
            pnStatus.setBackground(new Background(new BackgroundFill(Color.rgb(201, 48, 218), CornerRadii.EMPTY, Insets.EMPTY)));
            AnchorPane pane4 = FXMLLoader.load(HelloApplication.class.getResource("paymentView.fxml"));
            paneView.getChildren().setAll(pane4);


        } else if (event.getSource() == btnRooms) {
            txtHotelName.setText("ROOMS");
            txtMgmtSystem.setText("");
            txtWelcome.setText("");
            pnStatus.setBackground(new Background(new BackgroundFill(Color.rgb(48, 218, 144), CornerRadii.EMPTY, Insets.EMPTY)));
            AnchorPane pane5 = FXMLLoader.load(HelloApplication.class.getResource("roomPane-view.fxml"));
            paneView.getChildren().setAll(pane5);

/*
        } else if (event.getSource() == btnBookings) {
            txtHotelName.setText("BOOKINGS");
            txtMgmtSystem.setText("");
            txtWelcome.setText("");
            pnStatus.setBackground(new Background(new BackgroundFill(Color.rgb(218, 48, 189), CornerRadii.EMPTY, Insets.EMPTY)));
            ScrollPane pane6 = FXMLLoader.load(HelloApplication.class.getResource("booking-view.fxml"));
            paneView.getChildren().setAll(pane6);
*/
        } else if (event.getSource() == btnSettings) {
            txtHotelName.setText("SETTINGS");
            txtMgmtSystem.setText("");
            txtWelcome.setText("");
            pnStatus.setBackground(new Background(new BackgroundFill(Color.rgb(218, 127, 48), CornerRadii.EMPTY, Insets.EMPTY)));


        }
/*
        else if (event.getSource() == logoutBtn) {


            login.getScene().getWindow().hide();

            Parent toot = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene  = new Scene(toot);
            Stage stage2 =  new Stage();
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.setScene(scene);
            stage2.show();



        }*/
    }

    @FXML
    private Text payValue;

    //PAYMENT CALCULATIONS HERE
    //String payname = payName.getText();

    @FXML
    private Text txtpaystatus;

    @FXML
    void paynow(ActionEvent event) {
        int payamount  = Integer.parseInt(payAmount.getText());
        System.out.println("payamount = " + payamount);
        //String paycontact = payContact.getText();


        int payvalue = Integer.parseInt(payValue.getText());
        System.out.println("Payvalue = " + payvalue);

        TotalCurrentvalue = payvalue + payamount;
        System.out.println("TotalCurrentValue = " + TotalCurrentvalue);
        payValue.setText(String.valueOf(TotalCurrentvalue));

        txtpaystatus.setText("PAID");
        txtpaystatus.setFill(Color.rgb(13, 246, 6));
        Glow glow = new Glow();
        glow.setLevel(0.9);
        txtpaystatus.setEffect(glow);

   }



    //MY DB CONNECTOR ----------------------------------------------------------------------------------//


    Connection conn;
    int id;
    int myIndex;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/hoteldatabase", "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connected successfully to mysql..........");

        } catch (SQLException e) {
        }



    }



    // SAVING TO DATABASE
    @FXML
    void save(ActionEvent event){
        Connect();
        String FirstName = CusFname.getText();
        String LastName = CusLname.getText();
        String Bookings = CusBooking.getText();
        String Contacts = CusContact.getText();

        try{
            pst = conn.prepareStatement("insert into customer( fname, lname, booking, contact) values (?,?,?,?)");
            pst.setString(1, FirstName);
            pst.setString(2, LastName);
            pst.setString(3, Bookings);
            pst.setString(4, Contacts);


            int status = pst.executeUpdate();
            TableView();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert .setTitle("STATUS");
            alert.setHeaderText("New Customer");
            alert.setContentText("Added Successfully");
            alert.showAndWait();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("There was an error......");
        }

    }


    //DELETE FROM TABLE-----------------------------------------------------------------------------//
    public void CusDelete()
    {
        myIndex = CusTable.getSelectionModel().getSelectedIndex();
        System.out.println("Your selected Index is" + myIndex);
        id = Integer.parseInt(String.valueOf(CusTable.getItems().get(myIndex)));
        System.out.println("Your selected ID is" + id);
        try {
            pst = conn.prepareStatement("delete from customer where id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
            TableView();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //POPULATE TABLE

    public  void TableView()
    {
        Connect();
        ObservableList<CustomerViewController> customers = FXCollections.observableArrayList();
        try
        {
            pst = conn.prepareStatement("select id, booking, fname,  lname, contact from customer");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    CustomerViewController customer = new CustomerViewController();
                    customer.setid(rs.getString("id"));
                    customer.setfname(rs.getString("fname"));
                    customer.setlname(rs.getString("lname"));
                    customer.setbooking(rs.getString("booking"));
                    customer.setcontact(rs.getString("contact"));
                    customers.add(customer);

                }
            }
            CusTable.setItems(customers);
            CusIdCol.setCellValueFactory(f -> f.getValue().idProperty());
            CusFnameCol.setCellValueFactory(f -> f.getValue().fnameProperty());
            CusLnameCol.setCellValueFactory(f -> f.getValue().lnameProperty());
            CusBookCol.setCellValueFactory(f -> f.getValue().bookingProperty());
            CusContCol.setCellValueFactory(f -> f.getValue().contactProperty());

           /* populating booking table  in booking view
            bookingTable.setItems(customers);
            bookingCol.setCellValueFactory(f -> f.getValue().bookingProperty());
            BookFnameCol.setCellValueFactory(f -> f.getValue().fnameProperty());
            BookLnameCol.setCellValueFactory(f -> f.getValue().lnameProperty());
            */



        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        //CREATING CLICK TO EDIT ROW FOR CUSTOMER LIST
        CusTable.setRowFactory(tv ->{TableRow<CustomerViewController> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event ->
            {
                if ( event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex = CusTable.getSelectionModel().getSelectedIndex();

                    id = Integer.parseInt(String.valueOf(CusTable.getItems().get(myIndex).getid()));

                    CusLname.setText(CusTable.getItems().get(myIndex).getlname());
                    CusBooking.setText(CusTable.getItems().get(myIndex).getbooking());
                    CusContact.setText(CusTable.getItems().get(myIndex).getcontact());
                    CusFname.setText(CusTable.getItems().get(myIndex).getfname());

                }

            });
            return  myRow;
        });
    }



//--------------------------------------------------------------------------------------------------------
    // EMPLOYEE DETAILS----------------------------------------------------------------------------------

    //MY DB CONNECTOR ----------------------------------------------------------------------------------//


    Connection conn2;
    PreparedStatement pst2;
    int id2 = 1;
    int myIndex2;

    public void Connect2() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn2 = DriverManager.getConnection("jdbc:mysql://localhost/hoteldatabase", "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connected successfully to mysql..........");

        } catch (SQLException e) {
        }
    }

    @FXML
    void save2 (ActionEvent event){
        String firstname = Empfname.getText();
        String lastname = EmpLname.getText();
        String dateofbirth = EmpDOB.getText();
        String econtact = EmpContact.getText();
        String password = EmpPwd.getText();

        try {
            pst2 = conn2.prepareStatement("insert into employee( fname, lname, dob,  contact, password) values (?,?,?,?,?)");
            pst2.setString(1, firstname);
            pst2.setString(2, lastname);
            pst2.setString(3, dateofbirth);
            pst2.setString(4, econtact);
            pst2.setString(5, password);


            int status = pst2.executeUpdate();
            TableView2();

            Empfname.setText("");
            EmpLname.setText("");
            EmpDOB.setText("");
            EmpPwd.setText("");
            EmpContact.setText("");

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("STATUS");
            alert.setHeaderText("New Contact");
            alert.setContentText("Added Successfully");
            alert.showAndWait();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("There was an error......");
        }

    }



    //DELETE FROM TABLE-----------------------------------------------------------------------------------//
    /*public void EmpDelete()
        {
            myIndex = EmpTable.getSelectionModel().getSelectedIndex();
            System.out.println("Your selected index is" + myIndex);
            id2 = Integer.parseInt(String.valueOf(EmpTable.getItems().get(myIndex)));
            System.out.println("Your selected ID is" + id2);
            //id2 = Integer.parseInt(String.valueOf(myIndex));
            try {
                pst2 = conn2.prepareStatement("delete from employee where id = ?");
                pst2.setInt(1, id2);
                pst2.executeUpdate();
                TableView2();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("database......");
            }
        }*/

    //POPULATE TABLE---------------------------------------------------------------------------------
    public void TableView2 ()
    {
        Connect2();
        ObservableList<EmployeeViewController> employees = FXCollections.observableArrayList();
        try {
            pst = conn.prepareStatement("select id,fname, lname, dob, password,  contact from employee");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    EmployeeViewController employee = new EmployeeViewController();
                    employee.setempidnumber(rs.getString("id"));
                    employee.setfirstname(rs.getString("fname"));
                    employee.setlastname(rs.getString("lname"));
                    employee.setdateofbirth(rs.getString("dob"));
                    employee.setpassword(rs.getString("password"));
                    employee.setecontact(rs.getString("contact"));
                    employees.add(employee);

                }
            }
            EmpTable.setItems(employees);
            EmpIdCol.setCellValueFactory(f -> f.getValue().empidnumberProperty());
            EmpDOBcol.setCellValueFactory(f -> f.getValue().dateofbirthProperty());
            EmpFnameCol.setCellValueFactory(f -> f.getValue().firstnameProperty());
            EmpLnameCol.setCellValueFactory(f -> f.getValue().lastnameProperty());
            EmpContCol.setCellValueFactory(f -> f.getValue().econtactProperty());



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize (URL url, ResourceBundle resourceBundle){
        Connect();
        Connect2();


    }
    //-------------------------------------------------------------------------------------------------------------

}



