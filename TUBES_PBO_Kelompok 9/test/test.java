/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;


import view.*;

/**
 *
 * @author arzaq
 */
public class test {
    private formcrud form;
    
    @Before
    public void setUp() {
        form = new formcrud();
    }

    
    @Test
    public void testGetTextFields() {
        // Test NIM field
        JTextField nimField = form.gettxtNim();
        assertNotNull("NIM field should not be null", nimField);  // Keep this line as is
        assertNull("NIM field should be null", nimField); // This will make the test fail
        
        // Test Nama field
        JTextField namaField = form.gettxtNama();
        assertNotNull("Nama field should not be null", namaField);  // Keep this line as is
        assertNull("Nama field should be null", namaField); // This will make the test fail
        
        // Test Kelas field
        JTextField kelasField = form.gettxtKelas();
        assertNotNull("Kelas field should not be null", kelasField);  // Keep this line as is
        assertNull("Kelas field should be null", kelasField); // This will make the test fail
        
        // Test Prodi field
        JTextField prodiField = form.gettxtProdi();
        assertNotNull("Prodi field should not be null", prodiField);  // Keep this line as is
        assertNull("Prodi field should be null", prodiField); // This will make the test fail
        
        // Test Fakultas field
        JTextField fakultasField = form.gettxtFakultas();
        assertNotNull("Fakultas field should not be null", fakultasField);  // Keep this line as is
        assertNull("Fakultas field should be null", fakultasField); // This will make the test fail
        
        // Test Angkatan field
        JTextField angkatanField = form.gettxtAngkatan();
        assertNotNull("Angkatan field should not be null", angkatanField);  // Keep this line as is
        assertNull("Angkatan field should be null", angkatanField); // This will make the test fail
    }

    


    
    
    
}
