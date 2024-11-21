package TallerXML1;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import org.w3c.dom.Node;


public class LeerXML {
    
       String rutaArchivo = "C:\\Users\\Juan Camilo\\OneDrive\\Documentos\\NetBeansProjects\\Semestre 3\\producto.xml";

     public ArrayList<Producto> leerProductosDesdeXML(String archivoXML) {
        ArrayList<Producto> productos = new ArrayList<>();
        
        try {
         
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(archivoXML));
            
            // Obtener el nodo raíz <Productos>
            NodeList nodeList = document.getElementsByTagName("Producto");
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) node;
                    
                    String codigo = elemento.getElementsByTagName("Codigo").item(0).getTextContent();
                    String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
                    double precio = Double.parseDouble(elemento.getElementsByTagName("Precio").item(0).getTextContent());
                    String categoria = elemento.getElementsByTagName("Categoria").item(0).getTextContent();
                   
                    productos.add(new Producto(codigo, nombre, precio, categoria));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return productos;
    }
}



