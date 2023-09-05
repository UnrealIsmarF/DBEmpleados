package Controladores;

import Modelos.*;
import Vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author umg
 */
public class EmpleadosController implements ActionListener, MouseListener{
 frmEmpleados VistaEmpleados;
 frmPrincipal VistaPrincipal;
 EmpleadosModel ModeloEmpleado;
 
    

    public EmpleadosController(frmEmpleados VistaEmpleados, frmPrincipal VistaPrincipal, EmpleadosModel ModeloEmpleado) {
        this.VistaEmpleados = VistaEmpleados;
        this.VistaPrincipal = VistaPrincipal;
        this.ModeloEmpleado = ModeloEmpleado;
        
        /*LEVANTAR LAS VISTAS*/
      this.VistaPrincipal.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
      this.VistaPrincipal.setVisible(true);
      
      /*PONER A LA ESCUCHA LOS BOTONES*/
      this.VistaEmpleados.btn_Insertar.addActionListener(this);
      this.VistaEmpleados.btn_Editar.addActionListener(this);
      this.VistaEmpleados.btnEliminar.addActionListener(this);
        
      /*REALIZAR LA CONEXION*/
            
            /*Limpiar la tabla Vista Empleados
                DefaultTableModel TablaModelo = new DefaultTableModel();
                TablaModelo.setRowCount(0);
                TablaModelo.setColumnCount(0);
               this.VistaEmpleados.jtbEmpleados.setModel(TablaModelo);
            */        
            /*prepara el modelo de la tabla
                    TablaModelo.addColumn("ID");
                    TablaModelo.addColumn("APELLIDOS");
                    TablaModelo.addColumn("NOMBRES");
                    TablaModelo.addColumn("TELEFONO");
                    
      /* LEVANTAR EL MODELO Y LOGRAR RECORRER EL RESULTSET*/
         // Captar el resultado que viene del Modelo desde el método LISTARDATOS

                DefaultTableModel TablaModelo = this.ModeloEmpleado.ListarDatos();
//                this.VistaEmpleados.jtbEmpleados.setModel(TablaModelo);
                   
            //PASAR EL MODELO CREADO A LA TABLA DE LA VISTA EMPLEADOS        
//                    this.VistaEmpleados.jtbEmpleados.setModel(TablaModelo);
                    
            //PONER A LA ESCUCHA LA TABLA DE EMPLEADOS
//            this.VistaEmpleados.jtbEmpleados.addMouseListener(this);
        
        /*LEVANTAR LA VISTA EMPLEADOR*/
      this.VistaEmpleados.setLocationRelativeTo(null);
      this.VistaEmpleados.setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == this.VistaEmpleados.btn_Editar)
//        {
//            this.ModeloEmpleado.Actualizar(Integer.parseInt(this.VistaEmpleados.txtUsuario.getText()),
//                this.VistaEmpleados.txtApellidos.getText(),
//                    this.VistaEmpleados.txtContraseña.getText(), this.VistaEmpleados.txtTelefono.getText());
//
//            DefaultTableModel TablaModelo = this.ModeloEmpleado.ListarDatos();
//            this.VistaEmpleados.jtbEmpleados.setModel(TablaModelo);
//
//
//                this.VistaEmpleados.txtUsuario.setText("");
//
//                this.VistaEmpleados.txtContraseña.setText("");
//
//                
//        }
            if(e.getSource() == this.VistaEmpleados.btn_Insertar)
            {
                this.ModeloEmpleado.Guardar(this.VistaEmpleados.txtUsuario.getText(),
                        this.VistaEmpleados.txtContraseña.getText());

                DefaultTableModel TablaModelo = this.ModeloEmpleado.ListarDatos();
//                this.VistaEmpleados.jtbEmpleados.setModel(TablaModelo);

                this.VistaEmpleados.txtUsuario.setText("");

                this.VistaEmpleados.txtContraseña.setText("");

            }
        if(e.getSource() == this.VistaEmpleados.btnEliminar)
        {
            this.ModeloEmpleado.Eliminar(Integer.parseInt(this.VistaEmpleados.txtUsuario.getText()),      
                    this.VistaEmpleados.txtContraseña.getText());
            DefaultTableModel TablaModelo = this.ModeloEmpleado.ListarDatos();
//            this.VistaEmpleados.jtbEmpleados.setModel(TablaModelo);
            
            this.VistaEmpleados.txtUsuario.setText("");

            this.VistaEmpleados.txtContraseña.setText("");

        }

    }

    @Override
    public void mouseClicked(MouseEvent arg0){
        
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        
    }

}
