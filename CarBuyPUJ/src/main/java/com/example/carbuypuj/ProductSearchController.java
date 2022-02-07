package com.example.carbuypuj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductSearchController implements Initializable {

    @FXML
    private TableView<ProductSearchModel> productTableView;
    @FXML
    private TableColumn<ProductSearchModel ,Integer> idTableColumn;
    @FXML
    private TableColumn<ProductSearchModel ,String> markaTableColumn;
    @FXML
    private TableColumn<ProductSearchModel ,String> modelTableColumn;
    @FXML
    private TableColumn<ProductSearchModel ,String> godinaTableColumn;
    @FXML
    private TableColumn<ProductSearchModel ,String> vinTableColumn;
    @FXML
    private TableColumn<ProductSearchModel ,String> cijenaTableColumn;

    @FXML
    private TextField keywordTextField;

    ObservableList<ProductSearchModel> productSearchModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConn connectNow = new DatabaseConn();
        Connection connectDB = connectNow.getConnection();

        String productViewQuery = "SELECT idCars,Marka,Model,Godina,VIN,Cijena FROM Cars";


        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(productViewQuery);

            while (queryOutput.next()){

                Integer queryidCars = queryOutput.getInt("idCars");
                String queryMarka = queryOutput.getString("Marka");
                String queryModel = queryOutput.getString("Model");
                String queryGodina = queryOutput.getString("Godina");
                String queryVIN = queryOutput.getString("VIN");
                String queryCijena = queryOutput.getString("Cijena");


                productSearchModelObservableList.add(new ProductSearchModel(queryidCars,
                        queryMarka,
                        queryModel,
                        queryGodina,
                        queryVIN,
                        queryCijena));
            }

            idTableColumn.setCellValueFactory(new PropertyValueFactory<>("idCars"));
            markaTableColumn.setCellValueFactory(new PropertyValueFactory<>("Marka"));
            modelTableColumn.setCellValueFactory(new PropertyValueFactory<>("Model"));
            godinaTableColumn.setCellValueFactory(new PropertyValueFactory<>("Godina"));
            vinTableColumn.setCellValueFactory(new PropertyValueFactory<>("VIN"));
            cijenaTableColumn.setCellValueFactory(new PropertyValueFactory<>("Cijena"));

            productTableView.setItems(productSearchModelObservableList);

            FilteredList<ProductSearchModel> filteredData = new FilteredList<>(productSearchModelObservableList,b -> true);

            keywordTextField.textProperty().addListener((observable,oldValue,newValue) -> {

                filteredData.setPredicate(productSearchModel -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (productSearchModel.getMarka().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }else if (productSearchModel.getModel().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }else if (productSearchModel.getGodina().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }else if (productSearchModel.getVIN().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }else if (productSearchModel.getCijena().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }else{
                        return false;
                    }
                });
            });
            SortedList<ProductSearchModel> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(productTableView.comparatorProperty());
            productTableView.setItems(sortedData);

        }catch (SQLException e){
            Logger.getLogger(ProductSearchController.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
        }
    }
}
