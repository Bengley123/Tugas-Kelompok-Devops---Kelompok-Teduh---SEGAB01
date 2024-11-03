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
import view.formcrud;
import static org.junit.Assert.fail;


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


    


    
    
    
}
