package com.mcbx.jpa.eclipse.table1;

import com.mcbx.jpa.eclipse.entity.data.Person;
import com.mcbx.jpa.eclipse.entity.data.AuthorsData;
import com.mcbx.jpa.eclipse.entity.Authors;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Table1Controller implements Initializable {

    private final String persistentUnit = "booksreservation";
    private EntityManagerFactory emf;
    private EntityManager em;

    @FXML
    private Button ADDENTRY;

    @FXML
    private TextArea tfListener;

    @FXML
    /*SET TABLE LAYOUT*/
    ObservableList<Authors> authorsObservableList;                                      // <> -> SPECIFY THE <CLASSFILE> FOR YOUR OBSERVABLE_LIST
    public TableView<Authors> table = new TableView<>();                                // <> -> SPECIFY THE <CLASSFILE>
    /*SET COLUMN LAYOUT*/
    public TableColumn<Authors, String> column1 = new TableColumn<>("FIRST NAME");      // "" -> Column Header Name     <,> -> SPECIFY THE <CLASSFILE, DATA TYPE> OF THE TABLE COLUMN
    public TableColumn<Authors, String> column2 = new TableColumn<>("LAST NAME");       // "" -> Column Header Name     <,> -> SPECIFY THE <CLASSFILE, DATA TYPE> OF THE TABLE COLUMN
    public TableColumn<Authors, String> column3 = new TableColumn<>("INFORMATION");     // "" -> Column Header Name     <,> -> SPECIFY THE <CLASSFILE, DATA TYPE> OF THE TABLE COLUMN
    public TableColumn<Authors, String> column4 = new TableColumn<>("GENDER");          // "" -> Column Header Name     <,> -> SPECIFY THE <CLASSFILE, DATA TYPE> OF THE TABLE COLUMN

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /**/
        careteEntityManagerFactory();
        em = emf.createEntityManager();
        em.getTransaction().begin();

        /*INITIALIZE COLUMN CLASS.FIELDNAME*/
        column1.setCellValueFactory(new PropertyValueFactory("firstname"));             // "" -> Class.fieldname [Case Sensitive] CAREFUL IF NO DISPLAY IN THE TABLEVIEW
        column2.setCellValueFactory(new PropertyValueFactory("lastname"));              // "" -> Class.fieldname [Case Sensitive] CAREFUL IF NO DISPLAY IN THE TABLEVIEW
        column3.setCellValueFactory(new PropertyValueFactory("contactinformation"));    // "" -> Class.fieldname [Case Sensitive] CAREFUL IF NO DISPLAY IN THE TABLEVIEW
        column4.setCellValueFactory(new PropertyValueFactory("gender"));                // "" -> Class.fieldname [Case Sensitive] CAREFUL IF NO DISPLAY IN THE TABLEVIEW

        /*COLUMN EDITABLE*/
        column1.setCellFactory(TextFieldTableCell.forTableColumn());
        setTableColumnEditable();

        /*SET COLLUMN COMBOBOX*/
        column4.setCellFactory(ComboBoxTableCell.forTableColumn("Male", "Female", "Undefined"));
        setTableColumnEditableGender();

        /*SET COLUMN TABLE EDITABLE*/
        table.setEditable(true);

        /*ADD COLUMN TO THE TABLE*/
        table.getColumns().setAll(column1, column2, column3, column4);                  // ADD ALL YOUR INITIALIZED COLUMN TO THE TABLEMODEL
        /*SET TABLE SELECTION MODE*/
        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);               // ADDITIONAL PROPERTY SETTINGS TO YOUR TABLE

        /*PUT OBSERVABLE_LIST DATA TO THE TABLE VIEW*/
        table.setItems(getAuthors());                                                   // RETRIEVE THAT DATA YOU WANT TO STORE TO THE TABLE VIEW

        /**/
        setObservableListListener();

        /**/
        em.close();
        /**/
    }

