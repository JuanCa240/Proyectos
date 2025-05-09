package MiniProyecto3;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PantallaFacturas {
    private JFrame ventana;
    private JTable tablaFacturas;

    public JFrame configurarPantalla() {
        ventana = new JFrame("Facturas");
        ventana.setSize(600, 400);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

   
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("ID");
        modelo.addColumn("Dirección");
        modelo.addColumn("Producto");
        modelo.addColumn("Precio");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Total");

        tablaFacturas = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tablaFacturas);

        ventana.add(scrollPane, BorderLayout.CENTER);
        cargarFacturasEnTabla(modelo);

        ventana.setVisible(true);
        return ventana;
    }

   private void cargarFacturasEnTabla(DefaultTableModel modelo) {
        List<Factura> facturas = OperacionesJSON.leerFacturas();
        for (int i = 0; i < facturas.size(); i++) {
            Factura factura = facturas.get(i);
            Object[] fila = {
                factura.getNombre(),
                factura.getId(),
                factura.getDireccion(),
                factura.getNombreProducto(),
                factura.getPrecio(),
                factura.getImpuesto(),
                factura.getTotal()
            };
            modelo.addRow(fila);
        }
    }

}