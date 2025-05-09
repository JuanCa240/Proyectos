package TallerArchivosJSON;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EventoBotones {
    private VentanaPrincipal vp;
    private Formulario f;
    private ArrayList<Factura> facturas;
    private OperacionesJSON operacionesJSON;
      
    public EventoBotones(VentanaPrincipal vp, Formulario f) {
        this.vp = vp;
        this.f = f;
        this.facturas = new ArrayList<>();
        this.operacionesJSON = new OperacionesJSON();
        gestionarBotones();
        operacionesJSON.cargarPersonasEnTabla(vp.getModelo());
    }
    
    public void gestionarBotones(){
       vp.getBotonAgregar().addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               mostrarFormulario();
           }
       });
       
       f.getBotonGuardar().addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
              agregarPersona();
           }
       });
       
       vp.getBotonEliminar().addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
              eliminarContacto();
           }
       });
       
       vp.getBotonEditar().addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
             editarContacto();
           }
       });  
    }
    
    public void mostrarFormulario(){
        limpiarFila();
        f.setTitle("Agregar Contacto");
        f.setVisible(true);
    }
    
    public void agregarPersona(){
        String codigoProducto = f.getCampoCodigo().getText();
        String nombre  = f.getCampoNombre().getText();
        
        String cantidadText = f.getCampoCantidad().getText();
        int cantidad = 0;
        
          if (!cantidadText.isEmpty()) {
            try {
                cantidad = Integer.parseInt(cantidadText);
            } catch (NumberFormatException ex) {
              
                System.out.println("cantidad no válida");
                return; 
            }
        }
        
        String precioText = f.getCampoPrecio().getText();
        double precio = 0;
        
          if (!precioText.isEmpty()) {
            try {
                precio = Integer.parseInt(precioText);
            } catch (NumberFormatException ex) {
              
                System.out.println("precio no válido");
                return; 
            }
        }
        
        String impuestoText = f.getCampoImpuesto().getText();
        float impuesto = (float) 0.0;
        
        if (!impuestoText.isEmpty()) {
            try {
                impuesto = Integer.parseInt(impuestoText);
            } catch (NumberFormatException ex) {
              
                System.out.println("impuesto no válido");
                return; 
            }
        }
        
        String totalText = f.getCampoTotal().getText();
        double total = (precio * cantidad) + impuesto;
        
         if (!totalText.isEmpty()) {
            try {
                total = Integer.parseInt(totalText);
            } catch (NumberFormatException ex) {
              
                System.out.println("total no válida");
                return; 
            }
        }
              
         
        Factura factura = new Factura(codigoProducto,nombre,cantidad,precio,impuesto,total);
        
        int filaSeleccionada = vp.getTabla().getSelectedRow();
        
        if(f.getTitle().equals("Agregar Contacto")){
            operacionesJSON.agregarPersona(factura);
            operacionesJSON.cargarPersonasEnTabla(vp.getModelo());
        }else if(filaSeleccionada != -1){
             operacionesJSON.editarPersona(filaSeleccionada, factura);
             operacionesJSON.cargarPersonasEnTabla(vp.getModelo());
        }
        
        f.setVisible(false);
               
    }
    
    public void editarContacto() {
    int filaSeleccionada = vp.getTabla().getSelectedRow();

    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(null, "Por favor, selecciona una factura para editar.");
        return;
    }

    Factura factura = operacionesJSON.getFacturas().get(filaSeleccionada);

    f.getCampoCodigo().setText(factura.getCodigoProducto());
    f.getCampoNombre().setText(factura.getNombre());
    f.getCampoCantidad().setText(String.valueOf(factura.getCantidad()));
    f.getCampoPrecio().setText(String.valueOf(factura.getPrecio()));
    f.getCampoImpuesto().setText(String.valueOf(factura.getImpuesto()));
    f.getCampoTotal().setText(String.valueOf(factura.getTotal()));

    f.setTitle("Editar Factura");

    f.setVisible(true);
}


    
    public void sincronizarTabla() {
        DefaultTableModel modelo = vp.getModelo();
        modelo.setRowCount(0); 

        for (Factura factura : operacionesJSON.getFacturas()) {
            Object[] fila = {
                factura.getCodigoProducto(),
                factura.getNombre(),
                factura.getCantidad(),
                factura.getPrecio(),
                factura.getImpuesto(),
                factura.getTotal()
            };
            modelo.addRow(fila);
        }
    }

    
    
    public void eliminarContacto(){
        int filaSeleccionada = vp.getTabla().getSelectedRow();
        
        operacionesJSON.eliminarPersona(filaSeleccionada);
        operacionesJSON.cargarPersonasEnTabla(vp.getModelo());
    }
    
    public void actualizarFila(int fila, Factura factura){
        DefaultTableModel modelo = vp.getModelo();
        
        modelo.setValueAt(factura.getCodigoProducto(),fila, 0);
        modelo.setValueAt(factura.getNombre(),fila, 1);
        modelo.setValueAt(factura.getCantidad(), fila, 2);
        modelo.setValueAt(factura.getPrecio(), fila, 3);
        modelo.setValueAt(factura.getImpuesto(), fila, 4);
        modelo.setValueAt(factura.getTotal(), fila, 5);
    }
    
    public void agregarFila(Factura factura){
        DefaultTableModel modelo = vp.getModelo();
        
        ArrayList<Object> fila = new ArrayList<>();
        fila.add(factura.getCodigoProducto());
        fila.add(factura.getNombre());
        fila.add(factura.getCantidad());
        fila.add(factura.getPrecio());
        fila.add(factura.getImpuesto());
        fila.add(factura.getTotal());
        
        modelo.addRow(fila.toArray());
    }
    
    public void limpiarFila(){
        f.getCampoCodigo().setText("");
        f.getCampoNombre().setText("");
        f.getCampoCantidad().setText("");
        f.getCampoPrecio().setText("");
        f.getCampoImpuesto().setText("");
        f.getCampoTotal().setText("");
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }
    
}