//------------------------------------------------------------------------------ CREATE ENTITY MANAGER FACTORY
    private void careteEntityManagerFactory() {
        try {
            /*CONFIGURE THE CONNECTION FROM PERSISTENT_UNIT SETTINGS*/
            emf = Persistence.createEntityManagerFactory(persistentUnit);
            /**/
        } catch (Exception ex) {
            System.err.println("Failed to create sessionFactory object." + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

//------------------------------------------------------------------------------ CHECK IF ENTITY ID IS EXIST
    public boolean isEntityIDExist(Class<?> entityClass, int classID) {
        return em.find(entityClass, classID) != null;
    }

//------------------------------------------------------------------------------ THIS IS SAMPLE FOR TABLE DATA, NOT ON DATABASE DATA
    public ObservableList<Person> getPersons() {
        /*LOCAL DECLARATION OF OBSERVABLE_LIST*/
        ObservableList<Person> personsList = FXCollections.observableArrayList();
        /*CREATE A NEW OBJECTS OF A CLASS AND ADD TO THE OBSERVABLE_LIST*/
        personsList.add(new Person("Jacob", "Smith", "jacob.smith@example.com"));
        personsList.add(new Person("Jacob", "Smith", "jacob.smith@example.com"));
        personsList.add(new Person("Isabella", "Johnson", "isabella.johnson@example.com"));
        personsList.add(new Person("Ethan", "Williams", "ethan.williams@example.com"));
        personsList.add(new Person("Emma", "Jones", "emma.jones@example.com"));
        personsList.add(new Person("Michael", "Brown", "michael.brown@example.com"));

        /*RETURN OBJECTS WHICH IS NOW AN OBSERVABLE_LIST IN YOUR TABLE VIEW*/
        return personsList;
    }

//------------------------------------------------------------------------------ THIS IS SAMPLE FOR COLLECTING TABLE DATA, FROM YOUR DATABASE SERVER
    public ObservableList<AuthorsData> getAuthorsData() {
        /*LOCAL DECLARATION OF OBSERVABLE_LIST*/
        ObservableList<AuthorsData> authorsList = FXCollections.observableArrayList();
        /*CREATE A QUERY*/
        Query query = em.createQuery("Select a from Authors a");
        /*COLLECTED DATA WILL BE STORE TO THE LIST AS AN OBJECT OF A CLASS TYPE*/
        List<Authors> list = query.getResultList();
        /*MANIMUPLATE/READ EACH COLLECTED DATA*/
        list.forEach((e) -> {
            /*TO ADD NEW OBJECT FROM THE CLASS [CREATE CONSTRUCTOR FIRST(@POJO) WITH SPECIFIC FIELDS] ON TOP GENERATED JPA CLASS*/ /*NEW DATA WILL BE ADDED ALSO TO THE OBSERVABLE_LIST*/
            authorsList.add(new AuthorsData(e.getIdauthors(), e.getFirstname(), e.getLastname(), e.getContactinformation()));
        });
        /*RETURN OBJECTS WHICH IS NOW AN OBSERVABLE_LIST IN YOUR TABLE VIEW*/
        return authorsList;
    }

//------------------------------------------------------------------------------ GET DATA FROM DATABASE AND STORE TO THE OBSERVABLE_LIST, AND INSERT IT TO THE TABLEVIEW
    public ObservableList<Authors> getAuthors() {
        /*ObservableList<Authors> authorsObservableList = FXCollections.observableArrayList();*/ //THIS IS LOCAL DECLARATION -> I MAKE IT GLOBAL, SO THAT [OBSERVABLE_LIST] WILL BE MANIPULATED ALSO OUTSIDE, U CAN ALSO STORE ANOTHER ENTRY/OBJECT TO IT
        authorsObservableList = FXCollections.observableArrayList();

        /*RETRIEVE INFORMATION FROM DATABASE*/
        Query query = em.createQuery("Select a from Authors a");

        /*COLLECTED DATA WILL BE STORE TO THE LIST AS AN OBJECT OF A CLASS TYPE*/
        List<Authors> list = query.getResultList();

        /*MANIMUPALTE/READ EACH COLLECTED DATA*/
        list.forEach((e) -> {
            /*TO ADD NEW OBJECT FROM THE CLASS [CREATE CONSTRUCTOR FIRST(@POJO) WITH SPECIFIC FIELDS] ON TOP GENERATED JPA CLASS*/ /*NEW DATA WILL BE ADDED ALSO TO THE OBSERVABLE_LIST*/
            authorsObservableList.add(new Authors(e.getIdauthors(), e.getFirstname(), e.getLastname(), e.getContactinformation(), e.getGender()));
        });

        /*RETURN OBJECTS WHICH IS NOW AN OBSERVABLE_LIST IN YOUR TABLE VIEW*/
        return authorsObservableList;
    }
//------------------------------------------------------------------------------ ADD DATA TO DATABASE AND OBSERVABLE_LIST

    public void addEntry() {
        try {
            /*ESTABLISH A CONNECTION*/
            em = emf.createEntityManager();                                         // FOR DATABASE CONNECTION
            em.getTransaction().begin();                                            // FOR DATABASE CONNECTION -> OPEN A CONNECTION
            /*CREATE AN OBJECT*/
            Authors a = new Authors();
            a.setFirstname("NEW FIRSTNAME");
            a.setLastname("NEW LAST NAME");
            a.setContactinformation("NEW CONTACT INFORMATION");
            /*MAKE IT TO PERSISTENT STATE*/ /*NOT YET PUSH TO DATABASE*/
            em.persist(a);                                                          // FOR DATABASE CONNECTION -> PUT OBJECT PERSISTENT STATE, NOT YET PUT TO DATABASE
            em.getTransaction().commit();                                           // FOR DATABASE CONNECTION -> COMMIT PERSISTENT STATE, PUSH DATA TO DATABASE

            /*ADD NEW ENTRY TO THE OBSERVABLE_LIST, ADD NEW ENTRY TO THE TABLE VIEW, WITHOUT HAVING TO REFRESH THE DATA*/
            authorsObservableList.add(a);
            /**/
            em.close();                                                             // FOR DATABASE CONNECTION -> ALL PRESISTENT STATE WILL BE PUSH TO GARBAGE COLLECTOR, NO ENTRY TO COMMIT, NO PERSISTENT STATE AVAIABLE
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
//------------------------------------------------------------------------------ SET OBSERVABLE_LIST LISTENER

    private void setObservableListListener() {
        try {
            authorsObservableList.addListener((ListChangeListener) (c -> {
                System.out.println("Detected a change! ");
                while (c.next()) {
                    if (c.wasPermutated()) {
                        System.out.println("Was permuated" + c.wasPermutated());
                    } else if (c.wasUpdated()) {
                        System.out.println("Was updated " + c.wasUpdated());
                    } else {
                        System.out.println("Nothing here");
                    }
                }
            }));
        } catch (Exception e) {
            System.err.println("-----" + e.getMessage());
        }
    }
//------------------------------------------------------------------------------ SET TABLE EDITABLE
/*HOT STRING*/
    private void setTableColumnEditable() {
        try {
            column1.setOnEditCommit((TableColumn.CellEditEvent<Authors, String> t) -> {
                ((Authors) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                        .setFirstname(t.getNewValue());

                /*SAVE CHANGES TO DATABASE*/ /*GET ID OF THE OBJECT*/
                int idauthor = ((Authors) t.getTableView().getItems().get(t.getTablePosition().getRow())).getIdauthors();
                /*UPDATE*/ /*ESTABLISH A CONNECTION*/
                em = emf.createEntityManager();                                         // FOR DATABASE CONNECTION
                em.getTransaction().begin();                                            // FOR DATABASE CONNECTION -> OPEN A CONNECTION
                /*UPDATE OBJECT @ ID*/
                Authors a = em.find(Authors.class, idauthor);
                a.setFirstname(t.getNewValue());
                /*MAKE IT TO PERSISTENT STATE*/ /*NOT YET PUSH TO DATABASE*/
                em.persist(a);                                                          // FOR DATABASE CONNECTION -> PUT OBJECT PERSISTENT STATE, NOT YET PUT TO DATABASE
                em.getTransaction().commit();                                           // FOR DATABASE CONNECTION -> COMMIT PERSISTENT STATE, PUSH DATA TO DATABASE
                em.close();                                                             // FOR DATABASE CONNECTION -> ALL PRESISTENT STATE WILL BE PUSH TO GARBAGE COLLECTOR, NO ENTRY TO COMMIT, NO PERSISTENT STATE AVAIABLE
            });
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void setTableColumnEditableGender() {
        try {
            column4.setOnEditCommit((TableColumn.CellEditEvent<Authors, String> t) -> {
                ((Authors) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                        .setFirstname(t.getNewValue());
                /*SAVE CHANGES TO DATABASE*/ /*GET ID OF THE OBJECT*/
                int idauthor = ((Authors) t.getTableView().getItems().get(t.getTablePosition().getRow())).getIdauthors();
                /*UPDATE*/ /*ESTABLISH A CONNECTION*/
                em = emf.createEntityManager();                                         // FOR DATABASE CONNECTION
                em.getTransaction().begin();                                            // FOR DATABASE CONNECTION -> OPEN A CONNECTION
                /*UPDATE OBJECT @ ID*/
                Authors a = em.find(Authors.class, idauthor);
                a.setGender(t.getNewValue());
                /*MAKE IT TO PERSISTENT STATE*/ /*NOT YET PUSH TO DATABASE*/
                em.persist(a);                                                          // FOR DATABASE CONNECTION -> PUT OBJECT PERSISTENT STATE, NOT YET PUT TO DATABASE
                em.getTransaction().commit();                                           // FOR DATABASE CONNECTION -> COMMIT PERSISTENT STATE, PUSH DATA TO DATABASE
                em.close();                                                             // FOR DATABASE CONNECTION -> ALL PRESISTENT STATE WILL BE PUSH TO GARBAGE COLLECTOR, NO ENTRY TO COMMIT, NO PERSISTENT STATE AVAIABLE
            });
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
