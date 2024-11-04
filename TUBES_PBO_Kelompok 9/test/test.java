/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import org.junit.Before;
import org.junit.Test;
import koneksi.DBConnection;
import view.formcrud;
import controller.controllerData;
import DAO.DAOData;
import model.TambahData;
import javax.swing.JTextField;
import java.util.List;

public class test {
    private Connection mockConnection;
    private Statement mockStatement;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;
    private formcrud form;
    private DAOData daoData;
    private controllerData controller;

    @Before
    public void setUp() throws Exception {
        // Create mock objects
        mockConnection = mock(Connection.class);
        mockStatement = mock(Statement.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);
        
        // Set up mock behavior
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        
        // Mock ResultSet data
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString("nim")).thenReturn("12345");
        when(mockResultSet.getString("nama")).thenReturn("Test Name");
        when(mockResultSet.getString("jenis_kelamin")).thenReturn("Laki-laki");
        when(mockResultSet.getString("kelas")).thenReturn("A");
        when(mockResultSet.getString("prodi")).thenReturn("Test Prodi");
        when(mockResultSet.getString("fakultas")).thenReturn("Test Fakultas");
        when(mockResultSet.getString("angkatan")).thenReturn("2023");
        
        // Mock the database connection class
        mockStatic(DBConnection.class);
        when(DBConnection.connectDB()).thenReturn(mockConnection);
        
        // Initialize your components
        form = new formcrud();
        controller = new controllerData(form);
        daoData = new DAOData();
    }

    @Test
    public void testGetTextFields() {
        // Test NIM field
        JTextField nimField = form.gettxtNim();
        assertNotNull("NIM field should not be null", nimField);
        
        // Test Nama field
        JTextField namaField = form.gettxtNama();
        assertNotNull("Nama field should not be null", namaField);
        
        // Test Kelas field
        JTextField kelasField = form.gettxtKelas();
        assertNotNull("Kelas field should not be null", kelasField);
        
        // Test Prodi field
        JTextField prodiField = form.gettxtProdi();
        assertNotNull("Prodi field should not be null", prodiField);
        
        // Test Fakultas field
        JTextField fakultasField = form.gettxtFakultas();
        assertNotNull("Fakultas field should not be null", fakultasField);
        
        // Test Angkatan field
        JTextField angkatanField = form.gettxtAngkatan();
        assertNotNull("Angkatan field should not be null", angkatanField);
    }

    @Test
    public void testDatabaseInteraction() throws Exception {
        // Test data retrieval
        List<TambahData> data = daoData.getAll();
        assertNotNull("Data list should not be null", data);
        assertFalse("Data list should not be empty", data.isEmpty());
        
        // Test the first record
        TambahData firstRecord = data.get(0);
        assertEquals("12345", firstRecord.getNim());
        assertEquals("Test Name", firstRecord.getNama());
        assertEquals("A", firstRecord.getKelas());
        
        // Verify database interactions
        verify(mockConnection, atLeastOnce()).createStatement();
        verify(mockStatement).executeQuery("SELECT * FROM tb_mahasiswa");
    }
    
    @Test
    public void testInsertData() throws Exception {
        // Create test data
        TambahData testData = new TambahData();
        testData.setNim("54321");
        testData.setNama("New Test");
        testData.setJenisKelamin("Laki-laki");
        testData.setKelas("B");
        testData.setProdi("Test Prodi");
        testData.setFakultas("Test Fakultas");
        testData.setAngkatan("2024");
        
        // Set up form fields
        form.gettxtNim().setText(testData.getNim());
        form.gettxtNama().setText(testData.getNama());
        // ... set other fields
        
        // Test insert operation
        controller.insert();
        
        // Verify prepared statement was created with correct SQL
        verify(mockConnection).prepareStatement(contains("INSERT INTO tb_mahasiswa"));
    }
}