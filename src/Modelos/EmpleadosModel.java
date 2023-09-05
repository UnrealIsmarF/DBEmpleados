
package Modelos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpleadosModel {
Connection MyConexion;
ResultSet result;


public DefaultTableModel ListarDatos()
{
    DefaultTableModel TablaModelo = new DefaultTableModel();
    TablaModelo.setRowCount(0);
    TablaModelo.setColumnCount(0);
    
        TablaModelo.addColumn("idEmpleados");
        TablaModelo.addColumn("Apellidos");
        TablaModelo.addColumn("Nombres");
        TablaModelo.addColumn("Telefono");


    try
    {
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        result = sentencia.executeQuery("select * from Empleados");
        
        
            while(result.next())
            {
                TablaModelo.addRow(new Object[]{result.getInt("idEmpleados"),
                result.getString("Apellidos"),
                result.getString("Nombres"),
                result.getString("Telefono")});
            }
        return TablaModelo;
    }
    
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar Empleados...."+e.getMessage());
    }
    return TablaModelo;
}


public void Actualizar(int codigo, String Apellidos, String Nombre, String telefono)
{
        try
        {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.Conectar();
            Statement sentencia = MyConexion.createStatement();
            sentencia.executeQuery("Update Empleados set Apellidos ="+"'"+Apellidos+"',Nombres="+"'"+Nombre+"',Telefono="+"'"+telefono+"' where idEmpleados="+"'"+codigo+"'");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Actualizar..."+ex.getMessage());
        }
          
}

public void Guardar(String usuario, String Contraseña)
{
    try
        {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.Conectar();
            Statement sentencia = MyConexion.createStatement();
            sentencia.executeQuery("Insert into Empleados values("+"'"+usuario+"',"+"'"+Contraseña+"')");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "No se pudo Guardar..."+ex.getMessage());
        }  
}

public void Eliminar(int usuario, String Contraseña)
{
    try
        {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.Conectar();
            Statement sentencia = MyConexion.createStatement();
            sentencia.executeQuery("delete from Empleados where idEmpleados="+"'"+usuario+"'");

        }
            catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar..."+ex.getMessage());
        }  
}

}
