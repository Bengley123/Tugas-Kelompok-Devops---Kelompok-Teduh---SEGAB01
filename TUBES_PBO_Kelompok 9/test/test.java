/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito; // Correct import for Mockito class
import static org.mockito.Mockito.*; // Correct for static methods
import dao.FormCrudDAO;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import javax.swing.JTextField;
import view.formcrud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {
    private formcrud form;
    private Connection mockConnection;
    private Statement mockStatement;
    private ResultSet mockResultSet;

    @Before
    public void setUp() throws Exception {
        form = new formcrud();

        // Create mocks
        mockConnection = mock(Connection.class);
        mockStatement = mock(Statement.class);
        mockResultSet = mock(ResultSet.class);

        // Stub the behavior of the mocks
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        
        // Example of what your ResultSet should return
        when(mockResultSet.next()).thenReturn(true).thenReturn(false); // Simulate one record returned
        when(mockResultSet.getString("column_name")).thenReturn("mocked_value");
        
        // You might want to inject this mock connection into the class under test if it supports dependency injection
        // form.setConnection(mockConnection); // Adjust your formcrud class accordingly
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
        // Create an instance of FormCrudDAO with the mocked connection
        FormCrudDAO dao = new FormCrudDAO(mockConnection);

        // Call the method to be tested
        String result = dao.getData();

        // Validate the result
        assertEquals("mocked_value", result);

        // Verify SQL execution
        verify(mockStatement).executeQuery(anyString());
    }

}