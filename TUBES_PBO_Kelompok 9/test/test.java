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
import org.junit.Before;
import org.junit.Test;
import koneksi.DBConnection;
import view.formcrud;
import controller.controllerData;
import DAO.DAOData;
import javax.swing.JTextField;

public class test {
    private Connection mockConnection;
    private Statement mockStatement;
    private ResultSet mockResultSet;
    private formcrud form;
    private DAOData daoData;
    private controllerData controller;


    @Before
    public void setUp() throws Exception {
        // Create mock objects
        mockConnection = mock(Connection.class);
        mockStatement = mock(Statement.class);
        mockResultSet = mock(ResultSet.class);
        
        // Set up mock behavior
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false); // Return true once, then false
        
        // Mock the database connection
        DBConnection dbConnection = mock(DBConnection.class);
        when(dbConnection.connectDB()).thenReturn(mockConnection);
        
        form = new formcrud();
        
        // Initialize controller with form
        controller = new controllerData(form);
        
        // Initialize your DAO with mock connection
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
        // Test DAOData methods instead of FormCrudDAO
        DAOData dao = new DAOData();
        // If you have a setConnection method:
        // dao.setConnection(mockConnection);
        
        // Mock the result set data
        when(mockResultSet.getString("nim")).thenReturn("12345");
        when(mockResultSet.getString("nama")).thenReturn("Test Name");
        when(mockResultSet.getString("kelas")).thenReturn("A");
        when(mockResultSet.getString("prodi")).thenReturn("Test Prodi");
        when(mockResultSet.getString("fakultas")).thenReturn("Test Fakultas");
        when(mockResultSet.getString("angkatan")).thenReturn("2023");
        
        // Test getAll method or other methods from DAOData
        assertTrue("Database connection should be established", mockConnection != null);
        verify(mockConnection, atLeastOnce()).createStatement();
    }

}