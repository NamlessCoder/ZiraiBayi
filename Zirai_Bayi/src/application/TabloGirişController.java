package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.isteMYSQL.Veritabanı;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class TabloGirişController {
	public TabloGirişController() {
		baglanti = Veritabanı.Baglan();
	}

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private AnchorPane anchor_calısanislem;


    @FXML
    private URL location;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_guncel;

    @FXML
    private Button btn_sil;

    @FXML
    private Button btn_yetki;

    @FXML
    private Label lbl_yetki;

    @FXML
    private Label lbl_ıd;

    @FXML
    private TableColumn<Kayıtlar_Giris, String> table_ad;

    @FXML
    private TableColumn<Kayıtlar_Giris, String> table_sifre;

    @FXML
    private TableColumn<Kayıtlar_Giris, Integer> table_yetki;

    @FXML
    private TableColumn<Kayıtlar_Giris, Integer> table_ıd;

    @FXML
    private TableView<Kayıtlar_Giris> tableview_KayıtG;

    @FXML
    private TextField txt_ad;

    @FXML
    private TextField txt_sifre;
    
    
    Connection baglanti=null;
    PreparedStatement sorgu = null;
    ResultSet getirilen = null;
    String sql;
    
    
    public void DegerGetir() {
    	sql = "select * from gi̇ri̇ş ";
    	ObservableList<Kayıtlar_Giris> kayıt = FXCollections.observableArrayList();
    	try {
			sorgu = baglanti.prepareStatement(sql);
			ResultSet getirilen = sorgu.executeQuery();
			while (getirilen.next()) {
				kayıt.add(new Kayıtlar_Giris(getirilen.getInt("KID"),getirilen.getString("Kullanıcı_AD"),getirilen.getString("Sıfre"),getirilen.getInt("Yetki")));
				
			}
			table_ıd.setCellValueFactory(new PropertyValueFactory<>("ID"));
			table_ad.setCellValueFactory(new PropertyValueFactory<>("kulad"));
			table_sifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));
			table_yetki.setCellValueFactory(new PropertyValueFactory<>("yetki"));
			tableview_KayıtG.setItems(kayıt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
   

    @FXML
    void btn_ekle_Click(ActionEvent event) {
    	sql="insert into gi̇ri̇ş (Kullanıcı_AD,Sıfre,Yetki) values(?,?,?)";
    	try {
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(1, txt_ad.getText().trim());
    		sorgu.setString(2, txt_sifre.getText().trim());
    		sorgu.setString(3, "2");
    		sorgu.executeUpdate();	
    		 DegerGetir();
		}
    	catch (Exception e) {
			System.out.println(e.getMessage());
		}

    }

    @FXML
    void btn_guncel_Click(ActionEvent event) {
    	sql="update gi̇ri̇ş set Sıfre=?  where KID=? ";
    	try {
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(1, txt_sifre.getText().trim());
    		sorgu.setString(2, lbl_ıd.getText()); 
    		sorgu.executeUpdate();	
    		 DegerGetir();
		}
    	catch (Exception e) {
			System.out.println(e.getMessage());
		}


    }

    @FXML
    void btn_sil_Click(ActionEvent event) {
    	sql="delete from gi̇ri̇ş where Kullanıcı_AD=? and Sıfre=?";
    	try {
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(1, txt_ad.getText().trim());
    		sorgu.setString(2, txt_sifre.getText().trim()); 		
    		sorgu.executeUpdate();	
    		 DegerGetir();
		}
    	catch (Exception e) {
			System.out.println(e.getMessage());
		}

    }

    @FXML
    void btn_yetki_Click(ActionEvent event) {
    	sql="update gi̇ri̇ş set Yetki=?  where KID=? ";
    	try {
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(1,"1");
    		sorgu.setString(2, lbl_ıd.getText()); 
    		sorgu.executeUpdate();	
    		 DegerGetir();
		}
    	catch (Exception e) {
			System.out.println(e.getMessage());
		}

    }

    @FXML
    void tableview_kayıtG_Click(MouseEvent event) {
    	Kayıtlar_Giris kayıt1 = new Kayıtlar_Giris();
    	kayıt1 = (Kayıtlar_Giris)tableview_KayıtG.getItems().get(tableview_KayıtG.getSelectionModel().getSelectedIndex());
    	txt_ad.setText(kayıt1.getKulad());
    	txt_sifre.setText(kayıt1.getSifre());
    	lbl_ıd.setText(String.valueOf(kayıt1.getID()));
    	lbl_yetki.setText(String.valueOf(kayıt1.getYetki()));

    }

    @FXML
    void initialize() {
    	GirişController a=new GirişController();
    	
    	if(a.yetkisi == 1) {
    		anchor_calısanislem.setVisible(true);
    		btn_yetki.setVisible(true);
    	}
    		
        DegerGetir();
    }

}
