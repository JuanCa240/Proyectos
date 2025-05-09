
package AplicacionEscritorio;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EventoBotones {
    VentanaPrincipal vp;
    VentanaSecundaria vs;
    ArrayList<Contacto> listaContactos;

    public EventoBotones(VentanaPrincipal vp) {
        this.vp = vp;
        this.listaContactos = new ArrayList<>();
    }
    
    public void gestionarEventos(){
        vp.getAregarContacto().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaSecundaria vs = new VentanaSecundaria(vp.configurarVentana());
                vs.configurarVentanaBotonAgregarContacto();
                
                  vs.getCampoNumero().addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (!Character.isDigit(c)) {
                            e.consume(); 
                            JOptionPane.showMessageDialog(vp.configurarVentana(),
                                "El número de teléfono debe contener solo dígitos.");
                        }
                    }
                });

                
                vs.getCampoNombre().addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Si se presiona Enter
                            guardarContacto(vs);
                        }
                    }
                });
                
                 vs.getCampoCorreo().addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        String correo = vs.getCampoCorreo().getText();
                        if (!correo.contains("@") || !correo.endsWith(".com")) {
                            JOptionPane.showMessageDialog(vp.configurarVentana(),
                                "El correo debe contener un '@' y terminar en '.com'.");
                        }
                    }
                });
                
                vs.getGuardarContacto().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         if (vs.getCampoNombre().getText().isEmpty() || 
                             vs.getCampoApellido().getText().isEmpty() || 
                             vs.getCampoNumero().getText().isEmpty() || 
                             vs.getCampoCorreo().getText().isEmpty() || 
                             vs.getCampoDireccion().getText().isEmpty()||
                                 
                        (!vs.botonSoltero.isSelected() && !vs.botonCasado.isSelected() && 
                         !vs.botonUnionLibre.isSelected() && !vs.botonDivorciado.isSelected())) {
                        
                        JOptionPane.showMessageDialog(vp.configurarVentana(), 
                            "Por favor, complete todos los campos antes de guardar el contacto.");
                        return; 
                    }
                         
                     String nombre = vs.getCampoNombre().getText();
                        String numero = vs.getCampoNumero().getText();
                        for (Contacto contacto : listaContactos) {
                            if (contacto.getNombre().equalsIgnoreCase(nombre) || 
                                contacto.getNumero().equals(numero)) {
                                JOptionPane.showMessageDialog(vp.configurarVentana(),
                                    "Ya existe un contacto con el mismo nombre o número.");
                                return;
                            }
                        }

                    Contacto nuevoContacto = vs.obtenerDatosContacto();
                    listaContactos.add(nuevoContacto);
                    
                    String[] datosContacto = {
                        nuevoContacto.getNombre(),
                        nuevoContacto.getApellido(),
                        nuevoContacto.getNumero(),
                        nuevoContacto.getCorreo(),
                        nuevoContacto.getDireccion(),
                        nuevoContacto.getEstadoCivil()
                    };
                    
                    vp.agregarFila(datosContacto); 
                    vs.dispose(); 
                }
            });
                
                vs.setVisible(true);
            }
        });
        
       vp.getEditarContacto().addActionListener(new ActionListener() {
            @Override
       public void actionPerformed(ActionEvent e) {
            int filaSeleccionada = vp.getTabla().getSelectedRow();

            if (filaSeleccionada != -1) {
                Contacto contacto = listaContactos.get(filaSeleccionada);
                VentanaSecundaria ventanaEdicion = new VentanaSecundaria(vp.configurarVentana());
                ventanaEdicion.configurarVentanaBotonAgregarContacto();

                ventanaEdicion.getCampoNombre().setText(contacto.getNombre());
                ventanaEdicion.getCampoApellido().setText(contacto.getApellido());
                ventanaEdicion.getCampoNumero().setText(contacto.getNumero());
                ventanaEdicion.getCampoCorreo().setText(contacto.getCorreo());
                ventanaEdicion.getCampoDireccion().setText(contacto.getDireccion());
   
                ventanaEdicion.getGuardarContacto().addActionListener(new ActionListener() {
          @Override
    public void actionPerformed(ActionEvent e) {
        Contacto contactoActualizado = ventanaEdicion.obtenerDatosContacto();

        if (!contactoActualizado.getNombre().isEmpty() && 
            !contactoActualizado.getApellido().isEmpty()) {

            listaContactos.set(filaSeleccionada, contactoActualizado);

            vp.getTabla().setValueAt(contactoActualizado.getNombre(), filaSeleccionada, 0);
            vp.getTabla().setValueAt(contactoActualizado.getApellido(), filaSeleccionada, 1);
            vp.getTabla().setValueAt(contactoActualizado.getNumero(), filaSeleccionada, 2);
            vp.getTabla().setValueAt(contactoActualizado.getCorreo(), filaSeleccionada, 3);
            vp.getTabla().setValueAt(contactoActualizado.getDireccion(), filaSeleccionada, 4);
            vp.getTabla().setValueAt(contactoActualizado.getEstadoCivil(), filaSeleccionada, 5);

            ventanaEdicion.dispose(); 
        } else {
            JOptionPane.showMessageDialog(vp.configurarVentana(), 
                "Por favor, complete todos los campos.");
                            }
                        }
                    });

                    ventanaEdicion.setVisible(true); 
                } else {
                    JOptionPane.showMessageDialog(vp.configurarVentana(), 
                        "Por favor, seleccione un contacto para editar.");
                }
            }
        });
        
        vp.getEliminarContacto().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = vp.getTabla().getSelectedRow();

                if (filaSeleccionada != -1) {
                    int confirmacion = JOptionPane.showConfirmDialog(vp.configurarVentana(),
                            "¿Estás seguro de que deseas eliminar este contacto?",
                            "Eliminar Contacto",
                            JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.YES_OPTION) {
                        listaContactos.remove(filaSeleccionada); 
                        ((DefaultTableModel) vp.getTabla().getModel()).removeRow(filaSeleccionada);
                        JOptionPane.showMessageDialog(vp.configurarVentana(),
                                "Contacto eliminado exitosamente.");
                    }
                } else {
                    JOptionPane.showMessageDialog(vp.configurarVentana(),
                            "Por favor, selecciona un contacto para eliminar.");
                }
            }
        });
        
        vp.getBuscarContacto().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String terminoBusqueda = JOptionPane.showInputDialog(vp.configurarVentana(),
                        "Ingresa el nombre o apellido del contacto a buscar:");

                if (terminoBusqueda != null && !terminoBusqueda.trim().isEmpty()) {
                    boolean encontrado = false;
                    for (int i = 0; i < listaContactos.size(); i++) {
                        Contacto contacto = listaContactos.get(i);
                        if (contacto.getNombre().equalsIgnoreCase(terminoBusqueda) ||
                                contacto.getApellido().equalsIgnoreCase(terminoBusqueda)) {
                            vp.getTabla().setRowSelectionInterval(i, i); 
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        JOptionPane.showMessageDialog(vp.configurarVentana(),
                                "Contacto no encontrado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(vp.configurarVentana(),
                            "Por favor, ingresa un nombre o apellido válido.");
                }
            }
        });
    }
    
     private void actualizarTablaContactos() {
        String[] columnas = { "Nombre", "Apellido", "Número", "Correo", "Dirección", "Estado Civil" };
        String[][] datos = new String[listaContactos.size()][6];
        
        for (int i = 0; i < listaContactos.size(); i++) {
            Contacto c = listaContactos.get(i);
            datos[i][0] = c.getNombre();
            datos[i][1] = c.getApellido();
            datos[i][2] = c.getNumero();
            datos[i][3] = c.getCorreo();
            datos[i][4] = c.getDireccion();
            datos[i][5] = c.getEstadoCivil();
        }
        
        vp.crearTabla(datos, columnas); 
    }
     
      private void guardarContacto(VentanaSecundaria vs) {
        if (vs.getCampoNombre().getText().isEmpty() || 
            vs.getCampoApellido().getText().isEmpty() || 
            vs.getCampoNumero().getText().isEmpty() || 
            vs.getCampoCorreo().getText().isEmpty() || 
            vs.getCampoDireccion().getText().isEmpty() ||
            (!vs.botonSoltero.isSelected() && !vs.botonCasado.isSelected() && 
             !vs.botonUnionLibre.isSelected() && !vs.botonDivorciado.isSelected())) {

            JOptionPane.showMessageDialog(vp.configurarVentana(), 
                "Por favor, complete todos los campos antes de guardar el contacto.");
            return; 
        }
      }
}
